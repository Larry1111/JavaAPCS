/**
 * Represents  a panel on which "letter cubes" fall
 * in the Ramblecs game
 */
 
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;

import java.awt.geom.Rectangle2D;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class LetterPanel extends JPanel
      implements ActionListener
{
  private final int ROWS = 7, COLS = 5; // Grid dimensions

  private Ramblecs game;
  private RamblecsCharMatrix charMatrix;
  private FallingCube cube;
  private ScoreDisplay scoreDisplay;

  private final int CUBESIZE = 40;
  private final int X_LEFT = CUBESIZE / 2;

  private Timer t;
  private final int DELAY = 30;
  private int yStep;    // displacement in pixels per timer cycle

  private RamblecsDictionary dictionary;
  private static final int scoreIncr[] = {-15, -3, 0, 3, 6, 12};
  private int score;

  private EasySound drop;
  private EasySound chomp;

  public LetterPanel(Ramblecs game, RamblecsDictionary dictionary)
  {
    this.game = game;
    this.dictionary = dictionary;
    setPreferredSize(new Dimension(6*CUBESIZE, 8*CUBESIZE));
    setBackground(Color.WHITE);

    drop = new EasySound("drop.wav");
    chomp = new EasySound("chomp.wav");

    charMatrix = new RamblecsCharMatrix(ROWS, COLS);
    cube = new FallingCube(CUBESIZE);
    t = new Timer(DELAY, this);
  }

  public void setScoreDisplay(ScoreDisplay display)
  {
    scoreDisplay = display;
    scoreDisplay.update(score);
  }

  public void newGame()
  {
    charMatrix.clear();
    stopCube();
    score = 100;
    scoreDisplay.update(score);
  }

  public void setSpeed(int speed)
  {
    yStep = Math.max(1, speed * DELAY / 1000);
  }

  public void dropCube()
  {
    cube.setRandomLetters();
    int x = (int)(Math.random() * charMatrix.numCols()) * CUBESIZE;
    int y = -CUBESIZE;          // above the board for smooth entry
    cube.move(x, y);
    t.start();
  }

  public void stopCube()
  {
    t.stop();
    cube.move(-CUBESIZE, -CUBESIZE);
    repaint();
    if (game.soundEnabled())
      drop.play();
  }

  public void moveCubeLeft()
  {
    int x = cube.getX();
    int y = cube.getY();
    int row = (y + CUBESIZE) / CUBESIZE;
    int col = x / CUBESIZE;
    if (row >= 0 && row < charMatrix.numRows() &&
        col >= 1 && charMatrix.isEmpty(row, col - 1))
    {
      cube.move(x - CUBESIZE, y);
      repaint();
    }
  }

  public void moveCubeRight()
  {
    int x = cube.getX();
    int y = cube.getY();
    int row = (y + CUBESIZE) / CUBESIZE;
    int col = x / CUBESIZE;
    if (row >= 0 && row < charMatrix.numRows() &&
        col < charMatrix.numCols() - 1 && charMatrix.isEmpty(row, col + 1))
    {
      cube.move(x + CUBESIZE, y);
      repaint();
    }
  }

  private boolean moveCubeDown()
  {
    int x = cube.getX();
    int y = cube.getY();
    int row = (y + CUBESIZE + yStep) / CUBESIZE;
    int col = x / CUBESIZE;
    if (row < charMatrix.numRows() && charMatrix.isEmpty(row, col))
    {
      cube.move(x, y + yStep);
      return true;
    }
    else  // land this cube:
    {
      row--;
      if (row >= 0 && row < charMatrix.numRows())
        charMatrix.setCharAt(row, col, cube.getLetter());
      return false;
    }
  }

  public void rotateCube(int dir)
  {
    if (dir < 0)
      cube.rotateLeft();
    else
      cube.rotateRight();
    repaint();
  }

  public void enterWord()
  {
    String word = charMatrix.lastRowToString().trim();
    int len = word.length();
    if (len > 0)
    {
      if (dictionary.isFound(word))
        score += scoreIncr[len];  // reward
      else
        score += scoreIncr[0];  // penalty
      scoreDisplay.update(score);
      charMatrix.shiftDown();
      repaint();
      if (game.soundEnabled())
        chomp.play();
    }
  }

  public void dropWord()
  {
    String word = charMatrix.lastRowToString().trim();
    if (word.length() > 0)
    {
      score += scoreIncr[1];  // small penalty
      scoreDisplay.update(score);
      charMatrix.shiftDown();
      repaint();
      if (game.soundEnabled())
        chomp.play();
    }
  }

  // Handles timer events
  public void actionPerformed(ActionEvent e)
  {
    if (!moveCubeDown())
    {
      stopCube();
      dropCube();
    }
    repaint();
  }

  /***  Graphics display methods ***/

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    drawCharMatrix(g);
    drawCube(g);
  }

  public void drawCube(Graphics g)
  {
    drawCube(g, cube.getX() + X_LEFT, cube.getY(), cube.getLetter());
  }

  private void drawCharMatrix(Graphics g)
  {
    g.setColor(Color.GRAY);
    int size = CUBESIZE;
    int x1 = X_LEFT - 2;
    int x2 = X_LEFT + COLS * size + 1;
    int y1 = 2;
    int y2 = ROWS * size - 1;
    g.drawLine(x1, y1, x1, y2);
    g.drawLine(x2, y1, x2, y2);
    g.drawLine(x1, y2, x2, y2);

    for (int row = 0; row < ROWS; row++)
    {
      for (int col = 0; col < COLS; col++)
      {
        if (!charMatrix.isEmpty(row, col))
        {
          int x = X_LEFT + col * CUBESIZE;
          int y = row * CUBESIZE;
          drawCube(g, x, y, charMatrix.charAt(row, col));
        }
      }
    }
  }

  public void drawCube(Graphics g, int x, int y, char letter)
  {
    int size = CUBESIZE;

    // Get the width and height of the letter:
    String s = String.valueOf(letter);
    Font font = new Font("SansSerif", Font.BOLD, size / 2);
    Rectangle2D r = font.getStringBounds(s,
                          ((Graphics2D)g).getFontRenderContext());
    int w = (int)r.getWidth();
    int h = (int)(r.getHeight() * 0.6);

    // Draw the cube:
    g.setColor(Color.RED);
    g.fill3DRect(x, y, size - 1, size - 1, true);
    g.setColor(Color.WHITE);
    g.fillRoundRect(x + 5, y + 5, size - 10, size - 10,
                                        size/2 - 5, size/2 - 5);
    // Draw the letter:
    g.setColor(Color.BLACK);
    g.setFont(font);
    g.drawString(s, x + size / 2 - w/2, y + size/2 + h/2);
  }
}