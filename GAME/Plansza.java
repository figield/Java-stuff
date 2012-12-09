import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

class Plansza extends JPanel implements MouseMotionListener
{
   Belka b;
   Belka [] c;
   Kulka a;
   SilnikKulki s;

   Plansza()
   {
      super();
      addMouseMotionListener(this);
      b=new Belka(300);
      c = new Belka[12];
      for(int i=0;i<6;i++){
    	  c[i]   = new Belka(100 * i + 40, 50,  40, 15);
    	  c[i+6] = new Belka(100 * i + 20, 100, 40, 15);    	  
      }             
      a=new Kulka(this,b,c,100,100,1,1);
      s=new SilnikKulki(a); 
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2d=(Graphics2D)g;
      
      g2d.setColor(Color.ORANGE);
      for(int i=0;i<12;i++)    	    	
    	  g2d.fill(c[i]);
      
      g2d.setColor(Color.RED);
      g2d.fill(b);
      g2d.setColor(Color.BLUE);
      g2d.fill(a);
   }

   public void mouseMoved(MouseEvent e)
   {
      b.setX(e.getX()-50);
      repaint();
   }

   public void mouseDragged(MouseEvent e)
   {

   }
}