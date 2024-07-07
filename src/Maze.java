import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Maze class that represents the maze of the game.
 * It has a timer that repaints the maze every 100 milliseconds.
 *
 * @author javiergs
 * @version 1.0
 */
public class Maze extends JPanel implements ActionListener {
	
	private Pacman pacman;
	private Ghost ghost;
	
	public Maze(Pacman pacman, Ghost ghost) {
		setBackground(Color.BLACK);
		this.pacman = pacman;
		this.ghost = ghost;
		// notice the timer
		Timer timer = new Timer(100, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		background(g);
		pacman.draw(g);
		ghost.draw(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	private void background(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 600);
		g.setColor(new Color(90, 140, 255));
		// walls
		g.drawRoundRect(12, 12, 776, 576 - 28, 20, 20);
		g.drawRoundRect(17, 17, 766, 566 - 28, 20, 20);
		// dots
		g.setColor(Color.GRAY);
		for (int i = 50; i <= 750; i += 50) {
			for (int j = 50; j < 520; j += 50) {
				g.fillOval(i, j, 5, 5);
			}
		}
	}
	
}