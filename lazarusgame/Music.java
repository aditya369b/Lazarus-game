package lazarusgame;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {

    private Clip clip;
    private AudioInputStream audio;

    Music() throws IOException {
        try {
            audio = AudioSystem.getAudioInputStream(new File("Resources/Music.mid"));
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        try {
            if (clip != null) {
                clip.open(audio);
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

   // public void playCrush();
    //public void playButton();
    //public void playMove();
    //
    // public void playSquish();


}
