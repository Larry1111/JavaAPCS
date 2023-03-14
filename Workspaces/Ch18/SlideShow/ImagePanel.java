import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private Image picture;

	  public ImagePanel()
	  {
		setBackground(Color.white);
	    setSize(1000, 800);
//	    
//	    String pathname = "images/happy.jpg";
//	    try
//	    {
//	      picture = ImageIO.read(new File(pathname));
//	    }
//	    catch (IOException ex)
//	    {
//	      System.out.println("*** Can't load " + pathname + " ***");
//	      System.exit(1);
//	    }
	  }
	  
	  public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g);
	    
	    if (picture != null)
	    {
	      // center the picture:
	      int x = (getWidth() - picture.getWidth(null)) / 2;
	      int y = (getHeight() - picture.getHeight(null)) / 2;
	      g.drawImage(picture, x, y, null);
	    }
	  }
	  public void readImage(String fileName)
	  {
		  try
		    {
			  picture = ImageIO.read(new File(fileName));
		    }
		    catch (IOException ex)
		    {
		      System.out.println("*** Can't load " + fileName + " ***");
		      System.exit(1);
		    }
	  }
}
