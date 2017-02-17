package cubegame;

import java.awt.Color;
import java.awt.Graphics;

public class HUB {

	public static float HEALT = 100;
	public float greenValue = 255;
	public static int highScore = 0;
	private int score = 0;
	private int level = 1;
	
	public void tick(){
		HEALT = Game.clamp(HEALT, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		greenValue = HEALT*2;
		score++;
	}
	
	public void render(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect(15, 15, (int)HEALT * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		g.drawString("Score: "+score, 15, 64);
		g.drawString("Level: "+level, 15, 80);
	}
public void Score(int score){
	this.score = score;
}

public int getScore(){
	return score;
}
public void Level(int level){
	this.level = level;
}

public int getLevel(){
	return level;
}
}
