/*
 * This class implements a obstacle that block user to go threw the maze.

Author: WooSeok Hong
ID: 1612789
UPI: whon007
*/

import java.awt.*;

public class MovingDoorA {

	private static final int UP = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int RIGHT = 3;

	public static double mouseX;
	public static double mouseY;
	public static double speed;

	private int direction;
	
	public MovingDoorA(int left, int top) {

		speed = 0.8;
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
	
		g.setColor(Color.BLACK);
		g.drawRect((int)mouseX, (int)mouseY, 40, 5);
		g.setColor(Color.WHITE);
		g.fillRect((int)mouseX, (int)mouseY, 40, 5);
		
	}
	
}
