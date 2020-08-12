package dal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Games;
import model.PlayerGameStats;

import java.sql.*;
import model.PlayerSeasonStats;
import model.PlayerSeasons;
import model.Players;

/**
 * @author Sun Yu
 * @create 2020-07-05-7:29 AM
 */
public class PlayerGameStatsDao {
    private ConnectionManager connectionManager;

    private static PlayerGameStatsDao instance = null;
    protected PlayerGameStatsDao() {
        connectionManager = new ConnectionManager();
    }
    public static PlayerGameStatsDao getInstance() {
        if(instance == null) {
            instance = new PlayerGameStatsDao();
        }
        return instance;
    }

    /**
     * Save the PlayerGameStatsDao instance by storing it in your MySQL instance.
     * This runs a INSERT statement.
     */

    public PlayerGameStats create(PlayerGameStats playerGameStats) throws SQLException {
        String insertPlayerGameStats =
                "INSERT INTO PlayerGameStats(PlayerGameStatId,FG,FGA,FGP,FG3,FG3A,FG3P,FT,FTA,FTP,ORB,DRB,TRB,AST,STL,TOV,PTS,PF,BLK,GameId,PlayerSeasonId,PlayerId) " +
                        "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        ResultSet resultKey = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertPlayerGameStats,
                    Statement.RETURN_GENERATED_KEYS);
            insertStmt.setInt(1, playerGameStats.getPlayerGameStatId());
            insertStmt.setInt(2, playerGameStats.getFG());
            insertStmt.setInt(3, playerGameStats.getFGA());
            insertStmt.setDouble(4, playerGameStats.getFGP());
            insertStmt.setInt(5, playerGameStats.getFG3());
            insertStmt.setInt(6, playerGameStats.getFG3A());
            insertStmt.setDouble(7, playerGameStats.getFG3P());
            insertStmt.setInt(8, playerGameStats.getFT());
            insertStmt.setInt(9, playerGameStats.getFTA());
            insertStmt.setDouble(10, playerGameStats.getFTP());
            insertStmt.setInt(11, playerGameStats.getORB());
            insertStmt.setInt(12, playerGameStats.getDRB());
            insertStmt.setInt(13, playerGameStats.getTRB());
            insertStmt.setInt(14, playerGameStats.getAST());
            insertStmt.setInt(15, playerGameStats.getSTL());
            insertStmt.setInt(16, playerGameStats.getTOV());
            insertStmt.setInt(17, playerGameStats.getPTS());
            insertStmt.setInt(18, playerGameStats.getPF());
            insertStmt.setInt(19, playerGameStats.getBLK());
            insertStmt.setInt(20, playerGameStats.getGame().getGameId());


            insertStmt.executeUpdate();

            // Retrieve the auto-generated key and set it
            resultKey = insertStmt.getGeneratedKeys();
            int playerGameStatId = -1;
            if(resultKey.next()) {
                playerGameStatId = resultKey.getInt(1);
            } else {
                throw new SQLException("Unable to retrieve auto-generated key.");
            }
            playerGameStats.setPlayerGameStatId(playerGameStatId);
            return playerGameStats;
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

    /**
     * Delete the PlayerGameStats instance.
     * This runs a DELETE statement.
     */
    public PlayerGameStats delete(PlayerGameStats playerGameStats) throws SQLException {

        String deletePlayerAwards = "DELETE FROM PlayerGameStats WHERE PlayerGameStatId=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deletePlayerAwards);
            deleteStmt.setInt(1, playerGameStats.getPlayerGameStatId());
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
     * select some PlayerGameStats of one player for a sepecific game
     */
    public PlayerGameStats getPlayerGameStats(int gameId, String name) throws SQLException {

        String selectPlayerAwards =
                "SELECT PlayerGameStatId, FG, FGA, FGP, FG3, FG3A, GameId,PlayerSeasonId,PlayerId " +
                        "FROM PlayerGameStats left JOIN Players " +
                        "ON PlayerGameStats.PlayerId = Players.PlayerId " +
                        "WHERE Players.Name=? AND GameId =?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectPlayerAwards);
            selectStmt.setString(1, name);
            selectStmt.setInt(2, gameId);
            results = selectStmt.executeQuery();
            if(results.next()) {
                int playerGameStatId = results.getInt("PlayerGameStatId");
                int fg = results.getInt("FG");
                int fga = results.getInt("FGA");
                double fgp = results.getDouble("FGP");
                int fg3 = results.getInt("FG3");
                int fg3a = results.getInt("FG3A");



                PlayerGameStats playerGameStats = new PlayerGameStats(playerGameStatId,fg,fga,fgp,fg3,fg3a);
                return playerGameStats;
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
     * Calculates the player season stats
     * @param playerId the playerId for the player season stats to calculate
     * @return List of player season stats
     * @throws SQLException
     */
    public List<PlayerSeasonStats> getPlayerSeasonStats(int playerId) throws SQLException {
        List<PlayerSeasonStats> playerSeasonStatsList = new ArrayList<>();
        String selectByPlayerId = "SELECT PlayerSeasonId, G.Season, AVG(FGP) AS FGP, AVG(FG3P) "
            + " AS FG3P, AVG(FTP) AS FTP, \n"
            + "\tAVG(ORB + DRB) AS TRB, AVG(AST) AS AST, AVG(BLK) AS BLK, AVG(STL) AS STL, \n"
            + "    AVG(PTS) AS PTS\n"
            + "FROM ((SELECT * FROM PlayerSeasons WHERE PlayerID = ?) AS T \n"
            + "\tINNER JOIN PlayerGameStats USING(PlayerSeasonId))  \n"
            + "    INNER JOIN (SELECT * FROM Games WHERE Playoff = 0) AS G\n"
            + "    USING(GameId)\n"
            + "GROUP BY PlayerSeasonId, G.Season;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectByPlayerId);
            selectStmt.setInt(1, playerId);

            results = selectStmt.executeQuery();
            PlayerSeasonsDao playerSeasonsDao = PlayerSeasonsDao.getInstance();
            while (results.next()) {
                String season = results.getString("Season");
                double fgp = results.getDouble("FGP");
                double fg3p = results.getDouble("FG3P");
                double ftp = results.getDouble("FTP");
                int trb = results.getInt("TRB");
                int ast = results.getInt("AST");
                int stl = results.getInt("STL");
                int pts = results.getInt("pts");
                int blk = results.getInt("blk");
                int playerSeasonId = results.getInt("PlayerSeasonId");
                PlayerSeasons playerSeason = playerSeasonsDao.getPlayerSeasonsByPlayerSeasonId(playerSeasonId);
                PlayerSeasonStats playerSeasonStats = new PlayerSeasonStats(fgp, fg3p, ftp, trb, ast, stl
                    , pts, blk, season, playerSeason);
                playerSeasonStatsList.add(playerSeasonStats);
            }
            return playerSeasonStatsList;
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


    private PlayerGameStats getGameStatsHelper(ResultSet result) throws SQLException {
        GamesDao gamesDao = GamesDao.getInstance();
        PlayerSeasonsDao playerSeasonsDao = PlayerSeasonsDao.getInstance();

        int playerGameStatId = result.getInt("PlayerGameStatId");
        int fg = result.getInt("FG");
        int fga = result.getInt("FGA");
        double fgp = result.getDouble("FGP");
        int fg3 = result.getInt("FG3");
        int fg3a = result.getInt("FG3A");
        double fg3p = result.getDouble("FG3P");
        int ft = result.getInt("FT");
        int fta = result.getInt("FTA");
        double ftp = result.getDouble("FTP");
        int orb = result.getInt("ORB");
        int drb = result.getInt("DRB");
        int trb = result.getInt("TRB");
        int ast = result.getInt("AST");
        int stl = result.getInt("STL");
        int tov = result.getInt("TOV");

        int pts = result.getInt("pts");
        int pf = result.getInt("pf");
        int blk = result.getInt("blk");
        int gameId = result.getInt("GameId");
        int playerSeasonId = result.getInt("PlayerSeasonId");

        Games game = gamesDao.getGamesById(gameId);
        PlayerSeasons playerSeason = playerSeasonsDao.getPlayerSeasonsByPlayerSeasonId(playerSeasonId);
        PlayerGameStats playerGameStats = new PlayerGameStats(playerGameStatId, fg, fga, fgp, fg3, fg3a, fg3p, ft,
            fta, ftp, orb, drb, trb, ast, stl, tov, pts, pf, blk, game, playerSeason);
        return playerGameStats;
    }

    public List<PlayerGameStats> getAllPlayerGameStats(int gameId) throws SQLException {
        String selectPlayerGameStats = "SELECT * FROM PlayerGameStats WHERE GameId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        List<PlayerGameStats> stats = new ArrayList<>();
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectPlayerGameStats);
            selectStmt.setInt(1, gameId);
            results = selectStmt.executeQuery();
            GamesDao gamesDao = GamesDao.getInstance();
            PlayerSeasonsDao playerSeasonsDao = PlayerSeasonsDao.getInstance();

            while (results.next()) {
                int playerGameStatId = results.getInt("PlayerGameStatId");
                int fg = results.getInt("FG");
                int fga = results.getInt("FGA");
                double fgp = results.getDouble("FGP");
                int fg3 = results.getInt("FG3");
                int fg3a = results.getInt("FG3A");
                double fg3p = results.getDouble("FG3P");
                int ft = results.getInt("FT");
                int fta = results.getInt("FTA");
                double ftp = results.getDouble("FTP");
                int orb = results.getInt("ORB");
                int drb = results.getInt("DRB");
                int trb = results.getInt("TRB");
                int ast = results.getInt("AST");
                int stl = results.getInt("STL");
                int tov = results.getInt("TOV");
                int pts = results.getInt("PTS");
                int pf = results.getInt("PF");
                int blk = results.getInt("BLK");
                int playerSeasonId = results.getInt("PlayerSeasonId");

                Games game = gamesDao.getGamesById(gameId);
                PlayerSeasons playerSeason = playerSeasonsDao.getPlayerSeasonsByPlayerSeasonId(playerSeasonId);


                PlayerGameStats playerGameStats = new PlayerGameStats(playerGameStatId, fg, fga, fgp, fg3, fg3a, fg3p, ft,
                    fta, ftp, orb, drb, trb, ast, stl, tov, pts, pf, blk, game, playerSeason);
                stats.add(playerGameStats);
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
        return stats;
    }

}
