import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

class Kulka extends Ellipse2D.Float
{
   Plansza p;
   Belka b;
   int dx,dy;

   Kulka(Plansza p, Belka b, int x,int y,int dx,int dy)
   {
      this.x=x;
      this.y=y;
      this.width=10;
      this.height=10;

      this.p=p;
      this.b=b;
      this.dx=dx;
      this.dy=dy;
      
   }

   void nextKrok()
   {
      x+=dx;
      y+=dy;

      if(getMinX()<0 || getMaxX()>p.getWidth())  dx=-dx;
      if(getMinY()<0 || getMaxY()>p.getHeight()) dy=-dy;
      if(this.intersects(b)){
    	//System.out.println(b);  
    	dy=-dy;
      }
      p.repaint();
   }
}