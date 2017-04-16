package Model.Map.Tile.Features;

import Model.Map.Tile.FeatureType;

/**
 * Created by Lazaro on 4/15/2017.
 */
public class Rock extends FeatureType {
    String name="rock";

    public Rock() {}

    @Override
    public String getType() {
        return name;
    }
}
