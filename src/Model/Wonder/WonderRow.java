package Model.Wonder;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class WonderRow {
    private WonderBrick[] row;
    private int size;

    public WonderRow(int size) {
        this.row = new WonderBrick[size];
        this.size = size;
        initBricks();
    }

    private void initBricks(){
        for (int i = 0; i < size; i++) row[i] = new WonderBrick();
    }


    public void addBrick(){
        for (WonderBrick brick : row){
            if (!brick.isBuilt()){
                brick.build();
                return;
            }
        }
    }

    public boolean checkBrick(int index){
        if(index >= 0 && index < size) return row[index].isBuilt();
        else return false;
    }

    public boolean isComplete(){
        for (WonderBrick brick : row){
            if (!brick.isBuilt()) return false;
        }
        return true;
    }

    public int length(){
        return row.length;
    }
}
