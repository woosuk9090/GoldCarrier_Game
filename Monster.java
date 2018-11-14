import java.awt.Color;
import java.awt.Graphics;

public class Monster extends Mover {

	public Monster(double speed, double xCord, double yCord) {
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
		g.setColor(Color.RED);
		g.fillOval((int)xCord, (int)yCord, 30, 30);
		g.setColor(Color.WHITE);
		g.fillOval((int)xCord+5, (int)yCord+5, 20, 20);
		g.setColor(Color.RED);
		g.fillRect((int)xCord+5, (int)yCord+5, 20, 13);
		g.setColor(Color.BLACK);
		g.fillOval((int)xCord+10, (int)yCord+10, 3, 3);
		g.fillOval((int)xCord+18, (int)yCord+10, 3, 3);
	}

}
