package Model.Resource;

import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.SecondaryResource.Board;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/17/2017.
 */
public class ResourceVisitor {
    ArrayList<Trunk> trunkList;
    ArrayList<Board> boardList;
    public ResourceVisitor(){
        trunkList=new ArrayList<Trunk>();
        boardList=new ArrayList<Board>();
    }
    public void visit(Trunk trunk){
        trunkList.add(trunk);
    }
    public void visit(Board board){
        boardList.add(board);
    }
}
