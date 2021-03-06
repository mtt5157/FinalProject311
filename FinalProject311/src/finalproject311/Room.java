/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Graham
 */
public class Room extends JPanel implements ActionListener, KeyListener{
    
    
    public static final int PodeumWidth = 75;
    public static final int PodeumHeight = 55;
    public static final int LongtableWidth = 200;
    public static final int MiddletableWidth = 90;
    public static final int ShorttableWidth = 18;
    public static final int TableHeight = 40;
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
    private RoomObject prfessor;
    private RoomObject frontTable;
    private RoomObject leftDesk1;
    private RoomObject leftDesk2;
    private RoomObject leftDesk3;
    private RoomObject leftDesk4;
    private RoomObject rightDesk1;
    private RoomObject rightDesk2;
    private RoomObject rightDesk3;
    private RoomObject rightDesk4;
    private RoomObject printer;
    private RoomObject trashcan;
    private RoomObject key;
    private RoomObject wallUD1;
    private RoomObject wallUD2;
    private RoomObject wallLR1;
    private RoomObject wallLR2;
    
    private Background background;
    private int roomNumber;
    private ArrayList<RoomObject>  roomObjects;
    private Image roomImage;
    private player player1;
    private Timer timer1;
    private Image carpet;
    private Floor roomFloor;
    private RoomEntry exit;
    
    public Room(int theRoomNumber, Floor theFloor){
       super();
       
       this.roomFloor = theFloor;
       this.roomNumber =  theRoomNumber;
       this.exit = new RoomEntry(roomNumber, 400, 0, theFloor);
       this.carpet = new  ImageIcon("src/Images/carpet.png").getImage();
       this.setSize(500, 500);
       
       this.roomObjects = new ArrayList<>();
       this.timer1 = new Timer(50, this);
       this.timer1.start();
       init();
       addObjectsToArayList();
       this.player1 = new player(400, 30,300, 500);
       this.background = new Background("src/Images/carpet.png", Background.TILED, this);
       this.addKeyListener(this);
       this.setFocusable(true);
       this.player1.setLocation(400, 30);
    }
    
    

    private void addObjectsToArayList(){
        this.roomObjects.add(prfessor);
        this.roomObjects.add(podium);
        this.roomObjects.add(frontTable);
        this.roomObjects.add(leftDesk1);
        this.roomObjects.add(leftDesk2);
        this.roomObjects.add(leftDesk3);
        this.roomObjects.add(leftDesk4);
        this.roomObjects.add(rightDesk1);
        this.roomObjects.add(rightDesk2);
        this.roomObjects.add(rightDesk3);
        this.roomObjects.add(rightDesk4);
        this.roomObjects.add(printer);
        this.roomObjects.add(trashcan);
        //this.roomObjects.add(wallUD1);
        //this.roomObjects.add(wallUD2);
        //this.roomObjects.add(wallLR1);
        //this.roomObjects.add(wallLR2);
    }

    private void init() {
        prfessor = new RoomObject(110, 5, 35, 35, this, "src/Images/professor.png");
        podium = new RoomObject(100, 10, PodeumWidth, PodeumHeight, this, "src/Images/podium.png");
        frontTable = new RoomObject(0, 0,FrontTableWidth, FrontTableHeight, this, "src/Images/shortDesk.png");
        leftDesk1 = new RoomObject(0, 150, TableHeight, LongtableWidth,this, "src/Images/classroomDesks.png");
        leftDesk2 = new RoomObject(0, 235,TableHeight, LongtableWidth, this, "src/Images/classroomDesks.png");
        leftDesk3 = new RoomObject(0, 320,TableHeight, LongtableWidth, this, "src/Images/classroomDesks.png");
        leftDesk4 = new RoomObject(0, 405,TableHeight, LongtableWidth, this, "src/Images/classroomDesks.png");
        rightDesk1 = new RoomObject(285, 150,TableHeight, LongtableWidth, this, "src/Images/classroomDesks.png");
        rightDesk2 = new RoomObject(285, 235,TableHeight, LongtableWidth, this, "src/Images/classroomDesks.png");
        rightDesk3 = new RoomObject(285, 320,TableHeight, LongtableWidth, this, "src/Images/classroomDesks.png");
        rightDesk4 = new RoomObject(285, 405, TableHeight, LongtableWidth, this, "src/Images/classroomDesks.png");
        printer = new RoomObject(455, 90, PrinterWidth, PrinterHeight, this, "src/Images/printer.png");
        trashcan = new RoomObject(455, 55, TrashcanWidth, TrashcanHeight, this, "src/Images/trashcan.png");
        wallUD1 = new RoomObject(-15,0, WallUDWidth, WallUDHeight, this, "src/Images/classroomDesks.png");
        wallUD2 = new RoomObject(485,0, WallUDWidth, WallUDHeight, this, "src/Images/classroomDesks.png");
        wallLR1 = new RoomObject(0, -15, WallLRWidth, WallLRHeight, this, "src/Images/classroomDesks.png");
        wallLR2 = new RoomObject(0, 485, WallLRWidth, WallLRHeight, this, "src/Images/classroomDesks.png");   
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
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * @return the roomObjects
     */
    public ArrayList<RoomObject> getRoomObjects() {
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
            this.roomFloor.getController().roomToFloor(this);
        }
        
        for(int i = 0; i < roomObjects.size(); i++){
            
            if (player1.intersects(roomObjects.get(i))){
               Rectangle intersection = (Rectangle) player1.createIntersection(roomObjects.get(i)); 
                    
                if (player1.getDx() < 0 && player1.x >= roomObjects.get(i).x) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.x += intersection.getWidth();
                    checkForObjectMessage(roomObjects.get(i));
                    player1.paintComponent(g);
                }

                if (player1.getDy() < 0 && player1.y >= roomObjects.get(i).y) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.y += intersection.getHeight();
                    checkForObjectMessage(roomObjects.get(i));
                    player1.paintComponent(g);
                }

                if (player1.getDx() > 0 && player1.x <= roomObjects.get(i).x) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.x -= intersection.getWidth();
                    checkForObjectMessage(roomObjects.get(i));
                    player1.paintComponent(g);
                }

                if (player1.getDy() > 0 && player1.y <= roomObjects.get(i).y) {
                    player1.setDy(0);
                    player1.setDx(0);
                    player1.setStep(0); 
                    player1.y -= intersection.getHeight();
                    checkForObjectMessage(roomObjects.get(i));
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
    
    public void checkForObjectMessage(RoomObject obj){
        if(obj.equals(printer)){
                    JOptionPane.showMessageDialog(null, "Beep Beep I'm a copier", "" + "Copier", JOptionPane.INFORMATION_MESSAGE);
                }
                if(obj.equals(trashcan)){
                    JOptionPane.showMessageDialog(null, "It's Empty", "Trash Can " + "", JOptionPane.INFORMATION_MESSAGE);
                }
                if(obj.equals(prfessor) || obj.equals(podium)){
                    JOptionPane.showMessageDialog(null, "Penn State's network crashed,\n go find Prof. Oak in IT", "Professor " + "", JOptionPane.INFORMATION_MESSAGE);
                }
                if  (
                        obj.equals(leftDesk1)
                        || obj.equals(leftDesk1) 
                        || obj.equals(leftDesk1) 
                        || obj.equals(leftDesk2) 
                        || obj.equals(leftDesk3) 
                        || obj.equals(leftDesk4) 
                        || obj.equals(rightDesk1) 
                        || obj.equals(rightDesk2)
                        || obj.equals(rightDesk3) 
                        || obj.equals(rightDesk4) 
                    )
                {
                    JOptionPane.showMessageDialog(null, "Access Denied: Login credentials invalid", "Console: " + "Error", JOptionPane.INFORMATION_MESSAGE);
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
