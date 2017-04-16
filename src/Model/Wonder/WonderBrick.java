package Model.Wonder;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class WonderBrick {
    private boolean built;

    public WonderBrick() { built = false; }

    public void build(){ built = true; }
    public boolean isBuilt(){ return built; }
}
