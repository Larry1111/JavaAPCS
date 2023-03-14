/**
 * This is the main class for the Ramblecs game.
 * See Help for the rules.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;

public class Ramblecs extends JFrame
{
  private RamblecsMenu menuBar;
  private ControlPanel controlPanel;

  public Ramblecs()
  {
    super("Ramblecs");
    menuBar = new RamblecsMenu(this);
    setJMenuBar(menuBar);

    RamblecsDictionary dictionary = new RamblecsDictionary();
    LetterPanel whiteboard = new LetterPanel(this, dictionary);
    controlPanel = new ControlPanel(whiteboard);
    whiteboard.setScoreDisplay(controlPanel);
    controlPanel.addKeyListener(new
                  RamblecsKeyListener(whiteboard, controlPanel));

    Box box = Box.createHorizontalBox();
    box.add(whiteboard);
    box.add(controlPanel);
    getContentPane().add(box);

    newGame();
    
  }

  public void newGame()
  {
    controlPanel.newGame();
  }

  public boolean soundEnabled()
  {
    return menuBar.soundEnabled();
  }

  public static void main(String[] args)
  {
    // Set system look and feel:
	  String plafName = UIManager.getSystemLookAndFeelClassName();
	     try
	     {
	       UIManager.setLookAndFeel(plafName);
	     }
	     catch (Exception ex)
	     {
	       System.out.println("*** " + plafName + " PLAF not installed ***");
	     }
    Ramblecs window = new Ramblecs();
    window.setBounds(100, 100, 395, 355);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

