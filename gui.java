import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;


public class gui {

    public static void main(String[] args) {
        gui gui = new gui();
        gui.go();

    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panek = new JPanel();
        panek.setBackground(Color.green);
        panek.setLayout(new BoxLayout(panek,BoxLayout.Y_AXIS));
        JButton button = new JButton("CLICK");
        JButton button1 = new JButton("OCDLINNOE NAZVANIE EBANIY PATRON");
        Font font = new Font("serif",Font.BOLD,40);
        button.setFont(font);
        panek.add(button);
        panek.add(button1);
        frame.getContentPane().add(BorderLayout.EAST,panek);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setLocation(300, 200);
    }

}