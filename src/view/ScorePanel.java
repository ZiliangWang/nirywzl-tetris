/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * @author Ziliang Wang
 * @version 12/13/2015
 */
public class ScorePanel extends JPanel {
    /** Serial ID Numbers.*/
    private static final long serialVersionUID = 2890890771986609917L;
    /** my text area panel size. */
    private static final Dimension PANEL_SIZE = new Dimension(200, 200);
    /** Font size. */
    private static final int FONT_SIZE = 20;
    /** Line 3.*/
    private static final int THREE = 3;
    /** Line 4.*/
    private static final int FOUR = 4;
    /** Initial X coordinate. */
    private static final int X_COORDINATE = 20;
    /** Line changing coordinate. */
    private static final int LINE_POSITION = 40;
    /** Level up stage. */
    private static final int LEVEL_STAGE = 3;
    /** Level integer.*/
    private int myLevel = 1;
    /** Score integer.*/
    private int myScore; 
    /**
     * The constructor for ScorePanel class.
     */
    public ScorePanel() {
        super();
        setUpThePanel();
    }
    
    /**
     * Set up the panel.
     */
    private void setUpThePanel() {
        setBackground(Color.GREEN);
        setPreferredSize(PANEL_SIZE);
    }
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setFont(new Font("Serif", Font.BOLD, FONT_SIZE));
        g2d.drawString("Current Level: " + getMyLevel(), X_COORDINATE, LINE_POSITION);
        g2d.drawString("Score�� " + getMyScore(), X_COORDINATE, LINE_POSITION * 2);
        g2d.drawString("Next Level In: " 
                        + (THREE - myScore % LEVEL_STAGE), 
                        X_COORDINATE , LINE_POSITION * THREE);
        g2d.drawString("Total cleared lines: " 
                        + getMyScore(), X_COORDINATE , LINE_POSITION * FOUR);
    }
    /**
     * The getter for level.
     * @return a level integer.
     */
    public int getMyLevel() {
        return myLevel;
    }
    /**
     * The setter for level.
     */
    public void increaseMyLevel() {
        this.myLevel++;
        repaint();
    }
    /**
     * The getter for the score.
     * @return a score integer.
     */
    private int getMyScore() {
        return myScore;
    }
    /**
     * The setter for score.
     */
    public void increaseMyScore() {
        this.myScore++;
        if (myScore % LEVEL_STAGE == 0) {
            increaseMyLevel();
        }
        repaint();
    }
    /**
     * Set the initial level.
     * @param theLevel the initial level.
     */
    public void setMyLevel(final int theLevel) {
        this.myLevel = theLevel;
    }
    /**
     * Use for initializing the score.
     * @param theScore initial score.
     */
    public void setMyScore(final int theScore) {
        this.myScore = theScore;
    }
}
