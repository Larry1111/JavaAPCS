import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Home extends JFrame implements ActionListener{
	private JButton start, howTo,setting;
	public Home()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBackground(Color.white);
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridBagLayout());
		GridBagConstraints setUp = new GridBagConstraints();
		setUp.gridwidth = GridBagConstraints.REMAINDER;
		setUp.fill = GridBagConstraints.HORIZONTAL;
		howTo = new JButton("How To");
		howTo.setFont(new Font(null, Font.PLAIN, 20));
		howTo.addActionListener(this);
		howTo.setPreferredSize(new Dimension(150, 50));
		start = new JButton("Start");
		start.setFont(new Font(null, Font.PLAIN, 20));
		start.addActionListener(this);
		start.setPreferredSize(new Dimension(150, 50));
		setting = new JButton("Setting");
		setting.setFont(new Font(null, Font.PLAIN, 20));
		setting.setPreferredSize(new Dimension(150, 50));
		setting.addActionListener(this);
		buttons.setBackground(this.getBackground());
		buttons.add(start,setUp);
		buttons.add(howTo,setUp);
		buttons.add(setting,setUp);
		add(buttons);
		setBounds(0, 0, (int) screenSize.getWidth(), 8*(int) screenSize.getHeight()/9);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Home");
		setVisible(true);
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.black);
		((Graphics2D) g).setStroke(new BasicStroke(20));
		g.drawLine(500, 500, 150, 200);
		g.drawLine(1000, 500, 1300, 200);
		g.setColor(Color.red);
		g.fillArc(GamePanel.W/2+130, 3*GamePanel.H/5-100, GamePanel.W/4, GamePanel.W/4, 0, 180);
		g.setColor(Color.blue);
		g.fillArc(GamePanel.W/4-130, 3*GamePanel.H/5-100, GamePanel.W/4, GamePanel.W/4, 0, 180);
		
		g.setColor(Color.black);
		g.setFont(new Font(null, Font.BOLD,70));
		
		g.drawString("BR Tanks", 2*getWidth()/5-20, 2*getHeight()/5);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(b == start)
		{
			Game fr = new Game();
			fr.setVisible(true);
			dispose();
		}
		else if(b == setting)
		{
			Setting fr3 = new Setting();
			fr3.setVisible(true);
			dispose();
		}
		else
		{
			HowTo fr2 = new HowTo();
			fr2.setVisible(true);
			dispose();
		}
		Sound.button.play();
	}
	
	
	public static void main(String[] args)
	{
		
		new Home();
	}
}
