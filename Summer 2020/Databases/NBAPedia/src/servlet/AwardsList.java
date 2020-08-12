package servlet;

import dal.PlayerAwardsDao;
import model.PlayerAwards;
import model.Players;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sun Yu
 * @create 2020-07-12-7:26 AM
 */

@WebServlet("/award")
public class AwardsList extends HttpServlet {

    protected PlayerAwardsDao playerAwardsDao;

    @Override
    public void init() throws ServletException {
        playerAwardsDao = PlayerAwardsDao.getInstance();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate Name.
        String name = req.getParameter("name");
        if (name == null || name.trim().isEmpty()) {
            messages.put("title", "Invalid name.");
        } else {
            messages.put("title", "Awards for " + name);
        }

        // Retrieve PlayerAwards, and store in the request.
        List<PlayerAwards> playerAwards = new ArrayList<PlayerAwards>();
        try {
            Players player = new Players(name);
            playerAwards = playerAwardsDao.getPlayerAwardsByPlayer(player);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException(e);
        }
        req.setAttribute("award", playerAwards);
        req.getRequestDispatcher("/awards.jsp").forward(req, resp);
    }
}
