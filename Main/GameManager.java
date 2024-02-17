package Main;

import Event.Event01;
import Event.Event02;
import Event.Event03;

public class GameManager {

    // send game manager to create action handler and player attributes
    public Player player = new Player(this);
    ActionHandler aHandler = new ActionHandler(this);

    // send game manager to create UI and sceneChanger
    public UI ui = new UI(this);
    public SceneChanger sceneChanger = new SceneChanger(this);

    // Sound
    public Music music = new Music(
            "resources\\SoundEffects\\cute-creatures-150622.wav");

    public Music soundEffect = new Music("resources\\SoundEffects\\bed-cover-sheet-blanket-ruffle.wav",
            "resources\\SoundEffects\\big trash can.wav",
            "resources\\SoundEffects\\bushmovement-6986.wav",
            "resources\\SoundEffects\\car-door-closing.wav",
            "resources\\SoundEffects\\car-door-opening.wav",
            "resources\\SoundEffects\\cardboard-box-close-182562.wav",
            "resources\\SoundEffects\\cardboard-box-open-182560.wav",
            "resources\\SoundEffects\\cat-meow-14536.wav",
            "resources\\SoundEffects\\desk-lamp-switch-off.wav",
            "resources\\SoundEffects\\desk-lamp-switch-on.wav",
            "resources\\SoundEffects\\plastic-trash-can-98819.wav",
            "resources\\SoundEffects\\roof.wav",
            "resources\\SoundEffects\\sliding-chair-47711.wav",
            "resources\\SoundEffects\\tree climb.wav",
            "resources\\SoundEffects\\window-open-89994.wav",
            "resources\\SoundEffects\\window-opening-100430.wav");

    // interactions
    public Event01 ev01 = new Event01(this);
    public Event02 ev02 = new Event02(this);
    public Event03 ev03 = new Event03(this);

    public static void main(String[] args) {
        // instantiate game manager
        new GameManager();
    }

    public GameManager() {
        player.setPlayerDefaultStatus();
        playMusic();
    }

    public void playSoundEffects(int i) {
        soundEffect.setFile(i);
        soundEffect.play();
    }

    public void playMusic() {
        music.setFile(0);
        music.play();
        music.loop();
    }

    public void stopMusic() {
        music.stop();
    }
}