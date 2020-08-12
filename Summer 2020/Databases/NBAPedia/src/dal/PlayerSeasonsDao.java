package dal;

import java.util.ArrayList;
import java.util.List;
import model.PlayerAwards;
import model.PlayerSeasons;
import model.Players;
import model.Teams;

import java.sql.*;

/**
 * @author Sun Yu
 * @create 2020-07-05-8:24 AM
 */
public class PlayerSeasonsDao {
    private ConnectionManager connectionManager;

    private static PlayerSeasonsDao instance = null;
    protected PlayerSeasonsDao() {
        connectionManager = new ConnectionManager();
    }
    public static PlayerSeasonsDao getInstance() {
        if(instance == null) {
            instance = new PlayerSeasonsDao();
        }
        return instance;
    }

    /**
     * Save the PlayerAwards instance by storing it in your MySQL instance.
     * This runs a INSERT statement.
     */

    public PlayerSeasons create(PlayerSeasons playerSeasons) throws SQLException {
        String insertPlayerSeasons =
            "INSERT INTO PlayerSeasons(PlayerSeasonId,PlayerID,Season,TeamId,Salary) " +
                "VALUES(?,?,?,?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertPlayerSeasons);
            insertStmt.setInt(1, playerSeasons.getPlayerSeasonId());
            insertStmt.setInt(2, playerSeasons.getPlayer().getPlayerId());
            insertStmt.setString(3, playerSeasons.getSeason());
            insertStmt.setInt(4, playerSeasons.getTeam().getTeamId());
            insertStmt.setInt(5, playerSeasons.getSalary());
            insertStmt.executeUpdate();
            return playerSeasons;
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
     * Delete the PlayerSeasons instance.
     * This runs a DELETE statement.
     */
    public PlayerSeasons delete(PlayerSeasons playerSeasons) throws SQLException {

        String deletePlayerSeasons = "DELETE FROM PlayerSeasons WHERE PlayerSeasonId=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deletePlayerSeasons);
            deleteStmt.setInt(1, playerSeasons.getPlayerSeasonId());
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

    public PlayerSeasons getPlayerSeasonsByPlayerSeasonId(int playerSeasonId) throws SQLException {

        String selectPlayerSeasons =
            "SELECT PlayerSeasonId,PlayerID,Season,TeamId,Salary " +
                "FROM PlayerSeasons " +
                "WHERE PlayerSeasonId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectPlayerSeasons);
            selectStmt.setInt(1, playerSeasonId);
            results = selectStmt.executeQuery();
            TeamsDao teamsDao = TeamsDao.getInstance();
            PlayersDao playersDao = PlayersDao.getInstance();
            if(results.next()) {
                PlayerSeasons playerSeasons = this.getPlayerSeasonHelper(results);
                return playerSeasons;
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


    public List<PlayerSeasons> getChampionPlayerSeasonss(int playerId) throws SQLException {
        List<PlayerSeasons> playerSeasonsList = new ArrayList<>();
        String selectPlayerSeasonByPlayerId = "SELECT PlayerSeasonId, PlayerId, Salary, TeamId, Season\n"
            + "FROM (\n"
            + "\tSELECT * \n"
            + "\tFROM Teams INNER JOIN Champions \n"
            + "    USING(TeamId)) \n"
            + "AS T INNER JOIN (\n"
            + "\tSELECT * \n"
            + "    FROM PlayerSeasons \n"
            + "    WHERE PlayerId = ?) \n"
            + "AS P USING(TeamId, Season);";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectPlayerSeasonByPlayerId);

            selectStmt.setInt(1, playerId);
            results = selectStmt.executeQuery();
            while (results.next()) {
                PlayerSeasons playerSeasons = this.getPlayerSeasonHelper(results);
                playerSeasonsList.add(playerSeasons);
            }
            return playerSeasonsList;
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


    private PlayerSeasons getPlayerSeasonHelper(ResultSet results) throws SQLException {
        TeamsDao teamsDao = TeamsDao.getInstance();
        PlayersDao playersDao = PlayersDao.getInstance();
        int resultPlayerSeasonId = results.getInt("PlayerSeasonId");
        int playerID = results.getInt("PlayerID");
        String season = results.getString("Season");
        int teamId = results.getInt("TeamId");
        int salary = results.getInt("Salary");

        Teams teams = teamsDao.getTeamFromTeamId(teamId);
        Players player = playersDao.getPlayerById(playerID);

        PlayerSeasons playerSeasons = new PlayerSeasons(resultPlayerSeasonId,
            player, season,teams,salary);
        return playerSeasons;
    }
}
