package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler extends UI implements ActionListener {

    GameManager game;
    private int itemIdx;

    public ActionHandler(GameManager game) {
        this.game = game;
        itemIdx = 0;
    }

    public ActionHandler() {
    }

    public boolean isFirstInteraction(String yourChoice) {
        firstInteractionMap.putIfAbsent(yourChoice, true);
        if (firstInteractionMap.get(yourChoice)) {
            firstInteractionMap.put(yourChoice, false);
            return true;
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();
        System.out.println(yourChoice);
        switch (yourChoice) {
            case "cancel":
                game.ev01.cancel();
                break;
            case "lookChair":
                if (isFirstInteraction(yourChoice)) {
                    game.ev01.lookChair();
                    game.ui.createInventoryItem(itemIdx, "resources\\heart.png");
                    itemIdx++;
                } else {
                    game.ev01.nothingHere();
                }
                break;
            case "lookBed":
                game.ev01.nothingHere();
                break;
            case "moveSheet":
                if (isFirstInteraction(yourChoice)) {
                    game.ev01.moveSheet();
                    game.ui.createInventoryItem(itemIdx, "resources\\heart.png");
                    itemIdx++;
                } else {
                    game.ev01.nothingHere();
                }
                break;
            case "moveChair":
                game.ev01.moveChair();
                game.ev01.nothingHere();
                break;

            // change scene
            case "goScene0":
                game.sceneChanger.showScene0();
                break;
            case "goScene1":
                game.sceneChanger.showScene1();
                break;
        }
    }

}
