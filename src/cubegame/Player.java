package cubegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
//import java.util.Random;

public class Player extends GameObject{

//	private Random r = new Random();
	private Handler handler;
	
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		//velX = r.nextInt(5)+ 1;
		//velY = r.nextInt(5);
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
	public void tick() {
		x = x + velX;
		y = y + velY;
	
		x = Game.clamp(x, 0, Game.width_ - 37);
		y = Game.clamp(y, 0, Game.heigth_ - 60);
	
		handler.addObject(new Trail(x, y, ID.Trail, Color.white, 16, 16, 0.02f, handler));
		
		collision();
	}
	private void collision(){
		for(int i=0; i< handler.objectList.size(); i++){
			
			GameObject tempObject = handler.objectList.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastXEnemy|| tempObject.getId() == ID.FastYEnemy|| tempObject.getId() == ID.SlowEnemy || tempObject.getId() == ID.SmartEnemy){
				if(getBounds().intersects(tempObject.getBounds())){
					HUB.HEALT = HUB.HEALT -4;
				}
			}
		}
	}
	
	public void render(Graphics g) {
	 if(id == ID.Player){
		 g.setColor(Color.white);
	 }
	 //else if(id == ID.Player2){
	 //g.setColor(Color.blue);
	 //}
	// g.setColor(Color.black);
	 g.fillRect((int)x, (int)y, 32, 32);
	}

}
