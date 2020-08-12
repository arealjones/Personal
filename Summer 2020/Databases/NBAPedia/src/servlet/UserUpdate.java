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

@WebServlet("/user/update")
public class UserUpdate extends HttpServlet {

    private UsersDao usersDao;
    private TeamsDao teamsDao;

    @Override
    public void init() throws ServletException {
        this.usersDao = UsersDao.getInstance();
        this.teamsDao = TeamsDao.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username") == null) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

        String username = req.getSession().getAttribute("username").toString();
        String password = req.getParameter("password");
        int teamId = Integer.parseInt(req.getParameter("favTeam"));

        Users user;
        try {
            user = usersDao.getUserFromUserName(username);
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("msg", "Username not found.");
            req.getRequestDispatcher("/account").forward(req, resp);
            return;
        }

        if (!password.isEmpty() && !user.getPassword().equals(password)) {
            try {
                usersDao.updatePassword(user, password);
            } catch (SQLException e) {
                e.printStackTrace();
                req.setAttribute("msg", "Error updating password.");
                req.getRequestDispatcher("/account").forward(req, resp);
                return;
            }
        }

        try {
            if (user.getFavouriteTeam().getTeamId() != teamId) {
                Teams team = teamsDao.getTeamFromTeamId(teamId);
                usersDao.updateFavouriteTeam(user, team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("msg", "Error updating favorite team.");
            req.getRequestDispatcher("/account").forward(req, resp);
        }

        req.setAttribute("msg", "Success.");
        req.getRequestDispatcher("/account").forward(req, resp);
    }
}
