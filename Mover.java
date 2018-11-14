/*
 * This class implements a user to move gold.
*/

import java.awt.*;

public abstract class Mover {

	protected static final int UP = 0;
	protected static final int DOWN = 1;
	protected static final int LEFT = 2;
	protected static final int RIGHT = 3;

	public double xCord;
	public double yCord;
	public double speed;

	protected int direction;
	
	public Mover(double speed, double xCord, double yCord) {

		this.speed = speed;
		direction = RIGHT;
		this.xCord = xCord;
		this.yCord = yCord;
		
	}

	public abstract void setDirection(int direction);

	public abstract void move();
	
	public abstract void draw(Graphics g);
	
}
