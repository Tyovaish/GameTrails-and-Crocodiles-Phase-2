package View;

import Controller.MainController;
import Model.Location.TransportationLocation;
import Model.Map.Map;
import Model.Map.Tile.TileZone;
import Model.Movement.MovementManager;
import Model.Transportation.Donkey;
import Model.Transportation.TransportationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Lazaro on 4/11/2017.
 */
public class dashBoard extends JPanel implements KeyListener{

   private  TransportationManager transportationManager;

MainController mainctrl;

    public void keyPressed(KeyEvent e){

        switch (e.getKeyCode()){
            case KeyEvent.VK_0:{
                mainctrl.getKeyPress(0);
                break;
            }
            case KeyEvent.VK_1:{
                mainctrl.getKeyPress(1);
                break;
            }
            case KeyEvent.VK_2:{
                mainctrl.getKeyPress(2);
                break;
            }
            case KeyEvent.VK_3:{
                mainctrl.getKeyPress(3);
                break;
            }
            case KeyEvent.VK_4:{
                mainctrl.getKeyPress(4);
                break;
            }
            case KeyEvent.VK_5:{
                mainctrl.getKeyPress(5);
                break;
            }
            case KeyEvent.VK_6:{
                mainctrl.getKeyPress(6);
                break;
            }
            case KeyEvent.VK_ENTER:{
                mainctrl.getEnter();
                break;
            }
            case KeyEvent.VK_SHIFT:{
                mainctrl.getShift();
                break;
            }
        }

    }

    public void keyReleased(KeyEvent e){
    }

    public void keyTyped(KeyEvent e){
    }

    dashBoard(Map board){
        setPreferredSize(new Dimension(500,1000));
        addKeyListener(this);
        setFocusable(true);
       // transportationManager=new TransportationManager();
        MovementManager movementManager=new MovementManager(board,transportationManager);
        transportationManager.addTransportation(new Donkey(movementManager), new TransportationLocation(0,5, new TileZone()));
        mainctrl=new MainController(transportationManager);
    }
}
