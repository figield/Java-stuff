import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

class SilnikKulki extends Thread
{
   Kulka a;

   SilnikKulki(Kulka a)
   {
      this.a=a;
      start();
   }

   public void run()
   {
      try
      {
         while(true)
         {
            a.nextKrok();
            sleep(5);
         }
      }
      catch(InterruptedException e){}
   }
}