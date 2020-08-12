package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Players;


/**
 * Player access object
 */
public class PlayersDao {
  private ConnectionManager connectionManager;

  private static PlayersDao instance = null;
  protected PlayersDao() {
    connectionManager = new ConnectionManager();
  }
  public static PlayersDao getInstance() {
    if(instance == null) {
      instance = new PlayersDao();
    }
    return instance;
  }

  /**
   * Gets player by the playerId
   * @param playerId the playerId
   * @return player object
   * @throws SQLException
   */
  public Players getPlayerById(int playerId) throws SQLException {
    String selectPlayerById = "SELECT * FROM Players WHERE PlayerId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectPlayerById);

      selectStmt.setInt(1, playerId);
      results = selectStmt.executeQuery();
      if (results.next()) {
        Players player = getPlayerHelper(results);
        return player;
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


  /**
   * Gets a list of players based on their name
   * @param name the player name to get
   * @return a list of players
   * @throws SQLException
   */
  public List<Players> getPlayerByName(String name) throws SQLException {
    List<Players> playersList = new ArrayList<>();
    String selectPlayerByName = "SELECT * FROM Players WHERE Name LIKE ? OR "
        + "Name LIKE ? OR FullName LIKE ? OR FullName LIKE ?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectPlayerByName);

      String name1 = "%" + name;
      String name2 = name + "%";
      selectStmt.setString(1, name1);
      selectStmt.setString(2, name2);
      selectStmt.setString(3, name1);
      selectStmt.setString(4, name1);
      results = selectStmt.executeQuery();
      while (results.next()) {
        Players player = getPlayerHelper(results);
        playersList.add(player);
      }
      return playersList;
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


  /**
   * Gets players based on their positions
   * @param position the position
   * @return list of players based on their position
   * @throws SQLException
   */
  public List<Players> getPlayerByPosition(String position) throws SQLException {
    List<Players> playersList = new ArrayList<>();
    String selectPlayerByPosition = "SELECT * FROM Players WHERE Position=? OR Position2=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectPlayerByPosition);

      selectStmt.setString(1, position);
      selectStmt.setString(2, position);
      results = selectStmt.executeQuery();
      while (results.next()) {
        Players player = getPlayerHelper(results);
        playersList.add(player);
      }
      return playersList;
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


  /**
   * Gets players based on they are retired or not
   * @param retired true if players is retired, false otherwise
   * @return list of players
   * @throws SQLException
   */
  public List<Players> getPlayersByRetired(boolean retired) throws SQLException {
    List<Players> playersList = new ArrayList<>();
    String selectPlayerByRetired = "SELECT * FROM Players WHERE Retired=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectPlayerByRetired);

      selectStmt.setBoolean(1, retired);
      results = selectStmt.executeQuery();
      while (results.next()) {
        Players player = getPlayerHelper(results);
        playersList.add(player);
      }
      return playersList;
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


  public List<Players> getPlayersByTeamId(int teamId) throws SQLException {
    List<Players> playersList = new ArrayList<>();
    String selectPlayerByTeamId = "SELECT Players.PlayerId,Players.Name,"
        + "Players.FullName,Players.Position,Players.Position2,Players.Height,Players.Weight,"
        + "Players.BirthDate,Players.Retired,Players.About, Players.ImgUrl FROM PlayerSeasons \n"
        + "INNER JOIN Teams USING (TeamId) \n"
        + "INNER JOIN Players ON (Players.PlayerId = PlayerSeasons.PlayerID)\n"
        + "WHERE Season='2018-19' and TeamId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectPlayerByTeamId);
      selectStmt.setInt(1, teamId);
      results = selectStmt.executeQuery();
      while (results.next()) {
        Players player = getPlayerHelper(results);
        playersList.add(player);
      }
      return playersList;
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


  /**
   * Gets all of the players
   * @return List of players
   * @throws SQLException
   */
  public List<Players> getPlayers() throws SQLException {
    List<Players> playersList = new ArrayList<>();
    String selectPlayerByRetired = "SELECT * FROM Players LIMIT 200;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectPlayerByRetired);

      results = selectStmt.executeQuery();
      while (results.next()) {
        Players player = getPlayerHelper(results);
        playersList.add(player);
      }
      return playersList;
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


  /**
   * Helper method to query players
   * @param result the query result
   * @return a player object from the query
   * @throws SQLException
   */
  private Players getPlayerHelper(ResultSet result) throws SQLException {
    int playerId = result.getInt("PlayerId");
    String name = result.getString("Name");
    String fullName = result.getString("FullName");
    String postion = result.getString("Position");
    String postion2 = result.getString("Position2");
    String height = result.getString("Height");
    int weight = result.getInt("Weight");
    Date birthDate = result.getDate("BirthDate");
    boolean retired = result.getBoolean("Retired");
    String about = result.getString("About");
    String imgUrl = result.getString("ImgUrl");
//    String imgUrl = null;
    Players player = new Players(playerId, name, fullName, postion, postion2, height, weight,
        birthDate, retired, about, imgUrl);
    return player;
  }

}
