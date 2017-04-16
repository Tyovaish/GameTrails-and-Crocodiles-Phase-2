package View;

import Model.Map.Map;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lazaro on 4/11/2017.
 */
public class Display extends JFrame {

    private DisplayManager manager;

    private void createDisplay(boardView board,Map map){
        dashBoard dash = new dashBoard(map, manager);
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
        boardView map = new boardView(board);
        manager = new DisplayManager(board);
        createDisplay(map,board);
    }
}
