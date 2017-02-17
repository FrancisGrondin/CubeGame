package cubegame;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas {
	 
	private static final long serialVersionUID = 5259700796854880162L;

	public Window(int width, int heigth, String title, Game game){
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, heigth));
		frame.setMaximumSize(new Dimension(width, heigth));
		frame.setMinimumSize(new Dimension(width, heigth));
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(game);
		game.start();
	}

}
