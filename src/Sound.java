import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
    public class Sound {
        private AudioInputStream musicStream;
        private AudioInputStream fxStream;
        private Clip music;
        private Clip fx;
        private File audioPath;
        public void playMusic(String path) {
            try {
                audioPath = new File(path);
                if (audioPath.exists()) {
                    musicStream = AudioSystem.getAudioInputStream(audioPath);
                    music = AudioSystem.getClip();
                    music.open(musicStream);
                    music.start();
                    music.loop(Clip.LOOP_CONTINUOUSLY);
                } else {
                    System.out.println("No audio file found...");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
