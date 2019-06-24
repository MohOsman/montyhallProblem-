package com.tele2.montyhall.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class SimulationResult {

    @JsonProperty
    private List<Game> games;
    @JsonProperty
    private  long  gamesWonByStaying;
    @JsonProperty
    private  long  gamesWonBySwtiching;



    public SimulationResult( long gamesWonByStaying, long gamesWonBySwtiching, List<Game> games) {
        this.gamesWonByStaying = gamesWonByStaying;
        this.gamesWonBySwtiching = gamesWonBySwtiching;
        this.games = games;
    }

    public static class Builder {
        private long gamesWonByStaying;
        private long gamesWonbySwtiching;
        private List<Game> gamesList;

        public Builder(){}
        public Builder setgamesWonByStaying(long gamesWonByStaying) {
            this.gamesWonByStaying =  gamesWonByStaying;
            return this;
        }

        public Builder setGamesWonBySwitching(long gamesWonBySwitching) {
            this.gamesWonbySwtiching = gamesWonBySwitching;
            return this;
        }


        public Builder setGamesList(List<Game> games) {
            this.gamesList = games;
            return this;
        }


        public SimulationResult build() {
            return new SimulationResult(gamesWonByStaying, gamesWonbySwtiching, gamesList);
        }
    }


}
