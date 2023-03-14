import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;


public class RedBullets implements KeyListener, ActionListener{
	private int ballxR, ballyR;
	private int velBallr, velBallrx, velBallry;
	private boolean condition;
	private Timer timer;
	public RedBullets(int x, int y)
	{
		ballxR = x;
		ballyR = y;
		velBallr = 60;
		timer = new Timer(1,this);
		timer.start();
//		velBallrx = (int) (velBallr*Math.cos(Control.getAngleR()*Math.PI/180));
//		velBallry = (int) (velBallr*Math.sin(Control.getAngleR()*Math.PI/180));
		
	}
	public void paint(Graphics g)
	{
		draw(g);
	}
	public void draw(Graphics g)
	{
		if(condition)
		{
			g.fillOval(ballxR, ballyR, 15, 15);
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(condition)
		{
			ballyR-=3;
		}
		if(ballyR<0)
		{
			condition = false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int r = e.getKeyCode();
		if(r == KeyEvent.VK_RIGHT)
		{
			if(!condition)
				ballxR+=3;
		}
		if(r== KeyEvent.VK_LEFT)
			if(!condition)
				ballxR-=3;
		if(r==KeyEvent.VK_ENTER)
			condition=true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
