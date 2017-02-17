package cubegame;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUB hub;
	private int scoreKeep = 0;
	private Random r = new Random();
	public Spawn(Handler handler, HUB hub) {
		this.handler = handler;
		this.hub = hub;	
	}

	public void tick(){
		scoreKeep++;
		if(scoreKeep > 500){
			scoreKeep = 0;
			hub.Level(hub.getLevel() + 1);
		
		
		if(hub.getLevel() == 2){
			//handler.addObject(new FastYEnemy(r.nextInt(Game.width_-50), r.nextInt(Game.heigth_/2), ID.FastYEnemy, handler));	
			//handler.addObject(new FastYEnemy(r.nextInt(Game.width_-25), r.nextInt(Game.heigth_/2), ID.FastYEnemy, handler));	
			handler.addObject(new SlowEnemy(r.nextInt(Game.width_/2), r.nextInt(Game.heigth_-50), ID.SlowEnemy, handler));		
		}if(hub.getLevel() == 3){
			handler.addObject(new BasicEnemy(r.nextInt(Game.width_-50), r.nextInt(Game.heigth_/2), ID.BasicEnemy, handler));		
		}if(hub.getLevel() == 4){
		//	handler.addObject(new SlowEnemy(r.nextInt(Game.width_-50), r.nextInt(Game.heigth_/2), ID.SlowEnemy, handler));		
		}if(hub.getLevel() == 6){
			handler.addObject(new BasicEnemy(r.nextInt(Game.width_/2), r.nextInt(Game.heigth_-50), ID.BasicEnemy, handler));		
		}if(hub.getLevel() == 7){
			handler.addObject(new SmartEnemy(r.nextInt(Game.width_-100), r.nextInt(Game.heigth_-50), ID.SmartEnemy, handler));
		}if(hub.getLevel() == 8){
		//	handler.addObject(new BasicEnemy(r.nextInt(Game.width_-50), r.nextInt(Game.heigth_/2), ID.BasicEnemy, handler));		
		}if(hub.getLevel() == 10){
			handler.addObject(new FastXEnemy(r.nextInt(Game.width_/2), r.nextInt(Game.heigth_-50), ID.FastXEnemy, handler));		
		}if(hub.getLevel() == 11){
			handler.addObject(new SmartEnemy(r.nextInt(Game.width_-25), r.nextInt(Game.heigth_-50), ID.SmartEnemy, handler));
		}if(hub.getLevel() == 12){
			handler.addObject(new BasicEnemy(r.nextInt(Game.width_-50), r.nextInt(Game.heigth_-25), ID.BasicEnemy, handler));		
			handler.addObject(new BasicEnemy(r.nextInt(Game.width_/2), r.nextInt(Game.heigth_-50), ID.BasicEnemy, handler));		
		}if(hub.getLevel() == 13){
			handler.addObject(new SmartEnemy(r.nextInt(Game.width_/2), r.nextInt(Game.heigth_-50), ID.SmartEnemy, handler));
		}if(hub.getLevel() == 14){
			handler.addObject(new FastXEnemy(r.nextInt(Game.width_-100), r.nextInt(Game.heigth_/2), ID.FastXEnemy, handler));		
		}if(hub.getLevel() == 20){
			handler.addObject(new FastYEnemy(r.nextInt(Game.width_-50), r.nextInt(Game.heigth_/2), ID.FastYEnemy, handler));		
			//handler.addObject(new FastYEnemy(r.nextInt(Game.width_), r.nextInt(Game.heigth_+50), ID.FastYEnemy, handler));	
		}
		
		}
	}
}
