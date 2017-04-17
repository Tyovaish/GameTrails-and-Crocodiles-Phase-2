package Model.Structure;

import Model.Location.Location;
import Model.Map.Tile.FeatureType;
import Model.Resource.Resource;

import java.util.ArrayList;

/**
 * Created by khariollivierre on 4/15/17.
 */
public abstract class Structure<T> {
    private boolean isPrimaryProducer;
    private FeatureType productionFeature = null;
    private Location location;

    public boolean isPrimaryProducer() { return isPrimaryProducer; }
    public void setPrimaryProducer(boolean primaryProducer) { isPrimaryProducer = primaryProducer; }

    public FeatureType getProductionFeature() { return productionFeature; }
    public void setProductionFeature(FeatureType productionFeature) { this.productionFeature = productionFeature; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public abstract T produce();
}
