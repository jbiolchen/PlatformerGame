import java.io.IOException;

import javax.imageio.ImageIO;

public class Hero extends DynamicObject {
	
	public Hero(int x, int y, int w, int h, String type) {
		super(x, y, w, h, type);
		
		if (type.equals("player")) {
			try {
				img = ImageIO.read(getClass().getResourceAsStream("images/player.png")); // for testing
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
