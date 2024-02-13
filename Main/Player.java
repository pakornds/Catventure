package Main;

public class Player {
    GameManager game;

    public int playerMaxAction;
    public int playerAction;

    public boolean hasCatHair;
    public boolean hasScratchMark;

    public Player(GameManager game) {
        this.game = game;
    }

    public void setPlayerDefaultStatus() {
        playerMaxAction = game.ui.playerMaxAction;
        playerAction = playerMaxAction;

        hasCatHair = false;
        hasScratchMark = false;

        updatePlayerStatus();
    }

    public void updatePlayerStatus() {
        int i = 0;
        while (i < playerMaxAction) {
            game.ui.lifeLabel.get(i).setVisible(false);
            i++;
        }

        int actionCount = playerAction - 1;
        if (actionCount < 0) {
            game.sceneChanger.showGameoverScene();
        }
        while (actionCount >= 0) {
            game.ui.lifeLabel.get(actionCount).setVisible(true);
            actionCount--;
        }
    }
}
