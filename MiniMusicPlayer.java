import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System;


public class MiniMusicPlayer
{
    static JFrame f = new JFrame("PERVIY KLIP");
    static MyDrawPanel dp;
    JButton button;
    boolean flag = false;

  public static void main(String[] args)
  {
      MiniMusicPlayer mp = new MiniMusicPlayer();
     mp.go();


  }

    public void setUpGui()
    {   dp = new MyDrawPanel();
        button = new JButton("START");
        button.addActionListener(new Listener());
                f.setContentPane(dp);
        f.getContentPane().add(button);
        f.setVisible(true);
        f.setBounds(30,30,300,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    public void go () {
        setUpGui();
       // System.out.println("TEST");
        if (flag==false) {

            try {

                Sequencer sequencer = MidiSystem.getSequencer();
                sequencer.open();
                sequencer.addControllerEventListener(dp, new int[]{127});
                System.out.println("TEST");
                Sequence seq = new Sequence(Sequence.PPQ, 4);
                Track track = seq.createTrack();
                int r = 0;
                for (int i = 5; i < 256; i += 4) {
                    r = (int) ((Math.random() * 50) + 1);
                    track.add(makeEvent(144, 1, r, 100, i));
                    track.add(makeEvent(176, 1, 127, 0, i));
                    track.add(makeEvent(128, 1, r, 100, i + 2));
                }
                sequencer.setSequence(seq);

                sequencer.start();
                sequencer.setTempoInBPM(220);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public  MidiEvent makeEvent(int comd, int chan, int one, int two, int tick)
    {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd,chan,one,two);
            event= new MidiEvent(a,tick);
        }
        catch (Exception e)
        {e.printStackTrace();}
        return event;
    }
    class MyDrawPanel extends JPanel implements ControllerEventListener
    {
        boolean msg=false;

        public void controlChange(ShortMessage event)
        {
            msg=true;
            repaint();
        }


        public void paintComponent (Graphics g)
        {

            if (msg)
            {

                Graphics2D g2 =(Graphics2D) g;

                int red = (int) (Math.random() * 250);
                int green = (int) (Math.random() * 250);
                int blue = (int) (Math.random() * 250);
                g.setColor(new Color(red,green,blue));
                int ht = (int) ((Math.random() * 120)+10);
                int wt = (int) ((Math.random() * 120)+10);
                int x= (int) ((Math.random() * 40)+10);
                int y = (int) ((Math.random() * 40)+10);
                for (int i = 0 ; i<256; i++)
                {
                    if ( i % 2==0)
                    {
                        g.fillRect(x, y, ht, wt);
                        msg = false;
                        System.out.println(i + "PRYAMOUGOLNIK");
                    }
                    else
                    {
                     g.fillOval(20,40,30,30);
                        msg = false;
                        System.out.println(i + "OVAL");

                    }
                }
            }
        }


    }

    class Listener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            button.setText("TESTING");
            flag=true;
            System.out.println(flag);

        }
    }
}