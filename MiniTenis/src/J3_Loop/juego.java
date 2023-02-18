/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J3_Loop;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ikerf
 */
@SuppressWarnings("serial")
public class juego extends JPanel {
     public static int x = 0; 
     public static int y = 0;
     boolean control = false;
   
    private void moveBall(){
        Random r = new Random();
        int mov = r.nextInt(4);
        if(x > getWidth()-30 || y > getHeight()-30){
            control = true;
        }
        if(x<3 || y<3){
            control = false; 
        }
        
        if(control){
             if(x > 0 || y > 0){
                x--;
                y--;   
             }  
       }
       else {
           x++;
           y++;
       }
    }
    
  
    @Override
    public void paint(Graphics g){
       super.paint(g);
       Random r = new Random();
       Graphics2D g2d = (Graphics2D) g;
       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       g2d.setColor(new Color(r.nextInt(250),r.nextInt(250),r.nextInt(250)));
       g2d.fillOval(x,y,30,30);
           //g2d.fillRect(2*x, 2*y, 30, 30);  

      
    }
    public static void main(String[] args) throws InterruptedException{
        
    JFrame frame = new JFrame("Mini Tetris");
    juego game = new juego();
    frame.add(game);
    frame.setSize(300,300);
   
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    while(true){
          game.moveBall();
          game.repaint();
          Thread.sleep(10);
    }
    }
    
}
