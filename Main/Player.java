package Main;

public class Player {
    GameManager game;

    public int playerMaxAction;
    public int playerAction;

    public boolean hasCatHair;
    public boolean hasScratchMark;
    public boolean hasToy;
    public boolean hasSnack;
    public boolean hasNest;
    public boolean hasCollar;
    public boolean hasPaws;
    public boolean hasNettle;

    public Player(GameManager game) {
        this.game = game;
    }

    public void setPlayerDefaultStatus() {
        playerMaxAction = game.ui.playerMaxAction;
        playerAction = playerMaxAction;

        hasCatHair = false;
        hasScratchMark = false;
        hasToy = false;
        hasSnack = false;
        hasNest = false;
        hasCollar = false;
        hasPaws = false;
        hasNettle = false;

        updatePlayerStatus();
    }

    public void updatePlayerDifficulty(String difficulty) {
        if (difficulty.equals("Easy")) {
            playerMaxAction = 30;
            playerAction = playerMaxAction;
        } else if (difficulty.equals("Medium")) {
            playerMaxAction = 20;
            playerAction = playerMaxAction;
        } else if (difficulty.equals("Hard")) {
            playerMaxAction = 10;
            playerAction = playerMaxAction;
        }
        // game.ui.removeLifeField();
        game.ui.createLifeField(playerMaxAction);
        updatePlayerStatus();
    }

    public void updatePlayerStatus() {
        System.out.println("Player Max Action updated to: " + playerMaxAction);
        System.out.println("Player Action updated to: " + playerAction);
        int i = 0;
        while (i < playerMaxAction) {
            game.ui.lifeLabel.get(i).setVisible(false);
            i++;
        }

        int actionCount = playerAction - 1;

        // check for game over
        if (actionCount < 0) {
            game.sceneChanger.showGameoverScene();
        }

        // show action
        while (actionCount >= 0) {
            System.out.println(actionCount);
            game.ui.lifeLabel.get(actionCount).setVisible(true);
            actionCount--;
        }
    }
}
