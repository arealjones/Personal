package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Players;
import model.UserFollows;
import model.Users;

public class UserFollowsDao {
  protected ConnectionManager connectionManager;

  private static UserFollowsDao instance = null;
  protected UserFollowsDao() {
    connectionManager = new ConnectionManager();
  }
  public static UserFollowsDao getInstance() {
    if(instance == null) {
      instance = new UserFollowsDao();
    }
    return instance;
  }

  /** Save the UserFollows instance by storing it in MySQL instance. This runs a INSERT statement. */
  public UserFollows create(UserFollows userFollows) throws SQLException {
    String insertUserFollows = "INSERT INTO UserFollows(PlayerId,UserId) VALUES(?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertUserFollows, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setInt(1, userFollows.getPlayer().getPlayerId());
      insertStmt.setInt(2, userFollows.getUser().getUserId());
      insertStmt.executeUpdate();
      resultKey = insertStmt.getGeneratedKeys();
      int UserFollowId = -1;
      if (resultKey.next()) {
        UserFollowId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      userFollows.setUserFollowId(UserFollowId);
      return userFollows;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(insertStmt != null) {
        insertStmt.close();
      }
    }
  }

  /** Delete the UserFollows instance. This runs a DELETE statement. */
  public UserFollows delete(UserFollows userFollows) throws SQLException {
    String deleteUserFollows = "DELETE FROM UserFollows WHERE UserFollowId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteUserFollows);
      deleteStmt.setInt(1, userFollows.getUserFollowId());
      deleteStmt.executeUpdate();
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

  /**
   * Get the list of UserFollows records based on the userId. This runs a SELECT statement and
   * returns a list of matching UserFollows. */
  public List<UserFollows> getUserFollowsFromUserId(int userId) throws SQLException {
    List<UserFollows> userFollowsList = new ArrayList<>();
    String selectUserFollows = "SELECT UserFollowId,PlayerId,UserId FROM UserFollows WHERE UserId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectUserFollows);
      selectStmt.setInt(1, userId);
      results = selectStmt.executeQuery();
      PlayersDao playersDao = PlayersDao.getInstance();
      UsersDao usersDao = UsersDao.getInstance();
      while(results.next()) {
        int resultUserFollowId = results.getInt("UserFollowId");
        int playerId = results.getInt("PlayerId");
        Players player = playersDao.getPlayerById(playerId);
        int UserId = results.getInt("UserId");
        Users user = usersDao.getUserFromUserId(UserId);
        UserFollows userFollows = new UserFollows(resultUserFollowId, player, user);
        userFollowsList.add(userFollows);
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
    return userFollowsList;
  }

}
