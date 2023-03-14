import java.awt.Color;
import java.awt.Graphics2D;

public class Obstacles {
	private int x;
	private int y;
	private int height;
	private int width;
	private long timer;
	private int direction;
	private int timeLast;
	public Obstacles(int x, int y, int w, int h, int d, int t)
	{
		this.y = y;
		this.x = x;
		height = h;
		width = w;
		timer = System.nanoTime();
		direction = d;
		timeLast = t*1000; 
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getW()
	{
		return width;
	}
	public int getH()
	{
		return height;
	}
	public void update()
	{
		x += direction;
		long elapsed = (System.nanoTime()-timer)/1000000;
		if(elapsed>timeLast)
		{
			direction *= -1;
			timer = System.nanoTime();
		}
	}
	public void draw(Graphics2D g)
	{
		g.setColor(new Color(160,105,60));
		g.fillRect(x, y, width, height);
	}
	
}
