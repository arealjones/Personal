package dal;

import model.Champions;
import model.Teams;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChampionsDao {
    private ConnectionManager connectionManager;

    private static ChampionsDao instance = null;

    protected ChampionsDao() {
        connectionManager = new ConnectionManager();
    }

    public static ChampionsDao getInstance() {
        if (instance == null) {
            instance = new ChampionsDao();
        }
        return instance;
    }

    public List<Champions> getChampions() throws SQLException {
        List<Champions> champions = null;
        String selectChampions = "SELECT ChampionId,Season,TeamId FROM Champions;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectChampions);
            results = selectStmt.executeQuery();
            champions = wrapChampionList(results);
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
        return champions;
    }

    public List<Champions> getChampionByTeam(Teams team) throws SQLException {
        List<Champions> champions = null;
        String selectChampions = "SELECT ChampionId,Season,TeamId FROM Champions WHERE TeamId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectChampions);
            selectStmt.setInt(1, team.getTeamId());
            results = selectStmt.executeQuery();
            champions = wrapChampionList(results);
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
        return champions;
    }

    private List<Champions> wrapChampionList(ResultSet results) throws SQLException {
        List<Champions> champions = new ArrayList<>();
        while (results.next()) {
            int championId = results.getInt("ChampionId");
            String season = results.getString("Season");
            int teamId = results.getInt("TeamId");
            Teams team = TeamsDao.getInstance().getTeamFromTeamId(teamId);

            Champions champion = new Champions(championId, season, team);
            champions.add(champion);
        }
        return champions;
    }
}
