/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Board;

/**
 * This class is managing the GUI for tetris game.
 * @author Ziliang Wang
 * @version 12/1/2015
 */
public class TetrisGUI {
    /** The width of board.*/
    public static final int BOARD_WIDTH = 10;
    /** The height of board.*/
    public static final int BOARD_HEIGHT = 20;
    /** A second.*/
    private static final int A_SEC = 1000;
    /** The JMenuBar field.*/
    private final JMenuBar myMenu;
    /** The tetris drawing panel.*/
    private final TetrisDrawingPanel myTPanel;
    /** The information panel field.*/
    private final JPanel mySocrePanel = new ScorePanel();
    /** The main frame field.*/
    private final JFrame myFrame = new JFrame("Tetris Game");
    /** The board field.*/
    private final Board myBoard;
    /**
     * This is the constructor and initialize the fields.
     */
    public TetrisGUI() {
        
        myBoard = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        final Timer ticTimer = new Timer(A_SEC, new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myBoard.step();
            }
        });
        myTPanel = new TetrisDrawingPanel(myBoard, (ScorePanel) mySocrePanel, ticTimer);
        myMenu = new MenuBar(ticTimer, myFrame, myBoard, myTPanel, (ScorePanel) mySocrePanel);
        setUpFrame();
    }
    
    /**
     * Set up the game frame.
     */
    private void setUpFrame() {
        myFrame.setJMenuBar(myMenu);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.addKeyListener(new FrameKeyAdapter());
        myFrame.setLayout(new FlowLayout());
        myFrame.add(myTPanel, BorderLayout.WEST);
        final JPanel npPanel = new NextPiecePanel(myBoard);
        final JPanel infoPanel = new InfoPanel();
        myFrame.add(new MainPanel(npPanel, infoPanel, mySocrePanel), BorderLayout.CENTER);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
        myFrame.setResizable(false);
    }
    
    /**
     * The key adapter for the JFrame, assign the control key for the game.
     * @author Ziliang Wang
     * @version 12/1/2015
     */
    private class FrameKeyAdapter implements KeyListener {
        @Override
        public void keyPressed(final KeyEvent theEvent) {
            if (!myBoard.isGameOver() && !((MenuBar) myMenu).gameIsOver()) {
                final int keyCode = theEvent.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP: 
                        myBoard.rotate();
                        break;
                    case KeyEvent.VK_RIGHT:
                        myBoard.moveRight();
                        break;
                    case KeyEvent.VK_LEFT:
                        myBoard.moveLeft();
                        break;
                    case KeyEvent.VK_DOWN:
                        myBoard.moveDown();
                        break;
                    case KeyEvent.VK_SPACE:
                        myBoard.hardDrop();
                        break;
                    default:
                        break;
                }
            }
        }

        @Override
        public void keyTyped(final KeyEvent theEvent) {
            // do nothing
        }

        @Override
        public void keyReleased(final KeyEvent theEvent) {
            //do nothing
        }
        
    }

}
