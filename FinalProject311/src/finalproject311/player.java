/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject311;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Zack Lehmann
 */
public class player extends Rectangle {
       

       private int dx;
       private int dy;
       private PlayerMovement pm;
       private final Dimension size;
       private Image playerImage;
       private final int playerSize;
       private final int playerSpeed;
       private Floor panel1;

        public player(int panelWidth, int panelHeight) {
            this.dx = 0;
            this.dy = 0;
            playerImage = new ImageIcon("src/Images/sprite.png").getImage();
            this.size = new Dimension(panelWidth, panelHeight);
            this.playerSize = 50;
            this.playerSpeed = 10;
            
            this.setBounds(200, 50, playerSize, playerSize);
            
        }

        public void move() {
            this.x += dx;
            this.y += dy;
        }

//        public void keyPressed(KeyEvent e){
//        if(e.getKeyCode() == KeyEvent.VK_LEFT)
//        {
//            this.dx = -20;
//        }
//        else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
//        {
//            this.dx = 20;
//        }
//        else if(e.getKeyCode() == KeyEvent.VK_UP)
//        {
//            this.dx = -20;
//        }
//        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
//        {
//            this.dx = 20;
//        }
//        }
//         public void keyReleased(KeyEvent e){
//             
//        this.dx = 0;
//        }
        public void setDx(int dx) {
            this.dx = dx;
        }

        public void setDy(int dy) {
            this.dy = dy;
        }

        public void paintComponent(Graphics g) {
            move();
            g.drawRect(x, y, 30, 30);
        }
        
    
    
    
}
