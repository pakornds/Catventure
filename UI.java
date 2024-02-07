import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class UI {
    GameManager game;

    // game's window
    JFrame window;

    // game's text
    public JTextArea messageText;

    // game's backgrounds
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];

    // ArrayList of objects to display or hide
    public ArrayList<JLabel> objectList = new ArrayList<>();

    public UI(GameManager game) {

        this.game = game;

        createMainField();
        createTextBox();

        generateScreen();
        // closeTextBox();
        // openTextBox();

        window.setVisible(true);
    }

    // create the main game's windows
    public void createMainField() {
        window = new JFrame();
        window.setSize(1920, 1080);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setResizable(false);

    }

    public void createTextBox() {
        messageText = new JTextArea(
                "เป้าหมายของเกมนี้คือการกดสิ่งของต่างๆ เพื่อเก็บหาเบาะแสและรวมเพื่อไปตามหาแมวที่หนีจากบ้านเราไป");
        messageText.setBounds(175, 800, 1600, 220);
        messageText.setBackground(new Color(0, 0, 0, 100));

        Insets margins = new Insets(40, 40, 40, 40);

        // Set margins to move the text inside the JTextArea
        messageText.setMargin(margins);

        // text color
        messageText.setForeground(Color.white);

        // only use for displaying text
        messageText.setEditable(false);

        // line-breaking text-wraping
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Layiji MaHaNiYom V1.61", Font.PLAIN, 36));
        window.getContentPane().add(messageText);
        window.revalidate();
        window.repaint();
        messageText.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    closeTextBox();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
    }

    public void closeTextBox() {
        messageText.setVisible(false);
    }

    public void openTextBox() {
        messageText.setVisible(true);
    }

    public void createBackground(int bgNum, String bgFileLocation) {

        // create the space for the background
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(0, 0, 1920, 1080);
        bgPanel[bgNum].setBackground(Color.blue);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        // display an image
        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 1920, 1080);

        ImageIcon bgIcon1 = new ImageIcon(getClass().getClassLoader().getResource(bgFileLocation));
        bgLabel[bgNum].setIcon(bgIcon1);
    }

    public void createObject(int bgNum, int objX, int objY, int objWidth, int objHeight, String objFileLocation,
            String choiceName1, String choiceName2, String choiceName3, String choiceCommand1, String choiceCommand2,
            String choiceCommand3) {

        // create popup window to interact with object
        JPopupMenu popMenu = new JPopupMenu();
        // create popup items
        JMenuItem[] menuItem = new JMenuItem[3];
        menuItem[0] = new JMenuItem(choiceName1);
        menuItem[0].addActionListener(game.aHandler);
        menuItem[0].setActionCommand(choiceCommand1);
        popMenu.add(menuItem[0]);

        menuItem[1] = new JMenuItem(choiceName2);
        menuItem[1].addActionListener(game.aHandler);
        menuItem[1].setActionCommand(choiceCommand2);
        popMenu.add(menuItem[1]);

        menuItem[2] = new JMenuItem(choiceName3);
        menuItem[2].addActionListener(game.aHandler);
        menuItem[2].setActionCommand(choiceCommand3);
        popMenu.add(menuItem[2]);

        // create objects
        JLabel objLabel = new JLabel();
        objLabel.setBounds(objX, objY, objWidth, objHeight);

        ImageIcon objIcon1 = new ImageIcon(
                getClass().getClassLoader().getResource(objFileLocation));
        objLabel.setIcon(objIcon1);

        objLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    popMenu.show(objLabel, e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

        objectList.add(objLabel);

        // put the object wanting to overwritten in the bottom
        bgPanel[bgNum].add(objLabel);
        bgPanel[bgNum].add(bgLabel[bgNum]);
    }

    // New method to show the specified object
    public void showObject(int i) {
        JLabel obj = objectList.get(i);
        obj.setVisible(true);
    }

    // New method to hide the specified object
    public void hideObject(int i) {
        JLabel obj = objectList.get(i);
        obj.setVisible(false);
    }

    // send variables from bg to obj
    public void generateScreen() {

        // SCREEN1
        createBackground(0, "resources\\Bedroom\\TheBedroom.png");
        createObject(0, 550, 380, 400, 400, "resources\\Bedroom\\chair.png", "Look", "Cancel", "", "lookChair",
                "cancel", "");
        createObject(0, 1050, 210, 900, 900, "resources\\Bedroom\\Bed.png", "Look", "Cancel", "", "lookBed",
                "cancel", "");
    }
}
