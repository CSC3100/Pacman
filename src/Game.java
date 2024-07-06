import javax.swing.*;
import java.awt.*;

/**
 * Game class is the main class for the game.
 * It creates the maze and sets the window properties.
 *
 * @author javiergs
 * @version 1.0
 */
public class Game extends JFrame {
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setSize(800, 600);
		game.setTitle("Pacman");
		game.setVisible(true);
		game.setResizable(false);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Game() {
		setLayout(new GridLayout(1, 1));
		Maze maze = new Maze();
		add(maze);
		maze.setFocusable(true);
		maze.requestFocusInWindow();
	}
	
}