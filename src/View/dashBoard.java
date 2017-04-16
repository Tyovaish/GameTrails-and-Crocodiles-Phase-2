package View;

import Controller.MainController;
import Model.Location.ResourceLocation;
import Model.Location.TransportationLocation;
import Model.Map.Map;
import Model.Movement.MovementManager;
import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.Resource;
import Model.Resource.ResourceManager;
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
       TransportationManager transportationManager=new TransportationManager(board);
        ResourceManager resourceManager=new ResourceManager(transportationManager);
        Resource resource=new Trunk();
        resourceManager.addResource(resource,new ResourceLocation(0,0,board.getTileAt(0,0).getTileZone(0)));
        MovementManager movementManager=new MovementManager(board,transportationManager);
        Donkey donkey =new Donkey(movementManager);
        donkey.addResource(resource);
        transportationManager.addTransportation(donkey, new TransportationLocation(0,0, board.getTileAt(0,0).getTileZone(0)));
        mainctrl=new MainController(transportationManager);
    }
}
