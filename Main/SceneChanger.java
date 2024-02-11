package Main;

public class SceneChanger {
    GameManager game;

    public SceneChanger(GameManager game) {
        this.game = game;
    }

    public void showScene0() {
        game.ui.bgPanel[0].setVisible(true);
        game.ui.bgPanel[1].setVisible(false);
        game.ui.messageText.setText("คุณมาที่ห้องนอน ลืมหาอะไรที่นี่หรือเปล่า?");
        game.ui.openTextBox();
    }

    public void showScene1() {
        game.ui.bgPanel[0].setVisible(false);
        game.ui.bgPanel[1].setVisible(true);
        game.ui.messageText.setText("คุณมาที่หน้าบ้าน มีอะไรน่าสนใจบ้าง?");
        game.ui.openTextBox();
    }
}
