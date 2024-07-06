import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Maze class contains the items to be drawn on the maze.
 *
 * @author javiergs
 * @version 1.0
 */
public class Maze extends JPanel implements ActionListener {
	
	private Pacman pacman;
	private Ghost ghost;
	private PowerDot powerDot;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(90, 140, 255));
		g.fillRect(0, 0, 800, 600);
		// collision pacman and ghost
		if (pacman.getBounds().intersects(ghost.getBounds()))
			ghost.reset();
		// draw the characters
		pacman.draw(g);
		ghost.draw(g);
		powerDot.draw(g);
	}
	
	public Maze() {
		// multi-threading ghost
		ghost = new Ghost();
		Thread ghostThread = new Thread(ghost);
		ghostThread.start();
		// multi-threading pacman
		pacman = new Pacman();
		Thread pacmanThread = new Thread(pacman);
		pacmanThread.start();
		// keyboard controlled pacman
		NannyKeyboard nannyKeyboard = new NannyKeyboard(pacman);
		addKeyListener(nannyKeyboard);
		// timer
		Timer timer = new Timer(100, this);
		timer.start();
		// and a power dot
		powerDot = new PowerDot();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
}