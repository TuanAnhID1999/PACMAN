package manager;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class PlayerWav {
    private Clip clip;

    public PlayerWav(String fileName) {
        try {
            URL url = getClass().getResource("/res/raw/" + fileName + ".wav");
            AudioInputStream input = AudioSystem.getAudioInputStream(url);

            clip = AudioSystem.getClip();
            clip.open(input);
        } catch (LineUnavailableException
                | UnsupportedAudioFileException
                | IOException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip.isOpen() && !clip.isRunning()) {
            clip.start();
        }
    }

    public void stop() {
        clip.stop();
    }

    public void loop(int count) {               // lap vo han lan => count = -1  <=> Clip.LOOP_CONTINUOUSLY;
        clip.loop(count);
    }
}
