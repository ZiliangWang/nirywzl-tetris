/**
 * 
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import model.AbstractPiece;
import model.Board;

/**
 * This class would generate next piece and show in a JPanel.
 * @author Ziliang Wang
 * @version 12/1/2015
 */
public class NextPiecePanel extends JPanel implements Observer {
    /** The next piece panel size.*/
    public static final Dimension PANEL_SIZE = new Dimension(100, 100);
    /** Serial ID Numbers.*/
    private static final long serialVersionUID = -3254087614079880441L;
    /** Block size.*/
    private static final int BLOCK_SIZE = 20;
    /** The amount of block.*/
    private static final int BLOCKS_NUM = 4;
    /** The number to move the piece X coordinate.*/
    private static final int ARRANGE_X = 10;
    /** The number to move the piece Y coordinate.*/
    private static final int ARRANGE_Y = 470;
    /** The next piece coordinates.*/
    private int [][] myPieceCoord; 
    /** The board field.*/
    private final Board myBoard;
    /** 
     * This is the constructor and initialize the fields.
     * @param theBoard passed by the GUI.
     */
    public NextPiecePanel(final Board theBoard) {
        super();
        setUpNPPanel();
        myBoard = theBoard;
        myBoard.addObserver(this);
        myPieceCoord = new int [BLOCKS_NUM][2];
    }
    /**
     * set up the next piece panel.
     */
    private void setUpNPPanel() {
        setPreferredSize(PANEL_SIZE);
        setBackground(Color.darkGray);
    }
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        drawNextPiece(g2d);
    }
    
    /**
     * This method is for drawing next piece.
     * @param thePen drawing tool.
     */
   
    private void drawNextPiece(final Graphics2D thePen) {
        for (int i = 0; i < BLOCKS_NUM; i++) {
            thePen.setColor(Color.LIGHT_GRAY);
            thePen.fillRect(myPieceCoord[i][0] * BLOCK_SIZE + ARRANGE_X, 
                            -myPieceCoord[i][1] * BLOCK_SIZE + ARRANGE_Y, 
                         BLOCK_SIZE, BLOCK_SIZE);
            thePen.setColor(Color.CYAN);
            thePen.drawRect(myPieceCoord[i][0] * BLOCK_SIZE + ARRANGE_X, 
                            -myPieceCoord[i][1] * BLOCK_SIZE + ARRANGE_Y, 
                         BLOCK_SIZE, BLOCK_SIZE);
        }
    }
    
    @Override
    public void update(final Observable theO, final Object theArg) {
        myPieceCoord = ((AbstractPiece) myBoard.getNextPiece()).getBoardCoordinates();
        repaint();
    }
}
