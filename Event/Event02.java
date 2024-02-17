package Event;

import Main.GameManager;

public class Event02 {

    GameManager game;

    public Event02(GameManager game) {
        this.game = game;
    }

    public void moveMovedBush() {
        game.ui.hideObject(10);
        game.ui.showObject(11);
    }

    public void moveBush() {
        game.ui.hideObject(11);
        game.ui.showObject(10);
    }

    public void lookPalm() {

        game.player.hasScratchMark = true;
        game.ui.messageText.setText("เจอรอยข่วนแมว");
        game.ui.openTextBox();
        game.ui.messageText.repaint();
    }

    public void moveMovedPalm() {
        game.ui.hideObject(12);
        game.ui.showObject(13);
    }

    public void movePalm() {
        game.ui.hideObject(13);
        game.ui.showObject(12);
    }

    public void moveMovedWindow2() {
        game.ui.hideObject(14);
        game.ui.showObject(15);
    }

    public void moveWindow2() {
        game.ui.hideObject(15);
        game.ui.showObject(14);
    }

    public void moveMovedWindow() {
        game.ui.hideObject(16);
        game.ui.showObject(17);
    }

    public void moveWindow() {
        game.ui.hideObject(17);
        game.ui.showObject(16);
    }

    public void moveMovedRoof() {
        game.ui.hideObject(18);
        game.ui.showObject(19);
    }

    public void moveRoof() {
        game.ui.hideObject(19);
        game.ui.showObject(18);
    }

    public void lookMovedRoof() {

        game.player.hasNest = true;
        game.ui.messageText.setText("เจอรังนก");
        game.ui.openTextBox();
        game.ui.messageText.repaint();
        moveMovedRoof();
    }

    public void lookMovedBush() {

        game.player.hasNettle = true;
        game.ui.messageText.setText("เจอตำแยแมว");
        game.ui.openTextBox();
        game.ui.messageText.repaint();
    }

    public void cancel() {
        game.ev01.cancel();
    }

    public void nothingHere() {
        game.ev01.nothingHere();
    }
}
