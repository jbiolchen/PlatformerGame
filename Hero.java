public class Hero extends DynamicObject {

	private Image img;

	public Hero(int x, int y, int w, int h, String type) {
		super(x,y,w,h,type);
		if(type.equals("begin")) {
			try {
				img = ImageIO.read(getClass().getResourceAsStream("images/Large Platform.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		super.setHealth(4);
	}

	public void changeState() {
		if(super.getHealth()==4) {
			return;
		}
		else if(super.getHealth()==3) {
			try {
				img = ImageIO.read(getClass().getResourceAsStream("images/Large Platform Broken.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.w = (int) ((int) this.w*.8);
		}
		else if(super.getHealth()==2) {
			try {
				img = ImageIO.read(getClass().getResourceAsStream("images/Small Platform.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.w = (int) ((int) this.w*.656);
		}
		else if(super.getHealth()==1) {
			try {
				img = ImageIO.read(getClass().getResourceAsStream("images/Small Platform Broken.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.w = (int) ((int) this.w*.571);
		}
		else if(super.getHealth()==0) {
				img = null;
		}
	}

	public void draw(Graphics g) {
		g.drawImage(img, this.x, this.y, this.w, this.h, null);
	}

}
