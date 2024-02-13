package Main;

import javax.swing.SwingUtilities;

public class SceneChanger {
    GameManager game;

    public SceneChanger(GameManager game) {
        this.game = game;
    }

    public void showScene0() {
        game.ui.bgPanel[0].setVisible(true);
        game.ui.bgPanel[1].setVisible(false);
        game.ui.bgPanel[2].setVisible(false);
        game.ui.messageText.setText("คุณมาที่ห้องนอน ลืมหาอะไรที่นี่หรือเปล่า?");
        game.ui.openTextBox();
    }

    public void showScene1() {
        game.ui.bgPanel[0].setVisible(false);
        game.ui.bgPanel[1].setVisible(true);
        game.ui.bgPanel[2].setVisible(false);
        game.ui.messageText.setText("คุณมาที่หน้าบ้าน มีอะไรน่าสนใจบ้าง?");
        game.ui.openTextBox();
    }

    public void showScene2() {
        game.ui.bgPanel[0].setVisible(false);
        game.ui.bgPanel[1].setVisible(false);
        game.ui.bgPanel[2].setVisible(true);
        game.ui.messageText.setText("คุณมาที่ละแวกบ้าน นั่นใช่น้องแมวหรือเปล่า!?");
        game.ui.openTextBox();
    }

    public void showEndScene() {
        game.ui.bgPanel[0].setVisible(false);
        game.ui.bgPanel[1].setVisible(false);
        game.ui.bgPanel[2].setVisible(true);
        game.ui.messageText.setText("คุณมาที่ละแวกบ้าน นั่นใช่น้องแมวหรือเปล่า!?");
        game.ui.openTextBox();
    }

    public void showGameoverScene() {
        game.ui.bgPanel[0].setVisible(false);
        game.ui.bgPanel[1].setVisible(false);
        game.ui.bgPanel[2].setVisible(true);
        game.ui.messageText.setText("คุณตามหาน้องแมวช้าเกินไป!");
        game.ui.openTextBox();
        SwingUtilities.invokeLater(() -> {
            try {
                Thread.sleep(3000); // 3 seconds delay
                System.exit(0);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
    }
}
