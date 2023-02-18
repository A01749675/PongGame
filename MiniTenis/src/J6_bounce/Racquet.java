/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J6_bounce;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	private static final int Y = 330;
	private static final int WITH = 60;
	private static final int HEIGHT = 10;
	int x = 0;
	int xa = 0;
	private juego game;

	public Racquet(juego game) {
		this.game = game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - WITH)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, Y, WITH, HEIGHT);
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

	public Rectangle getBounds() {
		return new Rectangle(x, Y, WITH, HEIGHT);
	}

	public int getTopY() {
		return Y - HEIGHT;
	}
}
