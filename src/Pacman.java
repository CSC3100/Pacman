import java.awt.*;

public class Pacman implements Drawable {
    private int positionX;
    private int positionY;

    public void draw(Graphics go) {
        go.setColor(Color.YELLOW);
        go.fillRect(positionX, positionY,20,20 );

        if(positionX > 400) positionX =400;
        if(positionY > 400) positionY =400;
        if(positionX < 0)   positionX =0;
        if(positionY < 0)   positionY =0;
    }

    public void up() {
        positionY -= 20;
    }

    public void down() {
        positionY += 20;
    }

    public void left() {
        positionX -= 20;
    }

    public void right() {
        positionX += 20;
    }
}


