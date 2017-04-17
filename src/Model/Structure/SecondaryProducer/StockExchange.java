package Model.Structure.SecondaryProducer;

import Model.Resource.Resource;
import Model.Resource.ResourceEnum;
import Model.Resource.SecondaryResource.Coin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class StockExchange extends SecondaryProducer {
    private Queue<Resource> inputPaper;
    private Queue<Resource> inputCoin;

    public StockExchange() {
        super();
        setPrimaryProducer(false);
        inputPaper = new LinkedList<>();
        inputCoin = new LinkedList<>();
        setName("stockexchange");
    }

    public void addMaterial(Resource resource){
        if (resource.getType() != ResourceEnum.PAPER && resource.getType() != ResourceEnum.GOLD){
            System.out.println("This structure does not use this resource.");
            return;
        }
        else{
            if (resource.getType() == ResourceEnum.PAPER) {
                if (inputPaper.size() >= 6) System.out.println("Paper queue is full");
                else inputPaper.offer(resource);
            }
            if (resource.getType() == ResourceEnum.GOLD){
                if (inputCoin.size() >= 12) System.out.println("Coin queue is full");
                else inputCoin.offer(resource);
            }
        }
    }

    public ArrayList<Resource> produce(){
        output.clear();
        Resource input1 = inputPaper.poll();
        Resource input2 = inputCoin.poll();
        Resource input3 = inputCoin.poll();
        while(input1 != null && input2 != null && input3 != null){
            output.add(new Coin());
            input1 = inputPaper.poll();
            input2 = inputCoin.poll();
            input3 = inputCoin.poll();
        }
        return output;
    }
}
