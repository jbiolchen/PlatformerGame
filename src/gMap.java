import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class gMap {

	protected List<GameObject> gameObjects;
	protected DynamicObject s;
	static final double G = 9.8;

	public gMap() {
		gameObjects = new ArrayList<GameObject>();
		s = new DynamicObject(0, -56, 150, 150, "large");
		gameObjects.add(s);

	}

	public void tick() {
		List<GameObject> draw = new ArrayList<GameObject>();
		draw = location();
		for(int i = 0; i<draw.size(); i++) {
			draw.get(i).draw(g);
		}
	}
	public ArrayList<GameObject> location(){
		ArrayList<GameObject> draw = new ArrayList<GameObject>();
		for(int i = 0; i<gameObjects.size(); i++) {
			if((gameObjects.get(i).getX() <= h.getX()-400 || gameObjects.get(i).getX() >= h.getX()-400) && (gameObjects.get(i).getY() >= h.getY()-300 || gameObjects.get(i).getY() <= h.getY()-300)) {
				draw.add(gameObjects.get(i));
			}
			else { }
		}
		return draw;
	}

}
