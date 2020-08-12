package model;

import java.util.Date;

public class Games {
    private int gameId;
    private Teams homeTeam;
    private Teams awayTeam;
    private int HomeTeamScore;
    private int AwayTeamScore;
    private int OTs;
    private Date date;
    private boolean playOff;
    private String season;

    public Games(Teams homeTeam, Teams awayTeam, int OTs, Date date,
                 boolean playOff, String season) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.OTs = OTs;
        this.date = date;
        this.playOff = playOff;
        this.season = season;
    }

    public Games() {
    }

    public Games(int gameId, Teams homeTeam, Teams awayTeam, int homeTeamScore, int awayTeamScore, int OTs, Date date, boolean playOff, String season) {
        this.gameId = gameId;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        HomeTeamScore = homeTeamScore;
        AwayTeamScore = awayTeamScore;
        this.OTs = OTs;
        this.date = date;
        this.playOff = playOff;
        this.season = season;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Teams getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Teams homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Teams getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Teams awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeTeamScore() {
        return HomeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        HomeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return AwayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        AwayTeamScore = awayTeamScore;
    }

    public int getOTs() {
        return OTs;
    }

    public void setOTs(int OTs) {
        this.OTs = OTs;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPlayOff() {
        return playOff;
    }

    public void setPlayOff(boolean playOff) {
        this.playOff = playOff;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
