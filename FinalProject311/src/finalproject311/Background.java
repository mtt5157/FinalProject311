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
        //this.setBounds(x, y, 500, 500);
    }
    
    
    public Background(String roomImageString, int style, Room panel1){
        this.image =new  ImageIcon(roomImageString).getImage();
        this.panel = panel1;
        this.w = image.getWidth(panel);
        this.h = image.getHeight(panel);
        this.panelType = ROOM;
        this.style = style;
        this.size = new Dimension(panel.getWidth(), panel.getHeight());
       
        
        //this.setBounds(x, y, 500, 500);
    }
    
    
    public void paintComponent(Graphics g){
        
        switch (style)
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
    
    private void drawScaled(Graphics g)
	{
		
		g.drawImage(image, 0, 0, size.width, size.height, null);
	}

	/*
	 *  Custom painting code for drawing TILED images as the background
	 */
	private void drawTiled(Graphics g)
	{
            for (int y = 0; y < size.height; y += h) {
                    for (int x = 0; x < size.width; x += w) {
                        
                        g.drawImage(image, x, y, panel);
                        
                }
            }
            
            
                
                
		 
	}

	
	private void drawActual(Graphics g)
	{
		
		g.drawImage(image, 0,0, panel);
	}
    
    
    
    public double getCurrentX() {
        return super.getX();
    }
    
    public double getCurrrentY() {
        return super.getY();
    }
    
  
    
}

