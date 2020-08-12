package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Teams;
import model.Users;

public class UsersDao {
  protected ConnectionManager connectionManager;

  private static UsersDao instance = null;
  protected UsersDao() {
    connectionManager = new ConnectionManager();
  }
  public static UsersDao getInstance() {
    if(instance == null) {
      instance = new UsersDao();
    }
    return instance;
  }

  /** Save the Users instance by storing it in MySQL instance. This runs a INSERT statement. */
  public Users create(Users user) throws SQLException {
    String insertUser = "INSERT INTO Users(Username,Password,FavouriteTeamId) VALUES(?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, user.getUsername());
      insertStmt.setString(2, user.getPassword());
      insertStmt.setInt(3, user.getFavouriteTeam().getTeamId());
      insertStmt.executeUpdate();
      resultKey = insertStmt.getGeneratedKeys();
      int UserId = -1;
      if (resultKey.next()) {
        UserId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      user.setUserId(UserId);
      return user;
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
      if(resultKey != null) {
        resultKey.close();
      }
    }
  }

  /** Delete the Users instance. This runs a DELETE statement. */
  public Users delete(Users user) throws SQLException {
    String deleteUser = "DELETE FROM Users WHERE UserId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteUser);
      deleteStmt.setInt(1, user.getUserId());
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
   * Update the users favorite team. This runs a UPDATE statement. */
  public Users updateFavouriteTeam(Users user, Teams newFavouriteTeam) throws SQLException {
    String updateUser = "UPDATE Users SET FavouriteTeamId=? WHERE UserId=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateUser);
      updateStmt.setInt(1, newFavouriteTeam.getTeamId());
      updateStmt.setInt(2, user.getUserId());
      updateStmt.executeUpdate();
      user.setFavouriteTeam(newFavouriteTeam);
      return user;
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

  /**
   * Update the users password. This runs a UPDATE statement. */
  public Users updatePassword(Users user, String newPassword) throws SQLException {
    String updateUser = "UPDATE Users SET Password=? WHERE UserId=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateUser);
      updateStmt.setString(1, newPassword);
      updateStmt.setInt(2, user.getUserId());
      updateStmt.executeUpdate();
      user.setPassword(newPassword);
      return user;
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

  /**
   * Get the Users record from their username. This runs a SELECT statement and returns a single Users instance. */
  public Users getUserFromUserName(String userName) throws SQLException {
    String selectUser = "SELECT UserId,Username,Password,FavouriteTeamId FROM Users WHERE Username=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectUser);
      selectStmt.setString(1, userName);
      results = selectStmt.executeQuery();
      TeamsDao teamsDao = TeamsDao.getInstance();
      if(results.next()) {
        int resultUserId = results.getInt("UserId");
        String username = results.getString("Username");
        String password = results.getString("Password");
        int favouriteTeamId = results.getInt("FavouriteTeamId");
        Teams favouriteTeam = teamsDao.getTeamFromTeamId(favouriteTeamId);
        Users user = new Users(resultUserId, favouriteTeam, username, password);
        return user;
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

  /**
   * Get the Users record from their userId. This runs a SELECT statement and returns a single Users instance. */
  public Users getUserFromUserId(int userId) throws SQLException {
    String selectUser = "SELECT UserId,Username,Password,FavouriteTeamId FROM Users WHERE UserId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectUser);
      selectStmt.setInt(1, userId);
      results = selectStmt.executeQuery();
      TeamsDao teamsDao = TeamsDao.getInstance();
      if(results.next()) {
        int resultUserId = results.getInt("UserId");
        String username = results.getString("Username");
        String password = results.getString("Password");
        int favouriteTeamId = results.getInt("FavouriteTeamId");
        Teams favouriteTeam = teamsDao.getTeamFromTeamId(favouriteTeamId);
        Users user = new Users(resultUserId, favouriteTeam, username, password);
        return user;
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

}
