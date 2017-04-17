package View;

import Controller.MainController;
import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.Resource.ResourceManager;
import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

import java.util.ArrayList;

/**
 * Created by Lazaro on 4/16/2017.
 */
public class DisplayManager {
    TransportationManager transport;
    ResourceManager resource;
    Map board;
    MainController mainctrl;
    public Tile getTile(int row, int col){
        return board.getTileAt(row, col);
    }

    public ArrayList<Transportation> getTransportList(){
        return transport.getTransportationList();
    }

    public void load(){}//load resources
    public void unload(){} //unload resources

    public String getState(){
        return mainctrl.print();
    }




    DisplayManager(Map board){
        this.board = board;
        transport = new TransportationManager(board);
        resource = new ResourceManager(transport);
//        mainctrl = new MainController(transport);

    }
}
