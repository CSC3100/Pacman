import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * NannyKeyboard class is a KeyListener for Pacman movement.
 *
 * @author javiergs
 * @version 1.0
 */
public class NannyKeyboard implements KeyListener {
	
	private Pacman pacman;
	
	public NannyKeyboard(Pacman pacman) {
		this.pacman = pacman;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				 pacman.up();
				break;
			case KeyEvent.VK_DOWN:
				pacman.down();
				break;
			case KeyEvent.VK_LEFT:
				pacman.left();
				break;
			case KeyEvent.VK_RIGHT:
				 pacman.right();
				break;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	}
	
}