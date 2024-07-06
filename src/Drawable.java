import java.awt.*;

/**
 * Drawable interface is a contract for objects that can be drawn.
 *
 * @author javiergs
 * @version 1.0
 */
public abstract class Drawable {

	protected int x;
	protected int y;
	
	public int getY() {
		return y;
	}
	
	public int getX() {
		return x;
	}
	
	public abstract void draw (Graphics g);

}