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
                    game.playSoundEffects(12);
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
                    game.playSoundEffects(12);
                    break;
                case "lookLookedLamp":
                    game.ev01.nothingHere();
                    break;
                case "moveLookedLamp":
                    game.ev01.moveLookedLamp();
                    game.playSoundEffects(8);
                    break;
                case "lookLamp":
                    game.ev01.nothingHere();
                    break;
                case "moveLamp":
                    game.ev01.moveLamp();
                    game.playSoundEffects(9);
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
                    game.playSoundEffects(10);
                    break;
                case "lookBin":
                    game.ev01.nothingHere();
                    break;
                case "moveBin":
                    game.ev01.moveBin();
                    game.playSoundEffects(10);
                    break;
                case "lookMovedCarpet":
                    game.ev01.nothingHere();
                    break;
                case "moveMovedCarpet":
                    game.ev01.moveMovedCarpet();
                    game.playSoundEffects(0);
                    break;
                case "lookCarpet":
                    game.ev01.nothingHere();
                    break;
                case "moveCarpet":
                    game.ev01.moveCarpet();
                    game.playSoundEffects(0);
                    break;
                case "lookMovedBed":
                    game.ev01.nothingHere();
                    break;
                case "moveMovedSheet":
                    game.ev01.moveMovedSheet();
                    game.playSoundEffects(0);
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
                    game.playSoundEffects(0);
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
                    game.playSoundEffects(2);
                    break;
                case "lookBush":
                    game.ev02.nothingHere();
                    break;
                case "moveBush":
                    game.ev02.moveBush();
                    game.playSoundEffects(2);
                    break;
                case "lookLookedPalm":
                    game.ev02.nothingHere();
                    break;
                case "moveMovedPalm":
                    game.ev02.moveMovedPalm();
                    game.playSoundEffects(13);
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
                    game.playSoundEffects(13);
                    break;
                case "lookMovedWindow2":
                    game.ev02.nothingHere();
                    break;
                case "moveMovedWindow2":
                    game.ev02.moveMovedWindow2();
                    game.playSoundEffects(14);
                    break;
                case "lookWindow2":
                    game.ev02.nothingHere();
                    break;
                case "moveWindow2":
                    game.ev02.moveWindow2();
                    game.playSoundEffects(14);
                    break;
                case "lookMovedWindow":
                    game.ev02.nothingHere();
                    break;
                case "moveMovedWindow":
                    game.ev02.moveMovedWindow();
                    game.playSoundEffects(15);
                    break;
                case "lookWindow":
                    game.ev02.nothingHere();
                    break;
                case "moveWindow":
                    game.ev02.moveWindow();
                    game.playSoundEffects(15);
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
                    game.playSoundEffects(11);
                    break;
                case "lookRoof":
                    game.ev02.nothingHere();
                    break;
                case "moveRoof":
                    game.ev02.moveRoof();
                    game.playSoundEffects(11);
                    break;

                // Map 3
                case "lookLookedBox":
                    game.ev03.nothingHere();
                    break;
                case "moveLookedBox":
                    game.ev03.moveLookedBox();
                    game.playSoundEffects(5);
                    break;
                case "lookBox":
                    game.ev03.nothingHere();
                    break;
                case "moveBox":
                    game.ev03.moveBox();
                    game.playSoundEffects(6);
                    break;
                case "lookMovedCar":
                    game.ev03.nothingHere();
                    break;
                case "moveMovedCar":
                    game.ev03.moveMovedCar();
                    game.playSoundEffects(4);
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
                    game.playSoundEffects(3);
                    break;
                case "lookMovedNbin":
                    game.ev03.nothingHere();
                    break;
                case "moveMovedNbin":
                    game.ev03.moveMovedNbin();
                    game.playSoundEffects(1);
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
                    game.playSoundEffects(1);
                    break;
                case "lookCat":
                    if (game.player.hasNettle) {
                        game.ev03.lookCatSure();
                    } else if (game.player.hasCatHair && game.player.hasScratchMark && game.player.hasCollar
                            && game.player.hasToy) {
                        game.ev03.lookCatNotSure();
                    } else {
                        game.ev03.lookNUHUH();
                    }
                    break;
                case "touchCat":
                    int checkAction = game.player.playerAction;
                    if ((checkAction - 1) >= 0) {
                        if (game.player.hasNettle) {
                            game.ev03.touchCatSure();
                        } else if (game.player.hasCatHair && game.player.hasScratchMark && game.player.hasCollar
                                && game.player.hasToy) {
                            game.ev03.touchCatNotSure();
                        } else {
                            game.ev03.touchNUHUH();
                        }
                    } else {
                        game.sceneChanger.showGameoverScene();
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
