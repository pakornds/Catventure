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

    public void showTitleScreen() {
        for (int i = 0; i < game.ui.bgPanel.length - 1; i++) {
            if (game.ui.bgPanel[i] != null) {
                game.ui.bgPanel[i].setVisible(false);
            }
        }
        game.ui.bgPanel[19].setVisible(true);
        game.ui.messageText.setText(
                "(ตั้ง Display scale เป็น 100% !!)\n เป้าหมายของเกมนี้คือการกดสิ่งของต่างๆ เพื่อเก็บหาเบาะแสและรวมเพื่อไปตามหาแมวที่หนีจากบ้านเราไป โดยเมื่อกดของบางอย่างก็จะมีให้เลือกว่าจะทำอะไรกับสิ่งของนั้นและจะเสีย 1 action รวมถึงการเปลี่ยนแมพ (สามารถดูจำนวนการกดได้ที่ด้านซ้ายบน) Cancel จะไม่เสีย action และสามารถดูของที่อยู่ในตัวได้ที่มุมขวาบน (กดที่กล่องข้อความเพื่อปิด)");
    }

    public void showGameoverScene() {
        game.ui.lifePanel.setVisible(false);
        game.ui.inventoryPanel.setVisible(false);
        game.ui.bgPanel[0].setVisible(false);
        game.ui.bgPanel[1].setVisible(false);
        game.ui.bgPanel[2].setVisible(false);
        game.ui.messageText.setText("คุณตามหาน้องแมวช้าเกินไป!");
        game.ui.openTextBox();

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.ui.closeTextBox();
                game.music.stop();
                game.ui.bgPanel[7].setVisible(true);
                game.ui.bgPanel[8].setVisible(false);

                // Start the next timer within this ActionListener
                Timer timer2 = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        game.ui.bgPanel[7].setVisible(false);
                        game.ui.bgPanel[8].setVisible(true);

                        // Start the third timer within this ActionListener
                        Timer timer3 = new Timer(6000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                showTitleScreen();
                            }
                        });

                        timer3.setRepeats(false);
                        timer3.start();
                    }
                });

                timer2.setRepeats(false);
                timer2.start();
            }
        });

        timer.setRepeats(false);
        timer.start();
    }

    public void showBadEndScene() {
        game.ui.lifePanel.setVisible(false);
        game.ui.inventoryPanel.setVisible(false);
        game.ui.bgPanel[0].setVisible(false);
        game.ui.bgPanel[1].setVisible(false);
        game.ui.bgPanel[2].setVisible(false);
        game.ui.openTextBox();

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.ui.closeTextBox();
                game.music.stop();
                game.ui.bgPanel[3].setVisible(true);
                game.ui.bgPanel[4].setVisible(false);
                game.ui.bgPanel[5].setVisible(false);
                game.ui.bgPanel[6].setVisible(false);
                Timer timer2 = new Timer(4000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        game.ui.bgPanel[3].setVisible(false);
                        game.ui.bgPanel[4].setVisible(true);
                        game.ui.bgPanel[5].setVisible(false);
                        game.ui.bgPanel[6].setVisible(false);

                        Timer timer3 = new Timer(4000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                game.ui.bgPanel[3].setVisible(false);
                                game.ui.bgPanel[4].setVisible(false);
                                game.ui.bgPanel[5].setVisible(true);
                                game.ui.bgPanel[6].setVisible(false);

                                Timer timer4 = new Timer(4000, new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        game.ui.bgPanel[3].setVisible(false);
                                        game.ui.bgPanel[4].setVisible(false);
                                        game.ui.bgPanel[5].setVisible(false);
                                        game.ui.bgPanel[6].setVisible(true);

                                        Timer timer5 = new Timer(6000, new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                showTitleScreen();
                                            }
                                        });

                                        timer5.setRepeats(false);
                                        timer5.start();
                                    }
                                });

                                timer4.setRepeats(false);
                                timer4.start();
                            }
                        });

                        timer3.setRepeats(false);
                        timer3.start();
                    }
                });

                timer2.setRepeats(false);
                timer2.start();
            }
        });

        timer.setRepeats(false);
        timer.start();

    }

    public void showGoodEndScene() {
        game.ui.lifePanel.setVisible(false);
        game.ui.inventoryPanel.setVisible(false);
        game.ui.bgPanel[0].setVisible(false);
        game.ui.bgPanel[1].setVisible(false);
        game.ui.bgPanel[2].setVisible(false);
        game.ui.openTextBox();

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.ui.closeTextBox();
                game.music.stop();
                game.ui.bgPanel[9].setVisible(true);
                game.ui.bgPanel[10].setVisible(false);
                game.ui.bgPanel[11].setVisible(false);
                game.ui.bgPanel[12].setVisible(false);
                Timer timer2 = new Timer(4000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        game.ui.bgPanel[9].setVisible(false);
                        game.ui.bgPanel[10].setVisible(true);
                        game.ui.bgPanel[11].setVisible(false);
                        game.ui.bgPanel[12].setVisible(false);

                        Timer timer3 = new Timer(4000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                game.ui.bgPanel[9].setVisible(false);
                                game.ui.bgPanel[10].setVisible(false);
                                game.ui.bgPanel[11].setVisible(true);
                                game.ui.bgPanel[12].setVisible(false);

                                Timer timer4 = new Timer(4000, new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        game.ui.bgPanel[9].setVisible(false);
                                        game.ui.bgPanel[10].setVisible(false);
                                        game.ui.bgPanel[11].setVisible(false);
                                        game.ui.bgPanel[12].setVisible(true);

                                        Timer timer5 = new Timer(6000, new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                showTitleScreen();
                                            }
                                        });

                                        timer5.setRepeats(false);
                                        timer5.start();
                                    }
                                });

                                timer4.setRepeats(false);
                                timer4.start();
                            }
                        });

                        timer3.setRepeats(false);
                        timer3.start();
                    }
                });

                timer2.setRepeats(false);
                timer2.start();
            }
        });

        timer.setRepeats(false);
        timer.start();

    }
}
