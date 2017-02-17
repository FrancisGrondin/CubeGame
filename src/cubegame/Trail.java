package cubegame;

import java.awt.AlphaComposite;
import java.awt.Color;
//import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {



	private Color color;
	private int heigth;
	private float life;
	private float alpha;
	private Handler handler;
	private int width;

	public Trail(float x, float y, ID id, Color color,int width, int heigth, float life, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.heigth = heigth;
		this.width = width;
		this.life = life;
		
	}

	public void tick() {
		if(alpha > life){
			alpha -= (life - 0.0001f);
		}else{
			handler.removeObject(this);
		}
		
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect((int)x, (int)y, width, heigth);
		g2d.setComposite(makeTransparent(1));
		
		
	}

	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}


	public Rectangle getBounds() {
		return null;
	}

}
