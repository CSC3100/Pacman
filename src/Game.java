import javax.swing.*;

/**
 * Game class creates the main window and starts the game.
 * It creates a maze with a pacman and a ghost.
 *
 * @author javiergs
 * @version 1.0
 */
public class Game extends JFrame {
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setSize(800, 600);
		game.setTitle("Yet Another Pacman");
		game.setVisible(true);
		game.setResizable(false);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Game() {
		// ghost in its own thread
		Ghost ghost = new Ghost();
		Thread ghostThread = new Thread(ghost);
		ghostThread.start();
		// pacman in its own thread
		Pacman pacman = new Pacman();
		Thread pacmanThread = new Thread(pacman);
		pacmanThread.start();
		// keyboard controlled pacman
		KeyboardController keyboardController = new KeyboardController(pacman);
		addKeyListener(keyboardController);
		// maze with characters
		Maze maze = new Maze(pacman, ghost);
		add(maze);
	}
	
}