package View;

import Model.Map.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;

/**
 * Created by Lazaro on 4/11/2017.
 */
public class boardView extends JPanel implements MouseMotionListener, MouseListener {

    final   int BSIZE = 5; //board size.
    private paintHex hex = new paintHex();
    private Point hoverP = new Point(0,0);
    private JScrollPane wholeBoard = new JScrollPane(this);
    private Map board;


    private void fillInHex(Graphics2D g2){
        //for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
                if(board.getTileAt(0,j) != null) {
                    AffineTransform old = g2.getTransform();
                    hex.fillHex(0, j, board, g2);
                    hex.drawCursor(hoverP.x, hoverP.y, g2);
                    g2.setTransform(old);
                }
                else {
                    continue;
                }
           // }
        }
    }



    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //draws GameBoard
        //Fills In Hexes with Tile Images from the Board
         fillInHex(g2);



    }

    public JScrollPane returnBoard(){
        wholeBoard.getVerticalScrollBar().setUnitIncrement(16);
        wholeBoard.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        wholeBoard.setPreferredSize(new Dimension(2000, 1200));
        return wholeBoard;
    }
    public void mouseMoved(MouseEvent e){
        hoverP = hex.pxtoHex(e.getX(),e.getY());
        if (hoverP.x < 0 || hoverP.y < 0 || hoverP.x >= BSIZE || hoverP.y >= BSIZE){
            return;
        }

        repaint();
    }

    public void mouseClicked(MouseEvent e) {
        Point p = new Point( hex.pxtoHex(e.getX(),e.getY()) );
        if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE) {
                System.out.println("OUTSIDE"); //IF USER CLICKS OUT OF THE MAP
                return;
            }
            System.out.println(p.x + " " + p.y);

            this.repaint();




    }//end of mouseClicked method

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseDragged(MouseEvent e){

    }



    boardView(Map board){
        this.board = board;
        addMouseMotionListener(this);
        addMouseListener(this);
        setPreferredSize(new Dimension(2200,2100));



    }
}
