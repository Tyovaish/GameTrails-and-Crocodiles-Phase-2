package Model.Structure.SecondaryProducer;

import Model.Resource.PrimaryResource.Fuel;
import Model.Resource.Resource;
import Model.Resource.ResourceEnum;
import Model.Resource.SecondaryResource.Paper;
import Model.Structure.StructureEnum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Papermill extends SecondaryProducer {
    private Queue<Resource> inputTrunk;
    private Queue<Resource> inputBoard;

    public Papermill() {
        super();
        setPrimaryProducer(false);
        inputTrunk = new LinkedList<>();
        inputBoard = new LinkedList<>();
        setType(StructureEnum.PAPERMILL);
    }

    public void addMaterial(Resource resource){
        if (resource.getType() != ResourceEnum.TRUNK && resource.getType() != ResourceEnum.BOARD){
            System.out.println("This structure does not use this resource.");
            return;
        }
        else if ((inputTrunk.size() + inputBoard.size()) >= 12){
            System.out.println("Input queue is full.");
            return;
        }
        else{
            if (resource.getType() == ResourceEnum.TRUNK) inputTrunk.offer(resource);
            if (resource.getType() == ResourceEnum.BOARD) inputBoard.offer(resource);
        }
    }
    public ArrayList<Resource> produce() {
        output.clear();
        if ((inputTrunk.size() + inputBoard.size()) < 2) System.out.println("Not enough materials.");
        Resource input1 = useInput();
        Resource input2 = useInput();
        while (input1 != null && input2 != null){
            output.add(new Paper());
            input1 = useInput();
            input2 = useInput();
        }
        return output;
    }

    private Resource useInput(){
        Resource input = inputTrunk.poll();
        if (input == null) input = inputBoard.poll();
        return input;
    }
}
