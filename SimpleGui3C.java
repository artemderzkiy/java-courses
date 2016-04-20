import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;

public class SimpleGui3C
{
    JFrame frame;
    JLabel label;
    public static void main (String[] args)
    {
        SimpleGui3C gui = new SimpleGui3C();
        gui.go();
    }

    public void go()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change label");
       labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change color");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("i am label");


        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST,labelButton);
        frame.getContentPane().add(BorderLayout.NORTH,label);
        frame.setVisible(true);
        frame.setSize(300,300);
    }

    class LabelListener implements ActionListener
    {

        public void actionPerformed(ActionEvent event) {
            String s = "govnyashka";
            label.setText(s);
            s+=s;
        }
    }

    class ColorListener implements ActionListener
    {

        public void actionPerformed(ActionEvent event) {
            frame.repaint();
        }
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