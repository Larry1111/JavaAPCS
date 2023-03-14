import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MorningOnFarm extends JPanel

	implements ActionListener{
	 
		 
		 private int time;
		 private EasySound rooster;
		 private EasySound wolf; 
  public MorningOnFarm() 
  { 
	  rooster = new EasySound("roost.wav");
	  wolf = new EasySound("wolf.wav");
    time = 0;
    Timer clock = new Timer(30, this); 
    clock.start();
  }

  public void paintComponent(Graphics g)
  {
    int x = 150 - (int)(100 * Math.cos(0.005 * Math.PI * time));
    int y = 130 - (int)(75 * Math.sin(0.005 * Math.PI * time));
    int r = 20;

    Color sky;
    if (y > 130) { 
    	sky = Color.BLACK;
    	setBackground(sky);
    	}
    	
    	
    	
    else{
    	sky = Color.CYAN;
    	setBackground(sky);
    }
    if (y < 130) {
    super.paintComponent(g);
    g.setColor(Color.ORANGE);
    g.fillOval(x - r, y - r, 2*r, 2*r);
    }
    if (y > 135) {
    super.paintComponent(g);
    g.setColor(Color.BLUE);
    g.fillOval(150, 40, 40, 40);
    }
  }
  
  public void actionPerformed(ActionEvent e)
  {
	if (time%400 == 0)
	   rooster.play();
	
	
    time++;
    repaint();
    if (time%400 == 200)
		wolf.play();
  }

  public static void main (String[ ] args)
  {
    JFrame w = new JFrame("MorningOnFarm");
    w.setSize(300, 150);

    Container c = w.getContentPane();
    c.add (new MorningOnFarm());

    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    w.setResizable(false);
    w.setVisible(true);
  }
}

