import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mouse extends JPanel implements MouseListener, MouseMotionListener{
	private int x,y,w,h,xOffset,yOffset;
	private Color boxColor;
	private EasySound ding;
	private boolean isSelected;
	public Mouse()
	{
		ding = new EasySound("ding.wav");
		x = 100;
		y=50;
		w=200;
		h=100;
		boxColor = Color.green;
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(new Key(this));
		isSelected = false;
	}
	public void moveUp()
	{
		y-=3;
	}
	public void moveDown()
	{
		y+=3;
	}
	public void moveLeft()
	{
		x-=3;
	}
	public void moveRight()
	{
		x+=3;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(boxColor);
		g.fillRect(x, y, w, h);
		this.requestFocus();
	}
	public boolean isInside(int mx, int my)
	{
		return (x < mx && x> mx-w && y<my && y>y-h);
		
	}
	public static void main(String[] args)
	{
		JFrame window = new JFrame("Mouse Examples");
		window.setBounds(100, 100, 500, 250);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(new Mouse());
		window.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		ding.play();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int mouseX = e.getX();
		int mouseY = e.getY();
		if(isInside(mouseX, mouseY))
		{
			boxColor = Color.red;
			isSelected = true;
			xOffset = mouseX - x;
			yOffset = mouseY - y;
		}
		repaint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		boxColor = Color.green;
		repaint();
		isSelected = false;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		setBackground(Color.yellow);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		setBackground(Color.white);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int mouseX = e.getX();
		int mouseY = e.getY();
		if(isSelected) {
			x = mouseX - xOffset;
			y= mouseY - yOffset;
		}
		repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
