package Model.Structure;

import Model.Resource.Resource;
import Model.Resource.ResourceEnum;
import Model.ResourceHolder;
import Model.Structure.PrimaryProducer.*;
import Model.Structure.SecondaryProducer.*;
import Model.Structure.TransportProducer.*;
import Model.Transportation.Transportation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class StructureBuilder {
    private ArrayList<ResourceEnum> materials;

    private ArrayList<ResourceEnum> clayPitRecipe;
    private ArrayList<ResourceEnum> mineRecipe;
    private ArrayList<ResourceEnum> oilRigRecipe;
    private ArrayList<ResourceEnum> quarryRecipe;
    private ArrayList<ResourceEnum> woodcutterRecipe;
    private ArrayList<ResourceEnum> coalBurnerRecipe;
    private ArrayList<ResourceEnum> mintRecipe;
    private ArrayList<ResourceEnum> papermillRecipe;
    private ArrayList<ResourceEnum> sawmillRecipe;
    private ArrayList<ResourceEnum> stockExchangeRecipe;
    private ArrayList<ResourceEnum> stoneFactoryRecipe;
    private ArrayList<ResourceEnum> raftFactoryRecipe;
    private ArrayList<ResourceEnum> rowboatFactoryRecipe;
    private ArrayList<ResourceEnum> steamerFactoryRecipe;
    private ArrayList<ResourceEnum> truckFactoryRecipe;
    private ArrayList<ResourceEnum> wagonFactoryRecipe;


    private Map<StructureEnum, ArrayList> recipeMap;
    private Map<StructureEnum, Structure> structureMap;

    public StructureBuilder() {
        materials = new ArrayList<>();
        // Primary producer recipes
        clayPitRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.BOARD));
        mineRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.STONE));
        oilRigRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.STONE));
        quarryRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD));
        woodcutterRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD));

        // Secondary producer recipes
        coalBurnerRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.BOARD));
        mintRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.STONE));
        papermillRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.STONE));
        sawmillRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.STONE));
        stockExchangeRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.STONE, ResourceEnum.STONE, ResourceEnum.STONE));
        stoneFactoryRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD));

        // Transport producer recipes
        raftFactoryRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.STONE));
        rowboatFactoryRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.STONE));
        steamerFactoryRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.STONE, ResourceEnum.STONE));
        truckFactoryRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.STONE, ResourceEnum.STONE));
        wagonFactoryRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.STONE));

        createMaps();
    }
    private void createMaps(){
        recipeMap = new HashMap<>();
        recipeMap.put(StructureEnum.CLAYPIT, clayPitRecipe);
        recipeMap.put(StructureEnum.MINE, mineRecipe);
        recipeMap.put(StructureEnum.OILRIG, oilRigRecipe);
        recipeMap.put(StructureEnum.QUARRY, quarryRecipe);
        recipeMap.put(StructureEnum.WOODCUTTER, woodcutterRecipe);
        recipeMap.put(StructureEnum.COALBURNER, coalBurnerRecipe);
        recipeMap.put(StructureEnum.MINT, mintRecipe);
        recipeMap.put(StructureEnum.PAPERMILL, papermillRecipe);
        recipeMap.put(StructureEnum.SAWMILL, sawmillRecipe);
        recipeMap.put(StructureEnum.EXCHANGE, stockExchangeRecipe);
        recipeMap.put(StructureEnum.STONEFACTORY, stoneFactoryRecipe);
        recipeMap.put(StructureEnum.RAFTFACTORY, raftFactoryRecipe);
        recipeMap.put(StructureEnum.ROWBOATFACTORY, rowboatFactoryRecipe);
        recipeMap.put(StructureEnum.STEAMERFACTORY, steamerFactoryRecipe);
        recipeMap.put(StructureEnum.TRUCKFACTORY, truckFactoryRecipe);
        recipeMap.put(StructureEnum.WAGONFACTORY, wagonFactoryRecipe);


        structureMap = new HashMap<>();
        structureMap.put(StructureEnum.CLAYPIT, new ClayPit());
        structureMap.put(StructureEnum.MINE, new Mine());
        structureMap.put(StructureEnum.OILRIG, new OilRig());
        structureMap.put(StructureEnum.QUARRY, new Quarry());
        structureMap.put(StructureEnum.WOODCUTTER, new Woodcutter());
        structureMap.put(StructureEnum.COALBURNER, new CoalBurner());
        structureMap.put(StructureEnum.MINT, new Mint());
        structureMap.put(StructureEnum.PAPERMILL, new Papermill());
        structureMap.put(StructureEnum.SAWMILL, new Sawmill());
        structureMap.put(StructureEnum.EXCHANGE, new StockExchange());
        structureMap.put(StructureEnum.STONEFACTORY, new StoneFactory());
        structureMap.put(StructureEnum.RAFTFACTORY, new RaftFactory());
        structureMap.put(StructureEnum.ROWBOATFACTORY, new RowboatFactory());
        structureMap.put(StructureEnum.STEAMERFACTORY, new SteamerFactory());
        structureMap.put(StructureEnum.TRUCKFACTORY, new TruckFactory());
        structureMap.put(StructureEnum.WAGONFACTORY, new WagonFactory());
    }

    public void acceptMaterial(ResourceHolder holder, ResourceEnum resource){
        holder.giveMaterial(this, resource);
    }
    public void addMaterial(Resource resource){
        materials.add(resource.getType());
    }

    public Structure build(Transportation transportation, StructureEnum structure){
        ArrayList<ResourceEnum> recipe = recipeMap.get(structure);
        for (ResourceEnum resource : recipe){
            acceptMaterial(transportation, resource);
            if (!materials.remove(resource)){
                System.out.printf("Not enough resources! Structure not built.\n");
                return null;
            }
        }
        return structureMap.get(structure);
    }
}
