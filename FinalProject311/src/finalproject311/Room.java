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
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author matthewtucker
 */
public class Room extends JPanel implements ActionListener, KeyListener{
    
    
    public static final int PodeumWidth = 35;
    public static final int PodeumHeight = 35;
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
    
    
    
    private RoomObject podeum;
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
       
    private int roomNumber;
    private ArrayList<RoomObject>  roomObjects;
    private ArrayList<Object> computers;
    private Image roomImage;
    private player player1;
    private Timer timer1;
    //private GameFrame theFrame;
    
    public Room(int theRoomNumber){
       super();
       
       this.roomNumber =  theRoomNumber;
       this.roomObjects = new ArrayList<>();
       this.timer1 = new Timer(50, this);
       this.timer1.start();
       this.computers = new ArrayList<>();
       init();
       addObjectsToArayList();
       this.player1 = new player(500, 500);
       
       this.addKeyListener(this);
       this.setFocusable(true);
       
    }
    
    private void addObjectsToArayList(){
        this.roomObjects.add(podeum);
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
        this.roomObjects.add(wallUD1);
        this.roomObjects.add(wallUD2);
        this.roomObjects.add(wallLR1);
        this.roomObjects.add(wallLR2);
    }

    private void init() {
        podeum = new RoomObject(100, 20, PodeumWidth, PodeumHeight, this);
        frontTable = new RoomObject(0, 0,FrontTableWidth, FrontTableHeight, this);
        leftDesk1 = new RoomObject(0, 155, TableHeight, LongtableWidth,this);
        leftDesk2 = new RoomObject(0, 240,TableHeight, LongtableWidth, this);
        leftDesk3 = new RoomObject(0, 325,TableHeight, LongtableWidth, this);
        leftDesk4 = new RoomObject(0, 410,TableHeight, LongtableWidth, this);
        rightDesk1 = new RoomObject(285, 155,TableHeight, LongtableWidth, this);
        rightDesk2 = new RoomObject(285, 240,TableHeight, LongtableWidth, this);
        rightDesk3 = new RoomObject(285, 325,TableHeight, LongtableWidth, this);
        rightDesk4 = new RoomObject(285, 410, TableHeight, LongtableWidth, this);
        printer = new RoomObject(455, 25, PrinterWidth, PrinterHeight, this);
        trashcan = new RoomObject(455, 60, TrashcanWidth, TrashcanHeight, this);
        key = new RoomObject(250, 250, FrontTableWidth, FrontTableHeight, this);
        wallUD1 = new RoomObject(-15,0, WallUDWidth, WallUDHeight, this);
        wallUD2 = new RoomObject(485,0, WallUDWidth, WallUDHeight, this);
        wallLR1 = new RoomObject(0, -15, WallLRWidth, WallLRHeight, this);
        wallLR2 = new RoomObject(0, 485, WallLRWidth, WallLRHeight, this);   
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

    /**
     * @return the computers
     */
    public ArrayList<Object> getComputers() {
        return computers;
    }

    /**
     * @param computers the computers to set
     */
    public void setComputers(ArrayList<Object> computers) {
        this.computers = computers;
    }

    @Override
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       g.clearRect(0, 0, this.getWidth(), this.getHeight());
       
       player1.paintComponent(g);
       for (int i = 0; i<roomObjects.size(); i++)
        {
            roomObjects.get(i).paintComponent(g);
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

    @Override
    public void keyReleased(KeyEvent e) {
        player1.setDx(0);
        player1.setDy(0);
    }
    
}
