import java.awt.Color;
import java.awt.Graphics;

public class MovingDoor extends Mover {

	private int width;
	private int height;

	public MovingDoor(double speed, double xCord, double yCord, int width, int height) {
		super(speed, xCord, yCord);
		this.width = width;
		this.height = height;
	}

	@Override
	public void setDirection(int direction) {
		super.direction = direction;
	}
	
	@Override
	public void move() {
		
		if (direction == RIGHT) {
			xCord = xCord + speed;
		}else if(direction == LEFT){
			xCord = xCord - speed;
		}else if(direction == UP){
			yCord = yCord - speed;
		}else if(direction == DOWN){
			yCord = yCord + speed;
		}
		
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect((int)xCord, (int)yCord, width, height);
		g.setColor(Color.WHITE);
		g.fillRect((int)xCord, (int)yCord, width, height);
	}

}
