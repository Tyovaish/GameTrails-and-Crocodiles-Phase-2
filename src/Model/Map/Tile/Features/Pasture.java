package Model.Map.Tile.Features;
import Model.Map.Tile.FeatureType;

/**
 * Created by Trevor on 4/14/2017.
 */
public class Pasture extends FeatureType {
    String name="pasture";

    public Pasture() {}

    @Override
    public String getType() {
        return name;
    }
}
