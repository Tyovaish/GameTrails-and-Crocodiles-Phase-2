package Model.Map.Tile.Features;

import Model.Map.Tile.FeatureType;

/**
 * Created by Lazaro on 4/15/2017.
 */
public class Sea extends FeatureType {
    String name="sea";

    public Sea() {}

    @Override
    public String getType() {
        return name;
    }
}
