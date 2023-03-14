/* Represents a balloon in the BalloonDraw program.
 * Author: Willy Bolly
 * Ver 1.0 Created 12/31/17
 */

import java.awt.Color;


import java.awt.Graphics;

public class RoundBalloons extends Balloon
{

  /**
   * Constructs a balloon with the center at (0, 0),
   * radius 50, and blue color
   */
  public RoundBalloons()
  {
    super();
  }

  
  public RoundBalloons(int x, int y, int r, Color c)
  {
    super(x, y, r, c);
  }
  
 
  public void draw(Graphics g, boolean makeItFilled)
  {	
    g.setColor(getColor());
    if (makeItFilled)
      g.fillOval(getX() - getRadius(),
                 getY() - getRadius(), 2*getRadius(), 2*getRadius());
    else
      g.drawOval(getX() - getRadius(),
                 getY() - getRadius(), 2*getRadius(), 2*getRadius());
  }
}
