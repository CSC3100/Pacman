import java.awt.*;

/**
 * Pacman class is a Drawable object that can be drawn on the screen.
 * It is also a Runnable object that can be run in a separate thread.
 * It moves in the direction it is facing.
 *
 * @author javiergs
 * @version 1.0
 */
public class Pacman extends Drawable implements Runnable {
	
	public static final int DIAMETER = 50;
	public static final int STOPPED = 0;
	public static final int MOVING_UP = 1;
	public static final int MOVING_DOWN = 2;
	public static final int MOVING_LEFT = 3;
	public static final int MOVING_RIGHT = 4;
	public static final int SPEED = 150;
	
	public int direction = STOPPED;
	
	@Override
	public void run() {
		while (true) {
			if (direction == MOVING_UP)
				up();
			else if (direction == MOVING_DOWN)
				down();
			else if (direction == MOVING_LEFT)
				left();
			else if (direction == MOVING_RIGHT)
				right();
			try {
				Thread.sleep(SPEED);
			} catch (
				InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		if (direction == MOVING_UP)
			g.fillArc(x, y, DIAMETER, DIAMETER, 135, 270);
		else if (direction == MOVING_DOWN)
			g.fillArc(x, y, DIAMETER, DIAMETER, 315, 270);
		else if (direction == MOVING_LEFT)
			g.fillArc(x, y, DIAMETER, DIAMETER, 225, 270);
		else if (direction == MOVING_RIGHT || direction == STOPPED)
			g.fillArc(x, y, DIAMETER, DIAMETER, 45, 270);
	}
	
	public void up() {
		if (y > 0) y -= DIAMETER / 2;
		direction = MOVING_UP;
	}
	
	public void down() {
		if (y < (600 - Pacman.DIAMETER * 2)) y += DIAMETER / 2;
		direction = MOVING_DOWN;
	}
	
	public void left() {
		if (x > 0)
			x -= DIAMETER / 2;
		direction = MOVING_LEFT;
	}
	
	public void right() {
		if (x < (800 - Pacman.DIAMETER))
			x += DIAMETER / 2;
		direction = MOVING_RIGHT;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}