/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * This is used for generating the main information panel.
 * @author Ziliang Wang
 * @version 12/2/2015
 */
public class MainPanel extends JPanel {
    /** Serial ID Numbers.*/
    private static final long serialVersionUID = 7526370675764013626L;
    /** my main panel size. */
    private static final Dimension MAIN_SIZE = new Dimension(200, 600);
    /** The next piece panel field.*/
    private final JPanel myNPPanel;
    /** The introduction panel field.*/
    private final JPanel myIntroPanel;
    /** The score panel field.*/
    private final JPanel myScorePanel;
    /**
     * This is the constructor and initialize the fields.
     * @param theNPPanel the next piece panel.
     * @param theInfoPanel the information panel.
     * @param theScorePanel the score panel.
     */
    public MainPanel(final JPanel theNPPanel, final JPanel theInfoPanel,
                     final JPanel theScorePanel) {
        super();
        myIntroPanel = theInfoPanel;
        myNPPanel = theNPPanel;
        myScorePanel = theScorePanel;
        setUpThePanel();
    }
    /**
     * This would set up the main panel.
     */
    private void setUpThePanel() {
        setLayout(new BorderLayout());
        add(myNPPanel, BorderLayout.NORTH);
        add(myIntroPanel, BorderLayout.SOUTH);
        add(myScorePanel, BorderLayout.CENTER);
        setPreferredSize(MAIN_SIZE);
    }
}
