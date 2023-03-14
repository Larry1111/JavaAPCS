import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Status {
	private int bullets;
	private int healthIni;
	private int length;
	private int lengthF;
	private Color color;
	private Tanks tank;
	private int x;
	private int y;
	public Status(int h, Color color, int x, int y, Tanks tank)
	{
		length = GamePanel.W/8;
		this.x = x;
		this.y = y;
		this.tank = tank;
		healthIni = h;
		this.color = color;
	}
	public void update()
	{
		lengthF = tank.getHealth()*length/healthIni;
	}
	public void draw(Graphics2D g)
	{
		g.setColor(Color.gray);
		g.fillRect(x, y, GamePanel.W/8, GamePanel.H/40);
		g.setColor(Color.black);
		g.setFont(new Font(null, Font.PLAIN, 20));
		g.drawString("HP: ", x-40, y+20);
		g.setColor(color);
		g.fillRect(x, y, lengthF, GamePanel.H/40);
	}
}
