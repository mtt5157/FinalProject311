/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.FloorController;
import entities.Room;
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
import models.CharacterMovement;
import models.Customer;
import models.RoomEntry;
import models.AbpEntry;
import models.MeetingRoomMovement;

/**
 *
 * @author matthewtucker
 */
public class Floor1 extends JPanel implements ActionListener, KeyListener{

    private String floorName;
    private Image floorImage;
    private Timer refreshTimer;
    private FloorController controller;
    private ArrayList<JPanel> rooms;
    private ArrayList<RoomEntry> entries;
    private player player1;
    private AbpEntry entry1;
    private AuBonPainPanel abp1;
    private Customer cust1;
    private CharacterMovement charMove1;
    private MeetingRoomPanel mrPanel;
    private MeetingRoomMovement mrMovement;
    private Room206 room206;
    public Floor1(String floorName, FloorController cont1) {
        this.floorName = floorName;
        this.controller = cont1;
        refreshTimer = new Timer(50, this);
        refreshTimer.start();
        rooms = new ArrayList<>();
        entries = new ArrayList<>();
        
        cust1 = new Customer(new Dimension(800, 600));
        charMove1 = new CharacterMovement();
        mrMovement = new MeetingRoomMovement(cust1);
        abp1 = new AuBonPainPanel(cust1, charMove1);
        mrPanel = new MeetingRoomPanel(cust1,mrMovement);
        room206 = new Room206(cust1,charMove1);
       
        entry1 = new AbpEntry(1, 450, 50, abp1);
        
        rooms.add(new Room(202));
        rooms.add(new Room(204));
        rooms.add(room206);
        rooms.add(new Room(208));
        rooms.add(mrPanel);
        
        entries.add(new RoomEntry(202, 50, 100, rooms.get(0)));
        entries.add(new RoomEntry(204, 50, 150, rooms.get(1)));
        entries.add(new RoomEntry(208, 50, 250, rooms.get(3)));
        entries.add(new RoomEntry(206, 50, 250, rooms.get(2)));
        entries.add(new RoomEntry(210, 50, 300, rooms.get(4)));
        
        player1 = new player();
        
       
        
        this.addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, this.getWidth(), this.getHeight());

        player1.paintComponent(g);
        for (int i = 0; i < entries.size() - 1; i++) {
            entries.get(i).paintComponent(g);
        }

        entry1.paintComponent(g);

        for (int i = 0; i < entries.size(); i++) {
            entries.get(i).paintComponent(g);
        }

        for (int i = 0; i < entries.size(); i++) {
            if (player1.intersects(entries.get(i))) {
                controller.floorToRoom(entries.get(i).getRoom());
                 System.out.println("Collision");
            }
        }
        if (player1.intersects(entry1)) {
           controller.floorToAbp(entry1.getAbpPanel());
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == refreshTimer) {
            this.repaint();
        }
    }

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player1.setDx(-20);

            System.out.println("Typed");
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player1.setDx(20);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            player1.setDy(-20);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player1.setDy(20);
        }
    }

    public void keyReleased(KeyEvent e) {
        player1.setDx(0);
        player1.setDy(0);
    }


}

/*
######Graham's super cool hallway code ######

public Hallway(){
       super();
       this.addKeyListener(this);
       this.player1 = new Player1(500, 500);
       this.theFrame = new GameFrame1(this);
       this.setFocusable(true);
       this.dividers = new ArrayList<Divider>();
       this.tables = new ArrayList<Table>();
       this.trashcans = new ArrayList<>();
       populateObjects();
       this.timer1 = new Timer(50, this);
       this.timer1.start();
       
    }
    
    #tables and dividers can be just remade as rectabgles
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
    
    @Override
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       g.clearRect(0, 0, this.getWidth(), this.getHeight());
       player1.paintComponenet(g);
       paintObjects(g);
          
        
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
     
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
        if(o== timer1){
            this.repaint();

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player1.keyPressed(e);
        System.out.println("Hi");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player1.keyReleased(e);
    }

    
    public ArrayList<Table> getTables() {
        return tables;
    }

    
    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    
    public ArrayList<Divider> getDividers() {
        return dividers;
    }

    
    public void setDividers(ArrayList<Divider> dividers) {
        this.dividers = dividers;
    }

    
    public ArrayList<Trashcan> getTrashcans() {
        return trashcans;
    }

    
    public void setTrashcans(ArrayList<Trashcan> trashcans) {
        this.trashcans = trashcans;
    }

    
    public Player1 getPlayer1() {
        return player1;
    }

    
    public void setPlayer1(Player1 player1) {
        this.player1 = player1;
    }

    
    public GameFrame1 getTheFrame() {
        return theFrame;
    }

    
    public void setTheFrame(GameFrame1 theFrame) {
        this.theFrame = theFrame;
    }

    
    public Timer getTimer1() {
        return timer1;
    }

    
    public void setTimer1(Timer timer1) {
        this.timer1 = timer1;
    }
    
    
    
    
    
}
*/

