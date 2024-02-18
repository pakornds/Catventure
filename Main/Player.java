package Main;

import javax.swing.JLabel;

/**
 * The Player class represents a player in the game.
 * It keeps track of the player's actions, items, and status.
 */
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

    /**
     * Constructs a Player object with the specified GameManager.
     * 
     * @param game the GameManager object associated with the player
     */
    public Player(GameManager game) {
        this.game = game;
    }

    /**
     * Sets the player's default status.
     * The player's maximum action count is set based on the game's UI.
     * All item flags are set to false.
     * The player's status is updated.
     */
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

    /**
     * Updates the player's difficulty level and action count based on the specified
     * difficulty.
     * The player's status is updated.
     * 
     * @param difficulty the difficulty level ("Easy", "Medium", or "Hard")
     * @return the updated player's action count
     */
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

    /**
     * Updates the player's status based on the current action count.
     * The life labels in the game's UI are updated accordingly.
     */
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
