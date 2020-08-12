package dal;

import java.util.Date;
import model.PlayerAwards;
import model.PlayerSeasons;
import model.Players;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sun Yu
 * @create 2020-07-05-6:21 AM
 */
public class PlayerAwardsDao {
    private ConnectionManager connectionManager;

    private static PlayerAwardsDao instance = null;
    protected PlayerAwardsDao() {
        connectionManager = new ConnectionManager();
    }
    public static PlayerAwardsDao getInstance() {
        if(instance == null) {
            instance = new PlayerAwardsDao();
        }
        return instance;
    }

    /**
     * Save the PlayerAwards instance by storing it in your MySQL instance.
     * This runs a INSERT statement.
     */

    public PlayerAwards create(PlayerAwards playerAwards) throws SQLException {
        String insertPlayerAwards =
            "INSERT INTO PlayerAwards(PlayerAwardId,Award,Season,PlayerId,PlayerSeasonId) " +
                "VALUES(?,?,?,?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertPlayerAwards);
            insertStmt.setInt(1, playerAwards.getPlayerAwardId());
            insertStmt.setString(2, playerAwards.getAward());
            insertStmt.setString(3, playerAwards.getSeason());
            insertStmt.setInt(4, playerAwards.getPlayer().getPlayerId());
            insertStmt.setInt(5, playerAwards.getPlayerSeason().getPlayerSeasonId());
            insertStmt.executeUpdate();
            return playerAwards;
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
     * Delete the PlayerAwards instance.
     * This runs a DELETE statement.
     */
    public PlayerAwards delete(PlayerAwards playerAwards) throws SQLException {

        String deletePlayerAwards = "DELETE FROM PlayerAwards WHERE PlayerAwardId=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deletePlayerAwards);
            deleteStmt.setInt(1, playerAwards.getPlayerAwardId());
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



    public List<PlayerAwards> getPlayerAwardsByPlayer(Players player) throws SQLException {
        List<PlayerAwards> playerAwards = new ArrayList<PlayerAwards>();
        String selectPlayerAwards =
            "SELECT PlayerAwardId,Award,Season,PlayerId,PlayerSeasonId  " +
                "FROM PlayerAwards left JOIN Players " +
                "  ON PlayerAwards.PlayerId = Players.PlayerId " +
                "WHERE Players.Name=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectPlayerAwards);
            selectStmt.setString(1, player.getName());
            results = selectStmt.executeQuery();
            PlayersDao playersDao = PlayersDao.getInstance();
            PlayerSeasonsDao playerSeasonsDao = PlayerSeasonsDao.getInstance();

            while(results.next()) {
                int playerAwardId = results.getInt("PlayerAwardId");
                String award = results.getString("Award");
                String season = results.getString("Season");
                int playerId = results.getInt("PlayerId");
                int playerSeasonId = results.getInt("PlayerSeasonId");

                Players players = playersDao.getPlayerById(playerId);
                PlayerSeasons playerSeasons = playerSeasonsDao.getPlayerSeasonsByPlayerSeasonId(playerSeasonId);


                PlayerAwards playerAwards1 = new PlayerAwards(playerAwardId,award,season,players,playerSeasons);
                playerAwards.add(playerAwards1);
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
        return playerAwards;
    }


    public List<PlayerAwards> getPlayerAwardByPlayerId(int playerId) throws SQLException {
        List<PlayerAwards> playerAwardsList = new ArrayList<>();
        String selectPlayerById = "SELECT * FROM PlayerAwards WHERE PlayerId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectPlayerById);

            selectStmt.setInt(1, playerId);
            results = selectStmt.executeQuery();
            while (results.next()) {
                PlayerAwards playerAward = this.getPlayerAwardHelper(results);
                playerAwardsList.add(playerAward);
            }
            return playerAwardsList;
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



    private PlayerAwards getPlayerAwardHelper(ResultSet results) throws SQLException {
        PlayersDao playersDao = PlayersDao.getInstance();
        PlayerSeasonsDao playerSeasonsDao = PlayerSeasonsDao.getInstance();
        int playerAwardId = results.getInt("PlayerAwardId");
        String award = results.getString("Award");
        String season = results.getString("Season");
        int playerId = results.getInt("PlayerId");
        int playerSeasonId = results.getInt("PlayerSeasonId");

        Players players = playersDao.getPlayerById(playerId);
        PlayerSeasons playerSeasons = playerSeasonsDao.getPlayerSeasonsByPlayerSeasonId(playerSeasonId);


        PlayerAwards playerAward = new PlayerAwards(playerAwardId,award,season,players,playerSeasons);
        return playerAward;
    }





}
