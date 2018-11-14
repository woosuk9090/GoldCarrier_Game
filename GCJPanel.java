/*
F	*** Gold Carrier ***
	Carry the gold through the maze while avoiding all monsters and obstacles that may linger in the way.
	If gold collide into a wall or monster, the game ends up lose!
	Carry the gold to home located at the end of the maze.
*/

import java.applet.*;  
import java.net.*;  

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GCJPanel extends JPanel implements KeyListener, ActionListener {
	
	private static final long serialVersionUID = 1L;
	private AudioClip playBGM; 
	private AudioClip dieBGM;
	private AudioClip winnerBGM;  
	private AudioClip gameOverBGM;
	private AudioClip clapBGM;
	
	private int showTitleScreen;
	
	private int movingBall;
		
	private Timer t;
	private GoldCarrier carrier;
	private Monster monsterM;
	private MovingDoor[] door;
		
	private Rectangle[] map;
	private Rectangle gate;
	private Rectangle gold;
	private Rectangle monster;
	private Rectangle doorA;
	private Rectangle doorB;
	private Rectangle doorC;
	
	public GCJPanel() {
		
		showTitleScreen = 0;
		movingBall = 0;
		
		playBGM = loadSound("playBGM.wav"); 
		dieBGM = loadSound("dieBGM.wav");  
		winnerBGM = loadSound("winnerBGM.wav");
		gameOverBGM = loadSound("gameOverBGM.wav");
		clapBGM = loadSound("clapBGM.wav");
		
		playBGM.loop();
		
		Color BACKGROUND = new Color(223,241,255);
		setBackground(BACKGROUND);
		
		t = new Timer(20, this);
		carrier = new GoldCarrier(1.6, 40, 60);
		monsterM = new Monster(3, 285, 165);
		
		door = new MovingDoor[3];
		door[0] = new MovingDoor(0.8, 350, 210, 40, 5);
		door[1] = new MovingDoor(0.9, 150, 210, 40, 5);
		door[2] = new MovingDoor(0.6, 330, 50, 80, 5);
		
		addKeyListener(this);
		
		map = new Rectangle[32];
		map[0] = new Rectangle(0,20,500,30);
		map[1] = new Rectangle(0,20,30,480);
		map[2] = new Rectangle(0,470,500,30);
		map[3] = new Rectangle(470,20,30,480);
		map[4] = new Rectangle(0,80,235,5);
		map[5] = new Rectangle(230,80,5,40);
		map[6] = new Rectangle(60,115,140,5);
		map[7] = new Rectangle(195,120,5,35);
		map[8] = new Rectangle(200,150,65,5);
		map[9] = new Rectangle(265,50,5,105);
		map[10] = new Rectangle(30,150,135,5);
		map[11] = new Rectangle(30,205,390,5);
		map[12] = new Rectangle(320,100,5,105);
		map[13] = new Rectangle(325,100,95,5);
		map[14] = new Rectangle(375,150,95,5);
		map[15] = new Rectangle(80,255,390,5);	
		map[16] = new Rectangle(415,420,5,50);	
		map[17] = new Rectangle(415,415,25,5);	
		map[18] = new Rectangle(59,280,48,37);	
		map[19] = new Rectangle(83,301,62,63);
		map[20] = new Rectangle(48,350,62,58);
		map[21] = new Rectangle(51,425,54,45);
		map[22] = new Rectangle(130,382,110,70);
		map[23] = new Rectangle(180,337,84,63);
		map[24] = new Rectangle(167,278,63,40);
		map[25] = new Rectangle(259,425,84,45);
		map[26] = new Rectangle(260,384,63,21);
		map[27] = new Rectangle(365,356,30,94);
		map[28] = new Rectangle(281,319,70,45);
		map[29] = new Rectangle(250,260,100,40);
		map[30] = new Rectangle(375,283,73,50);
		map[31] = new Rectangle(411,348,42,50);
		
		gate = new Rectangle(434,430,20,30);
		
	}

	private AudioClip loadSound(String fileName) {  
	
		URL url = getClass().getResource(fileName);
		return Applet.newAudioClip(url);
	
	}
	
	public void actionPerformed(ActionEvent e) {

		carrier.move();
		monsterM.move();
		door[0].move();
		door[1].move();
		door[2].move();
		
		gold = new Rectangle((int)carrier.xCord,(int)carrier.yCord,10,10); 
		monster = new Rectangle((int)monsterM.xCord,(int)monsterM.yCord,30,30);
		doorA = new Rectangle((int)door[0].xCord,(int)door[0].yCord,40,5);
		doorB = new Rectangle((int)door[1].xCord,(int)door[1].yCord,40,5);
		doorC = new Rectangle((int)door[2].xCord,(int)door[2].yCord,80,5);
		
		for(int i = 0; i < map.length; i++){
			
			if (map[i].intersects(gold)) {
			
				t.stop();
				playBGM.stop();
				gameOverBGM.play();
				dieBGM.play();
				movingBall++;
				showTitleScreen = 500;
			
			}
			
		}
		
		if (gate.contains(gold)) {
			
			t.stop();
			playBGM.stop();
			winnerBGM.play();
			clapBGM.play();
			movingBall++;
			showTitleScreen = 501;
			
		}
		
		if (monster.intersects(gold)) {
			
			t.stop();
			playBGM.stop();
			gameOverBGM.play();
			dieBGM.play();
			movingBall++;
			showTitleScreen = 500;
			
		}
		
		if (monster.intersects(map[12])) {
			
			monsterM.setDirection(2);
			
		} else if (monster.intersects(map[1])) {
		
			monsterM.setDirection(3);
			
		}
			
		if (doorA.intersects(gold)) {
			
			t.stop();
			playBGM.stop();
			gameOverBGM.play();
			dieBGM.play();
			movingBall++;
			showTitleScreen = 500;
		
		}
		
		if (doorA.intersects(map[11])) {
			
			door[0].setDirection(1);
			
		} else if (doorA.intersects(map[15])) {
		
			door[0].setDirection(0);
		
		}
		
		if (doorB.intersects(gold)) {
			
			t.stop();
			playBGM.stop();
			gameOverBGM.play();
			dieBGM.play();
			movingBall++;
			showTitleScreen = 500;
		
		}
		
		if (doorB.intersects(map[11])) {
			
			door[1].setDirection(1);
			
		} else if (doorB.intersects(map[15])) {
		
			door[1].setDirection(0);

		}
		
		if (doorC.intersects(gold)) {
			
			t.stop();
			playBGM.stop();
			gameOverBGM.play();
			dieBGM.play();
			movingBall++;
			showTitleScreen = 500;
		
		}
		
		if (doorC.intersects(map[0])) {
			
			door[2].setDirection(1);
			
		} else if (doorC.intersects(map[13])) {
		
			door[2].setDirection(0);

		}
		
		repaint();
		
	}
	
	public void keyPressed(KeyEvent e) {
	
		if(e.getKeyCode() == KeyEvent.VK_ENTER && showTitleScreen != 500 && showTitleScreen != 501){
			showTitleScreen++;
			if(showTitleScreen >= 2){
				monsterM.setDirection(2);
			}
			if(showTitleScreen >= 2){
				door[0].setDirection(1);
			}
			if(showTitleScreen >= 2){
				door[1].setDirection(1);
			}
			if(showTitleScreen >= 2){
				door[2].setDirection(1);
			}
			
		} 
		
		repaint();
	
		if(e.getKeyCode() == KeyEvent.VK_UP){
			carrier.setDirection(0);
			if(movingBall == 0 && showTitleScreen >= 2){
				t.start();
			}
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			carrier.setDirection(1);
			if(movingBall == 0 && showTitleScreen >= 2){
				t.start();
			}
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			carrier.setDirection(2);
			if(movingBall == 0 && showTitleScreen >= 2){
				t.start();
			}
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			carrier.setDirection(3);
			if(movingBall == 0 && showTitleScreen >= 2){
				t.start();
			}
		}else if(e.getKeyChar() == '' && showTitleScreen >= 2){
			t.stop();
			int result = JOptionPane.showConfirmDialog(null, "Are you sure?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

			if(result == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
		
	}
	
	public void paintComponent(Graphics g){
 	    
		super.paintComponent(g);
		Font font = new Font("Lucida Sans", Font.BOLD,  50);
		Font font1 = new Font("Lucida Sans", Font.BOLD,  15);
		Font font2 = new Font("Lucida Sans", Font.BOLD,  70);
		Font font3 = new Font("Lucida Sans", Font.BOLD,  25);
		Font font4 = new Font("Lucida Sans", Font.BOLD, 18);
		
		if (showTitleScreen == 0) {
		
			g.setFont(font);
			g.drawString("GOLD CARRIER",60,150);
			g.setFont(font3);
			g.drawString("by Woo Seok (Brian)",195,200);
			g.setFont(font4);
			g.drawString("Press Enter to start",295,480);
			
		} else if (showTitleScreen == 1) {

			g.setFont(font);
			g.drawString("GOLD CARRIER",60,100);
			g.setFont(font1);
			g.drawString("Carry your gold through the maze while",90,160);
			g.drawString("avoiding all monsters and obstacles that",90,180);
			g.drawString("may linger in your way.",160,200);
			g.drawString("If you collide into a wall or monster,",110,220);
			g.drawString("you lose!",205,240);
			g.drawString("Carry your gold to your home located at",90,260);
			g.drawString("the end of the maze.",165,280);
			g.drawString("Key:",60,360);
			g.drawString("ESC = finish game",60,385);
			g.drawString("UP = heading up / DOWN = heading down",60,410);
			g.drawString("LEFT = heading left / RIGHT = heading right",60,435);
			
			g.setFont(font4);
			g.drawString("Enjoy!",345,310);
			g.drawString("Press Enter to start",295,480);
			
		} else if (showTitleScreen >= 2){
	
			g.setFont(font1);
			g.drawString("Press ESC to finish game.",2,16);
			
			Color BROWN = new Color(90,17,0);
			Color SKYBLUE = new Color(90,191,255);
			Color BACKGROUND = new Color(223,241,255);
			
			g.setColor(SKYBLUE);
			g.fillRect(map[0].x,map[0].y,500,30);
			g.drawRect(map[0].x,map[0].y,500,30);
			
			g.fillRect(map[1].x,map[1].y,30,480);
			g.drawRect(map[1].x,map[1].y,30,480);
			
			g.fillRect(map[2].x,map[2].y,500,30);
			g.drawRect(map[2].x,map[2].y,500,30);
			
			g.fillRect(map[3].x,map[3].y,30,480);
			g.drawRect(map[3].x,map[3].y,30,480);
			
			g.fillRect(map[4].x,map[4].y,235,5);
			g.drawRect(map[4].x,map[4].y,235,5);
			
			g.fillRect(map[5].x,map[5].y,5,40);
			g.drawRect(map[5].x,map[5].y,5,40);
			
			g.fillRect(map[6].x,map[6].y,140,5);
			g.drawRect(map[6].x,map[6].y,140,5);
			
			g.fillRect(map[7].x,map[7].y,5,35);
			g.drawRect(map[7].x,map[7].y,5,35);
			
			g.fillRect(map[8].x,map[8].y,65,5);
			g.drawRect(map[8].x,map[8].y,65,5);
			
			g.fillRect(map[9].x,map[9].y,5,105);
			g.drawRect(map[9].x,map[9].y,5,105);
			
			g.fillRect(map[10].x,map[10].y,135,5);
			g.drawRect(map[10].x,map[10].y,135,5);
			
			g.fillRect(map[11].x,map[11].y,390,5);
			g.drawRect(map[11].x,map[11].y,390,5);
			
			g.fillRect(map[12].x,map[12].y,5,105);
			g.drawRect(map[12].x,map[12].y,5,105);
			
			g.fillRect(map[13].x,map[13].y,95,5);
			g.drawRect(map[13].x,map[13].y,95,5);
			
			g.fillRect(map[14].x,map[14].y,95,5);
			g.drawRect(map[14].x,map[14].y,95,5);
			
			g.fillRect(map[15].x,map[15].y,390,5);
			g.drawRect(map[15].x,map[15].y,390,5);
			
			g.fillRect(map[16].x,map[16].y,5,50);
			g.drawRect(map[16].x,map[16].y,5,50);
			
			g.fillRect(map[17].x,map[17].y,25,5);
			g.drawRect(map[17].x,map[17].y,25,5);
			
			g.fillRect(map[18].x,map[18].y,48,37);
			g.drawRect(map[18].x,map[18].y,48,37);
			
			g.fillRect(map[19].x,map[19].y,62,63);
			g.drawRect(map[19].x,map[19].y,62,63);
			
			g.fillRect(map[20].x,map[20].y,62,58);
			g.drawRect(map[20].x,map[20].y,62,58);
			
			g.fillRect(map[21].x,map[21].y,54,45);
			g.drawRect(map[21].x,map[21].y,54,45);
			
			g.fillRect(map[22].x,map[22].y,110,70);
			g.drawRect(map[22].x,map[22].y,110,70);
			
			g.fillRect(map[23].x,map[23].y,84,63);
			g.drawRect(map[23].x,map[23].y,84,63);
			
			g.fillRect(map[24].x,map[24].y,63,40);
			g.drawRect(map[24].x,map[24].y,63,40);
			
			g.fillRect(map[25].x,map[25].y,84,45);
			g.drawRect(map[25].x,map[25].y,84,45);
			
			g.fillRect(map[26].x,map[26].y,63,21);
			g.drawRect(map[26].x,map[26].y,63,21);
			
			g.fillRect(map[27].x,map[27].y,30,94);
			g.drawRect(map[27].x,map[27].y,30,94);
			
			g.fillRect(map[28].x,map[28].y,70,45);
			g.drawRect(map[28].x,map[28].y,70,45);
			
			g.fillRect(map[29].x,map[29].y,100,40);
			g.drawRect(map[29].x,map[29].y,100,40);
			
			g.fillRect(map[30].x,map[30].y,73,50);
			g.drawRect(map[30].x,map[30].y,73,50);
			
			g.fillRect(map[31].x,map[31].y,42,50);
			g.drawRect(map[31].x,map[31].y,42,50);
			
			g.setColor(Color.WHITE);
			g.fillRect(gate.x,gate.y,20,30);
			g.setColor(Color.BLACK);
			g.drawRect(gate.x,gate.y,20,30);
			
			g.setColor(BROWN);
			g.fillRect(435,431,18,28);
			
			g.setColor(Color.BLACK);
			g.drawRect(435,431,18,28);
			
			g.drawLine(437,431,437,459);
			g.drawLine(439,431,439,459);
			g.drawLine(441,431,441,459);
			g.drawLine(443,431,443,459);
			g.drawLine(445,431,445,459);
			g.drawLine(447,431,447,459);
			g.drawLine(449,431,449,459);
			g.drawLine(451,431,451,459);
			
			g.fillOval(451,445,3,3);
			
			g.setColor(BACKGROUND);
			g.fillRect(64,285,38,27);	
			g.fillRect(88,306,52,53);
			g.fillRect(53,355,52,48);
			g.fillRect(56,430,44,35);
			g.fillRect(135,387,100,60);
			g.fillRect(185,342,74,53);
			g.fillRect(172,283,53,30);
			g.fillRect(264,430,74,35);
			g.fillRect(265,389,53,11);
			g.fillRect(370,361,20,84);
			g.fillRect(286,324,60,35);
			g.fillRect(255,265,90,30);
			g.fillRect(380,288,63,40);
			g.fillRect(416,353,32,40);
			g.fillRect(255,389,15,6);
			
			carrier.draw(g);
			
			monsterM.draw(g);
			
			door[0].draw(g);
			
			door[1].draw(g);
			
			door[2].draw(g);
		
			if (showTitleScreen == 500) {
		
				g.setFont(font2);
				g.setColor(Color.RED);
				g.drawString("You LOSE!",65,267);
		
			}
			
			if (showTitleScreen == 501) {
		
				g.setColor(Color.BLACK);
				g.setFont(font2);
				g.drawString("You WIN!",95,267);
				g.setFont(font3);
				g.drawString("CONGRATULATIONS",125,200);
		
			}
				
		} 
			
	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

}
