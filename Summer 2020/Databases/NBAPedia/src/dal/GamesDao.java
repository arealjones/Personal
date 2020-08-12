package dal;

import model.Games;
import model.Players;
import model.Teams;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sun Yu
 * @create 2020-07-05-3:51 AM
 */
public class GamesDao {
    protected ConnectionManager connectionManager;

    private static GamesDao instance = null;
    protected GamesDao() {
        connectionManager = new ConnectionManager();
    }
    public static GamesDao getInstance() {
        if(instance == null) {
            instance = new GamesDao();
        }
        return instance;
    }

    public Games getGamesById(int gameId) throws SQLException {
        String selectGameById = "SELECT * FROM Games WHERE GameId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectGameById);

            selectStmt.setInt(1, gameId);
            results = selectStmt.executeQuery();
            if (results.next()) {
                Games games = this.getGameHelper(results);
                return games;
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

    private Games getGameHelper(ResultSet results) throws SQLException {
        TeamsDao teamsDao = TeamsDao.getInstance();
        int gameId = results.getInt("GameId");
        int homeTeamId = results.getInt("HomeTeamId");
        int awayTeamId = results.getInt("AwayTeamId");
        int homeTeamScore = results.getInt("HomeTeamScore");
        int awayTeamScore = results.getInt("AwayTeamScore");
        int ots = results.getInt("OTs");
        Date date = new Date(results.getTimestamp("Date").getTime());
        boolean playoff = results.getBoolean("Playoff");
        String season = results.getString("Season");
        Teams homeTeam = teamsDao.getTeamFromTeamId(homeTeamId);
        Teams awayTeam = teamsDao.getTeamFromTeamId(awayTeamId);
        Games game = new Games(gameId, homeTeam, awayTeam, homeTeamScore, awayTeamScore,
            ots, date, playoff, season);
        return game;
    }


    /**
     * Save the Games instance by storing it in your MySQL instance.
     * This runs a INSERT statement.
     */

    public Games create(Games games) throws SQLException {
        String insertGames =
                "INSERT INTO Games(GameId,HomeTeamId,AwayTeamId,HomeTeamScore,AwayTeamScore,OTs,Date,Playoff,Season) " +
                        "VALUES(?,?,?,?,?,?,?,?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;

        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertGames);

            insertStmt.setInt(1, games.getGameId());
            insertStmt.setInt(2, games.getHomeTeam().getTeamId());
            insertStmt.setInt(3, games.getAwayTeam().getTeamId());
            insertStmt.setInt(4, games.getHomeTeamScore());
            insertStmt.setInt(5, games.getAwayTeamScore());
            insertStmt.setInt(6, games.getOTs());
            insertStmt.setDate(7, new Date(games.getDate().getTime()));
            insertStmt.setBoolean(8, games.isPlayOff());
            insertStmt.setString(9, games.getSeason());
            insertStmt.executeUpdate();
            return games;
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
     * Update the HomeTeamScore and AwayTeamScore of the Games instance.
     * This runs a UPDATE statement.
     */
    public Games updateHomeTeamScoreAndAwayTeamScore(Games games, int newHomeTeamScore, int newAwayTeamScore) throws SQLException {
        String updateGames = "UPDATE Games SET HomeTeamScore=?,AwayTeamScore=?,date=? WHERE gameId=?;";
        Connection connection = null;
        PreparedStatement updateStmt = null;
        try {
            connection = connectionManager.getConnection();
            updateStmt = connection.prepareStatement(updateGames);
            updateStmt.setInt(1, newHomeTeamScore);
            updateStmt.setInt(2, newAwayTeamScore);
            updateStmt.setDate(3, new Date(games.getDate().getTime()));
            updateStmt.setInt(4, games.getGameId());
            updateStmt.executeUpdate();

            // Update the blogPost param before returning to the caller.
            games.setHomeTeamScore(newHomeTeamScore);
            games.setAwayTeamScore(newAwayTeamScore);
            return games;
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
     * Delete the Games instance.
     * This runs a DELETE statement.
     */
    public Games delete(Games games) throws SQLException {

        String deleteGames = "DELETE FROM Games WHERE GameId=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deleteGames);
            deleteStmt.setInt(1, games.getGameId());
            deleteStmt.executeUpdate();

            // Return null so the caller can no longer operate on the Games instance.
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
     * Get the all the Games for one homeTeam, sorted by latest to first game
     */
    public List<Games> getGamesForhomeTeam(Teams homeTeam) throws SQLException {
        List<Games> games = new ArrayList<Games>();
        String selectGames =
                "SELECT GameId,HomeTeamId,AwayTeamId,HomeTeamScore,AwayTeamScore,OTs,Date,Playoff,Season " +
                        "FROM Games " +
                        "WHERE HomeTeamId=?;" +
                        "ORDER BY DESC ";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectGames);
            selectStmt.setInt(1, homeTeam.getTeamId());
            results = selectStmt.executeQuery();
            TeamsDao teamsDao = TeamsDao.getInstance();


            while(results.next()) {
                int gameId = results.getInt("GameId");
                int awayTeamId = results.getInt("AwayTeamId");
                int HomeTeamScore = results.getInt("HomeTeamScore");
                int AwayTeamScore = results.getInt("AwayTeamScore");
                int OTs = results.getInt("OTs");
                boolean playOff = results.getBoolean("Playoff");
                String season = results.getString("Season");
                java.util.Date date =  new java.util.Date(results.getDate("Date").getTime());

                Teams team = teamsDao.getTeamFromTeamId(awayTeamId);
                Games games1 = new Games(gameId, homeTeam, team, HomeTeamScore,AwayTeamScore,OTs,date,playOff,season);
                games.add(games1);
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
        return games;
    }

    /**
     * Get a list of all Games.
     */
    public List<Games> getGames() throws SQLException {
        String selectGame = "SELECT * FROM Games LIMIT 200";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        List<Games> games = new ArrayList<>();
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectGame);
            results = selectStmt.executeQuery();
            TeamsDao teamsDao = TeamsDao.getInstance();


            while(results.next()) {
                int gameId = results.getInt("GameId");
                int homeTeamId = results.getInt("HomeTeamId");
                int awayTeamId = results.getInt("AwayTeamId");
                int HomeTeamScore = results.getInt("HomeTeamScore");
                int AwayTeamScore = results.getInt("AwayTeamScore");
                int OTs = results.getInt("OTs");
                java.util.Date date =  new java.util.Date(results.getDate("Date").getTime());
                boolean playOff = results.getBoolean("Playoff");
                String season = results.getString("Season");

                Teams team1 = teamsDao.getTeamFromTeamId(homeTeamId);
                Teams team2 = teamsDao.getTeamFromTeamId(awayTeamId);
                Games games1 = new Games(gameId, team1, team2, HomeTeamScore,AwayTeamScore,OTs,date,playOff,season);
                games.add(games1);
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
        return games;
    }

}
