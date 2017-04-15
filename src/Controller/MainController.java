package Controller;

import Controller.Controller;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public class MainController implements Controller {
    ArrayList<Controller> controller;
    Controller currentController;
    //currentKeySet();
    MainController(){

    }
    public void getKeyPress(int keyPressed){
        if(currentController!=this){
            currentController.getKeyPress(keyPressed);
        } else {
            if(keyPressed>=0&&keyPressed<controller.size()){
                currentController=controller.get(keyPressed);
            }
        }
    }
    public void getEnter(){
        currentController=nextController();
    }
    public void getShift(){
        currentController=previousController();
    }

    @Override
    public Controller nextController() {
        if(currentController!=this){
            return currentController.nextController();
        } else {
            return this;
        }

    }

    @Override
    public Controller previousController() {
        if(currentController!=this){
           return currentController.previousController();

        } else
        {
            return this;
        }
    }

    public void print() {
        if(currentController!=this) {
            currentController.print();
        }
    }
}
