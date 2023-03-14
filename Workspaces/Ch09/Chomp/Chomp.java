/**
 * A board game program with someone
 * playing against the computer
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Chomp extends JFrame
{
  private ChompGame game;
  private JTextField display;
  private Player players[];
  private int currentPlayer;

  public Chomp()
  {
    Container c = getContentPane();

    display = new JTextField(20);
    display.setBackground(Color.YELLOW);
    display.setEditable(false);
    c.add(display, BorderLayout.NORTH);

    BoardPanel board = new BoardPanel();
    c.add(board, BorderLayout.CENTER);

    game = new ChompGame(board);

    HumanPlayer human = new HumanPlayer(this, game, board);
    ComputerPlayer computer = new ComputerPlayer(this, game, board);
    computer.setStrategy(new Chomp4by7Strategy());
    HumanPlayer human2 = new HumanPlayer(this, game, board);

    players = new Player[2];
    players[0] = human;
//  players[1] = computer;
    players[1]= human2;
    currentPlayer = 0;

    display.setText(HumanPlayer.getName1() + " go first");
    players[currentPlayer].makeMove();
  }

  // Called by the player when its move is completed.
  public void hasMoved()
  {
    currentPlayer = (currentPlayer + 1) % 2;
    Player p = players[currentPlayer];
    if(currentPlayer == 0) {
    if (game.isWon())
    {
      display.setText(p.getWinMessage());
    }
    else
    {
      display.setText(p.getPrompt());
      p.makeMove();
    }
    }
    if(currentPlayer == 1) {
        if (game.isWon())
        {
          display.setText(((HumanPlayer) p).getWinMessage2());
        }
        else
        {
          display.setText(((HumanPlayer) p).getPrompt2());
          p.makeMove();
        }
        }
  }

  public static void main(String[] args)
  {
    Chomp window = new Chomp();
    window.setTitle("Chomp");
    window.setBounds(200, 200, 300, 225);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setVisible(true);
  }
}

