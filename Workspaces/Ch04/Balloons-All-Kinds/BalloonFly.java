	import java.awt.Graphics;
	import java.awt.Color;
	import java.awt.Container;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.Timer;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;

	public class BalloonFly extends JPanel
	                 implements ActionListener
	{
	  private int xPos, yPos;  // hold the coordinates of the message
	  private OvalBalloon oval1;
	  private SquareBalloon square1;
	  // Called automatically after a repaint request
	  
	  public BalloonFly()
	  {
		  xPos=150;
		  yPos=150;
		  oval1 = new OvalBalloon (xPos, yPos, 50, Color.BLUE);
		  square1 = new SquareBalloon(xPos+100, yPos+30, 30, Color.GREEN);
		
	  }
	  
	  public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g); // Paint the background
	    g.setColor(Color.RED);
	    g.drawString("Hello, Action!", xPos, yPos);
	    oval1.draw(g, true);
	    square1.draw(g,true);
	  }

	  // Called automatically when the timer "fires"
	  public void actionPerformed(ActionEvent e)
	  {
	    // Adjust the horizontal position of the message:
	    yPos--;  // subtract 1
	    if (yPos < -100)
	      yPos = getHeight();
	    oval1.move(xPos, yPos);
	    square1.move(xPos+100, yPos+30);

	    repaint();
	  }

	  public static void main(String[] args)
	  {
	    JFrame window = new JFrame("Balloon Demo");

	    // Set this window's location and size:
	    // upper-left corner at 300, 300; width 300, height 100
	    window.setBounds(300, 300, 300, 300);

	    //  Create panel, a Banner object, which is a kind of JPanel:
	    BalloonFly panel = new BalloonFly();
	    panel.setBackground(Color.CYAN);  // the default color is light gray

	    // Add panel to window:
	    Container c = window.getContentPane();
	    c.add(panel);

	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setVisible(true);

	    // Set the initial position of the message:
	    panel.xPos = panel.getWidth()/2;
	    panel.yPos = panel.getHeight();

	    // Create a Timer object that fires every 30 milliseconds;
	    // attach it to panel so that panel "listens to" and
	    // processes the timer events; start the timer:
	    Timer clock = new Timer(30, panel);
	    clock.start();
	  }
	}
