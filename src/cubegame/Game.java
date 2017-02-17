package cubegame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7164477026122768296L;
	public static final int width_ = 640;
	public static final int heigth_ = width_ / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	private Random r;
	private Handler handler;
	private HUB hub;
	private Spawn spawner;
	private Menu menu;
	
	
	
	public STATE gameState = STATE.Menu;
	
	public Game(){
		handler = new Handler();
		hub = new HUB();
		menu = new Menu(this, handler, hub);
		this.addKeyListener(new KeyInput(handler));;
		this.addMouseListener(menu);
		new Window(width_, heigth_, "Let's try this Game!", this);
		r = new Random();
		spawner = new Spawn(handler, hub);
		
		
		if(gameState == STATE.Game){
		handler.addObject(new Player(width_/2-32, heigth_/2-32, ID.Player, handler));
     	handler.addObject(new SlowEnemy(r.nextInt(2), r.nextInt(2), ID.SlowEnemy, handler));	
		}else{
			for(int i = 0; i < 15 ; i++){
				handler.addObject(new MenuParticle(r.nextInt(width_-50), r.nextInt(heigth_-50), ID.MenuParticle, handler));
			}
		}
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
		thread.join();
		running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
		    delta = delta + (now - lastTime) / ns;
			lastTime = now;
			while(delta >=1){
				tick();
				delta--;
			}
			
			if(running){
				render();
				frames++;
			}
		
			if(System.currentTimeMillis() - timer > 1000 ){
				timer = timer + 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	
	private void tick(){
		handler.tick();
		if(gameState == STATE.Game){
		hub.tick();
		spawner.tick();
		
		if(HUB.HEALT <= 0){
			if(HUB.highScore < hub.getScore()){
				HUB.highScore = hub.getScore();
			}
			HUB.HEALT = 100;
			gameState = STATE.End;
			handler.clearEnemys();
			for(int i = 0; i < 15 ; i++){
				handler.addObject(new MenuParticle(r.nextInt(width_-50), r.nextInt(heigth_-50), ID.MenuParticle, handler));
			}
		}
		
	 } else if(gameState == STATE.Menu || gameState == STATE.End){
		 menu.tick();
	 }
	}
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
	
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, width_, heigth_);
		handler.render(g);
		if(gameState == STATE.Game){
		hub.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End){
			 menu.render(g);
		 }
		g.dispose();
		bs.show();
		
	
	}
	
	public static float clamp(float var, float min, float max){
		if(var >= max){
			var = max;
		}else if(var <= min){
			 var = min;
		}else{
		}
		return var;
	}
	
	public static void main(String args[]) {
		new Game();
	}

}
