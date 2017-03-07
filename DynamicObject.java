import java.io.IOException;

import javax.imageio.ImageIO;

public class DynamicObject extends GameObject {

	int i = 0;
	protected String state;
	protected double verticalVelocity, horizontalVelocity;
	protected final double VELOCITY_BOOST = 10;

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

	public void left() {
		horizontalVelocity -= VELOCITY_BOOST;
	}

	public void right() {
		horizontalVelocity += VELOCITY_BOOST;
	}

	public void down() {
		verticalVelocity -= VELOCITY_BOOST;
	}

	public void up() {
		verticalVelocity += VELOCITY_BOOST;
	}

	public void tick() {
		gravity();
		move();
		i++;
		System.out.println(i);
	}

	public void gravity() {
		verticalVelocity -= gMap.G * gPanel.DELTA_TIME * gPanel.SCALE;
	}

	public void move() {
		x += horizontalVelocity * gPanel.DELTA_TIME;
		y -= verticalVelocity * gPanel.DELTA_TIME; // -= because y increases as you move down the screen
	}
}
