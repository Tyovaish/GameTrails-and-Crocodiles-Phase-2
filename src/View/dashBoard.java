package View;

import Controller.MainController;
import Model.Abilities.DropResourceAbility;
import Model.Abilities.MovementAbility;
import Model.Abilities.PickUpResourceAbility;
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
    ArrayList<PickUpResourceAbility> pickUpResourceList;
    ArrayList<DropResourceAbility> dropResourceList;
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
                str = mainctrl.print();
                this.repaint();
                break;
            }
            case KeyEvent.VK_2:{
                mainctrl.getKeyPress(2);
                str = mainctrl.print();
                this.repaint();
                break;
            }
            case KeyEvent.VK_3:{
                mainctrl.getKeyPress(3);
                str = mainctrl.print();
                this.repaint();
                break;
            }
            case KeyEvent.VK_4:{
                mainctrl.getKeyPress(4);
                str = mainctrl.print();
                this.repaint();
                break;
            }
            case KeyEvent.VK_5:{
                mainctrl.getKeyPress(5);
                str = mainctrl.print();
                this.repaint();
                break;
            }
            case KeyEvent.VK_6:{
                mainctrl.getKeyPress(6);
                str = mainctrl.print();
                this.repaint();
                break;
            }
            case KeyEvent.VK_ENTER:{
                mainctrl.getEnter();
                str = mainctrl.print();
                int x = transportationManager.getTransportationLocation(transportationManager.getTransportationList().get(0)).getX();
                int y = transportationManager.getTransportationLocation(transportationManager.getTransportationList().get(0)).getY();
                board.setCurrentLocationCursor(x,y);
                System.out.println(str);

                if(str.equals("Movement")) {
                    movementList = transportationManager.getMovementList();
                    draw = true;
                }
                else if(str.equals("Pick Up")){
                    pickUpResourceList = transportationManager.getResourceList();
                    draw=true;
                }
                else if(str.equals("Drop Resource")){
                    dropResourceList = transportationManager.getDropList();
                 draw = true;
                }
                else
                    draw=false;
               this.repaint();
                break;
            }
            case KeyEvent.VK_SHIFT:{
                mainctrl.getShift();
                draw=false;
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
        if(str.equals("Movement")) {
            for(int i = 0 ; i < movementList.size(); i++){
                g2.drawString(i+" ) "+movementList.get(i).print(),200,200+(i*50));
            }
        }

        else if(str.equals("Pick Up")){
            for(int i = 0 ; i < pickUpResourceList.size(); i++){
                g2.drawString(i+" ) "+pickUpResourceList.get(i).print(),200,200+(i*50));
            }
        }
        else if(str.equals("Drop Resource")) {
            for (int i = 0; i < dropResourceList.size(); i++) {
                g2.drawString(i+" ) "+dropResourceList.get(i).print(), 200, 200 + (i * 50));
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
