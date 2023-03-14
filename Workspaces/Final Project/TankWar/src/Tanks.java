import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Tanks {
	public  int x, y, xR, yR;
	private int angle,angleW;
	private int dx;
	private int velR,velW;
	private boolean left,right,up,down,firing,split;
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
	public Tanks(int x, int y, Color color, String s)
	{
		name = s;
		this.x = x;
		this.y = y;
		dx = 0;
		speed =4;
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
	public void setSpeed(int s)
	{
		speed = s;
	}
	public boolean getSplit()
	{
		return split;
	}
	public void setSplit(boolean b)
	{
		split = b;
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
			velW = -speed;
		}
		if(right)
		{
			dx = speed;
			velW = speed;
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
		angleW+= velW;
		xR = x+65;
		yR = centerY-90;
		xR = (int) (centerX + (xR-centerX)*Math.cos(angle*Math.PI/180)-(yR-centerY)* Math.sin(angle*Math.PI/180));
		yR = (int) (centerY - 90*Math.cos(angle*Math.PI/180));
		dx=0;
		velR = 0;
		velW = 0;
		//reloading time
		if(firing)
		{
			long elapsed = (System.nanoTime()-firingTimer)/5000000;
			if(elapsed > firingDelay && !recovering)
			{
				GamePanel.bullets.add(new Bullets(angle-90,xR,yR,this));
				firingTimer = System.nanoTime();
				Sound.cannon.play();
			}
			
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
		//recovering time
		long elapsed = (System.nanoTime()-recoveryTimer)/1000000;
		if(elapsed > 2500)
		{
			recovering = false;
			recoveryTimer = 0;
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
		g.setStroke(new BasicStroke(4));
		g.setColor(Color.gray.brighter());
		int cX1= x+26;
		int cX2 = x+66;
		int cX3 = x+106;
		int cY = y-25;
		int xR1 = x+14;
		int yR1;
		int xR2 = x+48;
		int xR3 = x+88;
		int xR12,yR12,xR13,xR22,xR23,xR32,xR33,yR13,yR22,yR23,yR32,yR33;
		xR1 = (int) (cX1 + (xR1-cX1)*Math.cos(angleW*Math.PI/180));
		yR1 = (int) (cY - 14*Math.sin(angleW*Math.PI/180));
		xR12 = (int) (cX1 + (xR1-cX1)*Math.cos(2*Math.PI/3)+(yR1-cY)*Math.sin(2*Math.PI/3));
		yR12 = (int) (cY - (xR1-cX1)*Math.sin(2*Math.PI/3)+(yR1-cY)*Math.cos(2*Math.PI/3));
		xR13 = (int) (cX1 + (xR1-cX1)*Math.cos(-2*Math.PI/3)+(yR1-cY)*Math.sin(-2*Math.PI/3));
		yR13 = (int) (cY - (xR1-cX1)*Math.sin(-2*Math.PI/3)+(yR1-cY)*Math.cos(-2*Math.PI/3));
		xR2 = (int) (cX2 - (xR2-cX2)*Math.cos(angleW*Math.PI/180));
		xR22 = (int) (cX2 + (xR2-cX2)*Math.cos(2*Math.PI/3)+(yR1-cY)*Math.sin(2*Math.PI/3));
		yR22 = (int) (cY - (xR2-cX2)*Math.sin(2*Math.PI/3)+(yR1-cY)*Math.cos(2*Math.PI/3));
		xR23 = (int) (cX2 + (xR2-cX2)*Math.cos(-2*Math.PI/3)+(yR1-cY)*Math.sin(-2*Math.PI/3));
		yR23 = (int) (cY - (xR2-cX2)*Math.sin(-2*Math.PI/3)+(yR1-cY)*Math.cos(-2*Math.PI/3));
		xR3 = (int) (cX3 + (xR3-cX3)*Math.cos(angleW*Math.PI/180));
		xR32 = (int) (cX3 + (xR3-cX3)*Math.cos(2*Math.PI/3)+(yR1-cY)*Math.sin(2*Math.PI/3));
		yR32 = (int) (cY - (xR3-cX3)*Math.sin(2*Math.PI/3)+(yR1-cY)*Math.cos(2*Math.PI/3));
		xR33 = (int) (cX3 + (xR3-cX3)*Math.cos(-2*Math.PI/3)+(yR1-cY)*Math.sin(-2*Math.PI/3));
		yR33 = (int) (cY - (xR3-cX3)*Math.sin(-2*Math.PI/3)+(yR1-cY)*Math.cos(-2*Math.PI/3));
		g.drawOval(x+8, y-43, 35, 35);
		g.drawOval(x+48, y-43, 35, 35);
		g.drawOval(x+88, y-43, 35, 35);
		g.drawLine(cX1, cY, xR1, yR1);
		g.drawLine(cX1, cY, xR12, yR12);
		g.drawLine(cX1, cY, xR13, yR13);
		g.drawLine(cX2, cY, xR2, yR1);
		g.drawLine(cX2, cY, xR22, yR22);
		g.drawLine(cX2, cY, xR23, yR23);
		g.drawLine(cX3, cY, xR3, yR1);
		g.drawLine(cX3, cY, xR32, yR32);
		g.drawLine(cX3, cY, xR33, yR33);
		if(health<=0)
		{
			g.setColor(Color.black);
			g.setFont(new Font(null, Font.BOLD,70));
			g.drawString(name + " Won!", GamePanel.W/2-150, GamePanel.H/2);
			GamePanel.running = false;
			Sound.explode.play();
		}
	}
	public int getSpeed() {
		return speed;
	}
}
