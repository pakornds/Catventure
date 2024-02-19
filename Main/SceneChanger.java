package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        game.ui.window.dispose();
        game.stopMusic();

        new GameManager();
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
                game.ui.bgPanel[17].setVisible(false);

                // Start the next timer within this ActionListener
                Timer timer2 = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        game.ui.bgPanel[7].setVisible(false);
                        game.ui.bgPanel[8].setVisible(true);
                        game.ui.bgPanel[17].setVisible(false);

                        // Start the third timer within this ActionListener
                        Timer timer3 = new Timer(6000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                game.ui.bgPanel[7].setVisible(false);
                                game.ui.bgPanel[8].setVisible(false);
                                game.ui.bgPanel[17].setVisible(true);
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
                game.ui.bgPanel[14].setVisible(false);
                Timer timer2 = new Timer(4000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        game.ui.bgPanel[3].setVisible(false);
                        game.ui.bgPanel[4].setVisible(true);
                        game.ui.bgPanel[5].setVisible(false);
                        game.ui.bgPanel[6].setVisible(false);
                        game.ui.bgPanel[14].setVisible(false);

                        Timer timer3 = new Timer(4000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                game.ui.bgPanel[3].setVisible(false);
                                game.ui.bgPanel[4].setVisible(false);
                                game.ui.bgPanel[5].setVisible(true);
                                game.ui.bgPanel[6].setVisible(false);
                                game.ui.bgPanel[14].setVisible(false);

                                Timer timer4 = new Timer(4000, new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        game.ui.bgPanel[3].setVisible(false);
                                        game.ui.bgPanel[4].setVisible(false);
                                        game.ui.bgPanel[5].setVisible(false);
                                        game.ui.bgPanel[6].setVisible(true);
                                        game.ui.bgPanel[14].setVisible(false);

                                        Timer timer5 = new Timer(6000, new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {

                                                game.ui.bgPanel[3].setVisible(false);
                                                game.ui.bgPanel[4].setVisible(false);
                                                game.ui.bgPanel[5].setVisible(false);
                                                game.ui.bgPanel[6].setVisible(false);
                                                game.ui.bgPanel[14].setVisible(true);

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
                game.ui.bgPanel[15].setVisible(false);
                Timer timer2 = new Timer(4000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        game.ui.bgPanel[9].setVisible(false);
                        game.ui.bgPanel[10].setVisible(true);
                        game.ui.bgPanel[11].setVisible(false);
                        game.ui.bgPanel[12].setVisible(false);
                        game.ui.bgPanel[15].setVisible(false);
                        Timer timer3 = new Timer(4000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                game.ui.bgPanel[9].setVisible(false);
                                game.ui.bgPanel[10].setVisible(false);
                                game.ui.bgPanel[11].setVisible(true);
                                game.ui.bgPanel[12].setVisible(false);
                                game.ui.bgPanel[15].setVisible(false);
                                Timer timer4 = new Timer(4000, new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        game.ui.bgPanel[9].setVisible(false);
                                        game.ui.bgPanel[10].setVisible(false);
                                        game.ui.bgPanel[11].setVisible(false);
                                        game.ui.bgPanel[12].setVisible(true);
                                        game.ui.bgPanel[15].setVisible(false);
                                        Timer timer5 = new Timer(6000, new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                game.ui.bgPanel[9].setVisible(false);
                                                game.ui.bgPanel[10].setVisible(false);
                                                game.ui.bgPanel[11].setVisible(false);
                                                game.ui.bgPanel[12].setVisible(false);
                                                game.ui.bgPanel[15].setVisible(true);
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

    public void showHappyEndScene() {
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
                game.ui.bgPanel[13].setVisible(false);
                game.ui.bgPanel[11].setVisible(false);
                game.ui.bgPanel[12].setVisible(false);
                game.ui.bgPanel[16].setVisible(false);
                Timer timer2 = new Timer(4000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        game.ui.bgPanel[9].setVisible(false);
                        game.ui.bgPanel[13].setVisible(true);
                        game.ui.bgPanel[11].setVisible(false);
                        game.ui.bgPanel[12].setVisible(false);
                        game.ui.bgPanel[16].setVisible(false);

                        Timer timer3 = new Timer(4000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                game.ui.bgPanel[9].setVisible(false);
                                game.ui.bgPanel[13].setVisible(false);
                                game.ui.bgPanel[11].setVisible(true);
                                game.ui.bgPanel[12].setVisible(false);
                                game.ui.bgPanel[16].setVisible(false);

                                Timer timer4 = new Timer(4000, new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        game.ui.bgPanel[9].setVisible(false);
                                        game.ui.bgPanel[13].setVisible(false);
                                        game.ui.bgPanel[11].setVisible(false);
                                        game.ui.bgPanel[12].setVisible(true);
                                        game.ui.bgPanel[16].setVisible(false);

                                        Timer timer5 = new Timer(6000, new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                game.ui.bgPanel[9].setVisible(false);
                                                game.ui.bgPanel[13].setVisible(false);
                                                game.ui.bgPanel[11].setVisible(false);
                                                game.ui.bgPanel[12].setVisible(false);
                                                game.ui.bgPanel[16].setVisible(true);
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
