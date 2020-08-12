package servlet;

import dal.TeamsDao;
import dal.UsersDao;
import model.Teams;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/signup")
public class UserCreate extends HttpServlet {

    private UsersDao usersDao;
    private TeamsDao teamsDao;

    @Override
    public void init() throws ServletException {
        this.usersDao = UsersDao.getInstance();
        this.teamsDao = TeamsDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teams> teams = new ArrayList<>();
        try {
            teams = this.teamsDao.getTeams();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException();
        }

        req.setAttribute("teams", teams);
        req.getRequestDispatcher("/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int teamId = Integer.parseInt(req.getParameter("favTeam"));
        Users user;

        System.out.println(teamId);

        try {
            user = this.usersDao.getUserFromUserName(username);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException();
        }

        if (user != null) {
            req.setAttribute("succeed", false);
            req.setAttribute("msg", "Username exists!");
        } else {
            Teams team = null;

            if (teamId > 0) {
                try {
                    team = this.teamsDao.getTeamFromTeamId(teamId);
                } catch (SQLException e) {
                    req.setAttribute("succeed", false);
                    req.setAttribute("msg", "Sign up failed: team not found");
                    e.printStackTrace();
                }
            }

            user = new Users(username, password, team);
            try {
                this.usersDao.create(user);
            } catch (SQLException e) {
                req.setAttribute("succeed", false);
                req.setAttribute("msg", "Sign up failed: error creating new user.");
                e.printStackTrace();
            }
        }

        if (req.getAttribute("succeed") == null) {
            req.setAttribute("succeed", true);
            req.setAttribute("msg", "Succeed! Going to the home page in 3 seconds.");
            req.getSession().setAttribute("username",username);
        }
        req.getRequestDispatcher("/signup.jsp").forward(req, resp);
    }
}
