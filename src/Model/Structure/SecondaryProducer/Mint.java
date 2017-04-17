package Model.Structure.SecondaryProducer;

import Model.Resource.Resource;
import Model.Resource.ResourceEnum;
import Model.Resource.SecondaryResource.Coin;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Mint extends SecondaryProducer {
    private Queue<Resource> inputFuel;
    private Queue<Resource> inputGold;

    public Mint() {
        super();
        setPrimaryProducer(false);
    }

    public void addMaterial(Resource resource){
        if (resource.getType() != ResourceEnum.FUEL && resource.getType() != ResourceEnum.GOLD){
            System.out.println("This structure does not use this resource.");
            return;
        }
        else{
            if (resource.getType() == ResourceEnum.FUEL){
                if (inputFuel.size() >= 1) System.out.println("Fuel queue is full");
                else inputFuel.offer(resource);
            }
            if (resource.getType() == ResourceEnum.GOLD){
                if (inputGold.size() >= 2) System.out.println("Gold queue is full");
                else inputGold.offer(resource);
            }
        }
    }

    public ArrayList<Resource> produce(){
        output.clear();
        Resource input1 = inputFuel.poll();
        Resource input2 = inputGold.poll();
        Resource input3 = inputGold.poll();
        if(input1 != null && input2 != null && input3 != null) output.add(new Coin());
        return output;
    }
}
