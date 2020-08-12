package model;

import java.util.Date;

public class PlayerComments extends Comments {
    private Players player;

    public PlayerComments(int commentId, Users user, Date created, String content, Players player) {
        super(commentId, user, created, content);
        this.player = player;
    }

    public PlayerComments(Users user, String content, Players player) {
        super(user, content);
        this.player = player;
    }

    public PlayerComments() {
    }

    public Players getPlayer() {
        return player;
    }

    public void setPlayer(Players player) {
        this.player = player;
    }
}
