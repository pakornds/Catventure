package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

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
        game.ui.bgPanel[2].setVisible(false);
        game.ui.messageText.setText("คุณตามหาน้องแมวช้าเกินไป!");
        game.ui.openTextBox();

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.ui.closeTextBox();
                showScene0();
            }
        });

        timer.setRepeats(false);
        timer.start();

        Timer timer2 = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showScene1();
            }
        });

        timer2.setRepeats(false);
        timer2.start();

        Timer timer3 = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showScene2();
            }
        });

        timer3.setRepeats(false);
        timer3.start();

        Timer timer4 = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        timer4.setRepeats(false);
        timer4.start();
    }
}
