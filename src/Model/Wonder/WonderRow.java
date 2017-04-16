package Model.Wonder;

import java.util.ArrayList;

/**
 * Created by larry on 4/16/2017.
 */
public class WonderRow {
    private ArrayList<WonderBrick> brickRow;
    int size;

    //public void buyBrick()
    public void addBrickToRow(WonderBrick brick){brickRow.add(brick);}

}
