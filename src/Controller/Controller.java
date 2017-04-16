package Controller;

/**
 * Created by Trevor on 4/14/2017.
 */
public abstract class Controller{

    abstract public void getKeyPress(int keyPressed);
    abstract public Controller nextController();
    abstract public Controller previousController();
    abstract public void print();
}
