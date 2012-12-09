import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

class Belka extends Rectangle2D.Float
{
   Belka(int x)
   {
      this.x=x;
      this.y=300;
      this.width=60;
      this.height=5;
   }

   Belka(int x, int y, int width, int height)
   {
      this.x=x;
      this.y=y;
      this.width=width;
      this.height=height;
   }
   
   void setX(int x)
   {
      this.x=x;
   }
}