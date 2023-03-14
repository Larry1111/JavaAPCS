import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Setting extends JFrame implements ActionListener{
	private JButton home;
	private JSlider speedSlider;
	private JCheckBox sound;
	private int minSpeed = 5, maxSpeed = 35, initSpeed = 10;
	public Setting()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBackground(Color.white);
		home = new JButton("Home");
		home.setFont(new Font(null, Font.PLAIN, 20));
		home.addActionListener(this);
		Box box = Box.createVerticalBox();
		box.setPreferredSize(new Dimension(125,300));
		JPanel settingPanel = new JPanel(new GridLayout(1,2));
		settingPanel.setBackground(this.getBackground());
		settingPanel.setSize(new Dimension(GamePanel.W/2, GamePanel.H/3));
		speedSlider = new JSlider(JSlider.HORIZONTAL, minSpeed,
	    		maxSpeed, initSpeed);
		speedSlider.setMajorTickSpacing((maxSpeed - minSpeed)/2);
		speedSlider.setPaintTicks(true);
		speedSlider.setPaintLabels(true);
		sound = new JCheckBox("", true);
		if(sound.isSelected())
		{
			Sound.check = true;
		}
		else
		{
			Sound.check = false;
		}
		settingPanel.add(new JLabel("Speed: ",SwingConstants.CENTER)).setFont(new Font(null, Font.BOLD, 20));
		settingPanel.add(speedSlider);
		settingPanel.add(new JLabel("Sound: ", SwingConstants.CENTER)).setFont(new Font(null, Font.BOLD, 20));
		settingPanel.add(sound);
		
		box.add(settingPanel);
		box.add(home);
		add(box);
		setBounds(0, 0, (int) screenSize.getWidth(), 8*(int) screenSize.getHeight()/9);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Setting");
		setVisible(true);
		
	}

    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font(null, Font.BOLD,30));
       
        
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(b == home)
		{
			Home fr = new Home();
			fr.setVisible(true);
			dispose();
		}
		Sound.button.play();
		
	}
	
	public static void main(String[] args)
	{
		
		new Setting();
	}

	
	
}

