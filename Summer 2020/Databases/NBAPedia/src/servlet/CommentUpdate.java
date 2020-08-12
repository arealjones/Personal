package servlet;

import dal.CommentsDao;
import model.Comments;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/comment/update")
public class CommentUpdate extends HttpServlet {

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
        String content = req.getParameter("content");
        Comments comment;

        System.out.println(content);
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
            commentsDao.updateContent(comment, content);
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("commentMsg", "Error updating comment.");
            req.getRequestDispatcher("/account").forward(req, resp);
            return;
        }

        req.setAttribute("commentMsg", "Success.");
        req.getRequestDispatcher("/account").forward(req, resp);
    }
}
