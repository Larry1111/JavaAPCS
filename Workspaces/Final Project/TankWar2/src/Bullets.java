import java.awt.Color;
import java.awt.Graphics2D;

public class Bullets {
	private double x;
	private double y;
	private double acce;
	private int r;
	private double dx;
	private double dy;
	private double rad;
	private double speed;
	private Color color1;
	private boolean hit;
	private boolean state;
	private boolean split;
	public Bullets(double angle, int x, int y, int s)
	{
		split = false;
		state = true;
		hit = false;
		this.x = x;
		this.y = y;
		acce = 0;
		r=4;
		rad = Math.toRadians(angle);
		dx = Math.cos(rad)*s;
		dy = Math.sin(rad);
		speed = 10;
		color1 = Color.black;
	}
//	public boolean getSplit()
//	{
//		return split;
//	}
	public double getRad()
	{
		return rad;
	}
	public void setSplit(boolean b)
	{
		split = b;
	}
	public void setState(boolean b)
	{
		state = b;
	}
	public boolean getState()
	{
		return state;
	}
	public void setHit(boolean b)
	{
		hit = b;
	}
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public boolean update()
	{
		for(Obstacles o: GamePanel.wall)
		{
			if(x>o.getX()&&x<(o.getX()+o.getW())&&y>o.getY()&&y<(o.getY()+o.getH()+r))
			{
				dy *= -1;
			}
			else if(x>o.getX()&&x<(o.getX()+o.getW())&&y<o.getY()&&y>(o.getY()-r))
			{
				acce -= 20 ;
			}
				
		}
		acce += GamePanel.gravity/1000;
		x+=speed*dx;
		y+=speed*(dy+acce);
		if(x < -r || x > GamePanel.W +r||
				y < -r || y > GamePanel.H+r)
		{
			return true;
		}
		return false;
	}
	public void draw(Graphics2D g)
	{
		if(!hit && y< 6*GamePanel.H/7-70)
		{
			if(!split) 
			{
				g.setColor(color1);
				g.fillOval((int)(x-r), (int)(y-r), 2*r, 2*r);
			}
		}
		else 
		{
			split = false;
			if(state)
			{
				Sound.explosion.play();
				state = false;
			}
		}
	}
}
