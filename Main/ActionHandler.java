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

                // Map 1
                case "lookChair":
                    game.ev01.nothingHere();
                    break;
                case "moveChair":
                    game.ev01.moveChair();
                    game.ev01.nothingHere();
                    break;
                case "lookMovedChair":
                    if (isFirstInteraction(yourChoice)) {
                        game.ui.createInventoryItem(itemIdx, "resources\\Items\\Toy.png", 0);
                        game.ev01.lookMovedChair();
                        itemIdx++;

                    } else {
                        game.ev01.nothingHere();
                    }
                    break;
                case "moveMovedChair":
                    game.ev01.moveMovedChair();
                    break;
                case "lookLookedLamp":
                    game.ev01.nothingHere();
                    break;
                case "moveLookedLamp":
                    game.ev01.moveLookedLamp();
                    break;
                case "lookLamp":
                    game.ev01.nothingHere();
                    break;
                case "moveLamp":
                    game.ev01.moveLamp();
                    break;
                case "lookMovedBin":
                    if (isFirstInteraction(yourChoice)) {
                        game.ui.createInventoryItem(itemIdx, "resources\\Items\\Snack.png", 0);
                        game.ev01.lookMovedBin();
                        itemIdx++;

                    } else {
                        game.ev01.nothingHere();
                    }
                    break;
                case "moveMovedBin":
                    game.ev01.moveMovedBin();
                    break;
                case "lookBin":
                    game.ev01.nothingHere();
                    break;
                case "moveBin":
                    game.ev01.moveBin();
                    break;
                case "lookMovedCarpet":
                    game.ev01.nothingHere();
                    break;
                case "moveMovedCarpet":
                    game.ev01.moveMovedCarpet();
                    break;
                case "lookCarpet":
                    game.ev01.nothingHere();
                    break;
                case "moveCarpet":
                    game.ev01.moveCarpet();
                    break;
                case "lookMovedBed":
                    game.ev01.nothingHere();
                    break;
                case "moveMovedSheet":
                    game.ev01.moveMovedSheet();
                    break;
                case "lookBed":
                    if (isFirstInteraction(yourChoice)) {
                        game.ui.createInventoryItem(itemIdx, "resources\\Items\\Fur.png", 0);
                        game.ev01.lookMovedBed();
                        itemIdx++;

                    } else {
                        game.ev01.nothingHere();
                    }
                    break;
                case "moveSheet":
                    game.ev01.moveSheet();
                    break;

                // Map 2
                case "lookMovedBush":
                    if (isFirstInteraction(yourChoice)) {
                        game.ui.createInventoryItem(itemIdx, "resources\\Items\\Indian_nettle.png", 1);
                        game.ev02.lookMovedBush();
                        itemIdx++;

                    } else {
                        game.ev02.nothingHere();
                    }
                    break;
                case "moveMovedBush":
                    game.ev02.moveMovedBush();
                    break;
                case "lookBush":
                    game.ev02.nothingHere();
                    break;
                case "moveBush":
                    game.ev02.moveBush();
                    break;
                case "lookLookedPalm":
                    game.ev02.nothingHere();
                    break;
                case "moveMovedPalm":
                    game.ev02.moveMovedPalm();
                    break;
                case "lookPalm":
                    if (isFirstInteraction(yourChoice)) {
                        game.ui.createInventoryItem(itemIdx, "resources\\Items\\Scratching.png", 1);
                        game.ev02.lookPalm();
                        itemIdx++;

                    } else {
                        game.ev02.nothingHere();
                    }
                    break;
                case "movePalm":
                    game.ev02.movePalm();
                    break;
                case "lookMovedWindow2":
                    game.ev02.nothingHere();
                    break;
                case "moveMovedWindow2":
                    game.ev02.moveMovedWindow2();
                    break;
                case "lookWindow2":
                    game.ev02.nothingHere();
                    break;
                case "moveWindow2":
                    game.ev02.moveWindow2();
                    break;
                case "lookMovedWindow":
                    game.ev02.nothingHere();
                    break;
                case "moveMovedWindow":
                    game.ev02.moveMovedWindow();
                    break;
                case "lookWindow":
                    game.ev02.nothingHere();
                    break;
                case "moveWindow":
                    game.ev02.moveWindow();
                    break;
                case "lookMovedRoof":
                    if (isFirstInteraction(yourChoice)) {
                        game.ui.createInventoryItem(itemIdx,
                                "resources\\Items\\Nest.png", 1);
                        game.ev02.lookMovedRoof();
                        itemIdx++;

                    } else {
                        game.ev02.nothingHere();
                    }
                case "moveMovedRoof":
                    game.ev02.moveMovedRoof();
                    break;
                case "lookRoof":
                    game.ev02.nothingHere();
                    break;
                case "moveRoof":
                    game.ev02.moveRoof();
                    break;

                // Map 3
                case "lookLookedBox":
                    game.ev03.nothingHere();
                    break;
                case "moveLookedBox":
                    game.ev03.moveLookedBox();
                    break;
                case "lookBox":
                    game.ev03.nothingHere();
                    break;
                case "moveBox":
                    game.ev03.moveBox();
                    break;
                case "lookMovedCar":
                    game.ev03.nothingHere();
                    break;
                case "moveMovedCar":
                    game.ev03.moveMovedCar();
                    break;
                case "lookCar":
                    if (isFirstInteraction(yourChoice)) {
                        game.ui.createInventoryItem(itemIdx,
                                "resources\\Items\\Paws.png", 2);
                        game.ev03.lookCar();
                        itemIdx++;

                    } else {
                        game.ev03.nothingHere();
                    }
                    break;
                case "moveCar":
                    game.ev03.moveCar();
                    break;
                case "lookMovedNbin":
                    game.ev03.nothingHere();
                    break;
                case "moveMovedNbin":
                    game.ev03.moveMovedNbin();
                    break;
                case "lookNbin":
                    if (isFirstInteraction(yourChoice)) {
                        game.ui.createInventoryItem(itemIdx,
                                "resources\\Items\\Collar.png", 2);
                        game.ev03.lookNbin();
                        itemIdx++;

                    } else {
                        game.ev03.nothingHere();
                    }
                    break;
                case "moveNbin":
                    game.ev03.moveNbin();
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
