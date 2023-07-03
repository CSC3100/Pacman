import java.awt.*;

public class Ghost implements Drawable {
    private int positionX = 400;
    private int positionY = 400;

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        if (Math.random()>0.5)
            if (Math.random()>0.5)
                positionX += 20;
            else
                positionX -= 20;
        else
            if (Math.random()>0.5)
                positionY += 20;
            else
                positionY -= 20;

        if(positionX > 400) positionX =400;
        if(positionY > 400) positionY =400;
        if(positionX < 0)   positionX =0;
        if(positionY < 0)   positionY =0;

        g.fillRect(positionX, positionY, 20, 20);
    }
}


