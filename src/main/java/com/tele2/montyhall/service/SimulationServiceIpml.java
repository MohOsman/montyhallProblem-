package com.tele2.montyhall.service;

import com.tele2.montyhall.domain.Box;
import com.tele2.montyhall.domain.Game;
import com.tele2.montyhall.domain.Player;
import com.tele2.montyhall.domain.SimulationResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationServiceIpml implements SimulationService {


    private final List<Game> games;
    private final Random random;

    public SimulationServiceIpml() {
        this.random = new Random();
        this.games = new ArrayList();
    }

    @Override
    public SimulationResult startSimulation(long iterations) {
        int wonByStaying = 0;
        int wonBySwitiching = 0;
       final Player player = new Player();
        for (int i = 0; i < iterations; i++) {

           final Game game = new Game(i+1);
            player.setGame(game);
            player.chooseBox(random.nextInt(3));

            game.openOtherBox();

            final Box finalBox = player.SwitchOrStay(random.nextInt(2) + 1);

            if (finalBox.containsMoney() && game.isSwitched()) {
                game.setGameResult("Player won by switching ");
                wonBySwitiching++;


            } else if (finalBox.containsMoney() && !game.isSwitched()) {
                game.setGameResult("Player won by Staying ");
                wonByStaying++;
            } else if (!finalBox.containsMoney() && game.isSwitched()) {
                game.setGameResult("player loose by switching");
                wonByStaying++;
        } else if (!finalBox.containsMoney() && !game.isSwitched()) {
                game.setGameResult("player loose by staying");
                wonBySwitiching++;
            }
            games.add(game);

        }

        return new SimulationResult.Builder()
                .setgamesWonByStaying(wonByStaying)
                .setGamesWonBySwitching(wonBySwitiching)
                .setGamesList(games)
                .build();
    }




}
