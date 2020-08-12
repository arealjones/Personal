package servlet;


import dal.PlayersDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Players;

@WebServlet("/players")
public class PlayersList extends HttpServlet {
  protected PlayersDao playersDao;

  @Override
  public void init()throws ServletException{
    playersDao = PlayersDao.getInstance();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<Players> playersList = null;
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    try {
      playersList = playersDao.getPlayers();
    } catch (SQLException e) {
      e.printStackTrace();
      throw new IOException(e);
    }
    messages.put("title", "All Players");
    req.setAttribute("playersList", playersList);
    req.getRequestDispatcher("/players.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
