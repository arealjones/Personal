package servlet;

import dal.PlayerGameStatsDao;
import dal.PlayersDao;
import dal.TeamCommentsDao;
import dal.TeamSeasonStatsDao;
import dal.TeamsDao;
import dal.UsersDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PlayerComments;
import model.PlayerSeasonStats;
import model.Players;
import model.TeamComments;
import model.TeamSeasonStats;
import model.Teams;
import model.Users;

@WebServlet("/teaminfo")
public class TeamDetails extends HttpServlet {
  protected TeamsDao teamsDao;
  protected PlayersDao playersDao;
  protected TeamSeasonStatsDao teamSeasonStatsDao;
  protected TeamCommentsDao teamCommentsDao;
  protected UsersDao usersDao;
  protected int teamId;

  @Override
  public void init()throws ServletException {
    teamsDao = TeamsDao.getInstance();
    playersDao = PlayersDao.getInstance();
    teamSeasonStatsDao = TeamSeasonStatsDao.getInstance();
    teamCommentsDao = TeamCommentsDao.getInstance();
    usersDao = UsersDao.getInstance();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);
    String userName = req.getParameter("username");
    teamId = Integer.parseInt(req.getParameter("teamId"));
    if (userName == null || userName.trim().isEmpty()) {
      messages.put("title", "Invalid username.");
    } else {
      messages.put("title", "Team Details For " + userName);
    }
    Teams team;
    List<Players> playersList;
    List<TeamSeasonStats> teamSeasonStatsList;
    List<TeamComments> teamCommentsList;
    try {
      team = teamsDao.getTeamFromTeamId(teamId);
      playersList = playersDao.getPlayersByTeamId(teamId);
      teamSeasonStatsList = teamSeasonStatsDao.getAllTeamSeasonStats(teamId);
      teamCommentsList = teamCommentsDao.getTeamCommentsFromTeam(teamId);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new IOException(e);
    }
    req.setAttribute("team", team);
    req.setAttribute("playersList", playersList);
    req.setAttribute("teamSeasonStatsList", teamSeasonStatsList);
    req.setAttribute("teamCommentsList", teamCommentsList);
    req.getRequestDispatcher("/teamdetails.jsp").forward(req, resp);
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String userName = (String) req.getSession().getAttribute("username");
    String commentContent = req.getParameter("comment");
    Teams team = null;
    Users user;
    TeamComments teamComment;
    System.out.println("UserName: " + userName);
    if (userName == null || userName.trim().isEmpty()) {
      req.setAttribute("addTeamCommentMsg", "Please sign up or login to make comments");
    } else {
      try {
        user = usersDao.getUserFromUserName(userName);
        team = teamsDao.getTeamFromTeamId(teamId);
        teamComment = new TeamComments(user, commentContent, team);
        teamComment = teamCommentsDao.create(teamComment);
      } catch (SQLException e) {
        throw new IOException();
      }
      req.setAttribute("addTeamCommentMsg", "Comment Uploaded");
      req.setAttribute("teamId", team.getTeamId());
    }
    resp.sendRedirect("/teaminfo?teamId=" + teamId);
  }

}
