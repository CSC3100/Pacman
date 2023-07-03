import java.awt.*;

public class PowerDot implements Drawable {
    private int positionX;
    private int positionY;

    public PowerDot(int x, int y) {
        positionX = x;
        positionY = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(positionX, positionY, 20, 20);
    }
}
