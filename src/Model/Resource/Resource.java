package Model.Resource;

/**
 * Created by Trevor on 4/14/2017.
 */
public abstract class Resource {
    private ResourceEnum type;
    private String resourceType;
    boolean onGround=true;
    public boolean onGround(){return onGround;}
    void setOnGround(boolean onGround){
        this.onGround=onGround;
    }
    public ResourceEnum getType() { return type; }
    public void setType(ResourceEnum type) { this.type = type; }
    public String getResourceType(){return resourceType;}
    public void setResourceType(String resourceType){this.resourceType=resourceType;}
    public String getName() { return type.getName(); }
    public abstract void acceptVisitor(ResourceVisitor resourceVisitor);
}
