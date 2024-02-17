package Main;

import javax.swing.JLabel;

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

    public int updatePlayerDifficulty(String difficulty) {
        if (difficulty.equals("Easy")) {
            playerAction = 30;
        } else if (difficulty.equals("Medium")) {
            playerAction = 20;
        } else if (difficulty.equals("Hard")) {
            playerAction = 10;
        }
        // game.ui.removeLifeField();
        // game.ui.createLifeField(playerMaxAction);
        updatePlayerStatus();

        return playerAction;
    }

    public void updatePlayerStatus() {

        for (JLabel label : game.ui.lifeLabel) {
            label.setVisible(false);
        }

        int actionCount = playerAction - 1;

        // check for game over
        if (actionCount < 0) {
            game.sceneChanger.showGameoverScene();
        }

        // show action
        while (actionCount >= 0) {
            game.ui.lifeLabel.get(actionCount).setVisible(true);
            actionCount--;
        }
    }
}
