import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements ActionListener, KeyListener {

    private Maze maze;
    private Pacman pacman;
    private Ghost ghost;
    private Score score;
    private ScoreTable scoreTable;

    public Game() {
        JMenuBar menuBar = new JMenuBar();;
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem menuSave = new JMenuItem("Save");
        menu.add(menuSave);
        menuSave.addActionListener(this);
        JMenuItem menuShow = new JMenuItem("Show");
        menu.add(menuShow);
        menuShow.addActionListener(this);
        setJMenuBar(menuBar);

        pacman = new Pacman();
        ghost = new Ghost();
        score = new Score(400, 40);
        maze = new Maze(pacman, ghost, score);
        scoreTable = new ScoreTable(score);
        scoreTable.load();

        this.getContentPane().add(maze);
        this.addKeyListener(this);
    }

    public void startTimer() {
      Timer timer = new Timer(100, this);
      timer.start();
   }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s!=null && s.equals("Save")) {
            scoreTable.save(score);
        } else if (s!=null && s.equals("Show"))
            scoreTable.show(this);
        else {
            maze.repaint();
        }
    }

    public static void main(String[] args) {
        Game win = new Game();
        win.setSize(500,500);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.startTimer();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP:    pacman.up(); break;
            case KeyEvent.VK_DOWN:  pacman.down(); break;
            case KeyEvent.VK_LEFT:  pacman.left(); break;
            case KeyEvent.VK_RIGHT: pacman.right(); break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { }

}


