package Model.Research;

/**
 * Created by khariollivierre on 4/17/17.
 */
public class ResearchNode {
    private boolean active;

    public ResearchNode() { active = false; }

    public boolean isActive() { return active; }
    public void activate(){ active = true; }
    public void deactivate() { active = false; }

    public void setActive(boolean active) { this.active = active; }
}
