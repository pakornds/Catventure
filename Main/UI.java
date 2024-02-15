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
    public int playerMaxAction;
    JPanel inventoryPanel;
    private int MAX_ITEMS = 6;
    JLabel itemLabel[] = new JLabel[MAX_ITEMS];

    // ArrayList of objects to display or hide
    public ArrayList<JLabel> objectList = new ArrayList<>();
    protected HashMap<String, Boolean> firstInteractionMap = new HashMap<>();

    public UI(GameManager game) {

        this.game = game;
        playerMaxAction = 10;

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
                "เป้าหมายของเกมนี้คือการกดสิ่งของต่างๆ เพื่อเก็บหาเบาะแสและรวมเพื่อไปตามหาแมวที่หนีจากบ้านเราไป โดยเมื่อกดของบางอย่างก็จะมีให้เลือกว่าจะทำอะไรกับสิ่งของนั้นและจะเสีย 1 action รวมถึงการเปลี่ยนแมพ (สามารถดูจำนวนการกดได้ที่ด้านซ้ายบน) Cancel จะไม่เสีย action และสามารถดูของที่อยู่ในตัวได้ที่มุมขวาบน (กดที่กล่องข้อความเพื่อปิด)");
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
        objLabel.setBackground(Color.blue);

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

    public void createChangeMapBtn(int bgNum, int x, int y, int width, int height, String command, String arrowFilename,
            boolean isCenterRight) {
        ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFilename));

        JButton arrowButton = new JButton();
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrowIcon);
        arrowButton.addActionListener(game.aHandler);
        arrowButton.setActionCommand(command);
        arrowButton.setBorderPainted(false);

        // Calculate the x-coordinate based on the center-right or center-left position
        int arrowX;
        if (isCenterRight) {
            arrowX = window.getWidth() - 100;
        } else {
            arrowX = x;
        }

        // Calculate the y-coordinate based on the height of the screen
        int arrowY;
        arrowY = window.getHeight() / 2;

        arrowButton.setBounds(arrowX, arrowY, width, height);

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

        ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("resources\\CatFoot.png"));
        Image image = lifeIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
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

        createBackground(0, "resources\\Bedroom\\TheBedroom2.png");
        createChangeMapBtn(0, 0, 0, 100, 100, "goScene1", "resources\\arrowLeft.png", false);

        // CHAIR
        createObject(0, 550, 380, 260, 390, "resources\\Bedroom\\movedChair.png", "Look", "Move", "Cancel",
                "lookMovedChair", "moveMovedChair", "cancel");
        hideObject(0);
        createObject(0, 550, 380, 260, 390, "resources\\Bedroom\\chair.png", "Look", "Move", "Cancel", "lookChair",
                "moveChair", "cancel");

        // LAMP
        createObject(0, 730, 200, 350, 331, "resources\\Bedroom\\lookedLamp.png", "Look", "Move", "Cancel",
                "lookLookedLamp", "moveLookedLamp", "cancel");
        hideObject(2);
        createObject(0, 730, 200, 280, 331, "resources\\Bedroom\\Lamp.png", "Look", "Move", "Cancel", "lookLamp",
                "moveLamp", "cancel");

        // BEDROOM BIN
        createObject(0, -100, 594, 231, 240, "resources\\Bedroom\\movedBin.png", "Look", "Move", "Cancel",
                "lookMovedBin", "moveMovedBin", "cancel");
        hideObject(4);
        createObject(0, -100, 594, 231, 240, "resources\\Bedroom\\Bin.png", "Look", "Move", "Cancel", "lookBin",
                "moveBin", "cancel");

        // Carpet
        createObject(0, 725, 717, 760, 365, "resources\\Bedroom\\movedCarpet.png", "Look",
                "Move", "Cancel", "lookMovedCarpet", "moveMovedCarpet", "cancel");
        hideObject(6);
        createObject(0, 725, 717, 760, 365, "resources\\Bedroom\\Carpet.png", "Look",
                "Move", "Cancel", "lookCarpet", "moveCarpet", "cancel");

        // Bed
        createObject(0, 1050, 350, 880, 600, "resources\\Bedroom\\movedBed.png", "Look", "Move", "Cancel",
                "lookMovedBed", "moveMovedSheet", "cancel");
        hideObject(8);
        createObject(0, 1050, 350, 880, 600, "resources\\Bedroom\\Bed.png", "Look", "Move", "Cancel", "lookBed",
                "moveSheet", "cancel");

        bgPanel[0].add(bgLabel[0]);

        // SCENE 1

        createBackground(1, "resources\\House\\House.png");
        createChangeMapBtn(1, 0, 0, 100, 100, "goScene2",
                "resources\\arrowLeft.png", false);
        createChangeMapBtn(1, 0, 0, 100, 100, "goScene0",
                "resources\\arrowRight.png", true);

        // Bush
        createObject(1, 0, 500, 410, 550, "resources\\House\\movedBush.png", "Look",
                "Move", "Cancel", "lookMovedBush",
                "moveMovedBush", "cancel");
        hideObject(10);
        createObject(1, 0, 500, 410, 550, "resources\\House\\Bush.png", "Look",
                "Move", "Cancel", "lookBush",
                "moveBush", "cancel");

        // Palm tree
        createObject(1, 1290, 0, 590, 800, "resources\\House\\lookedPalm.png", "Look",
                "Move", "Cancel", "lookLookedPalm",
                "moveMovedPalm", "cancel");
        hideObject(12);
        createObject(1, 1290, 0, 590, 800, "resources\\House\\Palm.png", "Look",
                "Move", "Cancel", "lookPalm",
                "movePalm", "cancel");

        createObject(1, 882, 223, 1070, 425, "resources\\House\\movedWindow2.png",
                "Look", "Move", "Cancel",
                "lookMovedWindow2", "moveMovedWindow2", "cancel");
        hideObject(14);
        createObject(1, 882, 223, 1070, 425, "resources\\House\\Window2.png", "Look",
                "Move", "Cancel", "lookWindow2",
                "moveWindow2", "cancel");

        createObject(1, 475, 547, 390, 240, "resources\\House\\movedWindow.png", "Look",
                "Move", "Cancel", "lookWindow",
                "moveWindow", "cancel");
        hideObject(16);
        createObject(1, 475, 547, 390, 240, "resources\\House\\Window.png", "Look",
                "Move", "Cancel", "lookWindow",
                "moveWindow", "cancel");

        createObject(1, 363, 119, 1070, 425, "resources\\House\\lookedRoof.png", "Look",
                "Move", "Cancel", "lookRoof",
                "moveRoof", "cancel");
        hideObject(18);
        createObject(1, 363, 119, 1070, 425, "resources\\House\\Roof.png", "Look",
                "Move", "Cancel", "lookRoof",
                "moveRoof", "cancel");

        bgPanel[1].add(bgLabel[1]);

        // SCENE 2
        createBackground(2, "resources\\Neighborhood\\Background.png");
        createChangeMapBtn(2, 0, 0, 100, 100, "goScene1",
                "resources\\arrowRight.png", true);
        createObject(2, 870, 310, 100, 100, "resources\\Neighborhood\\BiggerCat.png",
                "Look", "Touch",
                "Cancel", "lookCat", "touchCat", "cancel");

        createObject(2, 1075, 550, 245, 175,
                "resources\\Neighborhood\\lookedBox.png", "Look", "Move", "Cancel",
                "lookLookedBox", "moveLookedBox", "cancel");
        hideObject(21);
        createObject(2, 1075, 550, 245, 175, "resources\\Neighborhood\\Box.png",
                "Look", "Move", "Cancel", "lookBox",
                "moveBox", "cancel");

        createObject(2,
                1168, 233,
                500,
                320, "resources\\Neighborhood\\Car.png",
                "Look", "Move", "Cancel", "lookMovedCar", "moveMovedCar", "cancel");
        hideObject(23);
        createObject(2, 1168, 233, 500, 320, "resources\\Neighborhood\\Car.png",
                "Look", "Move", "Cancel", "lookCar", "moveCar", "cancel");

        createObject(2, 450, 404, 359, 338, "resources\\Neighborhood\\movedBin.png",
                "Look", "Move", "Cancel",
                "lookMovedBin", "moveMovedBin", "cancel");
        hideObject(25);
        createObject(2, 450, 350, 275, 397, "resources\\Neighborhood\\Bin.png",
                "Look", "Move", "Cancel", "lookBin",
                "moveBin", "cancel");
        bgPanel[2].add(bgLabel[2]);
    }
}
