import java.awt.*;

/**
 * Pacman is a yellow circle that moves at a constant speed and
 * changes direction when the user presses the arrow keys.
 *
 * @author javiergs
 * @version 1.0
 */
public class Pacman implements Runnable {
	
	private static final int DIAMETER = 50;
	private static final int STOP = 0;
	private static final int MOVING_UP = 1;
	private static final int MOVING_DOWN = 2;
	private static final int MOVING_LEFT = 3;
	private static final int MOVING_RIGHT = 4;
	private static final int SPEED = 300;
	
	private int direction = STOP;
	private int x;
	private int y;
	
	public Pacman() {
		x = 375;
		y = 275;
	}
	
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
		if (direction == STOP)
			g.fillOval(x, y, DIAMETER, DIAMETER);
		else if (direction == MOVING_UP)
			g.fillArc(x, y, DIAMETER, DIAMETER, 135, 270);
		else if (direction == MOVING_DOWN)
			g.fillArc(x, y, DIAMETER, DIAMETER, 315, 270);
		else if (direction == MOVING_LEFT)
			g.fillArc(x, y, DIAMETER, DIAMETER, 225, 270);
		else if (direction == MOVING_RIGHT || direction == STOP)
			g.fillArc(x, y, DIAMETER, DIAMETER, 45, 270);
	}
	
	public void up() {
		if (y > 50)
			y -= (DIAMETER);
		direction = MOVING_UP;
	}
	
	public void down() {
		if (y < (575 - Pacman.DIAMETER * 2)) y += (DIAMETER);
		direction = MOVING_DOWN;
	}
	
	public void left() {
		if (x > 50)
			x -= (DIAMETER);
		direction = MOVING_LEFT;
	}
	
	public void right() {
		if (x < (775 - Pacman.DIAMETER))
			x += (DIAMETER);
		direction = MOVING_RIGHT;
	}
	
}