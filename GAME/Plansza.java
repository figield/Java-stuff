import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

class Plansza extends JPanel implements MouseMotionListener
{
   Belka b;
   Kulka a;
   SilnikKulki s;

   Plansza()
   {
      super();
      addMouseMotionListener(this);

      b=new Belka(100);
      a=new Kulka(this,100,100,1,1);
      s=new SilnikKulki(a);
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2d=(Graphics2D)g;

      g2d.fill(a);
      g2d.fill(b);
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