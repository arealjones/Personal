package servlet;

import dal.TeamsDao;
import dal.UsersDao;
import java.util.HashMap;
import java.util.Map;
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
import java.util.List;

@WebServlet("/teams")
public class TeamsList extends HttpServlet {
    private TeamsDao teamsDao;

    @Override
    public void init() throws ServletException {
        this.teamsDao = TeamsDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        List<Teams> teamsList = null;
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        try {
            teamsList = teamsDao.getTeams();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException(e);
        }
        messages.put("title", "All Teams");
        req.setAttribute("teamsList", teamsList);
        req.getRequestDispatcher("/teams.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
