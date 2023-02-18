/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J4_Direction;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.ImageObserver;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ikerf
 */
@SuppressWarnings("serial")
public class juego extends JPanel{
    
    public static int x = 0;
    public static  int y = 0;
    public static  int xa = 1;
    public static  int ya = 1;
    public static  int con = 1;
    int a = 0;
    int b = 0;

	private void moveBall() {
		if (x + xa < 0){
			xa = 1;
                        con++;
                }
		if (x + xa > getWidth() - 30){
			xa = -1;
                        con++;
                }
		if (y + ya < 0){
			ya = 1;
                        con++;
                }
		if (y + ya > getHeight() - 30){
			ya = -1;
                        con++;
                }
                if(con <20){
                 x = x + xa*con;
		 y = y + ya*con;  
                }
                else{
                    con--;
                    x = x + xa*con;
		    y = y + ya*con;  
                }
	}
        private void moveRect(){
            
        }
        	@Override
	public void paint(Graphics g) {
            Random r = new Random();
	    super.paint(g);
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
           //g2d.setColor(new Color(r.nextInt(250),r.nextInt(250),r.nextInt(250)));
	    g2d.fillOval(x, y, 30, 30);
            g2d.fillRect(a, b, 5, 50);
	}
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		juego game = new juego();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.moveBall();
			game.repaint();
			Thread.sleep(50);
		}
	}

}
