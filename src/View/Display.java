package View;

import Controller.MainController;
import Model.Location.ResourceLocation;
import Model.Location.TransportationLocation;
import Model.Map.Map;
import Model.Movement.MovementManager;
import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.Resource;
import Model.Resource.ResourceBag;
import Model.Resource.ResourceManager;
import Model.Resource.SecondaryResource.Board;
import Model.Structure.StructureManager;
import Model.Transportation.Donkey;
import Model.Transportation.TransportationManager;
import Model.ViewObserver;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lazaro on 4/11/2017.
 */
public class Display extends JFrame {

    private ViewObserver observer;

    private void createDisplay(boardView board, MainController mainctrl){
        dashBoard dash = new dashBoard(observer, mainctrl);
        setTitle("PHASE 02");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(board.returnBoard());
        add(dash, BorderLayout.EAST);

        pack();
        setMinimumSize(getSize());
        setVisible(true);
        setResizable(true);
    }

    public Display(Map board){

        StructureManager structure = new StructureManager();
        TransportationManager transportationManager=new TransportationManager(board);
        ResourceManager resourceManager=new ResourceManager(transportationManager);
        MovementManager movementManager=new MovementManager(board,transportationManager);
        transportationManager.setMovementManager(movementManager);
        transportationManager.setResourceManager(resourceManager);

        ResourceBag resourceBag=new ResourceBag(resourceManager);
        ResourceBag resourceBag2=new ResourceBag(resourceManager);
        Resource resource=new Trunk();
        Resource resource2=new Board();

        resource.setOnGround(false);
        resource2.setOnGround(false);

        Donkey donkey =new Donkey(resourceBag);
        donkey.addResource(resource);
        donkey.addResource(resource2);
        Donkey donkey2 =new Donkey(resourceBag2);


        resourceManager.addResource(resource,new ResourceLocation(0,0,board.getTileAt(0,0).getTileZone(0)));
        resourceManager.addResource(resource2,new ResourceLocation(3,3,board.getTileAt(3,3).getTileZone(0)));
        transportationManager.addTransportation(donkey, new TransportationLocation(0,0, board.getTileAt(0,0).getTileZone(0)));
        transportationManager.addTransportation(donkey2, new TransportationLocation(3,3, board.getTileAt(3,3).getTileZone(0)));

        observer = new ViewObserver(board, transportationManager, resourceManager, structure);
        boardView map = new boardView(observer);
        MainController mainctrl=new MainController(transportationManager);
        createDisplay(map, mainctrl);
    }
}
