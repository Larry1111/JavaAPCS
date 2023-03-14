import java.awt.BorderLayout;
import java.awt.Container;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SlideShow extends JFrame{
	private  ControlPanel obj;
	private  ImagePanel obj2;
	public SlideShow(String name) 
	{	
		setTitle(name);
		obj2 = new ImagePanel();
		obj = new ControlPanel(obj2,"images");
		getContentPane().add(obj,BorderLayout.SOUTH);
		getContentPane().add(obj2,BorderLayout.CENTER);
	}
	
	public void giveFocusToControlPanel()
	{
		 obj.requestFocus();
	}
	public static void main(String[] args)
	{
		SlideShow window = new SlideShow("Slide Show");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(20,20);
		window.setBounds(200, 300, 1000, 800);
		window.setVisible(true);
		window.giveFocusToControlPanel();
		
	}
}
