package model;

public class UserFollows {
    private int userFollowId;
    private Players player;
    private Users user;

    public UserFollows(int userFollowId, Players player, Users user) {
        this.userFollowId = userFollowId;
        this.player = player;
        this.user = user;
    }

    public UserFollows(Players player, Users user) {
        this.player = player;
        this.user = user;
    }

    public UserFollows() {
    }

    public int getUserFollowId() {
        return userFollowId;
    }

    public void setUserFollowId(int userFollowId) {
        this.userFollowId = userFollowId;
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
