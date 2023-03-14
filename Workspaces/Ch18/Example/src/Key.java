import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener{
	Mouse me;
	public Key(Mouse m)
	{
		me = m;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			me.moveUp(); break;
		case KeyEvent.VK_DOWN:
		me.moveDown(); break;
		case KeyEvent.VK_LEFT:
		me.moveLeft(); break;
		case KeyEvent.VK_RIGHT:
		me.moveRight(); break;
		
		}
		me.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
