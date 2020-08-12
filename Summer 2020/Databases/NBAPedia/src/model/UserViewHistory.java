package model;

public class UserViewHistory {
    private int userViewHistoryId;
    private int viewCount;
    private Players player;
    private Users user;

    public UserViewHistory(int userViewHistoryId, int viewCount, Players player, Users user) {
        this.userViewHistoryId = userViewHistoryId;
        this.viewCount = viewCount;
        this.player = player;
        this.user = user;
    }

    public UserViewHistory(int viewCount, Players player, Users user) {
        this.viewCount = viewCount;
        this.player = player;
        this.user = user;
    }

    public UserViewHistory() {
    }

    public int getUserViewHistoryId() {
        return userViewHistoryId;
    }

    public void setUserViewHistoryId(int userViewHistoryId) {
        this.userViewHistoryId = userViewHistoryId;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Players getPlayer() {
        return player;
    }

    public void setPlayer(Players player) {
        this.player = player;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
