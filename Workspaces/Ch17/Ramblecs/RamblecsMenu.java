/**
 * A menu bar for the Ramblecs game
 */

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;

public class RamblecsMenu extends JMenuBar 
    implements ActionListener
{
  private Ramblecs game;
  private JCheckBoxMenuItem sound;
  private JMenuItem newgame, exit, howtoplay, about, preferences;
  // Constructor:
  public RamblecsMenu(Ramblecs game)
  {
	this.game = game;
    sound = new JCheckBoxMenuItem("Play Sound");
    newgame = new JMenuItem("New Game");
    newgame.addActionListener(this);
    exit = new JMenuItem("Exit");
    exit.addActionListener(this);
    preferences = new JMenu("Preferences");
    preferences.setMnemonic(KeyEvent.VK_S);
    preferences.add(sound);
    JMenu fileMenu = new JMenu("File");
    fileMenu.add(preferences);
    fileMenu.addSeparator();
    fileMenu.add(newgame);
    fileMenu.add(exit);
    howtoplay = new JMenuItem("How to play...");
    howtoplay.addActionListener(this);
    about = new JMenuItem("About...");
    about.addActionListener(this);
    JMenu helpMenu = new JMenu("Help");
    
    helpMenu.add(howtoplay);
    helpMenu.add(about);
    this.add(fileMenu);
    this.add(helpMenu);
   
    
  }

  public boolean soundEnabled()
  {
    return sound.isSelected();
  }

  public void actionPerformed(ActionEvent e)
  {
    JMenuItem src = (JMenuItem)e.getSource();
    if(src == newgame)
    	game.newGame();
    if(src == exit)
    	System.exit(0);
    if(src == about)
    	RamblecsHelp.showAbout();
    if(src == howtoplay)
    	RamblecsHelp.showHelp();
  }
}

