package Event;

import Main.GameManager;

public class Event01 {

    GameManager game;

    public Event01(GameManager game) {
        this.game = game;
    }

    // public void lookChair() {
    // game.ui.messageText.setText("เจอรอยข่วนแมว");
    // game.player.hasScratchMark = true;
    // game.ui.openTextBox();
    // game.ui.messageText.repaint();
    // }

    public void lookMovedChair() {
        game.ui.messageText.setText("เจอของเล่นแมว");
        game.player.hasToy = true;
        game.ui.openTextBox();
        game.ui.messageText.repaint();
    }

    public void moveChair() {
        game.ui.hideObject(1);
        game.ui.showObject(0);
    }

    public void moveMovedChair() {
        game.ui.hideObject(0);
        game.ui.showObject(1);
    }

    public void moveLamp() {
        game.ui.hideObject(3);
        game.ui.showObject(2);
    }

    public void moveLookedLamp() {
        game.ui.hideObject(2);
        game.ui.showObject(3);
    }

    public void lookMovedBin() {
        game.ui.messageText.setText("เจอขนมแมว");
        game.player.hasSnack = true;
        game.ui.openTextBox();
        game.ui.messageText.repaint();
    }

    public void moveMovedBin() {
        game.ui.hideObject(4);
        game.ui.showObject(5);
    }

    public void moveBin() {
        game.ui.hideObject(5);
        game.ui.showObject(4);
    }

    public void moveMovedCarpet() {
        game.ui.hideObject(6);
        game.ui.showObject(7);
    }

    public void moveCarpet() {
        game.ui.hideObject(7);
        game.ui.showObject(6);
    }

    public void lookMovedBed() {

        game.player.hasCatHair = true;
        game.ui.messageText.setText("เจอขนแมว");
        game.ui.openTextBox();
        game.ui.messageText.repaint();
    }

    public void moveSheet() {
        game.ui.hideObject(9);
        game.ui.showObject(8);
    }

    public void moveMovedSheet() {
        game.ui.hideObject(8);
        game.ui.showObject(9);
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
