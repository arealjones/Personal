package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TeamSeasonStats;
import model.Teams;

public class TeamSeasonStatsDao {
  protected ConnectionManager connectionManager;

  private static TeamSeasonStatsDao instance = null;
  protected TeamSeasonStatsDao() {
    connectionManager = new ConnectionManager();
  }
  public static TeamSeasonStatsDao getInstance() {
    if(instance == null) {
      instance = new TeamSeasonStatsDao();
    }
    return instance;
  }

  public List<TeamSeasonStats> getAllTeamSeasonStats(int teamId) throws SQLException {
    String selectTeamSeason = "SELECT TeamSeasonStatId,FG,FGA,FGP,FG3,FG3A,FG3P,FT,FTA,FTP,ORB,DRB,"
        + "TRB,AST,STL,TOV,PTS,PF,BLK,Season,TeamID FROM TeamSeasonStats WHERE TeamID=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    List<TeamSeasonStats> stats = new ArrayList<>();
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectTeamSeason);
      selectStmt.setInt(1, teamId);
      results = selectStmt.executeQuery();
      TeamsDao teamsDao = TeamsDao.getInstance();
      while (results.next()) {
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
        String seasonRange = results.getString("Season");
        int teamID = results.getInt("TeamID");
        Teams team = teamsDao.getTeamFromTeamId(teamID);
        TeamSeasonStats teamStats = new TeamSeasonStats(fg, fga, fgp, fg3, fg3a, fg3p, ft, fta, ftp,
            orb, drb, trb, ast, stl, tov, pts, pf, blk, seasonRange, team);
        stats.add(teamStats);
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
