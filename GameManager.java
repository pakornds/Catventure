public class GameManager {

    // send game manager to create action handler
    ActionHandler aHandler = new ActionHandler(this);
    // send game manager to create UI of the game
    UI ui = new UI(this);

    public static void main(String[] args) {
        // instantiate game manager
        new GameManager();
    }

    public GameManager() {

    }
}