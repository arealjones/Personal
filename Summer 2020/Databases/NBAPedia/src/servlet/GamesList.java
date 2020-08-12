package servlet;

import dal.GamesDao;
import dal.PlayerAwardsDao;
import model.Games;
import model.PlayerAwards;
import model.Players;
import model.Teams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sun Yu
 * @create 2020-07-12-10:29 AM
 */
@WebServlet("/games")
public class GamesList extends HttpServlet {
    protected GamesDao gamesDao;

    @Override
    public void init() throws ServletException {
        gamesDao = GamesDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        List<Games> gamesList = null;
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        try {
            gamesList = gamesDao.getGames();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException(e);
        }
        messages.put("title", "All Games");
        req.setAttribute("gamesList", gamesList);
        req.getRequestDispatcher("/games.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        super.doPost(req, resp);
    }
}