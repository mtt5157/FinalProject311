package finalproject311;





import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *
 * @author matthewtucker
 */
public class Floor extends JPanel implements ActionListener, KeyListener{

    private String floorName;
    private Image floorImage;
    private Timer refreshTimer;
    private FloorController controller;
    private ArrayList<JPanel> rooms;
    private ArrayList<RoomEntry> entries;
    private player player1;
    private ArrayList<Divider> dividers;
    private ArrayList<Trashcan> trashcans;
    private ArrayList<Table> tables;
    private ArrayList<Rectangle> obstacles;
    private int currentX;
    private int currentY;
    private boolean collision;
   
 
    public Floor(String floorName, FloorController cont1) {
        this.floorName = floorName;
        this.controller = cont1;
        refreshTimer = new Timer(50, this);
        refreshTimer.start();
        rooms = new ArrayList<>();
        entries = new ArrayList<>();
        this.dividers = new ArrayList<Divider>();
        this.tables = new ArrayList<Table>();
        this.trashcans = new ArrayList<>();
        this.obstacles = new ArrayList<>();
        populateObjects();
        collision =false;
       
        
        rooms.add(new Room(202));
        rooms.add(new Room(204));
        rooms.add(new Room(206));
        rooms.add(new Room(208));
        rooms.add(new Room(210));
        
        entries.add(new RoomEntry(202, 50, 100, rooms.get(0)));
        entries.add(new RoomEntry(204, 50, 150, rooms.get(1)));
        entries.add(new RoomEntry(208, 50, 250, rooms.get(3)));
        entries.add(new RoomEntry(206, 50, 250, rooms.get(2)));
        entries.add(new RoomEntry(210, 50, 300, rooms.get(4)));
        
        player1 = new player(500,500);
        
       
        
        this.addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        
    }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        g.clearRect(0, 0, this.getWidth(), this.getHeight());

        player1.paintComponent(g);
        paintObjects(g);
       // currentX = player1.getCurrentX();
       // currentY = player1.getCurrentY();
        checkObjectCollision();
        for (int i = 0; i < entries.size() - 1; i++) {
            entries.get(i).paintComponent(g);
        }

       

        for (int i = 0; i < entries.size(); i++) {
            entries.get(i).paintComponent(g);
        }

        for (int i = 0; i < entries.size(); i++) {
            if (player1.intersects(entries.get(i))) {
                controller.floorToRoom(entries.get(i).getRoom());
                 System.out.println("Collision");
            }
        }
        
    }
    
    private void  populateObjects(){
        Table table1 = new Table(50, 100, 400, 50, "Table 1");
        Table table2 = new Table(50, 100, 400, 200, "Table 2");
        Table table3 = new Table(50, 100, 400, 350, "Table 3");
        Divider divider1 = new Divider(150, 10, 350, 25, "Divider 1");
        Divider divider2 = new Divider(150, 10, 350, 170, "Divider 2");
        Divider divider3 = new Divider(150, 10, 350, 315, "Divider 3");
        Trashcan trashcan1 = new Trashcan(30, 125, 0, 175, "Trashcan");
        
        trashcans.add(trashcan1);
        
        dividers.add(divider1);
        dividers.add(divider2);
        dividers.add(divider3);
        
        tables.add(table1);
        tables.add(table2);
        tables.add(table3);
        
    }
    
    private void checkObjectCollision(){
        for (int i = 0; i < dividers.size(); i++){
            if (player1.intersects(dividers.get(i))){
               player1.setX((dividers.get(i).getCurrentX()-30));
               player1.setY(dividers.get(i).getCurrentY());
            }
        }
        
        for(int i = 0; i<tables.size(); i++){
            if (player1.intersects(tables.get(i))){
                player1.setX(tables.get(i).getCurrentX()-30);
                player1.setY(tables.get(i).getCurrentY()+10);
                //player1.setDx(0);
                //player1.setDy(0);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == refreshTimer) {
            this.repaint();
        }
    }
    
     public void paintObjects(Graphics g){
      for(int i = 0; i<tables.size(); i++)
       {
           tables.get(i).paintComponent(g);
       }
      for(int i = 0; i<dividers.size(); i++)
       {
           dividers.get(i).paintComponent(g);
       }
      for(int i = 0; i<trashcans.size(); i++)
       {
           trashcans.get(i).paintComponent(g);
       }
    }

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
        
        //currentX = player1.getCurrentX();
        //currentY = player1.getCurrentY();
        
//       for (int i = 0; i < dividers.size(); i++){
//            if (player1.intersects(dividers.get(i))){
//                collision = true;
//            }
//       }   
//        for(int i =0; i<tables.size(); i++){
//            if(player1.intersects(tables.get(i))){
//              collision =true;
//            }    
            
       //}
//            if(collision ==true){
//             player1.setX(currentX-1);
//             player1.setY(currentY-1);
//            }    
            
           if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player1.setDx(-20);
          
            System.out.println("Typed");
            }
           
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player1.setDx(20);
      
            } 
            
            else if (e.getKeyCode() == KeyEvent.VK_UP) {
            player1.setDy(-20);
       
            } 
            
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player1.setDy(20);
         
        }
     }
        
    

    public void keyReleased(KeyEvent e) {
        player1.setDx(0);
        player1.setDy(0);
    }
    
    


}



