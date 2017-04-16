package Model.Structure;

import Model.Map.Tile.FeatureType;
import Model.Resource.Resource;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Structure {
    private boolean isPrimaryProducer;
    private FeatureType productionFeature = null;

    public boolean isPrimaryProducer() { return isPrimaryProducer; }
    public void setPrimaryProducer(boolean primaryProducer) { isPrimaryProducer = primaryProducer; }

    public FeatureType getProductionFeature() { return productionFeature; }
    public void setProductionFeature(FeatureType productionFeature) { this.productionFeature = productionFeature; }

    public Resource produce(){ return null; }
}
