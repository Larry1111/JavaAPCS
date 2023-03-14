import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HowTo extends JFrame implements ActionListener{
	private JButton home;
	public HowTo()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBackground(Color.white);
		JPanel buttons = new JPanel();
		home = new JButton("Home");
		home.setFont(new Font(null, Font.PLAIN, 20));
		home.addActionListener(this);
		
		buttons.setBackground(this.getBackground());
		buttons.add(home);
		
		add(buttons, BorderLayout.SOUTH);
		setBounds(0, 0, (int) screenSize.getWidth(), 11*(int) screenSize.getHeight()/12);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("How To");
		setVisible(true);
		
	}
	private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font(null, Font.BOLD,30));
        drawString(g, "The left and right arrow keys control the movement\n"
        		+ "nof the red tank. The up and down keys control the \n"
        		+ "direction of the red tank's muzzle. The A and S keys\n"
        		+ "control the movement of the blue tank. The W and S keys\n"
        		+ "control the direction of the blue tank's muzzle. Press\n"
        		+ "space bar for the blue tank to shoot, and press enter\n"
        		+ "for the red tank to shoot.", getWidth()/5, getHeight()/5);
        
    }
//	public void paint(Graphics g)
//	{
//		super.paint(g);
//		g.setFont(new Font(null, Font.BOLD,12));
//		
//		g.drawString("Use the left and right arrow keys to control the movement\nof the red tank.", getWidth()/6, getHeight()/6);
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(b == home)
		{
			Home fr = new Home();
			fr.setVisible(true);
			dispose();
		}

		
	}
	
	public static void main(String[] args)
	{
		
		new HowTo();
	}

	
	
}
