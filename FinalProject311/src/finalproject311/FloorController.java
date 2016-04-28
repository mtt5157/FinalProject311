package finalproject311;



import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class FloorController {
    private GameFrame frame1;
    private Floor floor1;
    private JPanel room1;
    private ArrayList<Floor> floors;
   
    
    public FloorController(){
        //floor1 = new Floor(this);
       
        frame1 = new GameFrame("SimIST");
        floors = new ArrayList<>();
        floors.add(new Floor(this));
        frame1.add(floors.get(0));
        floors.get(0).revalidate();
        floors.get(0).repaint();
        floors.get(0).setFocusable(true);
        floors.get(0).requestFocusInWindow();
        
        
    }

    
    public void floorToRoom(JPanel room1){
        frame1.remove(floors.get(0));
        
        frame1.add(room1);
        this.room1 = room1;
        room1.setFocusable(true);
        room1.requestFocusInWindow();
        frame1.revalidate();
        frame1.repaint();
    }
    
   
    
    public void roomToFloor(Room room1)
    {
        frame1.remove(room1);
        floors.remove(0);
        floors.add(new Floor(this));
        
        frame1.add(floors.get(0));
       
        floors.get(0).getPlayer().setX(50);
        floors.get(0).getPlayer().setY(100);
        floors.get(0).setFocusable(true);
        floors.get(0).requestFocusInWindow();
        
        frame1.revalidate();
        frame1.repaint();
        
    }
    
    public void room204ToFloor(Room204 room1,Floor floor)
    {
        frame1.remove(room1);
        floors.remove(0);
        floors.add(new Floor(this));
        
        frame1.add(floors.get(0));
        floors.get(0).getPlayer().setX(50);
        floors.get(0).getPlayer().setY(350);
        this.floors.get(0).setFocusable(true);
        this.floors.get(0).requestFocusInWindow();
        
        this.floors.get(0).revalidate();
        this.floors.get(0).repaint();
       
   }
            

}
