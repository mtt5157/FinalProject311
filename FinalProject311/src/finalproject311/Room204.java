package finalproject311;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author evangentis
 */
public class Room204 extends JPanel implements ActionListener, KeyListener {
    
    
    public static final int PodeumWidth = 85;
    public static final int PodeumHeight = 65;
    public static final int LongtableWidth = 200;
    public static final int MiddletableWidth = 90;
    public static final int ShorttableWidth = 18;
    public static final int TableHeight = 50;
    public static final int FrontTableWidth = 120;
    public static final int FrontTableHeight = 50;
    public static final int WallUDWidth = 500;
    public static final int WallUDHeight = 15;
    public static final int WallLRWidth= 15;
    public static final int WallLRHeight = 485;
    public static final int TrashcanHeight = 30;
    public static final int TrashcanWidth = 30;
    public static final int PrinterHeight = 30;
    public static final int PrinterWidth = 30;
    
    
    
    private RoomObject podium;
    private RoomObject frontTable;
    private RoomObject leftDesk1;
    private RoomObject leftDesk2;
    private RoomObject middleDesk1;
    private RoomObject middleDesk2;
    private RoomObject rightDesk1;
    private RoomObject rightDesk2;
    
    private Background background;
    private int roomNumber;
    private ArrayList<RoomObject>  roomObjects;
    private Image roomImage;
    private player player1;
    private Timer timer1;
    private Floor roomFloor;
    private Image carpet;
    private RoomEntry exit;

    public Room204(int n, Floor theFloor){
       super();
       this.roomFloor = theFloor;
       this.carpet = new  ImageIcon("src/Images/carpet.png").getImage();
       this.setSize(500, 500);
       this.roomNumber =  n;
       this.exit = new RoomEntry(roomNumber, 300, 0, theFloor);
       this.roomObjects = new ArrayList<>();
       this.timer1 = new Timer(50, this);
       this.timer1.start();
       init();
       addObjectsToArayList();
       this.player1 = new player(500, 500);
       this.background = new Background("src/Images/carpet.png", Background.TILED, this);
       this.addKeyListener(this);
       this.setFocusable(true);    
    }

    private void addObjectsToArayList(){
        this.roomObjects.add(podium);
        this.roomObjects.add(frontTable);
        this.roomObjects.add(leftDesk1);
        this.roomObjects.add(leftDesk2);
        this.roomObjects.add(middleDesk1);
        this.roomObjects.add(middleDesk2);
        this.roomObjects.add(rightDesk1);
        this.roomObjects.add(rightDesk2);
    }

    private void init() {
        podium = new RoomObject(400, 20, PodeumWidth, PodeumHeight, this, "src/Images/podium.png");
        frontTable = new RoomObject(125, 90, TableHeight, LongtableWidth, this, "src/Images/classroomDesks.png");
        leftDesk1 = new RoomObject(85, 180,FrontTableWidth, FrontTableHeight, this, "src/Images/shortDesk.png");
        leftDesk2 = new RoomObject(85, 315,FrontTableWidth, FrontTableHeight, this, "src/Images/shortDesk.png");
        middleDesk1 = new RoomObject(215, 180,FrontTableWidth, FrontTableHeight, this, "src/Images/shortDesk.png");
        middleDesk2 = new RoomObject(215, 315,FrontTableWidth, FrontTableHeight, this, "src/Images/shortDesk.png");
        rightDesk1 = new RoomObject(345, 180,FrontTableWidth, FrontTableHeight, this, "src/Images/shortDesk.png");
        rightDesk2 = new RoomObject(345, 315,FrontTableWidth, FrontTableHeight, this, "src/Images/shortDesk.png");
    }
    
    /**
     * @return the roomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber the roomNumber to set
     */
    public void setRoomNumber(int n) {
        this.roomNumber = n;
    }

    /**
     * @return the roomObjects
     */
    public ArrayList<RoomObject> getRoomNumberObjects() {
        return roomObjects;
    }

    public void setRoomObjects(ArrayList<RoomObject> objects) {
        this.roomObjects = objects;
    }

    @Override
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       g.clearRect(0, 0, this.getWidth(), this.getHeight());
       checkObjectCollision(g);
       background.paintComponent(g);
       player1.paintComponent(g);
       exit.paintComponent(60,30,g);
       for (int i = 0; i<roomObjects.size(); i++){
            roomObjects.get(i).paintComponent(g);
        }  
    }
    
    private void checkObjectCollision(Graphics g){
        if (player1.intersects(exit)){
            this.roomFloor.getController().room204ToFloor(this,roomFloor);
        }
        
        for(int i = 0; i < roomObjects.size(); i++){
            
            if (player1.intersects(roomObjects.get(i))){
               Rectangle intersection = (Rectangle) player1.createIntersection(roomObjects.get(i)); 
                    
                if (player1.getDx() < 0 && player1.x >= roomObjects.get(i).x) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.x += intersection.getWidth();
                    player1.paintComponent(g);
                }

                if (player1.getDy() < 0 && player1.y >= roomObjects.get(i).y) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.y += intersection.getHeight();
                    player1.paintComponent(g);
                }

                if (player1.getDx() > 0 && player1.x <= roomObjects.get(i).x) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.x -= intersection.getWidth();
                    player1.paintComponent(g);
                }

                if (player1.getDy() > 0 && player1.y <= roomObjects.get(i).y) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.y -= intersection.getHeight();
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
     
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
        if (o == timer1) {
            this.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player1.setDx(-10);
            System.out.println("Typed");
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player1.setDx(10);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            player1.setDy(-10);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player1.setDy(10);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player1.setDx(0);
        player1.setDy(0);
    }    
}