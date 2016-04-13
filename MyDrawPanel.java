import com.sun.prism.Graphics;

import java.awt.*;
import java.awt.Color;
import java.lang.Math;
import javax.swing.*;
import javax.swing.JPanel;

 class MyDrawPanel extends JPanel
{


    public void paintComponent (Graphics g)
    {

        g.fillRect(0,0,this.getWidth(),this.getHeight());
        int red = (int)(Math.random()*255);
        int green = (int)(Math.random()*255);
        int blue = (int)(Math.random()*255);
        Color randcolor = new Color(red,green,blue);
        g.setColor(randcolor);
        g.fillOval(70,70,100,40);

    }


}