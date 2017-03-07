import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected int x, y, w, h;
	protected String type;
	protected Image img;

	public GameObject(int x, int y, int w, int h, String type) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.type = type;
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
	public Rectangle hitBox(){
		return new Rectangle(x,y,w,h);
	}
	public boolean isColliding(GameObject r){
		if(r.hitBox().intersects(this.hitBox())){
			return true;
		}
		else{
			return false;
		}
	}
	
	public abstract void tick();
}