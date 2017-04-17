package Model.Research;

/**
 * Created by khariollivierre on 4/17/17.
 */
public class ResearchTree {
    private ResearchNode fundamentalResearch;
    private ResearchNode oilRig;
    private ResearchNode truckFactory;
    private ResearchNode rowboatFactory;
    private ResearchNode steamerFactory;
    private ResearchNode newShaft;
    private ResearchNode specialMine;
    private ResearchNode bigMine;

    public ResearchTree() {
        ResearchNode fundamentalResearch = new ResearchNode();
        ResearchNode oilRig = new ResearchNode();
        ResearchNode truckFactory = new ResearchNode();
        ResearchNode rowboatFactory = new ResearchNode();
        ResearchNode steamerFactory = new ResearchNode();
        ResearchNode newShaft = new ResearchNode();
        ResearchNode specialMine = new ResearchNode();
        ResearchNode bigMine = new ResearchNode();
    }

    public void activateFundamentalResearch() { fundamentalResearch.activate(); }
    public void activateOilRig() { oilRig.activate(); }
    public void activateTruckFactory() { truckFactory.activate(); }
    public void activateRowboatFactory() { rowboatFactory.activate(); }
    public void activateSteamerFactory() { steamerFactory.activate(); }
    public void activateNewShaft() { steamerFactory.activate(); }
    public void activateSpecialMine() { specialMine.activate(); }
    public void activateBigMine() { bigMine.activate(); }
}
