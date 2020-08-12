package dal;

import model.Comments;
import model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentsDao {
    private ConnectionManager connectionManager;

    private static CommentsDao instance = null;
    protected CommentsDao() {
        connectionManager = new ConnectionManager();
    }
    public static CommentsDao getInstance() {
        if(instance == null) {
            instance = new CommentsDao();
        }
        return instance;
    }

    public Comments create(Comments comment) throws SQLException {
        String insertBlogComment =
                "INSERT INTO Comments(Content,UserId) " +
                        "VALUES(?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        ResultSet resultKey = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertBlogComment,
                    Statement.RETURN_GENERATED_KEYS);
            insertStmt.setString(1, comment.getContent());
            insertStmt.setInt(2, comment.getUser().getUserId());
            insertStmt.executeUpdate();

            // Retrieve the auto-generated key and set it, so it can be used by the caller.
            resultKey = insertStmt.getGeneratedKeys();
            int commentId = -1;
            if (resultKey.next()) {
                commentId = resultKey.getInt(1);
            } else {
                throw new SQLException("Unable to retrieve auto-generated key.");
            }
            comment.setCommentId(commentId);
            return comment;
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
            if (resultKey != null) {
                resultKey.close();
            }
        }
    }

    public Comments updateContent(Comments comment, String content) throws SQLException {
        String updatePerson = "UPDATE Comments SET CONTENT=? WHERE CommentId=?;";
        Connection connection = null;
        PreparedStatement updateStmt = null;
        try {
            connection = connectionManager.getConnection();
            updateStmt = connection.prepareStatement(updatePerson);
            updateStmt.setString(1, content);
            updateStmt.setInt(2, comment.getCommentId());
            updateStmt.executeUpdate();

            // Update the person param before returning to the caller.
            comment.setContent(content);
            return comment;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(updateStmt != null) {
                updateStmt.close();
            }
        }
    }

    public Comments delete(Comments comment) throws SQLException {
        String deletePerson = "DELETE FROM Comments WHERE CommentId=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deletePerson);
            deleteStmt.setInt(1, comment.getCommentId());
            deleteStmt.executeUpdate();

            // Return null so the caller can no longer operate on the Persons instance.
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(deleteStmt != null) {
                deleteStmt.close();
            }
        }
    }

    public Comments getCommentFromCommentId(int commentId) throws SQLException {
        String selectPerson = "SELECT UserId,Created,Content FROM Comments WHERE CommentId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectPerson);
            selectStmt.setInt(1, commentId);
            results = selectStmt.executeQuery();

            // You can iterate the result set (although the example below only retrieves
            // the first record). The cursor is initially positioned before the row.
            // Furthermore, you can retrieve fields by name and by type.
            if(results.next()) {
                int resultUserId = results.getInt("UserId");
                Date resultCreated =  new Date(results.getTimestamp("Created").getTime());
                String resultContent = results.getString("Content");
                // need update when UserDao is implemented
                Users user = UsersDao.getInstance().getUserFromUserId(resultUserId);
                return new Comments(commentId, user, resultCreated, resultContent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(selectStmt != null) {
                selectStmt.close();
            }
            if(results != null) {
                results.close();
            }
        }
        return null;
    }

    public List<Comments> getCommentsFromUser(Users user) throws SQLException {
        List<Comments> comments = new ArrayList<Comments>();
        String selectBlogComments =
                "SELECT CommentId,Content,Created,UserId" +
                        "FROM Comments " +
                        "WHERE UserId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectBlogComments);
            selectStmt.setInt(1, user.getUserId());
            results = selectStmt.executeQuery();
            while(results.next()) {
                int commentId = results.getInt("CommentId");
                String content = results.getString("Content");
                Date created =  new Date(results.getTimestamp("Created").getTime());

                Comments blogComment = new Comments(commentId, user, created, content);
                comments.add(blogComment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(selectStmt != null) {
                selectStmt.close();
            }
            if(results != null) {
                results.close();
            }
        }
        return comments;
    }
}
