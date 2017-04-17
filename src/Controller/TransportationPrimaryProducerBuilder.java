package Controller;

import Model.Structure.StructureBuilder;
import Model.Structure.StructureEnum;
import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

/**
 * Created by Trevor on 4/17/2017.
 */
public class TransportationPrimaryProducerBuilder extends TransportationController {
    TransportationManager transportationManager;
    StructureBuilder builder;
    Controller prevController;
    Transportation currentTransportation;
    StructureEnum currentStructure;

    public TransportationPrimaryProducerBuilder(TransportationManager transportationManager, Controller previousController) {
        this.transportationManager=transportationManager;
        prevController=previousController;
        builder = new StructureBuilder(transportationManager);
        currentStructure = StructureEnum.WOODCUTTER;
    }

    @Override
    public void getKeyPress(int keyPressed) {
        if(keyPressed == 1) currentStructure = StructureEnum.WOODCUTTER;
        if(keyPressed == 2) currentStructure = StructureEnum.MINE;
        if(keyPressed == 3) currentStructure = StructureEnum.OILRIG;
        if(keyPressed == 4) currentStructure = StructureEnum.QUARRY;
        if(keyPressed == 5) currentStructure = StructureEnum.CLAYPIT;
        if(keyPressed == 0) builder.build(currentTransportation, currentStructure);
    }

    @Override
    public Controller nextController() {
        return null;
    }

    @Override
    public Controller previousController() {
        return prevController;
    }

    @Override
    public String print() {
        return null;
    }

    @Override
    public void setCurrentTransportation(Transportation transportation) {
        currentTransportation=transportation;

    }

    @Override
    public String printType() {
        return "Structure Builder";
    }
}
