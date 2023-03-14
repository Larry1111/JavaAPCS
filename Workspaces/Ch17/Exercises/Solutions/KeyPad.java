import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeyPad extends JPanel implements ActionListener{
	private JTextField display;
	private JButton zero, one, clear;
	public KeyPad()
	{
		setBackground(Color.blue);
		display = new JTextField();
		display.setEditable(false);
		display.setPreferredSize(new Dimension(150, 20));
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1,3,1,1));
		zero = new JButton("0");
		zero.addActionListener(this);
		one = new JButton("1");
		one.addActionListener(this);
		clear = new JButton("C");
		clear.addActionListener(this);
		buttons.setBackground(this.getBackground());
		buttons.add(zero);
		buttons.add(one);
		buttons.add(clear);
		add(display,BorderLayout.NORTH);
		add(buttons, BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(e.getSource()== clear)
		{
			display.setText("");
		}
		else
			display.setText(display.getText()+ b.getText());

		
	}
	
	public static void main(String[] args)
	{
		JFrame window = new JFrame("Binary");
		window.setBounds(100, 100, 300, 200);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = window.getContentPane();
		c.add(new KeyPad());
		window.setVisible(true);
	}

	
	
}
