package dal;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeamCommentsDao extends CommentsDao {
    private ConnectionManager connectionManager;

    private static TeamCommentsDao instance = null;

    protected TeamCommentsDao() {
        connectionManager = new ConnectionManager();
    }

    public static TeamCommentsDao getInstance() {
        if (instance == null) {
            instance = new TeamCommentsDao();
        }
        return instance;
    }

    public TeamComments create(TeamComments teamComment) throws SQLException {
        Comments comment = create(new Comments(teamComment.getUser(), teamComment.getContent()));
        CommentsDao commentsDao = CommentsDao.getInstance();
        comment = commentsDao.create(comment);
        teamComment.setCommentId(comment.getCommentId());

        String insertTeamComments = "INSERT INTO TeamComments(CommentId, TeamId) VALUES(?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertTeamComments);
            insertStmt.setInt(1, teamComment.getCommentId());
            insertStmt.setInt(2, teamComment.getTeam().getTeamId());
            insertStmt.executeUpdate();
            return teamComment;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (insertStmt != null) {
                insertStmt.close();
            }
        }
    }

    public TeamComments updateContent(TeamComments teamComment, String content) throws SQLException {
        super.updateContent(teamComment, content);
        return teamComment;
    }

    public PlayerComments delete(TeamComments teamComment) throws SQLException {
        super.delete(teamComment);
        return null;
    }

    public TeamComments getTeamCommentsFromId(int commentId) throws SQLException {
        String selectTeamComment =
                "SELECT TeamComments.CommentId AS CommentId, TeamId, UserId, Content, Created " +
                        "FROM TeamComments INNER JOIN Comments " +
                        "  ON TeamComments.CommentId = Comments.CommentId " +
                        "WHERE CommentId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectTeamComment);
            selectStmt.setInt(1, commentId);
            results = selectStmt.executeQuery();
            if (results.next()) {
                return wrapOneTeamComment(results);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (selectStmt != null) {
                selectStmt.close();
            }
            if (results != null) {
                results.close();
            }
        }
        return null;
    }

    private List<TeamComments> getTeamCommentsFromTeamOrUser(int id, String type) throws SQLException {
        List<TeamComments> teamComments;
        String selectTeamComments =
                "SELECT TeamComments.CommentId AS CommentId, TeamId, UserId, Content, Created " +
                        "FROM TeamComments INNER JOIN Comments " +
                        "  ON TeamComments.CommentId = Comments.CommentId " +
                        "WHERE "+ type + "=?;";

        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectTeamComments);
            selectStmt.setInt(1, id);
            results = selectStmt.executeQuery();
            teamComments = wrapTeamCommentsList(results);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (selectStmt != null) {
                selectStmt.close();
            }
            if (results != null) {
                results.close();
            }
        }
        return teamComments;
    }

    public List<TeamComments> getTeamCommentsFromUser(int userId) throws SQLException {
        return getTeamCommentsFromTeamOrUser(userId, "UserId");
    }

    public List<TeamComments> getTeamCommentsFromTeam(int teamId) throws SQLException {
        return getTeamCommentsFromTeamOrUser(teamId, "TeamId");
    }

    private List<TeamComments> wrapTeamCommentsList(ResultSet results) throws SQLException {
        List<TeamComments> teamComments= new ArrayList<>();
        while (results.next()) {
            teamComments.add(wrapOneTeamComment(results));
        }
        return teamComments;
    }

    private TeamComments wrapOneTeamComment(ResultSet results) throws SQLException {
        int commentId = results.getInt("CommentId");
        int teamId = results.getInt("TeamId");
        int userId = results.getInt("UserId");
        String content = results.getString("Content");
        Date created = new Date(results.getTimestamp("Created").getTime());
        Users user = UsersDao.getInstance().getUserFromUserId(userId);
        Teams team = TeamsDao.getInstance().getTeamFromTeamId(teamId);
        return new TeamComments(commentId, user, created, content, team);
    }
}
