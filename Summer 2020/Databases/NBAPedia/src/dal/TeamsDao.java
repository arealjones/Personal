package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Teams;

public class TeamsDao {
    protected ConnectionManager connectionManager;
    private static TeamsDao instance = null;

    protected TeamsDao() {
        this.connectionManager = new ConnectionManager();
    }

    public static TeamsDao getInstance() {
        if (instance == null) {
            instance = new TeamsDao();
        }
        return instance;
    }

    /**
     * Get the Teams record from their teamId. This runs a SELECT statement and returns a single
     * Teams instance.
     */
    public Teams getTeamFromTeamId(int teamId) throws SQLException {
        String selectTeam = "SELECT TeamId,Name,ShortName,Years,TotalGames,TotalWins,TotalLosses,"
                + "Champions,Active,City,State,About FROM Teams WHERE TeamId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectTeam);
            selectStmt.setInt(1, teamId);
            results = selectStmt.executeQuery();
            if (results.next()) {
                int resultTeamId = results.getInt("TeamId");
                String name = results.getString("Name");
                String shortName = results.getString("ShortName");
                int years = results.getInt("Years");
                int totalGames = results.getInt("TotalGames");
                int totalWins = results.getInt("TotalWins");
                int totalLosses = results.getInt("TotalLosses");
                int champions = results.getInt("Champions");
                boolean active = results.getBoolean("Active");
                String city = results.getString("City");
                String state = results.getString("State");
                String about = results.getString("About");
                Teams team = new Teams(resultTeamId, name, shortName, years, totalGames, totalWins,
                        totalLosses, champions, active, city, state, about);
                return team;
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
     * Get the Teams record from their team name. This runs a SELECT statement and returns a single
     * Teams instance.
     */
    public Teams getTeamFromName(String name) throws SQLException {
        String selectTeam = "SELECT TeamId,Name,ShortName,Years,TotalGames,TotalWins,TotalLosses,"
                + "Champions,Active,City,State,About FROM Teams WHERE (Name=? or ShortName=?);";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectTeam);
            selectStmt.setString(1, name);
            selectStmt.setString(2, name);
            results = selectStmt.executeQuery();
            if (results.next()) {
                int resultTeamId = results.getInt("TeamId");
                String teamName = results.getString("Name");
                String shortName = results.getString("ShortName");
                int years = results.getInt("Years");
                int totalGames = results.getInt("TotalGames");
                int totalWins = results.getInt("TotalWins");
                int totalLosses = results.getInt("TotalLosses");
                int champions = results.getInt("Champions");
                boolean active = results.getBoolean("Active");
                String city = results.getString("City");
                String state = results.getString("State");
                String about = results.getString("About");
                Teams team = new Teams(resultTeamId, teamName, shortName, years, totalGames,
                        totalWins,
                        totalLosses, champions, active, city, state, about);
                return team;
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
     * Get a list of all Teams. */
    public List<Teams> getTeams() throws SQLException {
        String selectTeam = "SELECT * FROM Teams";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        List<Teams> teams = new ArrayList<>();
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectTeam);
            results = selectStmt.executeQuery();
            while (results.next()) {
                int resultTeamId = results.getInt("TeamId");
                String teamName = results.getString("Name");
                String shortName = results.getString("ShortName");
                int years = results.getInt("Years");
                int totalGames = results.getInt("TotalGames");
                int totalWins = results.getInt("TotalWins");
                int totalLosses = results.getInt("TotalLosses");
                int champions = results.getInt("Champions");
                boolean active = results.getBoolean("Active");
                String city = results.getString("City");
                String state = results.getString("State");
                String about = results.getString("About");
                Teams team = new Teams(resultTeamId, teamName, shortName, years, totalGames,
                        totalWins,
                        totalLosses, champions, active, city, state, about);
                teams.add(team);
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
        return teams;
    }

    public List<Teams> getActiveTeams() throws SQLException {
        String selectTeam = "SELECT * FROM Teams WHERE Active=TRUE";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        List<Teams> teams = new ArrayList<>();

        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectTeam);
            results = selectStmt.executeQuery();
            while (results.next()) {
                int resultTeamId = results.getInt("TeamId");
                String teamName = results.getString("Name");
                String shortName = results.getString("ShortName");
                int years = results.getInt("Years");
                boolean active = results.getBoolean("Active");
                int totalGames = results.getInt("TotalGames");
                int totalWins = results.getInt("TotalWins");
                int totalLosses = results.getInt("TotalLosses");
                int champions = results.getInt("Champions");
                String city = results.getString("City");
                String state = results.getString("State");
                String about = results.getString("About");
                Teams team = new Teams(resultTeamId, teamName, shortName, years, totalGames,
                        totalWins,
                        totalLosses, champions, active,city, state, about);
                teams.add(team);
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
        return teams;
    }
}
