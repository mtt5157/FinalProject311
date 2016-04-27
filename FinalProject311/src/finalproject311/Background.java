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
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Graham
 */
public class Background extends Rectangle{
    public static final int SCALED = 0;
    public static final int TILED = 1;
    public static final int ACTUAL = 2;
      
    private final int FLOOR = 0;
    private final int ROOM = 1;
    
    private Image image;
    private int panelType;
    private int dy;
    private JPanel panel;
    private final Dimension size;
    private int style;
    private int w;
    private int h;

    public Background(String floorImageString, int style, Floor panel1){
        this.image =new  ImageIcon(floorImageString).getImage();
        
        this.panel = panel1;
        this.w = image.getWidth(panel);
        this.h = image.getHeight(panel);
        this.panelType = FLOOR;
        this.style = style;
        this.size = new Dimension(panel.getWidth(), panel.getHeight());
    }
    
    
    public Background(String roomImageString, int style, Room panel1){
        this.image =new  ImageIcon(roomImageString).getImage();
        this.panel = panel1;
        this.w = image.getWidth(panel);
        this.h = image.getHeight(panel);
        this.panelType = ROOM;
        this.style = style;
        this.size = new Dimension(panel.getWidth(), panel.getHeight());
    }
    
    
    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * @return the panelType
     */
    public int getPanelType() {
        return panelType;
    }

    /**
     * @param panelType the panelType to set
     */
    public void setPanelType(int panelType) {
        this.panelType = panelType;
    }

    /**
     * @return the style
     */
    public int getStyle() {
        return style;
    }

    /**
     * @param style the style to set
     */
    public void setStyle(int style) {
        this.style = style;
    }

    /**
     * @return the w
     */
    public int getW() {
        return w;
    }

    /**
     * @param w the w to set
     */
    public void setW(int w) {
        this.w = w;
    }

    /**
     * @return the h
     */
    public int getH() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setH(int h) {
        this.h = h;
    }
    
    public void paintComponent(Graphics g){
        
        switch (getStyle())
        {
                case SCALED :
                        drawScaled(g);
                        break;

                case TILED  :
                        drawTiled(g);
                        break;

                case ACTUAL :
                        drawActual(g);
                        break;

                default:
            drawScaled(g);
        }  
    }
    
    private void drawScaled(Graphics g){	
        g.drawImage(getImage(), 0, 0, size.width, size.height, null);
    }

    private void drawTiled(Graphics g){
        for (int y = 0; y < size.height; y += getH()) {
            for (int x = 0; x < size.width; x += getW()){
                g.drawImage(getImage(), x, y, panel);
            }
        }
    }
	
    private void drawActual(Graphics g){
        g.drawImage(getImage(), 0,0, panel);
    }
}

