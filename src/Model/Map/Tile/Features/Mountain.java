package Model.Map.Tile.Features;

import Model.Map.Tile.FeatureType;

/**
 * Created by Lazaro on 4/15/2017.
 */
public class Mountain extends FeatureType {
    String name="mountain";

    public Mountain() {}

    @Override
    public String getType() {
        return name;
    }
}
