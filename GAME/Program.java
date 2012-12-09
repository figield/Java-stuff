import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

public class Program
{
   public static void main(String[] args)
   {
      javax.swing.SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            Plansza p=new Plansza();

            JFrame jf=new JFrame();
            jf.add(p);

            jf.setTitle("ARGANOID 0.1");
            jf.setSize(600,370);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setVisible(true);
         }
      });
   }
}
//http://www.java2s.com/Tutorial/Java/0261__2D-Graphics/Catalog0261__2D-Graphics.htm