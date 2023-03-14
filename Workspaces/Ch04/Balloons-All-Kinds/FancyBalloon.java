import java.awt.Color;
import java.awt.Graphics;

public class FancyBalloon extends Balloon
{
public FancyBalloon()
  {
    super();
  }

  
  public FancyBalloon(int x, int y, int r, Color c)
  {
    super(x, y, r, c);
  }

public void draw(Graphics g, boolean makeItFilled)
{	
  g.setColor(getColor());
  if (makeItFilled) {
    g.fillOval(getX() - getRadius(),
               getY() - getRadius()/2, 2*getRadius(), getRadius());
  	g.fillOval(getX() - getRadius()/2,
  				getY() - getRadius(), getRadius(), 2*getRadius());
  }
  else {
    g.drawOval(getX() - getRadius(),
               getY() - getRadius()/2, 2*getRadius(), getRadius());
  	g.fillOval(getX() - getRadius()/2,
  				getY() - getRadius(), getRadius(), 2*getRadius());}
  }
  public double distance(int x, int y)
  {
    double dx = (x - getX())*2;
    double dy = y - getY();
    return Math.sqrt(dx*dx + dy*dy);
    
    
}
}
