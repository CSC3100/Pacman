import java.awt.*;
import java.io.Serializable;

public class Score implements Drawable, Serializable {
    private int positionX = 400;
    private int positionY = 40;
    private int score = 0;

    public Score () {

    }

    public Score(int x, int y) {
        positionX = x;
        positionY = y;
    }

    public Score(int score) {
        this.score = score;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawString("" + score, positionX, positionY);
    }

    public void increment() {
        score++;
    }

    public int getScore() {
        return score;
    }
}


