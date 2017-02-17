package cubegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class SmartEnemy extends GameObject {
		private Handler handler;
		private GameObject player;
			
			public SmartEnemy(float x, float y, ID id, Handler handler) {
				super(x, y, id);
				this.handler = handler;
			    
				for(int i =0 ; i < handler.objectList.size(); i++){
					if(handler.objectList.get(i).getId() == ID.Player){
						player = handler.objectList.get(i);
					}
				}
			}	

			
			public Rectangle getBounds(){
				return new Rectangle((int)x, (int)y, 16, 16);
			}
			
			public void tick() {
	
				x = x + velX;
				y = y + velY;
				
				float diffX = x - player.getX() - 16;
				float diffY = y - player.getY() - 16;
				float distance = (float)Math.sqrt( (x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
			
				velX = ((-1/distance) * diffX);
				velY = ((-1/distance) * diffY);
			//	if(y<=0 || y>= Game.heigth_- 37) velY = velY*-1;
			//	if(x<=0 || x>= Game.width_- 17) velX = velX*-1;
				
				handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.01f, handler ));
			}

			public void render(Graphics g) {
				g.setColor(Color.green);
				g.fillRect((int)x, (int)y, 16, 16);
				
			}

		}


