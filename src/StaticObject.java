import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StaticObject extends GameObject {

	public StaticObject(int x, int y, int w, int h, String type) {
		super(x, y, w, h, type);
		if (type.equals("large")) {
			try {
				img = ImageIO.read(getClass().getResourceAsStream("images/Large Platform.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (type.equals("small")) {
			try {
				img = ImageIO.read(getClass().getResourceAsStream("images/Small Platform.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void tick() { // intentionally blank
	} // can be used for animations
}
