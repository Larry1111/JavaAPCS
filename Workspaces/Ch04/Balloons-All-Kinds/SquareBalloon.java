import java.awt.Color;
import java.awt.Graphics;

public class SquareBalloon extends Balloon
{
public SquareBalloon()
  {
    super();
  }

  
  public SquareBalloon(int x, int y, int r, Color c)
  {
    super(x, y, r, c);
  }

public void draw(Graphics g, boolean makeItFilled)
{	
  g.setColor(getColor());
  if (makeItFilled)
    g.fillRect(getX() - getRadius(),
               getY() - getRadius(), 2*getRadius(), 2*getRadius());
  else
    g.drawRect(getX() - getRadius(),
               getY() - getRadius(), 2*getRadius(), 2*getRadius());
}
public double distance(int x, int y)
{
  double dx = Math.abs(x - getX());
  double dy = Math.abs(y - getY());
  return Math.max(dx,dy);
}
}
