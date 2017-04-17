package Model.Structure.SecondaryProducer;

import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.Resource;
import Model.Resource.ResourceEnum;
import Model.Resource.SecondaryResource.Board;
import Model.Structure.StructureEnum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Sawmill extends SecondaryProducer {
    private Queue<Resource> inputTrunk;

    public Sawmill() {
        super();
        setPrimaryProducer(false);
        inputTrunk = new LinkedList<>();
        setType(StructureEnum.CLAYPIT);
    }

    public ArrayList<Resource> produce(){
        output.clear();
        Resource input = inputTrunk.poll();
        if (input == null){
            System.out.println("Not enough materials.");
        }
        while(input != null){
            output.add(new Board());
            output.add(new Board());
            input = inputTrunk.poll();
        }
        return output;
    }

    public void addMaterial(Resource resource){
        if (resource.getType() != ResourceEnum.TRUNK){
            System.out.println("This structure does not use this resource.");
            return;
        }
        else if (inputTrunk.size() >= 3){
            System.out.println("Input queue is full.");
            return;
        }
        else inputTrunk.offer(resource);
    }
}
