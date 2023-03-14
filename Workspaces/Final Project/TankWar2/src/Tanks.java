import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Tanks {
	public  int x, y, xR, yR;
	private int angle;
	private int dx;
	private int velR;
	private boolean left,right,up,down,firing;
	private long firingTimer;
	private long firingDelay;
	private int health;
	private int speed;
	private Color color1;
	private Color color2;
	private Color colorHit;
	private boolean recovering;
	private long recoveryTimer;
	private String name;
	private ArrayList<Bullets> bullets;
	public Tanks(int x, int y, Color color, String s, ArrayList<Bullets> bullets)
	{
		
		this.bullets = bullets;
		name = s;
		this.x = x;
		this.y = y;
		dx = 0;
		speed =3;
		health = 3;
		color1 = color;
		color2= color.darker().darker();
		colorHit = Color.orange;
		firing = false;
		firingTimer = System.nanoTime();
		firingDelay = 300;
		recovering = false;
		recoveryTimer = 0;
	}
	public int getHealth()
	{
		return health;
	}
	public void update()
	{
		
		if(left)
		{
			dx = -speed;
		}
		if(right)
		{
			dx = speed;
		}
		if(up)
		{
			velR = 2;
		}
		if(down)
		{
			velR=-2;
		}
		if(x > GamePanel.W-130)
		{
			x=GamePanel.W-130;
		}
		if(x < 0)
		{
			x=0;
		}
		int centerY = y-55;
		int centerX = x+65;
		//Direction of the muzzle
		x += dx;
		angle += velR;
		xR = x+65;
		yR = centerY-90;
		xR = (int) (centerX + (xR-centerX)*Math.cos(angle*Math.PI/180)-(yR-centerY)* Math.sin(angle*Math.PI/180));
		yR = (int) (centerY - 90*Math.cos(angle*Math.PI/180));
		dx=0;
		velR = 0;
		//reloading time
		if(firing)
		{
			long elapsed = (System.nanoTime()-firingTimer)/5000000;
			if(elapsed > firingDelay)
			{
				GamePanel.bullets.add(new Bullets(angle-90,xR,yR,1));
				firingTimer = System.nanoTime();
				Sound.cannon.play();
			}
			
		}
//		if(split)
//		{
//			for(int i = 0; i<bullets.size();i++)
//			{
//				bullets.get(i).setSplit(true);
//			}
//		}
		//recovering time
		long elapsed = (System.nanoTime()-recoveryTimer)/1000000;
		if(elapsed > 2500)
		{
			recovering = false;
			recoveryTimer = 0;
		}
	for(int i = 0; i< GamePanel.bullets.size(); i++)
	{
		if(x+120 > GamePanel.bullets.get(i).getX() && 
			y-50 < GamePanel.bullets.get(i).getY()&&
			x+20< GamePanel.bullets.get(i).getX()&&
			y > GamePanel.bullets.get(i).getY())
		{
			if(!recovering)
			{
				Hit();
				Sound.explosion.play();
			}
			GamePanel.bullets.get(i).setHit(true);
		}
	}
	}
	
	public void Hit()
	{
		health--;
		recovering = true;
		recoveryTimer = System.nanoTime();
	}
	public void setLeft(boolean b)
	{
		left = b;
	}
	public void setRight(boolean b)
	{
		right = b;
	}
	public void setUp(boolean b)
	{
		up = b;
	}
	public void setDown(boolean b)
	{
		down = b;
	}
	public void setFiring(boolean b)
	{
		firing = b;
	}
	public boolean getFiring()
	{
		return firing;
	}
	public void draw(Graphics2D g)
	{
		if(recovering)
		{
			
			g.setColor(Color.black);
			g.setStroke(new BasicStroke(8));
			g.drawLine(x+65,y-55,xR,yR );
			g.setColor(colorHit);
			g.fillArc(x+33, y-80, 60, 60, 0, 180);
			g.setColor(colorHit.darker().darker());
			g.fillRoundRect(x, y-50, 130, 50, 50, 50);
		}
		else
		{
			g.setColor(Color.black);
			g.setStroke(new BasicStroke(8));
			g.drawLine(x+65,y-55,xR,yR );
			g.setColor(color1);
			g.fillArc(x+33, y-80, 60, 60, 0, 180);
			g.setColor(color2);
			g.fillRoundRect(x, y-50, 130, 50, 50, 50);
			
		}
		if(health<=0)
		{
			g.setColor(Color.black);
			g.setFont(new Font(null, Font.BOLD,70));
			g.drawString(name + " Won!", GamePanel.W/2-150, GamePanel.H/2);
			GamePanel.running = false;
			Sound.explode.play();
		}
	}
}
