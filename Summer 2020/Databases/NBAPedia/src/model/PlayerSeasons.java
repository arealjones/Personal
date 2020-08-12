package model;

public class PlayerSeasons {
    private int playerSeasonId;
    private Players player;
    private String season;
    private Teams team;
    private int salary;

    public PlayerSeasons(int playerSeasonId, Players player, String season, Teams team,
                         int salary) {
        this.playerSeasonId = playerSeasonId;
        this.player = player;
        this.season = season;
        this.team = team;
        this.salary = salary;
    }

    public PlayerSeasons() {
    }

    public PlayerSeasons(int salary) {
        this.salary = salary;
    }

    public int getPlayerSeasonId() {
        return playerSeasonId;
    }

    public void setPlayerSeasonId(int playerSeasonId) {
        this.playerSeasonId = playerSeasonId;
    }

    public Players getPlayer() {
        return player;
    }

    public void setPlayer(Players player) {
        this.player = player;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Teams getTeam() {
        return team;
    }

    public void setTeam(Teams team) {
        this.team = team;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
