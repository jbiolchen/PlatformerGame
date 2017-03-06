import java.io.IOException;

import javax.imageio.ImageIO;

public class DynamicObject extends GameObject {

	protected String state;
	protected static double verticalVelocity;
	protected static double horizontalVelocity;
	protected final static double HORIZONTAL_VELOCITY_BOOST = 3 * gPanel.SCALE;
	protected final static double DOWN_VELOCITY_BOOST = 1 * gPanel.SCALE;
	protected final static double UP_VELOCITY_BOOST = 5 * gPanel.SCALE;

	public DynamicObject(int x, int y, int w, int h, String type) {
		super(x, y, w, h, type);
		verticalVelocity = 0;
		horizontalVelocity = 0;

		try {
			img = ImageIO.read(getClass().getResourceAsStream("images/Small Platform.png")); // for testing
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void left() {
		if (!gPanel.leftPressed)
			horizontalVelocity -= HORIZONTAL_VELOCITY_BOOST;
	}

	public static void right() {
		if (!gPanel.rightPressed)
			horizontalVelocity += HORIZONTAL_VELOCITY_BOOST;
	}

	public static void down() {
		if (!gPanel.downPressed)
			verticalVelocity -= DOWN_VELOCITY_BOOST;
	}

	public static void up() {
		if (!gPanel.upPressed)
			verticalVelocity += UP_VELOCITY_BOOST;
	}

	public void tick() {
		gravity();
		move();
	}

	public void gravity() {
		verticalVelocity -= gMap.G * gPanel.DELTA_TIME;
	}

	public void move() {
		x += horizontalVelocity * gPanel.DELTA_TIME;
		y -= verticalVelocity * gPanel.DELTA_TIME; // -= because y increases as you move down the screen
	}
}
