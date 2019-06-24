package com.tele2.montyhall.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tele2.montyhall.exception.BoxException;

import java.util.Random;

@JsonPropertyOrder({
        "game_id",
        "chosenBox",
        "host_show_box",
        "player_Switched",
        "gameResult",

})
public class Game {

    private static final int STAY = 1;
    private static final int SWITCH = 2;


    @JsonProperty("game_id")
    private final int id;
    @JsonIgnore
    private final Box[] boxes;
    @JsonProperty
    private Box chosenBox;
    @JsonProperty("host_show_box")
    private Box openedBox;
    @JsonProperty("player_Switched")
    private boolean switched;

    @JsonProperty
    private String gameResult;


    public Game(int id) {
        this.id = id;
        this.boxes = new Box[3];
        createBoxes(boxes);
    }


    private void createBoxes(Box[] boxes) {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            boxes[i] = new Box(i + 1);
        }
        boxes[random.nextInt(3)].setContainsMoney(true);

    }

    void chooseBox(int choice) {
        if (choice >= 0 && choice <= 2) {
            this.chosenBox = boxes[choice];
        } else {
            throw new IllegalArgumentException("Choice have to be between 1 and 3");
        }
    }


    public Box[] getBoxes() {
        return boxes;
    }

    public void openOtherBox() {
        for (Box box : boxes) {
            if (box.getId() != chosenBox.getId() && !box.containsMoney()) {
                box.setBoxState(Box.BoxState.OPENED);
                setOpenedBox(box);
                break;

            }
        }

    }

    Box SwitchOrStay(int playerChoice) {
        switch (playerChoice) {
            case STAY:

                return chosenBox;
            case SWITCH:
                this.switched = true;
                return getBoxToSwitchTo();

            default:
                throw new BoxException("A player can only stay with same box or switch to other box");
        }
    }

    private Box getBoxToSwitchTo() {
        for (Box box : boxes) {
            if (box.getId() != chosenBox.getId() && box.getBoxState() != Box.BoxState.OPENED)
                return box;
        }
        throw new BoxException("The box was not found");
    }

    public boolean isSwitched() {
        return switched;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }


    private void setOpenedBox(Box openedBox) {
        this.openedBox = openedBox;
    }

}


