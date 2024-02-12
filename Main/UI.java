package Main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

    // player's ui
    JPanel lifePanel;
    public ArrayList<JLabel> lifeLabel = new ArrayList<>();
    public int playerMaxAction = 10;
    JPanel inventoryPanel;
    private int MAX_ITEMS = 6;
    private int itemCount;
    JLabel itemLabel[] = new JLabel[MAX_ITEMS];

    // ArrayList of objects to display or hide
    public ArrayList<JLabel> objectList = new ArrayList<>();
    protected HashMap<String, Boolean> firstInteractionMap = new HashMap<>();

    public UI(GameManager game) {

        this.game = game;

        createMainField();
        createTextBox();

        createLifeField();
        createInventoryField();
        generateScene();
        // closeTextBox();
        // openTextBox();

        window.setVisible(true);
    }

    public UI() {
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
                "เป้าหมายของเกมนี้คือการกดสิ่งของต่างๆ เพื่อเก็บหาเบาะแสและรวมเพื่อไปตามหาแมวที่หนีจากบ้านเราไป โดยเมื่อกดของบางอย่างก็จะมีให้เลือกว่าจะทำอะไรกับสิ่งของนั้นโดยจะเป็นการเสีย 1 action รวมถึงการเปลี่ยนแมพด้วย มีแค่ Cancel ที่จะไม่เสียอะไร ดังนั้นคิดให้ดีก่อนจะกดอะไร");
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
        messageText.repaint();
    }

    public void openTextBox() {
        messageText.setVisible(true);
        messageText.repaint();
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
        firstInteractionMap.put(choiceCommand1, true);
        popMenu.add(menuItem[0]);

        menuItem[1] = new JMenuItem(choiceName2);
        menuItem[1].addActionListener(game.aHandler);
        menuItem[1].setActionCommand(choiceCommand2);
        firstInteractionMap.put(choiceCommand2, true);
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

    }

    // New method to show the specified object
    public void showObject(int i) {
        JLabel obj = objectList.get(i);
        obj.setVisible(true);
        obj.repaint();
    }

    // New method to hide the specified object
    public void hideObject(int i) {
        JLabel obj = objectList.get(i);
        obj.setVisible(false);
        obj.repaint();
    }

    public void createChangeMapBtn(int bgNum, int x, int y, int width, int height, String command,
            String arrowFilename) {
        ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFilename));

        JButton arrowButton = new JButton();
        arrowButton.setBounds(x, y, width, height);
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrowIcon);
        arrowButton.addActionListener(game.aHandler);
        arrowButton.setActionCommand(command);
        arrowButton.setBorderPainted(false);

        bgPanel[bgNum].add(arrowButton);
    }

    public void createLifeField() {
        int LIFE_PANEL_X = 30;
        int LIFE_PANEL_Y = 15;
        int LIFE_PANEL_WIDTH = 400;
        int LIFE_PANEL_HEIGHT = 200;
        lifePanel = new JPanel();
        lifePanel.setBounds(LIFE_PANEL_X, LIFE_PANEL_Y, LIFE_PANEL_WIDTH, LIFE_PANEL_HEIGHT);
        lifePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        lifePanel.setOpaque(false);
        window.add(lifePanel);

        ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("resources\\heart.png"));
        Image image = lifeIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        lifeIcon = new ImageIcon(image);

        int i = 0;
        while (i < playerMaxAction) {
            lifeLabel.add(new JLabel());
            lifeLabel.get(i).setIcon(lifeIcon);
            lifePanel.add(lifeLabel.get(i));
            i++;
        }

    }

    public void createInventoryField() {
        int INVENTORY_PANEL_X = 1470;
        int INVENTORY_PANEL_Y = 15;
        int INVENTORY_PANEL_WIDTH = 400;
        int INVENTORY_PANEL_HEIGHT = 50;
        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(INVENTORY_PANEL_X, INVENTORY_PANEL_Y, INVENTORY_PANEL_WIDTH, INVENTORY_PANEL_HEIGHT);
        inventoryPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        inventoryPanel.setOpaque(false);

        window.add(inventoryPanel);
    }

    public void createInventoryItem(int idx, String itemFileLocation) {
        itemLabel[idx] = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(itemFileLocation));
        Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        icon = new ImageIcon(image);
        itemLabel[idx].setIcon(icon);
        inventoryPanel.add(itemLabel[idx]);
    }

    public void storeItem() {
        if (itemCount < MAX_ITEMS) {
            itemCount++;
            System.out.println("Stored item, Total items: " + itemCount);
        } else {
            System.out.println("Store is full, cannot store more items");
        }
    }

    public void discardItem() {
        if (itemCount > 0) {
            itemCount--;
            System.out.println("Discarded item, Total items : " + itemCount);
        } else {
            System.out.println("Store is empty, no items to discard");
        }
    }

    public int getItemCount() {
        return itemCount;
    }

    // send variables from bg to obj
    public void generateScene() {

        // SCENE 0

        createBackground(0, "resources\\Bedroom\\TheBedroom.png");
        createChangeMapBtn(0, 0, 450, 100, 100, "goScene1", "resources\\arrowLeft.png");
        createObject(0, 550, 380, 350, 400, "resources\\Bedroom\\movedChair.png", "Look", "Move", "Cancel",
                "lookMovedChair",
                "moveMovedChair", "cancel");
        hideObject(0);
        createObject(0, 550, 380, 400, 400, "resources\\Bedroom\\chair.png", "Look", "Move", "Cancel", "lookChair",
                "moveChair", "cancel");
        createObject(0, 1050, 210, 900, 600, "resources\\Bedroom\\movedBed.png", "Look", "Move", "Cancel",
                "lookMovedBed",
                "moveMovedSheet", "cancel");
        hideObject(2);
        createObject(0, 1050, 210, 900, 600, "resources\\Bedroom\\Bed.png", "Look", "Move", "Cancel", "lookBed",
                "moveSheet", "cancel");
        bgPanel[0].add(bgLabel[0]);

        // SCENE 1

        createBackground(1, "resources\\Bedroom\\TheBedroom.png");
        createChangeMapBtn(1, 0, 450, 100, 100, "goScene2", "resources\\arrowLeft.png");
        createChangeMapBtn(1, 1800, 450, 100, 100, "goScene0", "resources\\arrowRight.png");
        createObject(1, 550, 380, 400, 400, "resources\\Bedroom\\chair.png", "Look", "Move", "Cancel", "lookChair",
                "moveChair", "cancel");
        createObject(1, 1050, 210, 900, 900, "resources\\Bedroom\\Bed.png", "Look", "Move", "Cancel", "lookBed",
                "moveSheet", "cancel");
        bgPanel[1].add(bgLabel[1]);

        // SCENE 2
        createBackground(2, "resources\\Neighborhood\\Background.png");
        createChangeMapBtn(2, 1800, 450, 100, 100, "goScene1",
                "resources\\arrowRight.png");
        createObject(
                2, 550, 380, 500, 500, "resources\\Neighborhood\\Cat.png", "Look", "Touch",
                "Cancel", "lookCat",
                "touchCat", "cancel");
        bgPanel[2].add(bgLabel[2]);
    }
}
