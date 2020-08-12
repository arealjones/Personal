package model;

public class Champions {
    private int championId;
    private String season;
    private Teams team;

    public Champions(int championId, String season, Teams team) {
        this.championId = championId;
        this.season = season;
        this.team = team;
    }

    public Champions() {
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
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
}
