package finalproject311;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zack
 */
public class PlayerMovement {
    private String animation = "left1.png";
    private String facing = "Left";
    private int frame = 0;
    


    public PlayerMovement(String face) {
     
        this.facing = face;
    }

    public String getAnimation() {
        return animation;
    }

    public void setAnimation(String set) {
        animation = set;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String set) {
        facing = set;
    }
    
    
    public int getFrame()
    {
        return frame;
    }
    
    public void setFrame(int set)
    {
        frame = set;
    }


}


