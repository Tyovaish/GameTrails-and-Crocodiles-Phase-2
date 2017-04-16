package View;

import Model.Map.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;


/**
 * Created by Lazaro on 4/11/2017.
 */
public class boardView extends JPanel implements MouseMotionListener, MouseListener {

    final   int BSIZE = 6; //board size.
    private paintHex hex = new paintHex();
    private Point hoverP = new Point(0,0);
    private JScrollPane wholeBoard;
    boolean clickCheck = false;
    private int pointX = -1, pointY = -1;
    private Map board;



    private void drawCursor(Graphics2D g2){
        if(!clickCheck)
            hex.drawCursor(hoverP.x, hoverP.y, g2);
        else
            hex.drawCursorLockOn(hoverP.x,hoverP.y,g2);
    }

    private void fillInHex(Graphics2D g2){
        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
                if(board.getTileAt(i,j) != null) {
                    AffineTransform old = g2.getTransform();
                    hex.fillHex(i, j, board, g2);
                    g2.setTransform(old);
                }
            }
        }
    }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D) g;
        //Fills In Hexes with Tile Images from the Board
        fillInHex(g2);
        drawCursor(g2);
    }

    public JScrollPane returnBoard(){
        wholeBoard = new JScrollPane(this);
        wholeBoard.getVerticalScrollBar().setUnitIncrement(16);
        wholeBoard.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        wholeBoard.setPreferredSize(new Dimension(2000, 800));
        return wholeBoard;
    }
    public void mouseMoved(MouseEvent e){
        if(!clickCheck) {
            hoverP = hex.pxtoHex(e.getX(), e.getY());
            if (hoverP.x < 0 || hoverP.y < 0 || hoverP.x >= BSIZE || hoverP.y >= BSIZE) {
                return;
            }
            this.repaint();
        }
    }

    public void mouseClicked(MouseEvent e) {
        hoverP = new Point( hex.pxtoHex(e.getX(),e.getY()) );
        if (hoverP.x < 0 || hoverP.y < 0 || hoverP.x >= BSIZE || hoverP.y >= BSIZE) {
                System.out.println("OUTSIDE"); //IF USER CLICKS OUT OF THE MAP
                return;
            }

            if(pointX == hoverP.x && pointY == hoverP.y) {
                pointX = -1;
                pointY = -1;
                clickCheck = false;
            }
            else{
                pointX = hoverP.x;
                pointY = hoverP.y;
                clickCheck = true;
            }
            repaint();

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
        setPreferredSize(new Dimension(2200,1500));
        hex.createImages();
        hex.CreateRiver();
    }

}
