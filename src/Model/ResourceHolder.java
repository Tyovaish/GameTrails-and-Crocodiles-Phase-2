package Model;

import Model.Resource.Resource;
import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;

/**
 * Created by khariollivierre on 4/15/17.
 */
public interface ResourceHolder {
    void addResource(Resource resource);
    Resource removeResource(ResourceEnum resource);
}
