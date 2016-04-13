import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui implements ActionListener
{
    JButton button;
    public static void main (String[] args)
    {
        gui gui = new gui();
        gui.go();

    }
    public void go ()
    {
        JFrame frame = new JFrame();
         button = new JButton("CLICK ME");
        button.addActionListener(this);
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setLocation(300,200);
    }

    public void actionPerformed (ActionEvent event)
    {
        button.setText("I have been changed");
    }
}