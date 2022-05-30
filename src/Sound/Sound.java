package Sound;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {
    public Clip soundclip;
    private long position;
    public String path;

    Sound(String path) {
        this.path = path;
        try {
            soundclip = AudioSystem.getClip();
            soundclip.open(AudioSystem.getAudioInputStream(new File(path)));
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
        position = 0;
    }

    public void restart() {
        position = 0;
        soundclip.setMicrosecondPosition(0);
        soundclip.start();
    }

    public void stop() {
        position = soundclip.getMicrosecondPosition();
        soundclip.stop();
    }
    public void resume() {
        if (position != 0) {
            soundclip.start();
        }
    }

//    public void pause() {
//        position = soundclip.getMicrosecondPosition();
//        soundclip.stop();
//    }
//
//    public void resume() {
//        if (position != 0) {
//            soundclip.setMicrosecondPosition(position);
//            soundclip.start();
//        }
//    }
}
