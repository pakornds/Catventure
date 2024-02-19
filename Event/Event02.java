package Event;

import Main.GameManager;

public class Event02 {

    GameManager game;

    public Event02(GameManager game) {
        this.game = game;
    }

    public void moveMovedBush() {
        game.ui.hideObject(20);
        game.ui.showObject(21);
        game.ui.hideObject(22);
        game.ui.showObject(23);
    }

    public void moveBush() {
        game.ui.hideObject(21);
        game.ui.showObject(20);
        game.ui.hideObject(23);
        game.ui.showObject(22);
    }

    public void lookPalm() {

        game.player.hasScratchMark = true;
        game.ui.messageText.setText("เจอรอยข่วนแมว");
        game.ui.openTextBox();
        game.ui.messageText.repaint();
    }

    public void moveMovedPalm() {

        game.ui.hideObject(24);
        game.ui.showObject(25);
        game.ui.hideObject(26);
        game.ui.showObject(27);
    }

    public void movePalm() {

        game.ui.hideObject(25);
        game.ui.showObject(24);
        game.ui.hideObject(27);
        game.ui.showObject(26);
    }

    public void moveMovedWindow2() {

        game.ui.hideObject(28);
        game.ui.showObject(29);
        game.ui.hideObject(30);
        game.ui.showObject(31);
    }

    public void moveWindow2() {

        game.ui.hideObject(29);
        game.ui.showObject(28);
        game.ui.hideObject(31);
        game.ui.showObject(30);
    }

    public void moveMovedWindow() {

        game.ui.hideObject(32);
        game.ui.showObject(33);
        game.ui.hideObject(34);
        game.ui.showObject(35);
    }

    public void moveWindow() {

        game.ui.hideObject(33);
        game.ui.showObject(32);
        game.ui.hideObject(35);
        game.ui.showObject(34);
    }

    public void moveMovedRoof() {

        game.ui.hideObject(36);
        game.ui.showObject(37);
        game.ui.hideObject(38);
        game.ui.showObject(39);
    }

    public void moveRoof() {

        game.ui.hideObject(37);
        game.ui.showObject(36);
        game.ui.hideObject(39);
        game.ui.showObject(38);
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
