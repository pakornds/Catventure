package Event;

import Main.GameManager;

public class Event03 {

    GameManager game;

    public Event03(GameManager game) {
        this.game = game;
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
        game.ui.messageText.setText("จับผิดตัว!");
        game.ui.openTextBox();
    }

    public void touchCatNotSure() {
        game.ui.messageText.setText("หน้าไม่คุ้นเลย...");
        game.ui.openTextBox();
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
