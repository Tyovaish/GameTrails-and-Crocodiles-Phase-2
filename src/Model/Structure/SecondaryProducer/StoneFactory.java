package Model.Structure.SecondaryProducer;

import Model.Resource.PrimaryResource.Stone;
import Model.Resource.Resource;
import Model.Resource.ResourceEnum;
import Model.Resource.SecondaryResource.Board;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class StoneFactory extends SecondaryProducer {
    private Queue<Resource> inputClay;

    public StoneFactory() {
        super();
        setPrimaryProducer(false);
        inputClay = new LinkedList<>();
        setName("stonefactory");
    }

    public ArrayList<Resource> produce(){
        output.clear();
        Resource input = inputClay.poll();
        if (input == null){
            System.out.println("Not enough materials.");
        }
        while(input != null){
            output.add(new Stone());
            output.add(new Stone());
            input = inputClay.poll();
        }
        return output;
    }

    public void addMaterial(Resource resource){
        if (resource.getType() != ResourceEnum.CLAY){
            System.out.println("This structure does not use this resource.");
            return;
        }
        else if (inputClay.size() >= 3){
            System.out.println("Input queue is full.");
            return;
        }
        else inputClay.offer(resource);
    }
}
