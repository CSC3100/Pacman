import java.awt.*;

/**
 * Ghost class contains the items to be drawn on the maze.
 * It is a thread that moves the ghost around the maze.
 *
 * @author javiergs
 * @version 1.0
 */
public class Ghost extends Drawable implements Runnable {
	
	private int SIZE = 50;
	public static final int SPEED = 150;
	
	public Ghost() {
		reset();
	}
	
	@Override
	public void run() {
		while (true) {
			move();
			try {
				Thread.sleep(SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void move() {
		y -= SIZE/2;
		if (y < 0) {
			x += SIZE/2;
			y = 600;
		}
		if (x > 800)
			x = 0;
	}
	
	public void draw(Graphics g) {
		// Draw the body of the ghost
		g.setColor(Color.RED);
		g.fillArc(x, y, SIZE, SIZE, 0, 180);
		g.fillRect(x, y + SIZE / 2, SIZE, SIZE / 2);
		// Draw the eyes
		g.setColor(Color.WHITE);
		g.fillOval(x + SIZE / 4, y + SIZE / 4, SIZE / 5, SIZE / 5);
		g.fillOval(x + SIZE * 3 / 4 - SIZE / 5, y + SIZE / 4, SIZE / 5, SIZE / 5);
		g.setColor(Color.BLUE);
		g.fillOval(x + SIZE / 4 + SIZE / 20, y + SIZE / 4 + SIZE / 20, SIZE / 10, SIZE / 10);
		g.fillOval(x + SIZE * 3 / 4 - SIZE / 5 + SIZE / 20, y + SIZE / 4 + SIZE / 20, SIZE / 10, SIZE / 10);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, SIZE, SIZE);
	}
	
	public void reset() {
		x = 0;
		y = 500;
	}
}