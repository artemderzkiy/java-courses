import com.sun.prism.Graphics;

import java.awt.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.Math;
import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import javax.swing.JPanel;

 class MyDrawPanel extends JPanel implements ControllerEventListener
{
boolean msg;
    public void controlChange(ShortMessage event)
    {
        msg=true;
        repaint();
    }


    public void paintComponent (Graphics g)
    {
     if (msg)
     {
         Graphics2D g2 = (Graphics2D) g;

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
         g.setColor(new Color(red,green,blue));
         int ht = (int) ((Math.random() * 135)+20);
         int wt = (int) ((Math.random() * 135)-20);
         int x= (int) ((Math.random() * 60)+20);
         int y = (int) ((Math.random() * 60)-20);

        g.fillOval(x,y,ht,wt);
         msg=false;
    }
    }


}