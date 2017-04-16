package Model.Structure.PrimaryProducer;

import Model.Map.Tile.Features.Mountain;
import Model.Resource.PrimaryResource.Gold;
import Model.Resource.PrimaryResource.Iron;
import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.Resource;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Mine extends PrimaryProducer {
    private int oreCounter = 10;

    public Mine() {
        setPrimaryProducer(true);
        setProductionFeature(new Mountain());
    }

    public Resource selectOre(){
        if (oreCounter > 0){
            oreCounter--;
            int choice = ThreadLocalRandom.current().nextInt(0, 2);
            if (choice == 0) return new Iron();
            else return new Gold();
        }
        return null;
    }

    public int getOreCounter() { return oreCounter; }
    public void setOreCounter(int oreCounter) { this.oreCounter = oreCounter; }

    @Override
    public Resource produce(){ return selectOre(); }
}
