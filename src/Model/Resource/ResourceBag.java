package Model.Resource;

import Model.Resource.PrimaryResource.*;
import Model.Resource.SecondaryResource.*;

import java.util.LinkedList;
import java.util.Queue;

public class ResourceBag {
    // Resource counter keeps track of number of resources in bag
    private int counter;

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

    // Constructor
    public ResourceBag() {
        counter = 0;

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
    }

    // Accessors
    public int getCounter() { return counter;}
    public Queue<Stone> getStones() { return stones; }
    public Queue<Trunk> getTrunks() { return trunks; }
    public Queue<Fuel> getFuel() { return fuels; }
    public Queue<Iron> getIron() { return irons; }
    public Queue<Gold> getGold() { return golds; }
    public Queue<Clay> getClay() { return clays; }
    public Queue<Board> getBoards() { return boards; }
    public Queue<Coin> getCoins() { return coins; }
    public Queue<Marble> getMarbles() { return marbles; }
    public Queue<Paper> getPapers() { return papers; }
    public Queue<Pearl> getPearls() { return pearls; }
    public Queue<StockBond> getBonds() { return bonds; }

    // Mutators
    public void setCounter(int counter) { this.counter = counter;}
    public void setStones(Queue<Stone> stones) { this.stones = stones; }
    public void setTrunks(Queue<Trunk> trunks) { this.trunks = trunks; }
    public void setFuel(Queue<Fuel> fuel) { this.fuels = fuel; }
    public void setIron(Queue<Iron> iron) { this.irons = iron; }
    public void setGold(Queue<Gold> gold) { this.golds = gold; }
    public void setClay(Queue<Clay> clay) { this.clays = clay; }
    public void setBoards(Queue<Board> boards) { this.boards = boards; }
    public void setCoins(Queue<Coin> coins) { this.coins = coins; }
    public void setMarbles(Queue<Marble> marbles) { this.marbles = marbles; }
    public void setPapers(Queue<Paper> papers) { this.papers = papers; }
    public void setPearls(Queue<Pearl> pearls) { this.pearls = pearls; }
    public void setBonds(Queue<StockBond> bonds) { this.bonds = bonds; }

    // Adding resources to bag
    public void addResource(Stone stone){ stones.offer(stone); counter++; }
    public void addResource(Trunk trunk){ trunks.offer(trunk); counter++;}
    public void addResource(Fuel fuel){ fuels.offer(fuel); counter++; }
    public void addResource(Iron iron){ irons.offer(iron); counter++; }
    public void addResource(Gold gold){ golds.offer(gold); counter++; }
    public void addResource(Clay clay){ clays.offer(clay); counter++; }
    public void addResource(Board board){ boards.offer(board); counter++; }
    public void addResource(Coin coin){ coins.offer(coin); counter++; }
    public void addResource(Marble marble){ marbles.offer(marble); counter++; }
    public void addResource(Paper paper){ papers.offer(paper); counter++; }
    public void addResource(Pearl pearl){ pearls.offer(pearl); counter++; }
    public void addResource(StockBond bond){ bonds.offer(bond); counter++; }

    // Removing resources from bag
    public Stone removeStone(){
        if (!stones.isEmpty()){ counter--; return stones.poll();  }
        else return null;
    }
    public Trunk removeTrunk(){
        if (!trunks.isEmpty()){ counter--; return trunks.poll(); }
        else return null;
    }
    public Fuel removeFuel(){
        if (!fuels.isEmpty()){ counter--; return fuels.poll(); }
        else return null;
    }
    public Iron removeIron(){
        if (!irons.isEmpty()){ counter--; return irons.poll(); }
        else return null;
    }
    public Gold removeGold(){
        if (!golds.isEmpty()){ counter--; return golds.poll(); }
        else return null;
    }
    public Clay removeClay(){
        if (!clays.isEmpty()){ counter--; return clays.poll(); }
        else return null;
    }
    public Board removeBoard(){
        if (!boards.isEmpty()){ counter--; return boards.poll(); }
        else return null;
    }
    public Coin removeCoin(){
        if (!coins.isEmpty()){ counter--; return coins.poll(); }
        else return null;
    }
    public Marble removeMarble(){
        if (!marbles.isEmpty()){ counter--; return marbles.poll(); }
        else return null;
    }
    public Paper removePaper(){
        if (!papers.isEmpty()){ counter--; return papers.poll(); }
        else return null;
    }
    public Pearl removePearl(){
        if (!pearls.isEmpty()){ counter--; return pearls.poll(); }
        else return null;
    }
    public StockBond removeBond(){
        if (!bonds.isEmpty()){ counter--; return bonds.poll(); }
        else return null;
    }
}

