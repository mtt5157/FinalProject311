/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject311;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author Graham
 */
public class Divider extends Rectangle{
    private int dy;
    private final Dimension size;
    private Image dividerImage;
    
    private String deskID;
    
    
    public Divider(int panelHeight, int panelWidth,int deskx,int desky, String Name) {
        
        
        this.deskID = Name;
        this.size = new Dimension(panelWidth, panelHeight);
        this.setBounds(deskx, desky, panelHeight, panelWidth);  
      
    }
    
    
    public void paintComponent(Graphics g){
        move();
        g.setColor(Color.CYAN);
        g.draw3DRect(this.x, this.y, this.width, this.height, true);
        g.fill3DRect(x, y, width, height, true);
    }
    
    public double getCurrentX() {
        return super.getX();
    }
    
    public double getCurrrentY() {
        return super.getY();
    }
    
  
    public void move() {
        
        
    }
    
}


