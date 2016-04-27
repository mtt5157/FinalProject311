/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject311;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Graham
 */
public class RoomObject extends Rectangle {
    private int xLocation;
    private int yLocation;
    private int height;
    private int width;
    private JPanel panel1;
    private Image objectImage;
    
    public RoomObject(int x, int y, int height, int width, JPanel panel1, String objImageSource){
        this.xLocation = x;
        this.yLocation = y;
        this.height = height;
        this.width = width;
        this.panel1=panel1;
        this.objectImage = new ImageIcon(objImageSource).getImage();
        this.setBounds(this.xLocation, this.yLocation, this.width, this.height);
    }
    
    public void paintComponent(Graphics g){
           g.drawImage(objectImage, x, y, width, height, panel1);
       }

    /**
     * @return the xLocation
     */
    public int getxLocation() {
        return xLocation;
    }

    /**
     * @param xLocation the xLocation to set
     */
    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    /**
     * @return the yLocation
     */
    public int getyLocation() {
        return yLocation;
    }

    /**
     * @param yLocation the yLocation to set
     */
    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }

    /**
     * @return the panel1
     */
    public JPanel getPanel1() {
        return panel1;
    }

    /**
     * @param panel1 the panel1 to set
     */
    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
    
    
}
