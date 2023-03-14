import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends JFrame implements ActionListener{
	private JButton newGame, home;
	private GamePanel gamePanel;
	public Game()
	{
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBackground(Color.white);
		JPanel buttons = new JPanel();
		home = new JButton("Home");
		home.setFont(new Font(null, Font.PLAIN, 20));
		home.addActionListener(this);
		newGame = new JButton("New Game");
		newGame.setFont(new Font(null, Font.PLAIN, 20));
		newGame.addActionListener(this);
		buttons.setBackground(this.getBackground());
		buttons.add(home);
		buttons.add(newGame);
		add(buttons, BorderLayout.SOUTH);
		gamePanel = new GamePanel();
		getContentPane().add(gamePanel);
		setBounds(0, 0, (int) screenSize.getWidth(), 8*(int) screenSize.getHeight()/9);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Game");
		setVisible(true);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setFont(new Font(null, Font.BOLD,15));
		
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
		else
		{
			Game f = new Game();
			f.setVisible(true);
			dispose();
		}
		Sound.button.play();
		
	}
	
	public static void main(String[] args)
	{
		new Game();
	}
	
}
