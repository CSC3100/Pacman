import java.awt.*;

/**
 * Ghost class represents a ghost in the Pacman game.
 * The ghost moves around the screen.
 *
 * @author javiergs
 * @version 1.0
 */
public class Ghost implements Runnable {
	
	private static final int SIZE = 50;
	private static final int SPEED = 150;
	private int x;
	private int y;
	
	public Ghost() {
		x = 25;
		y = 25;
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
		if (x == 25) y += SIZE / 2;
		if (y > 470) x += SIZE / 2;
		if (x > 700) y -= SIZE / 2;
		if (y == 25) x -= SIZE / 2;
	}
	
	public void draw(Graphics g) {
		// Draw the body of the ghost
		g.setColor(Color.RED);
		g.fillArc(x, y, SIZE, SIZE, 0, 180);
		g.fillRect(x, y + SIZE / 2, SIZE, SIZE / 2);
		// Draw the eyes
		g.setColor(Color.WHITE);
		g.fillOval(x + SIZE / 4, y + SIZE / 4, SIZE / 4, SIZE / 4);
		g.fillOval(x + SIZE * 3 / 4 - SIZE / 5, y + SIZE / 4, SIZE / 4, SIZE / 4);
		g.setColor(Color.BLUE);
		g.fillOval(x + SIZE / 4 + SIZE / 20, y + SIZE / 4 + SIZE / 20, SIZE / 10, SIZE / 10);
		g.fillOval(x + SIZE * 3 / 4 - SIZE / 5 + SIZE / 20, y + SIZE / 4 + SIZE / 20, SIZE / 10, SIZE / 10);
	}
	
}