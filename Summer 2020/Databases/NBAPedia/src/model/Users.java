package model;

public class Users {
    private int userId;
    private String username;
    private String password;
    private Teams favouriteTeam;

    public Users(int userId, Teams favouriteTeam, String username, String password) {
        this.userId = userId;
        this.favouriteTeam = favouriteTeam;
        this.username = username;
        this.password = password;
    }

    public Users(String username, String password, Teams favouriteTeam) {
        this.username = username;
        this.password = password;
        this.favouriteTeam = favouriteTeam;
    }

    public Users() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Teams getFavouriteTeam() {
        return favouriteTeam;
    }

    public void setFavouriteTeam(Teams favouriteTeam) {
        this.favouriteTeam = favouriteTeam;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
