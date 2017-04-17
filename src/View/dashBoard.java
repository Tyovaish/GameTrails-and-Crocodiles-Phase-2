package View;

import Controller.MainController;
import Model.Abilities.MovementAbility;
import Model.Location.ResourceLocation;
import Model.Location.TransportationLocation;
import Model.Map.Map;
import Model.Movement.MovementManager;
import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.Resource;
import Model.Resource.ResourceBag;
import Model.Resource.ResourceManager;
import Model.Transportation.Donkey;
import Model.Transportation.TransportationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by Lazaro on 4/11/2017.
 */
public class dashBoard extends JPanel implements KeyListener{

   private  TransportationManager transportationManager;
   MainController mainctrl;
   DisplayManager manager;
   Graphics2D g2;
   String str = "";
   boolean draw = false;
    ArrayList<MovementAbility> movementList;

    public void keyPressed(KeyEvent e){

        switch (e.getKeyCode()){
            case KeyEvent.VK_0:{
                mainctrl.getKeyPress(0);
                str = mainctrl.print();
                this.repaint();
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
                str = mainctrl.print();
               this.repaint();
                break;
            }
            case KeyEvent.VK_D:{
                movementList = transportationManager.getMovementList();
                draw = true;
                this.repaint();
            }
            case KeyEvent.VK_SHIFT:{
                mainctrl.getShift();
                str = mainctrl.print();
                this.repaint();
                break;
            }
        }

    }

    public void keyReleased(KeyEvent e){
    }

    public void keyTyped(KeyEvent e){
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g2 = (Graphics2D) g;
        g2.setFont(new Font("Times New Roman",Font.BOLD,50));
        g2.drawString(str,100,150);
        if(draw)
       drawlist(g2);

    }

    private void drawlist(Graphics2D g2){
        switch(movementList.size()){
            case 3:{
                g2.drawString(movementList.get(0).print(),200,200);
                g2.drawString(movementList.get(1).print(),200,250);
                g2.drawString(movementList.get(2).print(),200,300);
                break;
            }
        }
    }
    dashBoard(Map board, DisplayManager manger){
        setPreferredSize(new Dimension(700,1000));
        addKeyListener(this);
        setFocusable(true);
        manager = manger;


        transportationManager=new TransportationManager(board);
        ResourceManager resourceManager=new ResourceManager(transportationManager);
        MovementManager movementManager=new MovementManager(board,transportationManager);
        transportationManager.setMovementManager(movementManager);
        transportationManager.setResourceManager(resourceManager);

        ResourceBag resourceBag=new ResourceBag(resourceManager);
        Resource resource=new Trunk();
        Donkey donkey =new Donkey(resourceBag);
        donkey.addResource(resource);
        resourceManager.addResource(resource,new ResourceLocation(0,0,board.getTileAt(0,0).getTileZone(0)));
        transportationManager.addTransportation(donkey, new TransportationLocation(0,0, board.getTileAt(0,0).getTileZone(0)));
        mainctrl=new MainController(transportationManager);

    }
}
