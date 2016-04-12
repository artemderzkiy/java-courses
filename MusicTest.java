import java.lang.Exception;
import java.util.*;
import javax.sound.midi.*;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import static java.lang.System.out;

public class MusicTest

{
    public void play ()
    {
        try
        {
            Sequencer player = MidiSystem.getSequencer();
out.println("DOBAVLEN");
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,44,100);
            MidiEvent noteOn = new MidiEvent(a,1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            a.setMessage(128,1,44,100);
            MidiEvent noteOff = new MidiEvent(b,16);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();


        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }


    }

    public static void main (String[] args)
    {
        MusicTest mini = new MusicTest();
        mini.play();
    }
}