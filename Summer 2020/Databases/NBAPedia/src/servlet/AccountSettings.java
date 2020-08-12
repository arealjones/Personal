package servlet;

import dal.PlayerCommentsDao;
import dal.TeamCommentsDao;
import dal.TeamsDao;
import dal.UsersDao;
import model.PlayerComments;
import model.TeamComments;
import model.Teams;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/account")
public class AccountSettings extends HttpServlet {

    private UsersDao usersDao;
    private TeamsDao teamsDao;
    private PlayerCommentsDao playerCommentsDao;
    private TeamCommentsDao teamCommentsDao;

    @Override
    public void init() throws ServletException {
        this.usersDao = UsersDao.getInstance();
        this.teamsDao = TeamsDao.getInstance();
        this.playerCommentsDao = PlayerCommentsDao.getInstance();
        this.teamCommentsDao = TeamCommentsDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username") == null) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

        String username = (String) req.getSession().getAttribute("username");
        req.setAttribute("username", username);
        Users user;
        try {
            user = usersDao.getUserFromUserName(username);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException();
        }
        req.setAttribute("user", user);

        List<Teams> teams;
        try {
            teams = this.teamsDao.getActiveTeams();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException();
        }

        req.setAttribute("teams", teams);

        List<PlayerComments> playerComments;
        try {
            playerComments = playerCommentsDao.getPlayerCommentsFromUser(user.getUserId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException();
        }
        req.setAttribute("playerComments", playerComments);
        System.out.println(playerComments);

        List<TeamComments> teamComments;
        try {
            teamComments = teamCommentsDao.getTeamCommentsFromUser(user.getUserId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException();
        }
        req.setAttribute("teamComments", teamComments);
        System.out.println(teamComments);

        req.getRequestDispatcher("/accountSettings.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
