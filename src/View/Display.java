package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lazaro on 4/11/2017.
 */
public class Display extends JFrame {
    boardView board = new boardView();
    dashBoard dash = new dashBoard();

    private void createDisplay(){
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

    public Display(){
        createDisplay();
    }
}
