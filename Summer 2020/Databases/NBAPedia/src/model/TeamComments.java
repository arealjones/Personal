package model;

import java.util.Date;

public class TeamComments extends Comments {
    private Teams team;

    public TeamComments(int commentId, Users user, Date created, String content, Teams team) {
        super(commentId, user, created, content);
        this.team = team;
    }

    public TeamComments(Users user, String content, Teams team) {
        super(user, content);
        this.team = team;
    }

    public TeamComments() {
    }

    public Teams getTeam() {
        return team;
    }

    public void setTeam(Teams team) {
        this.team = team;
    }
}
