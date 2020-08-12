package servlet;

import dal.*;
import model.Comments;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/comment/delete")
public class CommentDelete extends HttpServlet {

    private CommentsDao commentsDao;

    @Override
    public void init() throws ServletException {
        this.commentsDao = CommentsDao.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("username") == null) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

        String username = req.getSession().getAttribute("username").toString();
        int commentId = Integer.parseInt(req.getParameter("commentId"));
        Comments comment;
        try {
            comment = commentsDao.getCommentFromCommentId(commentId);
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("commentMsg", "Comments not found.");
            req.getRequestDispatcher("/account").forward(req, resp);
            return;
        }

        if (!comment.getUser().getUsername().equals(username)) {
            req.setAttribute("commentMsg", "Incorrect user.");
            req.getRequestDispatcher("/account").forward(req, resp);
            return;
        }

        try {
            commentsDao.delete(comment);
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("commentMsg", "Error deleting comment.");
            req.getRequestDispatcher("/account").forward(req, resp);
            return;
        }

        req.setAttribute("commentMsg", "Success.");
        req.getRequestDispatcher("/account").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
