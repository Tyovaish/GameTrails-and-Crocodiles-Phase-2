package Model.Map.Tile;

/**
 * Created by Trevor on 4/14/2017.
 */
public class TileOrientation {
    int numberOfRotations=0;

    public int getNumberOfRotations() {
        return numberOfRotations;
    }

    public void setNumberOfRotations(int numberOfRotations) {
        this.numberOfRotations = numberOfRotations;
    }

    void rotate(){numberOfRotations++;}

}
