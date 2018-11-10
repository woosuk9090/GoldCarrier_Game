/*
 * This class implements a monster that block user to go threw the maze.
*/

import java.awt.*;

public class MonsterMover {

	private static final int UP = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int RIGHT = 3;

	public static double mouseX;
	public static double mouseY;
	public static double speed;

	private int direction;
	
	public MonsterMover(int left, int top) {

		speed = 3;
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
	
		g.setColor(Color.RED);
		g.fillOval((int)mouseX, (int)mouseY, 30, 30);
		g.setColor(Color.WHITE);
		g.fillOval((int)mouseX+5, (int)mouseY+5, 20, 20);
		g.setColor(Color.RED);
		g.fillRect((int)mouseX+5, (int)mouseY+5, 20, 13);
		g.setColor(Color.BLACK);
		g.fillOval((int)mouseX+10, (int)mouseY+10, 3, 3);
		g.fillOval((int)mouseX+18, (int)mouseY+10, 3, 3);
		
	}
	
}
