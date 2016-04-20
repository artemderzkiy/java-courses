import javafx.scene.shape.Box;

import java.awt.*;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.*;
import javax.sound.midi.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Exception;
import java.lang.String;
import java.util.*;
import java.util.ArrayList;

public class BeatBox
{
    JPanel panel;
    JFrame frame;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    ArrayList <JCheckBox> checkBoxList;
    String [] instrumentsNames =  {"Bass Drum","Closed Hi-Hat","Open Hi-Hat","Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
    int [] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    public static void main (String[] args)
    {
        new BeatBox().buildGui();
    }

    public void buildGui()
    {
        frame = new JFrame("CYBER BEATBOX");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        checkBoxList = new ArrayList<JCheckBox>();


        javax.swing.Box buttonBox = new javax.swing.Box(BoxLayout.Y_AXIS);


        JButton start = new JButton("START");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("STOP");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("TEMPO UP");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("TEMPO DOWN");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        javax.swing.Box nameBox = new javax.swing.Box(BoxLayout.Y_AXIS);
        for (String ins : instrumentsNames)
        {
            nameBox.add(new Label(ins));
        }

        background.add(BorderLayout.EAST,buttonBox);
        background.add(BorderLayout.WEST,nameBox);

        frame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16,16);
        grid.setVgap(1);
        grid.setVgap(2);
        panel = new JPanel(grid);
        background.add(BorderLayout.CENTER,panel);

        for (int i = 0 ; i<256; i++)
        {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxList.add(c);
            panel.add(c);
        }

        setUpMidi();
        frame.setBounds(50,50,400,400);
        frame.pack();
        frame.setVisible(true);


    }

    public void setUpMidi()
    {
        try
        {
         sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ,4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(100);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void buildTrackStart()
    {
        int [] trackList = null;
        sequence.deleteTrack(track);
        track=sequence.createTrack();

        for (int i=0;i<16;i++)
        {
            trackList = new int[16];
            int key = instruments[i];
            for (int j=0 ;j<16;j++)
            {
                JCheckBox jc = (JCheckBox)checkBoxList.get(j+(16*i));
                if (jc.isSelected())
                {
                    trackList[j]=key;
                }
                else
                {
                    trackList[j]=0;
                }
            }
            makeTracks(trackList);
            track.add(makeEvent(176,1,127,0,16));
        }
        track.add(makeEvent(192,9,1,0,15));
        try
        {
         sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(100);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    class MyStartListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            buildTrackStart();
        }
    }

    class MyStopListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            sequencer.stop();
        }
    }
    class MyDownTempoListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoInBPM((float)(tempoFactor*0.8));
        }
    }

    class MyUpTempoListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoInBPM((float)(tempoFactor*1.3));
        }
    }

    public void makeTracks(int [] list)
    {
        for (int i=0; i<16; i++)
        {
            int key = list[i];
            if (key!=0)
            {
                track.add(makeEvent(144,9,key,100,i));
                track.add(makeEvent(128,9,key,100,i+1));
            }
        }
    }

    public MidiEvent makeEvent(int comd,int chan, int one, int two, int tick)
    {
        MidiEvent event = null;
        try
        {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd,chan,one,two);
            event = new MidiEvent(a,tick);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return event;
    }

}
