import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameObject {

	protected int x, y, w, h;
	protected String type;
	protected Image img;
	protected static double verticalVelocity, horizontalVelocity;

	public GameObject(int x, int y, int w, int h, String type) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.type = type;
		verticalVelocity = 0;
		horizontalVelocity = 0; // DynamicObjects redefine these as necessary
	}

	public void draw(Graphics g) {
		g.drawImage(img, x, y, w, h, null);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setHorizontalVelocity(double boost){
		horizontalVelocity += boost;
	}
	
	public void setVerticalVelocity(double boost){
		verticalVelocity += boost;
	}
	
	public String getType(){
		return type;
	}

	public abstract void tick();

	public Rectangle getBoundingRect() {
	return new Rectangle((int) (x + horizontalVelocity + gMap.G * gPanel.DELTA_TIME), (int) (y - verticalVelocity - gMap.G * gPanel.DELTA_TIME), w, h); // checks for collision using locations at next tick
	}

	public abstract void onCollision(GameObject go);
}