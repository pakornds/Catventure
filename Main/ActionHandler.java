package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    GameManager game;

    public ActionHandler(GameManager game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();

        switch (yourChoice) {
            case "lookChair":
                game.ui.messageText.setText("เจอรอยข่วนแมว");
                game.ui.openTextBox();
                break;
            case "cancel":
                game.ui.messageText.setText("ไม่ดูให้ครบก่อนหรอ");
                game.ui.openTextBox();
                break;
            case "lookBed":
                game.ui.messageText.setText("เจอขนแมว");
                game.ui.openTextBox();
                break;
        }
    }

}
