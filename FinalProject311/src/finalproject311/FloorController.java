package finalproject311;



import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class FloorController {
    private GameFrame frame1;
    private Floor floor1;
    private JPanel room1;
   
    
    public FloorController(){
        floor1 = new Floor("Floor1", this);
        frame1 = new GameFrame("SimIST");
 
        frame1.add(floor1);
        floor1.revalidate();
        floor1.repaint();
        floor1.setFocusable(true);
        floor1.requestFocusInWindow();
    }

    //protected ArrayList<Unit> unitList = new ArrayList<Unit>();

//    public void addUnit(Unit u) {
//        this.unitList.add(u);
//    }
//    
//    public void removeUnit(Unit u){
//        this.unitList.remove(u);
//    } 
//
//    public ArrayList<Unit> getUnitList() {
//        return this.unitList;
//    }
//
//    public void setUnitList(ArrayList<Unit> unitList) {
//        this.unitList = unitList;
//    }
    
    public void floorToRoom(JPanel room1){
        frame1.remove(floor1);
        frame1.add(room1);
        this.room1 = room1;
        room1.setFocusable(true);
        room1.requestFocusInWindow();
        frame1.revalidate();
        frame1.repaint();
    }
    
   
    
    public void roomToFloor(Floor floor)
    {
        frame1.remove(room1);
        frame1.add(floor);
        frame1.revalidate();
        frame1.repaint();
    }
            

}
