import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class gMap {

	protected static List<GameObject> gameObjects;
	protected DynamicObject player;
	protected StaticObject largePlatform;
	static final double G = 9.8 * gPanel.SCALE;

	protected final static double HORIZONTAL_VELOCITY_BOOST = 3 * gPanel.SCALE;
	protected final static double DOWN_VELOCITY_BOOST = 1 * gPanel.SCALE;
	protected final static double UP_VELOCITY_BOOST = 8 * gPanel.SCALE;

	public gMap() {
		gameObjects = new ArrayList<GameObject>();
		player = new Hero(0, 0, 50, 50, "player");
		largePlatform = new StaticObject(0, 200, 150, 150, "large");
		gameObjects.add(player);
		gameObjects.add(largePlatform);

	}

	public void tick() {
		for (GameObject go : gameObjects)
			go.tick();
		collision();
	}

	public void draw(Graphics g) {
		for (GameObject go : gameObjects)
			go.draw(g);
	}

	public void collision() {
		for (int i = 0; i < gameObjects.size(); i++) {
			for (int j = i + 1; j < gameObjects.size(); j++) {
				if (gameObjects.get(i).getBoundingRect().intersects(gameObjects.get(j).getBoundingRect())) {
					gameObjects.get(i).onCollision(gameObjects.get(j));
					gameObjects.get(j).onCollision(gameObjects.get(i));
				}
			}
		}
	}

	public static void heroLeft() { // equivalent of moving Hero left
		if (!gPanel.leftPressed)
			for (GameObject go : gameObjects) {
				if (!(go instanceof Hero))
					go.setHorizontalVelocity(-HORIZONTAL_VELOCITY_BOOST);
			}
	}

	public static void heroRight() {
		if (!gPanel.rightPressed)
			for (GameObject go : gameObjects) {
				if (!(go instanceof Hero))
					go.setHorizontalVelocity(HORIZONTAL_VELOCITY_BOOST);
			}
	}

	public static void heroDown() {
		if (!gPanel.downPressed)
			for (GameObject go : gameObjects) {
				if (!(go instanceof Hero))
					go.setVerticalVelocity(-DOWN_VELOCITY_BOOST);
			}
	}

	public static void heroUp() {
		if (!gPanel.upPressed)
			for (GameObject go : gameObjects) {
				if (!(go instanceof Hero))
					go.setVerticalVelocity(UP_VELOCITY_BOOST);
			}
	}

}
