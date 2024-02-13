package Main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class UI {
    GameManager game;

    // game's window
    JFrame window;

    // game's text
    public JPanel textBoxPanel;
    public JTextArea messageText;

    // game's backgrounds
    public JPanel bgPanel[] = new JPanel[15];
    public JLabel bgLabel[] = new JLabel[15];

    // player's ui
    JPanel lifePanel;
    public ArrayList<JLabel> lifeLabel = new ArrayList<>();
    public int playerMaxAction = 10;
    JPanel inventoryPanel;
    private int MAX_ITEMS = 6;
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
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setUndecorated(true);

        // Add KeyListener to the JFrame
        // Register Escape key globally
        InputMap inputMap = window.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke("ESCAPE"), "escapeKey");
        window.getRootPane().getActionMap().put("escapeKey", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showExitConfirmationDialog();
            }
        });
    }

    // Show a more visually appealing exit confirmation dialog
    private void showExitConfirmationDialog() {
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("resources\\CatFoot.png"));
        Image image = icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        icon = new ImageIcon(image);
        String message = "This game wonn't save your progress!";
        String title = "Exit Confirmation";

        int result = JOptionPane.showOptionDialog(
                window,
                message,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                icon,
                new Object[] { "Yes, exit", "No, cancel" },
                "No, cancel");

        if (result == JOptionPane.YES_OPTION) {
            // If user chooses to exit, close the application
            System.exit(0);
        }
    }

    public void createTextBox() {

        messageText = new JTextArea(
                "เป้าหมายของเกมนี้คือการกดสิ่งของต่างๆ เพื่อเก็บหาเบาะแสและรวมเพื่อไปตามหาแมวที่หนีจากบ้านเราไป โดยเมื่อกดของบางอย่างก็จะมีให้เลือกว่าจะทำอะไรกับสิ่งของนั้นโดยจะเป็นการเสีย 1 action รวมถึงการเปลี่ยนแมพด้วย มีแค่ Cancel ที่จะไม่เสียอะไร ดังนั้นคิดให้ดีก่อนจะกดอะไร (กดที่กล่องข้อความเพื่อปิด)");
        messageText.setLayout(new FlowLayout());
        Insets margins = new Insets(40, 40, 40, 40);
        messageText.setBounds(175, 800, 1600, 220);
        messageText.setBackground(new Color(255, 253, 208));

        // Set margins to move the text inside the JTextArea
        messageText.setMargin(margins);

        // text color
        messageText.setForeground(Color.black);

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
                if (SwingUtilities.isLeftMouseButton(e)) {
                    closeTextBox();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

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
        window.repaint();
    }

    public void openTextBox() {
        messageText.setVisible(true);
        window.repaint();
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
                if (SwingUtilities.isLeftMouseButton(e)) {
                    popMenu.show(objLabel, e.getX(), e.getY());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

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
        window.repaint();
    }

    // New method to hide the specified object
    public void hideObject(int i) {
        JLabel obj = objectList.get(i);
        obj.setVisible(false);
        window.repaint();
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
        Image image = lifeIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
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
        inventoryPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        inventoryPanel.setOpaque(false);

        window.add(inventoryPanel);
    }

    public void createInventoryItem(int idx, String itemFileLocation, int bgNum) {
        itemLabel[idx] = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(itemFileLocation));
        Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        icon = new ImageIcon(image);
        itemLabel[idx].setIcon(icon);
        inventoryPanel.add(itemLabel[idx]);
        showItemCenter(idx, itemFileLocation, bgNum);
    }

    public void showItemCenter(int idx, String itemFileLocation, int bgNum) {
        closeTextBox();
        game.ui.bgPanel[bgNum].setVisible(false);

        // Create a new JDialog for the item popup
        JDialog itemDialog = new JDialog(window);

        // Create a new JLabel for the item
        JLabel itemLabel = new JLabel();

        // Set the icon for the item
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(itemFileLocation));
        itemLabel.setIcon(icon);

        // Set the bounds for the item
        itemLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        // Add the item to the dialog
        itemDialog.add(itemLabel);

        // Add a mouse listener to close the dialog when clicked
        itemLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    // Close the dialog
                    itemDialog.dispose();
                    game.ui.bgPanel[bgNum].setVisible(true);
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

        // Set dialog properties
        itemDialog.setSize(icon.getIconWidth(), icon.getIconHeight());
        itemDialog.setLocationRelativeTo(window);
        itemDialog.setUndecorated(true);
        itemDialog.setModal(true);
        itemDialog.setVisible(true);
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
        createObject(1, 1050, 210, 900, 900, "resources\\Neighborhood\\Cat.png", "Look", "Move", "Cancel", "lookBed",
                "moveShit", "cancel");
        bgPanel[1].add(bgLabel[1]);
        bgPanel[1].setVisible(false);

        // SCENE 2
        createBackground(2, "resources\\Neighborhood\\Background.png");
        createChangeMapBtn(2, 1800, 450, 100, 100, "goScene1",
                "resources\\arrowRight.png");
        createObject(
                2, 550, 380, 500, 500, "resources\\Neighborhood\\Cat.png", "Look", "Touch",
                "Cancel", "lookCat",
                "touchCat", "cancel");
        bgPanel[2].add(bgLabel[2]);
        bgPanel[2].setVisible(false);
    }
}
