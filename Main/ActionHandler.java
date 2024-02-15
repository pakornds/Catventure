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
        try {
            switch (yourChoice) {
                case "cancel":
                    game.ev01.cancel();
                    game.player.playerAction++;
                    break;
                case "lookChair":
                    if (isFirstInteraction(yourChoice)) {
                        game.ui.createInventoryItem(itemIdx, "resources\\Items\\Scratching.png", 0);
                        game.ev01.lookChair();
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
                        game.ui.createInventoryItem(itemIdx, "resources\\Items\\speed.gif", 0);
                        itemIdx++;
                        game.ev01.moveSheet();

                    } else {
                        game.ev01.nothingHere();
                    }
                    break;
                case "moveChair":
                    game.ev01.moveChair();
                    game.ev01.nothingHere();
                    break;
                case "lookCat":
                    if (game.player.hasCatHair && game.player.hasScratchMark) {
                        game.ev03.lookCatSure();
                    } else if (game.player.hasCatHair || game.player.hasScratchMark) {
                        game.ev03.lookCatNotSure();
                    } else {
                        game.ev03.lookNUHUH();
                    }
                    break;
                case "touchCat":
                    if (game.player.hasCatHair && game.player.hasScratchMark) {
                        game.ev03.touchCatSure();
                    } else if (game.player.hasCatHair || game.player.hasScratchMark) {
                        game.ev03.touchCatNotSure();
                    } else {
                        game.ev03.touchNUHUH();
                    }
                    break;

                // change scene
                case "goScene0":
                    game.sceneChanger.showScene0();
                    break;
                case "goScene1":
                    game.sceneChanger.showScene1();
                    break;
                case "goScene2":
                    game.sceneChanger.showScene2();
                    break;
            }
        } finally {
            game.player.playerAction--;
            game.player.updatePlayerStatus();
        }

    }

}
