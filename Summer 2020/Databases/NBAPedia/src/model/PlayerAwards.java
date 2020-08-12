package model;

public class PlayerAwards{
    private int playerAwardId;
    private String award;
    private String season;
    private Players player;
    private PlayerSeasons playerSeason;

    public PlayerAwards(int playerAwardId, String award, String season,
                        Players player, PlayerSeasons playerSeason) {
        this.playerAwardId = playerAwardId;
        this.award = award;
        this.season = season;
        this.player = player;
        this.playerSeason = playerSeason;
    }

    public PlayerAwards() {
    }



    public PlayerAwards(String award) {
        this.award = award;
    }

    public int getPlayerAwardId() {
        return playerAwardId;
    }

    public void setPlayerAwardId(int playerAwardId) {
        this.playerAwardId = playerAwardId;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Players getPlayer() {
        return player;
    }

    public void setPlayer(Players player) {
        this.player = player;
    }

    public PlayerSeasons getPlayerSeason() {
        return playerSeason;
    }

    public void setPlayerSeason(PlayerSeasons playerSeason) {
        this.playerSeason = playerSeason;
    }
}
