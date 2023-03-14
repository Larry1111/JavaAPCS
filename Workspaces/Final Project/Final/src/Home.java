import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Home extends JFrame implements ActionListener{
	private JButton start, howTo;
	public Home()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBackground(Color.white);
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		howTo = new JButton("How To");
		howTo.setFont(new Font(null, Font.PLAIN, 20));
		howTo.addActionListener(this);
		howTo.setPreferredSize(new Dimension(150, 60));
		start = new JButton("Start");
		start.setFont(new Font(null, Font.PLAIN, 20));
		start.addActionListener(this);
		start.setPreferredSize(new Dimension(150, 60));
		buttons.setBackground(this.getBackground());
		buttons.add(start,gbc);
		buttons.add(howTo,gbc);
		add(buttons);
		setBounds(0, 0, (int) screenSize.getWidth(), 11*(int) screenSize.getHeight()/12);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Home");
		setVisible(true);
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
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
		else
		{
			HowTo fr2 = new HowTo();
			fr2.setVisible(true);
			dispose();
		}

		
	}
	
	public static void main(String[] args)
	{
		
		new Home();
	}

	
	
}
