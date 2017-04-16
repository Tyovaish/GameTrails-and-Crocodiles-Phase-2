package Controller;

import Controller.Controller;
import Model.Transportation.TransportationManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public class MainController extends Controller {
    ArrayList<Controller> controller;
    Controller currentController;
    //currentKeySet();
   public MainController(TransportationManager transportationManager) {
       controller=new ArrayList<Controller>();
       currentController=this;
       controller.add(new TransportationSelectionController(transportationManager, this));
   }
    public void getKeyPress(int keyPressed){
        if(currentController!=this){
            currentController.getKeyPress(keyPressed);
        } else {
            if(keyPressed>=0&&keyPressed<controller.size()){
                currentController=controller.get(keyPressed);
            }
            System.out.println(keyPressed);
        }
        //currentController.print();
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
        System.out.println("In Main controller");
    }
}
