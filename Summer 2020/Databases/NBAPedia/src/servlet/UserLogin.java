package servlet;

import dal.UsersDao;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class UserLogin extends HttpServlet {

    private UsersDao usersDao;

    @Override
    public void init() throws ServletException {
        this.usersDao = UsersDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Users user = null;

        try {
            user = this.usersDao.getUserFromUserName(username);
        } catch (SQLException e) {
            req.setAttribute("succeed", false);
            req.setAttribute("msg", "Failed to log you in, please try again later.");
            e.printStackTrace();
        }

        if (user == null || !password.equals(user.getPassword())) {
            req.setAttribute("succeed", false);
            req.setAttribute("msg", "Incorrect username or password.");
        }

        if (req.getAttribute("succeed") == null) {
            req.setAttribute("succeed", true);
            req.setAttribute("msg", "Succeed! Going to the home page in 3 seconds.");
            req.getSession().setAttribute("username",username);
        }

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
