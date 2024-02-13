package Event;

import Main.GameManager;

public class Event01 {

    GameManager game;

    public Event01(GameManager game) {
        this.game = game;
    }

    public void lookChair() {
        game.ui.messageText.setText("เจอรอยข่วนแมว");
        game.player.hasScratchMark = true;
        game.ui.openTextBox();
        game.ui.messageText.repaint();
    }

    public void moveChair() {
        game.ui.hideObject(1);
        game.ui.showObject(0);
    }

    public void moveSheet() {

        game.player.hasCatHair = true;
        game.player.updatePlayerStatus();
        game.ui.messageText.setText("เจอขนแมว");
        game.ui.openTextBox();
        game.ui.messageText.repaint();
        game.ui.hideObject(3);
        game.ui.showObject(2);
    }

    public void moveMovedChair() {
        game.ui.hideObject(0);
        game.ui.showObject(1);
    }

    public void moveMovedSheet() {
        game.ui.hideObject(2);
        game.ui.showObject(3);
    }

    public void cancel() {
        game.ui.messageText.setText("ไม่ดูให้ครบก่อนหรอ");
        game.ui.openTextBox();
        game.ui.messageText.repaint();
    }

    public void nothingHere() {
        game.ui.messageText.setText("ไม่มีอะไรตรงนี้");
        game.ui.openTextBox();
        game.ui.messageText.repaint();
    }
}
