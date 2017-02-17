package cubegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;




public class Menu extends MouseAdapter{

	Game game;
	Handler handler;
	public Random r = new Random();
	private HUB hub;
	
	public Menu(Game game, Handler handler, HUB hub){
		this.handler = handler;
		this.game = game;
		this.hub = hub;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu){
		if(mouseOver(mx, my, 210, 150, 200 ,64)){
			game.gameState = STATE.Game;  
				handler.clearEnemys();
				handler.addObject(new Player(game.width_/2-32, game.heigth_/2-32, ID.Player, handler));
				handler.addObject(new SlowEnemy(r.nextInt(2), r.nextInt(2), ID.SlowEnemy, handler));	
				
		}
		
	// help
		if(mouseOver(mx, my, 210, 250, 200 ,64)){
			game.gameState = STATE.Help;
		}
	
		
	// quit
		if(mouseOver(mx, my, 210, 350, 200 ,64)){
			System.exit(1);
		}
	
		}
		//back help 
				if(game.gameState == STATE.Help){
					if(mouseOver(mx, my, 210, 350, 200 ,64)){
						game.gameState = STATE.Menu;
						return;
					}
				}
				
		//back game
				if(game.gameState == STATE.End){
					if(mouseOver(mx, my, 210, 350, 200 ,64)){
						game.gameState = STATE.Game;
						hub.Level(1);
						hub.Score(0);
						handler.clearEnemys();
						handler.addObject(new Player(game.width_/2-32, game.heigth_/2-32, ID.Player, handler));
						handler.addObject(new SlowEnemy(r.nextInt(2), r.nextInt(2), ID.SlowEnemy, handler));
					}
				}		
	}
	
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int heigth){
		if(mx > x && mx < x + width){
			if(my > y && my < y + heigth){
				return true;
			}else return false;
		}else return false;


	}
	
	public void tick(){
		
	}

	public void render(Graphics g){
		
		if(game.gameState == STATE.Menu){
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Menu",240, 70);
		g.setFont(fnt2);
		g.drawRect(210, 150, 200, 64);
		g.drawString("Play",270 ,190);
		g.drawRect(210, 250, 200, 64);
		g.drawString("Help",270 ,290);
		g.drawRect(210, 350, 200, 64);
		g.drawString("Quit",270 ,390);
	}else if(game.gameState == STATE.Help){
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		Font fnt3 = new Font("arial",1,20);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Help",240, 70);
		g.setFont(fnt3);
		g.drawString("Use WASD keys to move player and dodge enemies", 50, 200);
		g.setFont(fnt2);
		g.drawRect(210, 350, 200, 64);
		g.drawString("Back",270 ,390);
	}else if(game.gameState == STATE.End){
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		Font fnt3 = new Font("arial",1,20);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Game Over", 180, 70);
		g.setFont(fnt3);
		g.drawString("You lost whit a score of: "+ hub.getScore(), 175, 200);
		g.setFont(fnt3);
		g.drawString("HighScore: "+ HUB.highScore, 175, 250);
		g.setFont(fnt2);
		g.drawRect(210, 350, 200, 64);
		g.drawString("Try Again",245 ,390);
	}

	
	}
	

}
