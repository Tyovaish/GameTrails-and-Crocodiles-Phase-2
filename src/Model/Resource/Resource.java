package Model.Resource;

/**
 * Created by Trevor on 4/14/2017.
 */
public abstract class Resource {
    private ResourceEnum type;

    public ResourceEnum getType() { return type; }
    public void setType(ResourceEnum type) { this.type = type; }
}
