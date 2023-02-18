/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J5_ra;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author ikerf
 */
public class Racquet {
        int x = 0;
	int xa = 0;
        
	private juego game;

	public Racquet(juego game) {
		this.game= game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth()-60)
			x = x + xa;
	}
	public void paint(Graphics2D g) {
		g.fillRect(x, 330, 60, 10);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 1;
	}
}
