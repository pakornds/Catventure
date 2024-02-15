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
                case "moveChair":
                    game.ev01.moveChair();
                    game.ev01.nothingHere();
                    break;
                case "lookMovedChair":
                    break;
                case "moveMovedChair":
                    break;
                case "lookLookedLamp":
                    break;
                case "moveLookedLamp":
                    break;
                case "lookLamp":
                    break;
                case "moveLamp":
                    break;
                case "lookMovedBin":
                    break;
                case "moveMovedBin":
                    break;
                case "lookBin":
                    break;
                case "moveBin":
                    break;
                case "lookMovedCarpet":
                    break;
                case "moveMovedCarpet":
                    break;
                case "lookCarpet":
                    break;
                case "moveCarpet":
                    break;
                case "lookMovedBed":
                    break;
                case "moveMovedSheet":
                    break;
                case "lookBed":
                    game.ev01.nothingHere();
                    break;
                case "moveSheet":
                    if (isFirstInteraction(yourChoice)) {
                        game.ui.createInventoryItem(itemIdx, "resources\\Items\\Fur.png", 0);
                        itemIdx++;
                        game.ev01.moveSheet();

                    } else {
                        game.ev01.nothingHere();
                    }
                    break;
                case "lookMovedBush":
                    break;
                case "moveMovedBush":
                    break;
                case "lookBush":
                    break;
                case "moveBush":
                    break;
                case "lookLookedPalm":
                    break;
                case "moveMovedPalm":
                    break;
                case "lookPalm":
                    break;
                case "movePalm":
                    break;
                case "lookMovedWindow2":
                    break;
                case "moveMovedWindow2":
                    break;
                case "lookWindow2":
                    break;
                case "moveWindow2":
                    break;
                case "lookMovedWindow":
                    break;
                case "moveMovedWindow":
                    break;
                case "lookWindow":
                    break;
                case "moveWindow":
                    break;
                case "lookMovedRoof":
                    break;
                case "moveMovedRoof":
                    break;
                case "lookRoof":
                    break;
                case "moveRoof":
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

        } catch (Exception eDeezNutz) {
            eDeezNutz.printStackTrace();
        } finally {
            game.player.playerAction--;
            game.player.updatePlayerStatus();
        }

    }

}
