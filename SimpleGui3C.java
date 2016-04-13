import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui3C implements ActionListener
{
    JFrame frame;
    public static void main (String[] args)
    {
        SimpleGui3C gui = new SimpleGui3C();
        gui.go();
    }

    public void go()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change color");
        button.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setVisible(true);
        frame.setSize(300,300);
    }

    public void actionPerformed (ActionEvent event)
    {
        frame.repaint();
    }

}


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