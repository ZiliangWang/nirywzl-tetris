package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
/**
 * This class is used for drawing text on introduction panel.
 * @author Ziliang Wang
 * @version 12/8/2015
 */
public class InfoPanel extends JPanel {
    /** Serial ID Numbers.*/
    private static final long serialVersionUID = 4691417946172572337L;
    /** my text area panel size. */
    private static final Dimension TA_SIZE = new Dimension(200, 300);
    /** The list of introduction string.*/
    private static final String[] INTRO = {"Introduction to Tetris", "Left move: ¡û", 
        "Right move: ¡ú", "Rotate: ¡ü", "Down move: ¡ý", "Hard Drop: Space"};
    /** Font size. */
    private static final int FONT_SIZE = 15;
    /** Font size. */
    private static final int HINT_SIZE = 7;
    /** Information coordinate. */
    private static final int INITIAL_COORDINATE = 25;
    /** Line changing integer. */
    private static final int LINE_CHANGE = 25;
    /**
     * Constructor for infoPanel class.
     */
    public InfoPanel() {
        super();
        setUpPanel();
    }
    /**
     * Set up the panel.
     */
    private void setUpPanel() {
        setBackground(Color.CYAN);
        setPreferredSize(TA_SIZE);
    }
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
        for (int i = 0; i <= INTRO.length - 1; i++) {
            g2d.drawString(INTRO[i], INITIAL_COORDINATE, 
                           INITIAL_COORDINATE + LINE_CHANGE * i);
        }
        
        g2d.drawString("Score added 3, level up.", 
                       INITIAL_COORDINATE, INITIAL_COORDINATE + LINE_CHANGE * HINT_SIZE);
    }
}
