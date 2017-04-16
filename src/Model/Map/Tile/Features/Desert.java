package Model.Map.Tile.Features;

import Model.Map.Tile.FeatureType;

/**
 * Created by Lazaro on 4/15/2017.
 */
public class Desert extends FeatureType {
    String name="desert";

    public Desert() {}

    @Override
    public String getType() {
        return name;
    }
}
