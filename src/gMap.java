import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class gMap {

	protected List<GameObject> gameObjects;
	protected DynamicObject s;
	static final double G = 9.8 * gPanel.SCALE;

	public gMap() {
		gameObjects = new ArrayList<GameObject>();
		s = new DynamicObject(0, -56, 150, 150, "large");
		gameObjects.add(s);

	}

	public void tick() {
		for (GameObject go : gameObjects)
			go.tick();
	}

	public void draw(Graphics g) {
		for (GameObject go : gameObjects)
			go.draw(g);
	}

}
