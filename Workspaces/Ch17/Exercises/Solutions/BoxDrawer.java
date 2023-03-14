import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BoxDrawer extends JPanel {

	private Color boxColor;
	private int boxType;
	private int width, height;
	
	public BoxDrawer()
	{
		boxColor = Color.blue;
		boxType = 1;
		width = 200;
		height = 100;
		setBackground(Color.white);
	}
	public void increase()
	{
		width *= 1.1;
		height *= 1.1;
	}
	public void decrease()
	{
		width *= 0.9;
		height *= 0.9;
	}
	public void setBoxColor(Color c)
	{
		boxColor = c;
	}
	public void setBoxType(int t)
	{
		boxType = t;
	}
	public void paintComponent(Graphics g)
	{	if (!boxColor.equals(Color.white))
			setBackground (Color.white);
		else setBackground (Color.DARK_GRAY);
	
		super.paintComponent(g);
		drawBox(g);
	}
	public void drawBox(Graphics g)
	{
		g.setColor(boxColor);
		int x = getWidth()/4, y = getHeight()/4; 
		switch (boxType)
		{
			case 0: g.drawRect(x, y, width, height); break;
			case 1: g.fillRect(x, y, width, height); break;
			case 2: g.drawRoundRect(x, y, width, height, width/4, width/4); break;
			case 3: g.fillRoundRect(x, y, width, height, width/4, width/4); break;
			case 4: g.draw3DRect(x, y, width, height, false); break;
			case 5: g.fill3DRect(x, y, width, height, false); break;
			case 6: 
			case 7: g.drawString("Can't do that", width-25, height); break;
		}
	}
	
	
	
	
	
}