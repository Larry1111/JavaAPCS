package src;
/**
 * A human player in a board game
 */

import java.awt.event.MouseListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class HumanPlayer
    implements Player, MouseListener
{
  private Chomp program;
  private ChompGame game;
  private BoardPanel board;
  private String name = "Tom";
  private String name2 = "Larry";

  private boolean myTurn;

  public HumanPlayer(Chomp program, ChompGame game, BoardPanel board)
  {
    this.program = program;
    this.game = game;
    this.board = board;
    board.addMouseListener(this);
  }

  /**
   * Returns a prompt to be displayed before
   * the next move of this player
   */
  public String getPrompt()
  {
    return " Your turn, " + name;
  }
  public String getPrompt2() {
	  return "Your turn, " + name2;
  }

  /**
   * Returns a message to be displayed when
   * this player has won
   */
  public String getWinMessage()
  {
    return " Congratulations, " + name + " won!";
  }
  public String getWinMessage2()
  {
    return " Congratulations, " + name2 + " won!";
  }
  /**
   * Initiates this player's next move
   */
  public void makeMove()
  {
      myTurn = true;
  }

  /**
   * Called automatically when the mouse button is released
   */
  public void mouseReleased(MouseEvent e)
  {
    if (!myTurn)
      return;

    // board "knows" how to translate raw pixel coordinates x, y
    //   into row, col on the board:

    Location pos = board.getPos(e.getX(), e.getY());
    int row = pos.getRow();
    int col = pos.getCol();

    if (!game.isEmpty(row, col))
    {
      game.makeMove(row, col);
      program.hasMoved();
      myTurn = false;
    }
  }

  // Not used but required by the MouseListener interface spec:
  public void mouseClicked(MouseEvent e) {}
  public void mousePressed(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
}
