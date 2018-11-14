import java.awt.Color;
import java.awt.Graphics;

public class GoldCarrier extends Mover {

	public GoldCarrier(double speed, double xCord, double yCord) {
		super(speed, xCord, yCord);
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
		g.setColor(Color.YELLOW);
		g.fillOval((int)xCord, (int)yCord, 10, 10);
		g.setColor(Color.BLACK);
		g.drawOval((int)xCord, (int)yCord, 10, 10);
	}

}
