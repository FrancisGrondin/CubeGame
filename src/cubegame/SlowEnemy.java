package cubegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SlowEnemy extends GameObject {
		private Handler handler;
			
			public SlowEnemy(float x, float y, ID id, Handler handler) {
				super(x, y, id);
				this.handler = handler;
			    velX = 2;
				velY = 2;
				
			}	

			
			public Rectangle getBounds(){
				return new Rectangle((int)x, (int)y, 24, 24);
			}
			
			public void tick() {
				y = y + velY ;
				x = x + velX ;
			
				if(y<=0 || y>= Game.heigth_- 50) velY = velY*-1;
				if(x<=0 || x>= Game.width_- 30) velX = velX*-1;
				
				handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 16, 16, 0.01f, handler ));
			}

			public void render(Graphics g) {
				g.setColor(Color.yellow);
				g.fillRect((int)x, (int)y, 24, 24);
				
			}

		}





