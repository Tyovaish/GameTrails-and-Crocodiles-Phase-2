package Model.Map.Tile.Features;

import Model.Map.Tile.FeatureType;

/**
 * Created by Lazaro on 4/15/2017.
 */
public class Woods extends FeatureType {
    String name="woods";

    public Woods() {}

    @Override
    public String getType() {
        return name;
    }
}
