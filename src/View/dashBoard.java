package View;

import Controller.MainController;
import Model.Abilities.DropResourceAbility;
import Model.Abilities.MovementAbility;
import Model.Abilities.PickUpResourceAbility;
import Model.ViewObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by Lazaro on 4/11/2017.
 */
public class dashBoard extends JPanel implements KeyListener{

    ArrayList<MovementAbility> movementList;
    ArrayList<PickUpResourceAbility> pickUpResourceList;
    ArrayList<DropResourceAbility> dropResourceList;
    ViewObserver observer;
    MainController mainctrl;
   Graphics2D g2;
   String str = "";
   boolean draw = false;

    public void keyPressed(KeyEvent e){

        switch (e.getKeyCode()){
            case KeyEvent.VK_0:{
                mainctrl.getKeyPress(0);
                str = mainctrl.print();
                draw = true;
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

                if(str.equals("Movement")) {
                    movementList = observer.getMovementList();
                    draw = true;
                }
                else if(str.equals("Pick Up")){
                    pickUpResourceList = observer.getResourceList();
                    draw=true;
                }
                else if(str.equals("Drop Resource")){
                    dropResourceList = observer.getDropList();
                 draw = true;
                }
                else
                    draw=false;
               this.repaint();
                break;
            }
            case KeyEvent.VK_SHIFT:{
                mainctrl.getShift();
                str = mainctrl.print();
                draw=true;
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
                g2.drawString(i+") "+movementList.get(i).print(),200,200+(i*50));
            }
        }

        else if(str.equals("Pick Up")){
            for(int i = 0 ; i < pickUpResourceList.size(); i++){
                g2.drawString(i+") "+ pickUpResourceList.get(i).print(),200,200+(i*50));
            }
        }
        else if(str.equals("Drop Resource")) {

            for (int i = 0; i < dropResourceList.size(); i++) {
                g2.drawString(i+") "+dropResourceList.get(i).print(), 200, 200 + (i * 50));
            }
        }
        else if(str.equals("Select Transportation")){
            for(int i = 0; i < observer.getTransportList().size();i++){
                g2.drawString(i+") "+observer.getTransportList().get(i).getType(), 200, 200 + (i * 50));
            }
        }
    }
    dashBoard(ViewObserver observer, MainController ctrl){
        setPreferredSize(new Dimension(700,1000));
        addKeyListener(this);
        setFocusable(true);
        mainctrl = ctrl;
        this.observer = observer;





    }
}
