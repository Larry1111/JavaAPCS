import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ControlPanel extends JPanel implements ActionListener, KeyListener
{
	private ImagePanel canvas;
	private String imageFolderPathname;
	private JButton forward, reverse;
	private JComboBox<String> imageList;
	private String[] fileNames, comboBoxNames;
	private int currentIndex;
	public ControlPanel(ImagePanel img, String path)
	{
		addKeyListener(this);
		imageFolderPathname = path;
		canvas = img;
		File folder = new File(imageFolderPathname);
		fileNames = folder.list(); 
		if(fileNames == null || fileNames.length == 0)
		{
			System.out.println("*** The folder " + 
				imageFolderPathname + " does not exist or is empty ***");
			System.exit(1);
		}
		imageList = new JComboBox<String>(fileNames);
		JPanel buttons = new JPanel();
		buttons.setBackground(this.getBackground());
		forward = new JButton();
		forward.setIcon(new ImageIcon("arrow-left.gif"));
		reverse = new JButton();
		reverse.setIcon(new ImageIcon("arrow-right.gif"));
		buttons.add(forward);
		buttons.add(imageList);
		buttons.add(reverse);
		forward.addActionListener(this);
		reverse.addActionListener(this);
		imageList.addActionListener(this);
		add(buttons, BorderLayout.SOUTH);
		currentIndex = 0;
		canvas.readImage(path + "/" + fileNames[currentIndex]);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(forward))
		{
			if(currentIndex==fileNames.length-1)
				currentIndex = 0;
			else
				currentIndex++;
		}
		if(e.getSource().equals(reverse))
		{
			if(currentIndex == 0)
				currentIndex = fileNames.length-1;
			else
				currentIndex--;
		}
		if(e.getSource().equals(imageList))
		{
			currentIndex = imageList.getSelectedIndex();
		}
		imageList.setSelectedIndex(currentIndex);
		canvas.readImage(imageFolderPathname + "/"+fileNames[currentIndex]);
		canvas.repaint();
		requestFocus();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int b = e.getKeyCode();
		switch(b)
		{
		case 13:
			if(currentIndex==fileNames.length-1)
				currentIndex = 0;
			else
				currentIndex++;
			break;
		case 9:
			if(currentIndex==fileNames.length-1)
				currentIndex = 0;
			else
				currentIndex++;
			break;
		case 39:
			if(currentIndex==fileNames.length-1)
				currentIndex = 0;
			else
				currentIndex++;
			break;
		case 32:
			if(currentIndex==fileNames.length-1)
				currentIndex = 0;
			else
				currentIndex++;
			break;
		case 37:
			if(currentIndex == 0)
				currentIndex = fileNames.length-1;
			else
				currentIndex--;
		
			break;
		case 38:
			if(currentIndex == 0)
				currentIndex = fileNames.length-1;
			else
				currentIndex--;
			break;
		case 27:
			System.exit(1);
			break;
		}
		imageList.setSelectedIndex(currentIndex);
		canvas.readImage(imageFolderPathname + "/"+fileNames[currentIndex]);
		canvas.repaint();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}