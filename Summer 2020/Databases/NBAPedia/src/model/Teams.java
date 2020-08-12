package model;

public class Teams {
    private int teamId;
    private String name;
    private String shortName;
    private int years;
    private int totalGames;
    private int totalWins;
    private int totalLosses;
    private int champions;
    private boolean active;
    private String city;
    private String state;
    private String about;

    public Teams(int teamId, String name, String shortName, int years, int totalGames,
                 int totalWins, int totalLosses, int champions, boolean active, String city, String state, String about) {
        this.teamId = teamId;
        this.name = name;
        this.shortName = shortName;
        this.years = years;
        this.totalGames = totalGames;
        this.totalWins = totalWins;
        this.totalLosses = totalLosses;
        this.champions = champions;
        this.active = active;
        this.city = city;
        this.state = state;
        this.about = about;
    }

    public Teams(int teamId) {
        this.teamId = teamId;
    }

    public Teams(String name, String shortName, int years, int totalGames, int totalWins,
                 int totalLosses, int champions, boolean active, String city, String state, String about) {
        this.name = name;
        this.shortName = shortName;
        this.years = years;
        this.totalGames = totalGames;
        this.totalWins = totalWins;
        this.totalLosses = totalLosses;
        this.champions = champions;
        this.active = active;
        this.city = city;
        this.state = state;
        this.about = about;
    }

    public Teams() {
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getTotalLosses() {
        return totalLosses;
    }

    public void setTotalLosses(int totalLosses) {
        this.totalLosses = totalLosses;
    }

    public int getChampions() {
        return champions;
    }

    public void setChampions(int champions) {
        this.champions = champions;
    }

    public boolean isActive() { return active; }

    public void setActive(boolean active) { this.active = active; }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAbout() { return about; }

    public void setAbout(String about) { this.about = about; }
}
