package CricketMatchDashboard.models;

import CricketMatchDashboard.enums.Gender;

public class CricketPlayer extends Player {
    private PlayerData playerData;
    private boolean isOnStrike;
    private boolean isOut;

    public CricketPlayer(String name, Gender gender, int age) {
        super(name, gender, age);
        this.isOnStrike = false;
        this.isOut = false;
        this.playerData = new PlayerData();
    }

    public PlayerData getPlayerData() {
        return playerData;
    }

    public void updatePlayerScore(int score){
        playerData.updatePlayerScore(score);
    }
}
