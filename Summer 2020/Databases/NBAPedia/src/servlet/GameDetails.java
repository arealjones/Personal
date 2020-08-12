package servlet;

import dal.GamesDao;
import dal.PlayerGameStatsDao;
import model.Games;
import model.PlayerGameStats;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sun Yu
 * @create 2020-07-16-4:25 AM
 */

@WebServlet("/gameinfo")
public class GameDetails extends HttpServlet {
  protected GamesDao gamesDao;
  protected PlayerGameStatsDao playerGameStatsDao;

  @Override
  public void init()throws ServletException {
    gamesDao = GamesDao.getInstance();
    playerGameStatsDao = PlayerGameStatsDao.getInstance();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);
    String userName = req.getParameter("username");
    int gameId = Integer.parseInt(req.getParameter("gameId"));
    if (userName == null || userName.trim().isEmpty()) {
      messages.put("title", "Invalid username.");
    } else {
      messages.put("title", "Game Details For " + userName);
    }
    Games game;
    List<PlayerGameStats> playerGameStatsList;
    try {
      game = gamesDao.getGamesById(gameId);
      playerGameStatsList = playerGameStatsDao.getAllPlayerGameStats(gameId);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new IOException(e);
    }
    req.setAttribute("game", game);

    req.setAttribute("playerGameStatsList", playerGameStatsList);
    req.getRequestDispatcher("/gamedetails.jsp").forward(req, resp);
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doPost(req, resp);
  }

}