package Model.Resource;

import Model.Location.ResourceLocation;
import Model.Location.TransportationLocation;
import Model.Resource.PrimaryResource.*;
import Model.Resource.SecondaryResource.*;
import Model.ResourceHolder;
import Model.Structure.StructureBuilder;

import java.util.*;

public class ResourceBag implements ResourceHolder {
    // Resource counter keeps track of number of resources in bag. If counter >= size, no resources can be added
    ResourceManager resourceManager;
    private int counter;
    private int size = 6;
    ArrayList<Resource> resourceList;

    public ResourceBag(ResourceManager resourceManager) {
        resourceList = new ArrayList<Resource>();
        this.resourceManager = resourceManager;
    }

    public ArrayList<Resource> getResourceList() {
        return resourceList;
    }

    public void carry(TransportationLocation transportationLocation) {
        for (int i = 0; i < resourceList.size(); i++) {
            ResourceLocation locationToChange = resourceManager.getResourceLocation(resourceList.get(i));
            locationToChange.setX(transportationLocation.getX());
            locationToChange.setY(transportationLocation.getY());
            locationToChange.setTileZone(transportationLocation.getTileZone());
        }
    }


    // Primary Resources
    private Queue<Stone> stones;
    private Queue<Trunk> trunks;
    private Queue<Fuel> fuels;
    private Queue<Iron> irons;
    private Queue<Gold> golds;
    private Queue<Clay> clays;

    // Secondary Resources
    private Queue<Board> boards;
    private Queue<Coin> coins;
    private Queue<Marble> marbles;
    private Queue<Paper> papers;
    private Queue<Pearl> pearls;
    private Queue<StockBond> bonds;

    private Map<ResourceEnum, Queue> resourceMap;

    // Constructor
    public ResourceBag(int size) {
        counter = 0;
        this.size = size;
        resourceList = new ArrayList<Resource>();

        stones = new LinkedList<>();
        trunks = new LinkedList<>();
        fuels = new LinkedList<>();
        irons = new LinkedList<>();
        golds = new LinkedList<>();
        clays = new LinkedList<>();

        boards = new LinkedList<>();
        coins = new LinkedList<>();
        marbles = new LinkedList<>();
        papers = new LinkedList<>();
        pearls = new LinkedList<>();
        bonds = new LinkedList<>();

        resourceMap = new HashMap<>();
        createResourceMap();
    }

    private void createResourceMap() {
        resourceMap.put(ResourceEnum.STONE, stones);
        resourceMap.put(ResourceEnum.TRUNK, trunks);
        resourceMap.put(ResourceEnum.FUEL, fuels);
        resourceMap.put(ResourceEnum.IRON, irons);
        resourceMap.put(ResourceEnum.GOLD, golds);
        resourceMap.put(ResourceEnum.CLAY, clays);
        resourceMap.put(ResourceEnum.BOARD, boards);
        resourceMap.put(ResourceEnum.COIN, coins);
        resourceMap.put(ResourceEnum.MARBLE, marbles);
        resourceMap.put(ResourceEnum.PAPER, papers);
        resourceMap.put(ResourceEnum.PEARL, pearls);
        resourceMap.put(ResourceEnum.BOND, bonds);
    }

    // Accessors
    public int getCounter() {
        return counter;
    }

    public Queue<Stone> getStones() {
        return stones;
    }

    public Queue<Trunk> getTrunks() {
        return trunks;
    }

    public Queue<Fuel> getFuels() {
        return fuels;
    }

    public Queue<Iron> getIrons() {
        return irons;
    }

    public Queue<Gold> getGolds() {
        return golds;
    }

    public Queue<Clay> getClays() {
        return clays;
    }

    public Queue<Board> getBoards() {
        return boards;
    }

    public Queue<Coin> getCoins() {
        return coins;
    }

    public Queue<Marble> getMarbles() {
        return marbles;
    }

    public Queue<Paper> getPapers() {
        return papers;
    }

    public Queue<Pearl> getPearls() {
        return pearls;
    }

    public Queue<StockBond> getBonds() {
        return bonds;
    }

    // Mutators
    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setStones(Queue<Stone> stones) {
        this.stones = stones;
    }

    public void setTrunks(Queue<Trunk> trunks) {
        this.trunks = trunks;
    }

    public void setFuel(Queue<Fuel> fuel) {
        this.fuels = fuel;
    }

    public void setIron(Queue<Iron> iron) {
        this.irons = iron;
    }

    public void setGold(Queue<Gold> gold) {
        this.golds = gold;
    }

    public void setClay(Queue<Clay> clay) {
        this.clays = clay;
    }

    public void setBoards(Queue<Board> boards) {
        this.boards = boards;
    }

    public void setCoins(Queue<Coin> coins) {
        this.coins = coins;
    }

    public void setMarbles(Queue<Marble> marbles) {
        this.marbles = marbles;
    }

    public void setPapers(Queue<Paper> papers) {
        this.papers = papers;
    }

    public void setPearls(Queue<Pearl> pearls) {
        this.pearls = pearls;
    }

    public void setBonds(Queue<StockBond> bonds) {
        this.bonds = bonds;
    }

    // ResourceHolder
    public void addResource(Resource resource) {
//        Queue<Resource> resourceQueue = resourceMap.get(resource.getType());
//        if (counter < size || size == -1){
//            resourceQueue.offer(resource);
//            counter++;
//        }
//        else System.out.printf("Bag is full! Resource not added.\n");
        if (resourceList.size() < size) {
            resource.setOnGround(false);
            resourceList.add(resource);
        }
    }

    public void removeResource(Resource resource) {
        resource.setOnGround(true);
        resourceList.remove(resource);
    }

    public Resource removeResource(ResourceEnum resource) {
//        Queue<Resource> resourceQueue = resourceMap.get(resource);
//        if (!resourceQueue.isEmpty()){ counter--; return resourceQueue.poll(); }
//        else {
//            System.out.printf("No resources of this type in bag!\n");
//            return null;
//        }
        return null;
    }

    public void giveMaterial(StructureBuilder builder, ResourceEnum resource) {
        Resource material = removeResource(resource);
        if (material != null) builder.addMaterial(material);
        else System.out.printf("Material not found in bag!\n");
    }
}

    // Abilities
