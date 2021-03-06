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
    private Background tileFloor;
   
 
    public Floor( FloorController cont1) {
        this.floorName = floorName;
        this.controller = cont1;
        this.setSize(500, 500);
        refreshTimer = new Timer(50, this);
        refreshTimer.start();
        rooms = new ArrayList<>();
        entries = new ArrayList<>();
        this.dividers = new ArrayList<Divider>();
        this.tables = new ArrayList<Table>();
        this.trashcans = new ArrayList<>();
        this.obstacles = new ArrayList<>();
        this.tileFloor = new Background("src/Images/floor_tile2.png", Background.TILED, this);
        populateObjects();
        collision =false;
       
        
        rooms.add(new Room(202, this));
        rooms.add(new Room204(204, this));

        
        entries.add(new RoomEntry(202, 0, 100, rooms.get(0)));
        entries.add(new RoomEntry(204, 0, 350, rooms.get(1)));

        
        player1 = new player(200, 50,500,500);
        
       
        
        this.addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        
    }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        tileFloor.paintComponent(g);
        player1.paintComponent(g);
        
       paintObjects(g);     
       checkObjectCollision(g);

      paintEntries(g);                
      checkEntryCollision();
      
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
        
        obstacles.add(divider1);
        obstacles.add(divider2);
        obstacles.add(divider3);
        
        obstacles.add(table1);
        obstacles.add(table2);
        obstacles.add(table3);
        obstacles.add(trashcan1);
        dividers.add(divider1);
        dividers.add(divider2);
        dividers.add(divider3);
        
        tables.add(table1);
        tables.add(table2);
        tables.add(table3);
        
    }

    
        private void checkObjectCollision(Graphics g){
        
        
        for(int i = 0; i < obstacles.size(); i++){
            
            if (player1.intersects(obstacles.get(i))){
               Rectangle intersection = (Rectangle) player1.createIntersection(obstacles.get(i)); 
                    
                if (player1.getDx() < 0 && player1.x >= obstacles.get(i).x) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.x += intersection.getWidth();
                    player1.paintComponent(g);
                }

                if (player1.getDy() < 0 && player1.y >= obstacles.get(i).y) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.y += intersection.getHeight()+30;
                    player1.paintComponent(g);
                }

                if (player1.getDx() > 0 && player1.x <= obstacles.get(i).x) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.x -= intersection.getWidth();
                    player1.paintComponent(g);
                }

                if (player1.getDy() > 0 && player1.y <= obstacles.get(i).y) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.y -= intersection.getHeight()+30;
                    player1.paintComponent(g);
                }
            }
            
                if (player1.getDx() < 0 && player1.x <= 0) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.x += 10;
                    player1.paintComponent(g);
                }
                if (player1.getDx() > 0 && player1.x >= 500) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.x -= 10;
                    player1.paintComponent(g);
                }
                if (player1.getDy() > 0 && player1.y >= 500) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.y -= 10;
                    player1.paintComponent(g);
                }
                if (player1.getDy() < 0 && player1.y <= 0) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.y += 10;
                    player1.paintComponent(g);
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
            
           if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player1.setDx(-10);
          
            
            }
           
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player1.setDx(10);
      
            } 
            
            else if (e.getKeyCode() == KeyEvent.VK_UP) {
            player1.setDy(-10);
       
            } 
            
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player1.setDy(10);
         
        }
     }
        
    

    public void keyReleased(KeyEvent e) {
        player1.setDx(0);
        player1.setDy(0);
    }

    /**
     * @return the controller
     */
    public FloorController getController() {
        return controller;
    }

    /**
     * @param controller the controller to set
     */
    public void setController(FloorController controller) {
        this.controller = controller;
    }
    
    public void checkEntryCollision (){
          for (int i = 0; i < entries.size(); i++) {
            if (player1.intersects(entries.get(i))) {
                getController().floorToRoom(entries.get(i).getRoom());
                
            }
        }
        
    }
    
    public void paintEntries(Graphics g){
        for (int i = 0; i < entries.size(); i++) {
            entries.get(i).paintComponent(30, 60, g);
        }
    }
    
    public player getPlayer(){
        return this.player1;
    }
    
    


}



