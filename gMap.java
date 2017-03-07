import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class gMap {

	protected List<GameObject> gameObjects;
	protected DynamicObject s;
	protected StaticObject x;
	static final double G = 9.8;
	private Dimension d;

	public gMap() {
		gameObjects = new ArrayList<GameObject>();
		d = new Dimension(800,600); 
		s = new DynamicObject(0, -56, 150, 150, "large");
		x = new StaticObject(0,450,((int) d.getWidth()),((int) d.getHeight()/4),"lava");
		
		gameObjects.add(s);
		gameObjects.add(x);
		//StaticObject y = new StaticObject(0,0,250,250,"lava");
		//gameObjects.add(y);

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
