import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Control extends JPanel implements ActionListener, KeyListener, Runnable{
	private static int xR, xB, xRR,yRR, xBR, yBR;
	private static int angleR, angleB ;
	private int velXR, velRR, velXB, velBR; 
	private int[] bulletXR = new int[10];
	private int[] bulletYR = new int[10];
	private int bulletNo;
	private boolean[] isShot = new boolean[10];
//	private int ballxR, ballyR, ballxB, ballyB;
//	private int velBallr, velBallrx, velBallry;
//	private int velBallb, velBallbx, velBallby;
	private int gAcceleration=5;
//	private boolean conditionR, conditionB;
	private Timer tm; 
	public Control(int xR1, int xB1)
	{
		bulletNo=0;
		xR = xR1;
		xB = xB1;
		tm = new Timer(5, this);
		addKeyListener(this);
		angleR = 0;
		angleB = 0;
		tm.start();
		velXR=0;
		velXB=0;
		velBR=0;
		velRR=0;
		for(int i =0; i<bulletXR.length; i++)
		{
			isShot[i] = false;
			bulletXR[i] = xRR;
		}
//		velBallr = 60;
//		velBallb = 60;
//		ballxR = 400;
//		ballyR = 400;
//		ballxB = 400;
//		ballyB = 400;
//		conditionR=false;
//		conditionB=false;
	}
	//Draw tanks
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int y = 6*getHeight()/7;
		Graphics2D lineB = (Graphics2D)g;
		g.setColor(Color.black);
		lineB.setStroke(new BasicStroke(8));
		g.drawLine(xB+65,y-55,xBR,yBR );
//		if(conditionB)
//			g.fillOval(ballxB, ballyB, 15, 15);
		g.setColor(Color.blue);
		g.fillArc(xB+33, y-80, 60, 60, 0, 180);
		g.setColor(Color.blue.darker().darker());
		g.fillRoundRect(xB, y-50, 130, 50, 50, 50);
		g.setColor(Color.black);
		lineB.setStroke(new BasicStroke(8));
		g.drawLine(xR+65,y-55,xRR,yRR );
//		if(conditionR)
//			g.fillOval(ballxR, ballyR, 15, 15);
		g.setColor(Color.red);
		g.fillArc(xR+33, y-80, 60, 60, 0, 180);
		g.setColor(Color.red.darker().darker());
		g.fillRoundRect(xR, y-50, 130, 50, 50, 50);
		g.setColor(Color.gray);
		g.fillRect(0, y, getWidth(), getHeight()/2);
	}
	
	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int r = e.getKeyCode();
		if(r==KeyEvent.VK_LEFT)
			velXR = -1;
		if(r==KeyEvent.VK_RIGHT)
			velXR= 1;
		if(r==KeyEvent.VK_UP)
			velRR=1;
		if(r==KeyEvent.VK_DOWN)
			velRR=-1;
		if(r==KeyEvent.VK_A)
			velXB = -1;
		if(r==KeyEvent.VK_D)
			velXB = 1;
		if(r==KeyEvent.VK_W)
			velBR=1;
		if(r==KeyEvent.VK_S)
			velBR=-1;
		if(r==KeyEvent.VK_SPACE)
		{
			
//			conditionB = true;
		}
		if(r==KeyEvent.VK_ENTER)
		{
//			conditionR=true;
//			velBallrx = 3;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		velXB = 0;
		velXR = 0;
		velBR=0;
		velRR=0;
//		conditionB=false;
//		conditionR=false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int centerY = 6*getHeight()/7-55;
		int centerXR = xR+65;
		int centerXB = xB+65;
		xB += velXB;
		xR += velXR;
		//Direction of the muzzle
		angleB += velBR;
		angleR += velRR;
		xBR = xB+65;
		xRR = xR+65;
		yBR = centerY-90;
		yRR= centerY-90;
		xBR = (int) (centerXB + (xBR-centerXB)*Math.cos(angleB*Math.PI/180)-(yBR-centerY)*Math.sin(angleB*Math.PI/180));
		yBR = (int) (centerY -90*Math.cos(angleB*Math.PI/180));
		xRR = (int) (centerXR + (xRR-centerXR)*Math.cos(angleR*Math.PI/180)-(yRR-centerY)*Math.sin(angleR*Math.PI/180));
		yRR = (int) (centerY - 90*Math.cos(angleR*Math.PI/180));
		//Position of the balls
//		ballxB += velBallbx;
//		ballyB += 3;
//		ballxR = xRR-4;
//		ballyR = yRR-2;
//		velBallrx = (int) (velBallr*Math.cos(angleR*Math.PI/180));
//		velBallry = (int) (velBallr*Math.sin(angleR*Math.PI/180));
//		ballxR += (int) (velBallrx * 0.001);
//		ballyR += (int)(velBallry*0.001);
//		velBallry += gAcceleration * 0.001;
//		ballxB = xBR-4;
//		ballyB = yBR-2;
//		velBallbx = (int) (velBallb*Math.cos(angleB*Math.PI/180));
//		velBallby = (int) (velBallb*Math.sin(angleB*Math.PI/180));
//		ballxB += (int) (velBallbx);
//		ballyB += (int)(velBallby);
//		velBallby += gAcceleration;
		if(xB<0)
		{
			velXB=0;
			xB=0;
		}
		if(xB > getWidth()-130)
		{
			velXB=0;
			xB=getWidth()-130;
		}
		if(xR<0)
		{
			velXR=0;
			xR=0;
		}
		if(xR > getWidth()-130)
		{
			velXR = 0;
			xR= getWidth()-130;
		}
		if(yBR>6*getHeight()/7-60)
		{
			velBR = 0;
			yBR = 6*getHeight()/7-60;
		}
		if(yRR>6*getHeight()/7-60)
		{
			velRR = 0;
			yRR = 6*getHeight()/7-60;
		}
//		if(ballxB > getWidth()-25)
//		{
//			conditionB = false;
//		}
		repaint();
		requestFocus();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
