package View;

import Controller.MainController;

import Model.Abilities.MovementAbility;
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
   boardView board;
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
                int x = transportationManager.getTransportationLocation(transportationManager.getTransportationList().get(0)).getX();
                int y = transportationManager.getTransportationLocation(transportationManager.getTransportationList().get(0)).getY();
                board.setCurrentLocationCursor(x,y);
                if(str.equals("Movement")) {
                    movementList = transportationManager.getMovementList();
                    draw = true;
                }
               this.repaint();
                break;
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
            case 1:{
                g2.drawString(movementList.get(0).print(),200,200);
                break;
            }
            case 2:{
                g2.drawString(movementList.get(0).print(),200,200);
                g2.drawString(movementList.get(1).print(),200,250);
                break;
            }
            case 3:{
                g2.drawString(movementList.get(0).print(),200,200);
                g2.drawString(movementList.get(1).print(),200,250);
                g2.drawString(movementList.get(2).print(),200,300);
                break;
            }
            case 4:{
                g2.drawString(movementList.get(0).print(),200,200);
                g2.drawString(movementList.get(1).print(),200,250);
                g2.drawString(movementList.get(2).print(),200,300);
                g2.drawString(movementList.get(3).print(),200,350);
                break;
            }
            case 5:{
                g2.drawString(movementList.get(0).print(),200,200);
                g2.drawString(movementList.get(1).print(),200,250);
                g2.drawString(movementList.get(2).print(),200,300);
                g2.drawString(movementList.get(3).print(),200,350);
                g2.drawString(movementList.get(4).print(),200,400);
                break;
            }
            case 6:{
                g2.drawString(movementList.get(0).print(),200,200);
                g2.drawString(movementList.get(1).print(),200,250);
                g2.drawString(movementList.get(2).print(),200,300);
                g2.drawString(movementList.get(3).print(),200,350);
                g2.drawString(movementList.get(4).print(),200,400);
                g2.drawString(movementList.get(5).print(),200,450);
                break;
            }
        }
    }
    dashBoard(boardView board, DisplayManager manger, MainController ctrl, TransportationManager transport){
        setPreferredSize(new Dimension(700,1000));
        addKeyListener(this);
        setFocusable(true);
        this.board = board;
        manager = manger;
        mainctrl = ctrl;
        transportationManager = transport;

        int x = transportationManager.getTransportationLocation(transportationManager.getTransportationList().get(0)).getX();
        int y = transportationManager.getTransportationLocation(transportationManager.getTransportationList().get(0)).getY();

        board.setCurrentLocationCursor(x,y);



    }
}
