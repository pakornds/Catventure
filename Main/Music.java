package Main;

import java.util.ArrayList;
import java.util.Arrays;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.net.URL;

public class Music {
    ArrayList<String> musicPathList;
    ArrayList<URL> musicList;

    Clip clip;

    public Music(String... musicPaths) {
        musicPathList = new ArrayList<>(Arrays.asList(musicPaths));
        musicList = new ArrayList<>();
        for (String musicPath : musicPathList) {
            URL url = getClass().getClassLoader().getResource(musicPath);
            if (url != null) {
                musicList.add(url);
            } else {
            }
        }
    }

    public Music() {
    }

    public void setFile(int i) {
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(musicList.get(i));
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}
