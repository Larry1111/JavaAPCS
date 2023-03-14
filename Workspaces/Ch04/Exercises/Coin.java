import java.awt.Graphics;
import java.awt.Image;
	
	public class Coin {
	    private Image head;
	    private Image tail;
	    private int side;
	     
	    //Constructor
	    public Coin(Image heads, Image tails) {
	        head = heads;
	        tail = tails;
	        side = 0;
	    }
	     
	    //Flips the coin
	    public void flip() {
	        if (side == 0) {
	            side = 1;
	        }
	        else {
	            side = 0;
	        }
	    }
	     
	    //draws the appropriate side of the coin
	    //centered at (x,y)
	    public void draw(Graphics g, int x, int y) {
	        if (side == 0) {
	            g.drawImage(head, x-head.getWidth(null)/2, y-head.getHeight(null)/2, null);
	        }
	        else {
	            g.drawImage(tail, x-tail.getWidth(null)/2, y-tail.getHeight(null)/2, null);
	        }
	    }
	}