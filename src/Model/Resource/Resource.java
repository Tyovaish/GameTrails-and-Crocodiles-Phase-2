package Model.Resource;

/**
 * Created by Trevor on 4/14/2017.
 */
public abstract class Resource {
    private ResourceEnum type;
    boolean onGround=true;
    public boolean onGround(){return onGround;}
    void setOnGround(boolean onGround){
        this.onGround=onGround;
    }
    public ResourceEnum getType() { return type; }
    public void setType(ResourceEnum type) { this.type = type; }
}
