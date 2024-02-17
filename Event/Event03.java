package Event;

import Main.GameManager;

public class Event03 {

    GameManager game;

    public Event03(GameManager game) {
        this.game = game;
    }

    public void moveLookedBox() {
        game.ui.hideObject(21);
        game.ui.showObject(22);
    }

    public void moveBox() {
        game.ui.hideObject(22);
        game.ui.showObject(21);
    }

    public void moveMovedCar() {
        game.ui.hideObject(23);
        game.ui.showObject(24);
        game.ui.messageText.setText("ออกมาแล้ว");
        game.ui.openTextBox();
    }

    public void moveCar() {
        game.ui.hideObject(24);
        game.ui.showObject(23);
        game.ui.messageText.setText("เข้าไปทำไม");
        game.ui.openTextBox();
    }

    public void lookCar() {
        game.player.hasPaws = true;
        game.ui.messageText.setText("เจอรอยเท้าแมว");
        game.ui.openTextBox();
        game.ui.messageText.repaint();
    }

    public void lookNbin() {
        game.player.hasCollar = true;
        game.ui.messageText.setText("เจอปลอกคอแมว");
        game.ui.openTextBox();
        game.ui.messageText.repaint();
    }

    public void moveMovedNbin() {
        game.ui.hideObject(25);
        game.ui.showObject(26);
    }

    public void moveNbin() {
        game.ui.hideObject(26);
        game.ui.showObject(25);
    }

    public void lookNUHUH() {
        game.ui.messageText.setText("มองจากข้างหลังแล้วดูเหมือนแมวคุณ");
        game.ui.openTextBox();
    }

    public void lookCatNotSure() {
        game.ui.messageText.setText("อาจจะใช่แมวของคุณ");
        game.ui.openTextBox();

    }

    public void lookCatSure() {
        game.ui.messageText.setText("คิดว่าน่าจะใช่แมวของคุณ");
        game.ui.openTextBox();
    }

    public void touchNUHUH() {
        game.ui.messageText.setText("คุณจับผิดตัว!");
        game.ui.openTextBox();
        game.sceneChanger.showBadEndScene();
    }

    public void touchCatNotSure() {
        game.ui.messageText.setText("เจอแมวแล้ว!");
        game.ui.openTextBox();
        game.sceneChanger.showGoodEndScene();
    }

    public void touchCatSure() {
        game.ui.messageText.setText("เจอแมวแล้ว!");
        game.ui.openTextBox();
    }

    public void cancel() {
        game.ev01.cancel();
    }

    public void nothingHere() {
        game.ev01.nothingHere();
    }
}
