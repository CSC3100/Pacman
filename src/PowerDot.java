import java.awt.*;

/**
 * PowerDot class is a Drawable object.
 *
 * @author javiergs
 * @version 1.0
 */
public class PowerDot extends Drawable {
	
	public static final int DIAMETER = 50;
	
	public PowerDot() {
		this.x = 725;
		this.y = 500;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(x, y, DIAMETER, DIAMETER);
		g.setColor(Color.WHITE);
		g.fillOval(x + DIAMETER / 4, y + DIAMETER / 4, DIAMETER / 2, DIAMETER / 2);
	}
	
}