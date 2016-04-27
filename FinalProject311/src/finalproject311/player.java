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
       
       private final Dimension size;
       private Image playerImage;
       private final int playerSize;
       private final int playerSpeed;
       private Floor panel1;
       private int step = 0;

        public player(int panelWidth, int panelHeight) {
            this.dx = 0;
            this.dy = 0;
            playerImage = new ImageIcon("src/Images/player_back.png").getImage();
            this.size = new Dimension(panelWidth, panelHeight);
            this.playerSize = 50;
            this.playerSpeed = 10;
            
            this.setBounds(200, 50, playerSize, playerSize);
            
        }

        public void move() {
            String imagePath = "";
            this.x += dx;
            this.y += dy;
            if(dx == -20)
            {
                if(step ==0)
                {
                    imagePath = "src/Images/player_left.png";
                     step = 1;
                }
                else if(step ==1)
                {
                    imagePath = "src/Images/left_step.png";
                    step = 0;
                }
                playerImage = new ImageIcon(imagePath).getImage();
               
            }
            else if(dx == 20)
            {
                 if(step ==0)
                {
                    imagePath = "src/Images/player_right.png";
                     step = 1;
                }
                else if(step ==1)
                {
                    imagePath = "src/Images/right_step.png";
                    step = 0;
                }
                playerImage = new ImageIcon(imagePath).getImage();
               
            }
            else if(dy == -20)
            {
                 if(step ==0)
                {
                    imagePath = "src/Images/player_front.png";
                     step = 1;
                }
                else if(step ==1)
                {
                    imagePath = "src/Images/front_step.png";
                    step = 0;
                }
                playerImage = new ImageIcon(imagePath).getImage();
               
            }
            else if(dy == 20)
            {
                 if(step ==0)
                {
                    imagePath = "src/Images/player_back.png";
                     step = 1;
                }
                else if(step ==1)
                {
                    imagePath = "src/Images/back_step.png";
                    step = 0;
                }
                playerImage = new ImageIcon(imagePath).getImage();
                 
            }
        }

        public void setDx(int dx) {
            this.dx = dx;
        }
        public int getDx(){
            return this.dx;
        }
        
        public int getDy(){
            return this.dy;
        }

        public void setDy(int dy) {
            this.dy = dy;
        }

        public void paintComponent(Graphics g) {
            move();
            g.drawImage(playerImage, x, y, width, height, panel1);
        }
        
        public void setX( int x){
            this.x = x;
        }
        
        public void setY(int y){
            this.y =y;
        }
    
    
}
