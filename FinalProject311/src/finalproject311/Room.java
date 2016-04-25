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
    
    
    public static final int PodeumWidth = 60;
    public static final int PodeumHeight = 15;
    public static final int LongtableWidth = 175;
    public static final int MiddletableWidth = 90;
    public static final int ShorttableWidth = 18;
    public static final int TableHeight = 15;
    public static final int FrontTableWidth = 30;
    public static final int FrontTableHeight = 64;
    public static final int WallUDWidth = 450;
    public static final int WallUDHeight = 45;
    public static final int WallLRWidth= 15;
    public static final int WallLRHeight = 600;

    private Rectangle podeum;
    private Rectangle frontTable;
    private Rectangle leftDesk1;
    private Rectangle leftDesk2;
    private Rectangle leftDesk3;
    private Rectangle leftDesk4;
    private Rectangle rightDesk1;
    private Rectangle rightDesk2;
    private Rectangle rightDesk3;
    private Rectangle rightDesk4;
    private Rectangle printer;
    private Rectangle trashcan;
    private Rectangle key;
    private Rectangle wallUD1;
    private Rectangle wallUD2;
    private Rectangle wallLR1;
    private Rectangle wallLR2;
       
    private int roomNumber;
    private ArrayList<Rectangle>  roomObjects;
    private ArrayList<Object> computers;
    private Image roomImage;
    private player player1;
    private Timer timer1;
    //private GameFrame theFrame;
    
    public Room(int theRoomNumber){
       super();
       this.addKeyListener(this);
       this.player1 = new player();
       this.setFocusable(true);
       this.roomNumber =  theRoomNumber;
       this.roomObjects = new ArrayList<Rectangle>();
       this.timer1 = new Timer(50, this);
       this.timer1.start();
       this.computers = new ArrayList<Object>();
       
    }

    private void placeStations() {
        player1.setBounds(450, 150, 50, 50);
        podeum.setBounds(43, 100, PodeumWidth, PodeumHeight);
        frontTable.setBounds(363,100,PodeumWidth, PodeumHeight);
        leftDesk1.setBounds(0, 80, LongtableWidth, TableHeight);
        leftDesk2.setBounds(0,105,LongtableWidth, TableHeight);
        leftDesk3.setBounds(266,256,LongtableWidth, TableHeight);
        leftDesk4.setBounds(94,356,LongtableWidth, TableHeight);
        rightDesk1.setBounds(266,356,LongtableWidth, TableHeight);
        rightDesk2.setBounds(94,456,LongtableWidth, TableHeight);
        rightDesk3.setBounds(266,456,LongtableWidth, TableHeight);
        rightDesk4.setBounds(436, 449, LongtableWidth, TableHeight);
        printer.setBounds(444, 353, FrontTableWidth, FrontTableHeight);
        trashcan.setBounds(413, 449, FrontTableWidth, FrontTableHeight);
        key.setBounds(29, 353, FrontTableWidth, FrontTableHeight);
        wallUD1.setBounds(23,30, WallUDWidth, WallUDHeight);
        wallUD2.setBounds(23, 544, WallUDWidth, WallUDHeight);
        wallLR1.setBounds(0,66, WallLRWidth, WallLRHeight);
        wallLR2.setBounds(458,226, WallLRWidth, WallLRHeight);
   
    }
    
    private void init() {
        podeum = new Rectangle();
        frontTable = new Rectangle();
        leftDesk1 = new Rectangle();
        leftDesk2 = new Rectangle();
        leftDesk3 = new Rectangle();
        leftDesk4 = new Rectangle();
        rightDesk1 = new Rectangle();
        rightDesk2 = new Rectangle();
        rightDesk3 = new Rectangle();
        rightDesk4 = new Rectangle();
        printer = new Rectangle();
        trashcan = new Rectangle();
        key = new Rectangle();
        wallUD1 = new Rectangle();
        wallUD2 = new Rectangle();
        wallLR1 = new Rectangle();
        wallLR2 = new Rectangle();

   
        
        
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
    public ArrayList<Rectangle> getRoomObjects() {
        return roomObjects;
    }

    /**
     * @param roomObjects the roomObjects to set
     */
    public void setRoomObjects(ArrayList<Rectangle> desks) {
        this.roomObjects = desks;
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
       player1.paintComponenet(g);
       paintDesks(g);
          
        
    }
    
     public void paintDesks(Graphics g){
      for(int i = 0; i<roomObjects.size(); i++)
       {
           roomObjects.get(i).paintComponent(g);
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
    
    
}
