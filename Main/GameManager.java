package Main;

import Event.Event01;

public class GameManager {
    // send game manager to create action handler
    ActionHandler aHandler = new ActionHandler(this);
    // send game manager to create UI of the game
    public UI ui = new UI(this);
    public SceneChanger sceneChanger = new SceneChanger(this);

    public Event01 ev01 = new Event01(this);

    public static void main(String[] args) {
        // instantiate game manager
        new GameManager();
    }

    public GameManager() {

    }
}