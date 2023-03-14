import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	public static double gravity = 15;
	private Thread thread;
	public static boolean running;
	public static ArrayList<Obstacles> wall;
	private Obstacles wall1, wall2, wall3;
	private BufferedImage image;
	private Graphics2D g;
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int FPS = 30;
	private double averageFPS;
	public static Tanks redTank, blueTank;
	private Status redStatus, blueStatus;
	public static ArrayList<Bullets> bullets, redBullets,blueBullets;
	public static int W = (int) screenSize.getWidth();
	public static int H = (int) (6*screenSize.getHeight()/7);
	public GamePanel()
	{
		super();
		setPreferredSize(new Dimension(W, H));
		setFocusable(true);
		requestFocus();
	}
	public void addNotify()
	{
		super.addNotify();
		if(thread == null)
		{
			thread = new Thread(this);
			thread.start();
		}
		addKeyListener(this);
	}
	@Override
	public void run() {
		running = true;
		image = new BufferedImage(W, H, BufferedImage.TYPE_INT_RGB);
		g=(Graphics2D) image.getGraphics();
		redBullets = new ArrayList<Bullets>();
		blueBullets = new ArrayList<Bullets>();
		bullets = new ArrayList<Bullets>();
		bullets.addAll(redBullets);
		bullets.addAll(blueBullets);
		redTank = new Tanks(6*GamePanel.W/7, 6*GamePanel.H/7-70, Color.red,"Blue", redBullets);
		blueTank = new Tanks(GamePanel.W/7-130, 6*GamePanel.H/7-70, Color.blue,"Red", blueBullets);
		redStatus = new Status(3,Color.red, 5*GamePanel.W/6, GamePanel.H/10, redTank);
		blueStatus = new Status(3,Color.blue, GamePanel.W/10, GamePanel.H/10, blueTank);
		wall1 = new Obstacles(2*GamePanel.W/7,150,100,10,3,8);
		wall2 = new Obstacles(5*GamePanel.W/7,250,100,10,-1,6);
		wall3 = new Obstacles(3*GamePanel.W/7,350,100,10,2,10);
		wall = new ArrayList<Obstacles>();
		wall.add(wall1);
		wall.add(wall2);
		wall.add(wall3);
		long startTime;
		long URDTimeMillis;
		long waitTime;
		long totalTime=0;
		int frameCount = 0;
		int maxFrameCount = 30;
		long targetTime = 1000/FPS;
		while(running)
		{
			startTime = System.nanoTime();
			gameUpdate();
			gameRender();
			gameDraw();
			URDTimeMillis = (System.nanoTime()-startTime)/1000000;
			waitTime = targetTime - URDTimeMillis;
			try {
				Thread.sleep(waitTime);
			}
			catch(Exception e)
			{
				
			}
			totalTime += System.nanoTime()-startTime;
			frameCount++;
			if(frameCount == maxFrameCount)
			{
				averageFPS = 1000.0 / ((totalTime/frameCount)/1000000);
				frameCount = 0;
				totalTime = 0;
				
			}
		}
	}
	private void gameUpdate()
	{
		for(int i =0; i<bullets.size();i++)
		{
			boolean remove = bullets.get(i).update();
			if(remove) 
			{
				bullets.remove(i);
				i--;
			}
		}
		for(int i =0; i<redBullets.size();i++)
		{
			boolean remove = redBullets.get(i).update();
			if(remove) 
			{
				redBullets.remove(i);
				i--;
			}
		}
		for(int i =0; i<blueBullets.size();i++)
		{
			boolean remove = blueBullets.get(i).update();
			if(remove) 
			{
				blueBullets.remove(i);
				i--;
			}
		}
		for(int i= 0; i< wall.size();i++)
		{
			wall.get(i).update();
		}
		redTank.update();
		blueTank.update();
		redStatus.update();
		blueStatus.update();
	}
	private void gameRender()
	{
		
		g.setColor(Color.white);
		g.fillRect(0, 0, W, H);
		g.setColor(Color.gray);
		g.fillRect(0, 6*H/7-70, W, H/5);
		for(int i =0; i< redBullets.size();i++)
		{
			redBullets.get(i).draw(g);
		}
		for(int i =0; i< blueBullets.size();i++)
		{
			blueBullets.get(i).draw(g);
		}
		for(int i =0; i< bullets.size();i++)
		{
			bullets.get(i).draw(g);
		}
		wall1.draw(g);
		wall2.draw(g);
		wall3.draw(g);
		redStatus.draw(g);
		blueStatus.draw(g);
		blueTank.draw(g);
		redTank.draw(g);
		
	}
	public void gameDraw()
	{
		Graphics g2 = this.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int r = e.getKeyCode();
		if(r == KeyEvent.VK_LEFT)
		{
			redTank.setLeft(true);
		}
		if(r == KeyEvent.VK_RIGHT)
		{
			redTank.setRight(true);
		}
		if(r==KeyEvent.VK_UP)
		{
			redTank.setUp(true);
		}
		if(r==KeyEvent.VK_DOWN)
		{
			redTank.setDown(true);
		}
		if(r==KeyEvent.VK_ENTER)
		{
			redTank.setFiring(true);
			
		}
		if(r == KeyEvent.VK_A)
		{
			blueTank.setLeft(true);
		}
		if(r == KeyEvent.VK_D)
		{
			blueTank.setRight(true);
		}
		if(r==KeyEvent.VK_W)
		{
			blueTank.setUp(true);
		}
		if(r==KeyEvent.VK_S)
		{
			blueTank.setDown(true);
		}
		if(r==KeyEvent.VK_SPACE)
		{
			blueTank.setFiring(true);
			
		}
		if(r==KeyEvent.VK_T)
		{
			for(int i = 0; i < blueBullets.size(); i++)
			{
				Bullets b = blueBullets.get(i);
				b.setSplit(true);
			}
		}
		if(r==KeyEvent.VK_P)
		{
			for(int i = 0; i < redBullets.size(); i++)
			{
				redBullets.get(i).setSplit(true);
			}
		}
		if(r == KeyEvent.VK_ESCAPE)
		{
			System.exit(1);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int r = e.getKeyCode();
		if(r == KeyEvent.VK_LEFT)
		{
			redTank.setLeft(false);
		}
		if(r == KeyEvent.VK_RIGHT)
		{
			redTank.setRight(false);
		}
		if(r==KeyEvent.VK_UP)
		{
			redTank.setUp(false);
		}
		if(r==KeyEvent.VK_DOWN)
		{
			redTank.setDown(false);
		}
		if(r==KeyEvent.VK_ENTER)
		{
			redTank.setFiring(false);
		}
		if(r == KeyEvent.VK_A)
		{
			blueTank.setLeft(false);
		}
		if(r == KeyEvent.VK_D)
		{
			blueTank.setRight(false);
		}
		if(r==KeyEvent.VK_W)
		{
			blueTank.setUp(false);
		}
		if(r==KeyEvent.VK_S)
		{
			blueTank.setDown(false);
		}
		if(r==KeyEvent.VK_SPACE)
		{
			blueTank.setFiring(false);
		}
	}
}