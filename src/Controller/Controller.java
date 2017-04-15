package Model;

/**
 * Created by Trevor on 4/14/2017.
 */
public interface Controller{

    public void getKeyPress(int keyPressed);
    public Controller nextController();
    public Controller previousController();
    public void print();
}
