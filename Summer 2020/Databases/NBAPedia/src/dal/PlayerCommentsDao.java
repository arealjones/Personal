package dal;

import model.Comments;
import model.PlayerComments;
import model.Players;
import model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerCommentsDao extends CommentsDao {
    private ConnectionManager connectionManager;

    private static PlayerCommentsDao instance = null;

    protected PlayerCommentsDao() {
        connectionManager = new ConnectionManager();
    }

    public static PlayerCommentsDao getInstance() {
        if (instance == null) {
            instance = new PlayerCommentsDao();
        }
        return instance;
    }

    public PlayerComments create(PlayerComments playerComment) throws SQLException {
        Comments comment = new Comments(playerComment.getUser(), playerComment.getContent());
        CommentsDao commentsDao = CommentsDao.getInstance();
        comment = commentsDao.create(comment);
        playerComment.setCommentId(comment.getCommentId());

        String insertPlayerComments = "INSERT INTO PlayerComments(CommentId, PlayerId) VALUES(?,"
            + "?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertPlayerComments);
            insertStmt.setInt(1, playerComment.getCommentId());
            insertStmt.setInt(2, playerComment.getPlayer().getPlayerId());
            insertStmt.executeUpdate();
            return playerComment;
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

    public PlayerComments updateContent(PlayerComments playerComment, String content) throws SQLException {
        super.updateContent(playerComment, content);
        return playerComment;
    }

    public PlayerComments delete(PlayerComments playerComments) throws SQLException {
        super.delete(playerComments);
        return null;
    }

    public PlayerComments getPlayerCommentsFromId(int commentId) throws SQLException {
        String selectPlayerComment =
                "SELECT PlayerComments.CommentId AS CommentId, PlayerId, UserId, Content, Created " +
                        "FROM PlayerComments INNER JOIN Comments " +
                        "  ON PlayerComments.CommentId = Comments.CommentId " +
                        "WHERE CommentId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectPlayerComment);
            selectStmt.setInt(1, commentId);
            results = selectStmt.executeQuery();
            if (results.next()) {
                return wrapOnePlayerComment(results);
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

    private List<PlayerComments> getPlayerCommentsFromPlayerOrUser(int id, String type) throws SQLException {
        List<PlayerComments> playerComments;
        String selectPlayerComments =
                "SELECT PlayerComments.CommentId AS CommentId, PlayerId, UserId, Content, Created " +
                        "FROM PlayerComments INNER JOIN Comments " +
                        "  ON PlayerComments.CommentId = Comments.CommentId " +
                        "WHERE "+ type + "=?;";

        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectPlayerComments);
            selectStmt.setInt(1, id);
            results = selectStmt.executeQuery();
            playerComments = wrapPlayerCommentsList(results);
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
        return playerComments;
    }

    public List<PlayerComments> getPlayerCommentsFromUser(int userId) throws SQLException {
        return getPlayerCommentsFromPlayerOrUser(userId, "UserId");
    }

    public List<PlayerComments> getPlayerCommentsFromPlayer(int playerId) throws SQLException {
        return getPlayerCommentsFromPlayerOrUser(playerId, "PlayerId");
    }

    private List<PlayerComments> wrapPlayerCommentsList(ResultSet results) throws SQLException {
        List<PlayerComments> playerComments = new ArrayList<>();
        while (results.next()) {
            playerComments.add(wrapOnePlayerComment(results));
        }
        return playerComments;
    }

    private PlayerComments wrapOnePlayerComment(ResultSet results) throws SQLException {
        int commentId = results.getInt("CommentId");
        int playerId = results.getInt("PlayerId");
        int userId = results.getInt("UserId");
        String content = results.getString("Content");
        Date created = new Date(results.getTimestamp("Created").getTime());
        Users user = UsersDao.getInstance().getUserFromUserId(userId);
        Players player = PlayersDao.getInstance().getPlayerById(playerId);
        return new PlayerComments(commentId, user, created, content, player);
    }
}
