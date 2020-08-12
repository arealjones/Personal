package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Players;
import model.UserViewHistory;
import model.Users;

public class UserViewHistoryDao {
  private ConnectionManager connectionManager;

  private static UserViewHistoryDao instance = null;
  protected UserViewHistoryDao() {
    connectionManager = new ConnectionManager();
  }
  public static UserViewHistoryDao getInstance() {
    if(instance == null) {
      instance = new UserViewHistoryDao();
    }
    return instance;
  }


  /** Save the UserViewHistory instance by storing it in MySQL instance. This runs a INSERT statement. */
  public UserViewHistory create(UserViewHistory userView) throws SQLException {
    String insertUserView = "INSERT INTO UserViewHistory(UserId,ViewCount,PlayerId) "
        + "VALUES(?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertUserView, Statement.RETURN_GENERATED_KEYS);

      insertStmt.setInt(1, userView.getUser().getUserId());
      insertStmt.setInt(2, userView.getViewCount());
      insertStmt.setInt(3, userView.getPlayer().getPlayerId());
      insertStmt.executeUpdate();
      resultKey = insertStmt.getGeneratedKeys();
      int UserViewHistoryId = -1;
      if (resultKey.next()) {
        UserViewHistoryId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      userView.setUserViewHistoryId(UserViewHistoryId);
      return userView;
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

  /**
   * Get the list of UserViewHistory records based on the userId. This runs a SELECT statement and
   * returns a list of matching UserViewHistory. */
  public List<UserViewHistory> getUserViewHistoryFromUserId(int userId) throws SQLException {
    List<UserViewHistory> userViewHistoryList = new ArrayList<>();
    String selectUserViewHistory = "SELECT * FROM UserViewHistory WHERE UserId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectUserViewHistory);
      selectStmt.setInt(1, userId);
      results = selectStmt.executeQuery();
      PlayersDao playersDao = PlayersDao.getInstance();
      UsersDao usersDao = UsersDao.getInstance();
      while(results.next()) {
        int resultUserViewHistoryId = results.getInt("UserViewHistoryId");
        int viewCount = results.getInt("ViewCount");
        int PlayerId = results.getInt("PlayerId");
        Players player = playersDao.getPlayerById(PlayerId);
        int UserId = results.getInt("UserId");
        Users user = usersDao.getUserFromUserId(UserId);
        UserViewHistory userViews = new UserViewHistory(resultUserViewHistoryId, viewCount, player, user);
        userViewHistoryList.add(userViews);
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
    return userViewHistoryList;
  }

  public List<Integer> getMostViewedPlayers(int numOfPlayers) throws SQLException {
    List<Integer> playersIdList = new ArrayList<>();
    String selectMostViewedPlayers = "SELECT PlayerId, COUNT(ViewCount) AS CNT \n"
        + "FROM UserViewHistory \n"
        + "GROUP BY PlayerId \n"
        + "ORDER BY CNT \n"
        + "DESC LIMIT ?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectMostViewedPlayers);

      selectStmt.setInt(1, numOfPlayers);
      results = selectStmt.executeQuery();
      while (results.next()) {
        int playerId = results.getInt("PlayerId");
        playersIdList.add(playerId);
      }
      return playersIdList;
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
  }


  public UserViewHistory getByUserNameAndPlayer(String username, int playerId) throws SQLException {
    String selectUserViewHistory = "SELECT * FROM Users INNER JOIN UserViewHistory USING(UserId) "
        + "WHERE UserName=? AND PlayerId =?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    UserViewHistory userViews = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectUserViewHistory);
      selectStmt.setString(1, username);
      selectStmt.setInt(2, playerId);
      results = selectStmt.executeQuery();
      PlayersDao playersDao = PlayersDao.getInstance();
      UsersDao usersDao = UsersDao.getInstance();
      while(results.next()) {
        int resultUserViewHistoryId = results.getInt("UserViewHistoryId");
        int viewCount = results.getInt("ViewCount");
        int PlayerId = results.getInt("PlayerId");
        Players player = playersDao.getPlayerById(PlayerId);
        int UserId = results.getInt("UserId");
        Users user = usersDao.getUserFromUserId(UserId);
        userViews = new UserViewHistory(resultUserViewHistoryId, viewCount, player, user);
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
    return userViews;
  }


  public UserViewHistory updateViewCount(int newCount, UserViewHistory userViewHistory) throws
      SQLException {
    String updateCount = "UPDATE UserViewHistory SET ViewCount=? WHERE UserViewHistoryId=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateCount);
      updateStmt.setInt(1, newCount);
      updateStmt.setInt(2, userViewHistory.getUserViewHistoryId());

      updateStmt.executeUpdate();
      userViewHistory.setViewCount(newCount);
      return userViewHistory;
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

}
