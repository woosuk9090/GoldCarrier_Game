/*
 * This class implements a user to move gold.
*/

import java.awt.*;

public class Mover {

	private static final int UP = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int RIGHT = 3;

	public static double mouseX;
	public static double mouseY;
	public static double speed;

	private int direction;
	
	public Mover(int left, int top) {

		speed = 1.6;
		direction = RIGHT;
		mouseX = left;
		mouseY = top;
		
	}

	public void setDirection(int direction) {
	
		this.direction = direction;
		
	}

	public void move() {
	
		if (direction == RIGHT) {
			mouseX = mouseX + speed;
		}else if(direction == LEFT){
			mouseX = mouseX - speed;
		}else if(direction == UP){
			mouseY = mouseY - speed;
		}else if(direction == DOWN){
			mouseY = mouseY + speed;
		}
		
	}
	
	public void draw(Graphics g) {
	
		g.setColor(Color.YELLOW);
		g.fillOval((int)mouseX, (int)mouseY, 10, 10);
		g.setColor(Color.BLACK);
		g.drawOval((int)mouseX, (int)mouseY, 10, 10);
		
	

	}
	
}
