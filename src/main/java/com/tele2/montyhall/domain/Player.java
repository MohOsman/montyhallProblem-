package com.tele2.montyhall.domain;

public class Player {

    private  int id;
    private Game game;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void chooseBox(int choice){
        this.game.chooseBox(choice);
    }

    public Box SwitchOrStay(int choice) {
        return this.game.SwitchOrStay(choice);
    }
}
