package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Lazaro on 4/11/2017.
 */
public class boardView extends JPanel implements MouseMotionListener, MouseListener {

    final   int BSIZE = 6; //board size.
    private paintHex hex = new paintHex();
    private Point hoverP = new Point(0,0);
    private JScrollPane wholeBoard = new JScrollPane(this);



    private void drawGameBoard(Graphics2D g2){

        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
                hex.drawHex(i, j, g2);
            }
        }
    }


/*
    private void fillInHex(Graphics2D g2){
        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
                AffineTransform old = g2.getTransform();
                hex.fillHex(i, j, board.getTileOrientation(i, j), board.getTileType(i, j),
                        board.getTileNumberOfRivers(i,j) , g2);
                hex.drawCursor(hoverP.x,hoverP.y,g2);
                g2.setTransform(old);
            }
        }
    }
*/


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //draws GameBoard
        drawGameBoard(g2);
        //Fills In Hexes with Tile Images from the Board
       // fillInHex(g2);
        //Drawing the cursor
        hex.drawCursor(hoverP.x,hoverP.y,g2);




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



    boardView(){
        addMouseMotionListener(this);
        addMouseListener(this);
        setPreferredSize(new Dimension(2200,2100));



    }
}
