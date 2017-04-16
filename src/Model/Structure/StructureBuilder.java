package Model.Structure;

import Model.Resource.Resource;
import Model.Resource.ResourceEnum;
import Model.ResourceHolder;
import Model.Structure.PrimaryProducer.*;
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
    private ArrayList<ResourceEnum> woodCutterRecipe;

    private Map<StructureEnum, ArrayList> recipeMap;
    private Map<StructureEnum, Structure> structureMap;

    public StructureBuilder() {
        materials = new ArrayList<>();

        clayPitRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.BOARD));
        mineRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.STONE));
        oilRigRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.BOARD, ResourceEnum.STONE));
        quarryRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD, ResourceEnum.BOARD));
        woodCutterRecipe = new ArrayList<>(Arrays.asList(ResourceEnum.BOARD));

        createMaps();
    }
    private void createMaps(){
        recipeMap = new HashMap<>();
        recipeMap.put(StructureEnum.CLAYPIT, clayPitRecipe);
        recipeMap.put(StructureEnum.MINE, mineRecipe);
        recipeMap.put(StructureEnum.OILRIG, oilRigRecipe);
        recipeMap.put(StructureEnum.QUARRY, quarryRecipe);
        recipeMap.put(StructureEnum.WOODCUTTER, woodCutterRecipe);

        structureMap = new HashMap<>();
        structureMap.put(StructureEnum.CLAYPIT, new ClayPit());
        structureMap.put(StructureEnum.MINE, new Mine());
        structureMap.put(StructureEnum.OILRIG, new OilRig());
        structureMap.put(StructureEnum.QUARRY, new Quarry());
        structureMap.put(StructureEnum.WOODCUTTER, new Woodcutter());
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
