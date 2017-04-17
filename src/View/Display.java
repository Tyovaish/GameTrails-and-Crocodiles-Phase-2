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
import Model.Transportation.Donkey;
import Model.Transportation.TransportationManager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lazaro on 4/11/2017.
 */
public class Display extends JFrame {

    private DisplayManager manager;

    private void createDisplay(boardView board,Map map, MainController mainctrl, TransportationManager transport){
        dashBoard dash = new dashBoard(board, manager, mainctrl, transport);
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
        manager = new DisplayManager(board);


        TransportationManager transportationManager=new TransportationManager(board);
        ResourceManager resourceManager=new ResourceManager(transportationManager);
        MovementManager movementManager=new MovementManager(board,transportationManager);
        transportationManager.setMovementManager(movementManager);
        transportationManager.setResourceManager(resourceManager);

        ResourceBag resourceBag=new ResourceBag(resourceManager);
        Resource resource=new Trunk();
        Donkey donkey =new Donkey(resourceBag);
        donkey.addResource(resource);
        resourceManager.addResource(resource,new ResourceLocation(0,0,board.getTileAt(0,0).getTileZone(0)));
        transportationManager.addTransportation(donkey, new TransportationLocation(0,0, board.getTileAt(0,0).getTileZone(0)));
        MainController mainctrl=new MainController(transportationManager);

        boardView map = new boardView(board);
        createDisplay(map,board, mainctrl, transportationManager);
    }
}
