package finalproject311;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import static java.awt.Color.RED;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;


/**
 *
 * @author matthewtucker
 */
public class RoomEntry extends Rectangle {
    private int roomNum;
       private int floor;
       private int capacity;
       private int xLocation;
       private int yLocation;
       private JPanel panel1;
       //private JPanel roomView;
       
       public RoomEntry(int roomNum, int x, int y, JPanel panel1 ){
           this.roomNum = roomNum;
           //this.roomView = roomView;
           this.xLocation = x;
           this.yLocation = y;
           this.capacity = 50;
           this.floor = 1;
           this.panel1=panel1;
           
           this.setBounds(this.xLocation, this.yLocation, 30, 30);
       }
       
       public void paintComponent(Graphics g){
           g.setColor(RED);
           g.fillRect(x, y, 30, 60);
       }
       
       public int getNum(){
           return this.roomNum;
       }
       
       public JPanel getRoom(){
           return this.panel1;
       }
   }
   
   