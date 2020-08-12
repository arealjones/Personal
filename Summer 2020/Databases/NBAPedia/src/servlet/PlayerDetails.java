package servlet;


import dal.CommentsDao;
import dal.PlayerAwardsDao;
import dal.PlayerCommentsDao;
import dal.PlayerGameStatsDao;
import dal.PlayerRecommendationDao;
import dal.PlayerSeasonsDao;
import dal.PlayersDao;
import dal.UserViewHistoryDao;
import dal.UsersDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PlayerAwards;
import model.PlayerComments;
import model.PlayerSeasonStats;
import model.PlayerSeasons;
import model.Players;
import model.UserViewHistory;
import model.Users;
import org.apache.mahout.cf.taste.common.TasteException;

@WebServlet("/playerdetails")
public class PlayerDetails extends HttpServlet {
  protected PlayersDao playersDao;
  protected PlayerGameStatsDao playerGameStatsDao;
  protected PlayerAwardsDao playerAwardsDao;
  protected PlayerSeasonsDao playerSeasonsDao;
  protected UserViewHistoryDao userViewHistoryDao;
  protected UsersDao usersDao;
  protected PlayerRecommendationDao playerRecommendationDao;
  protected PlayerCommentsDao playerCommentsDao;
  protected CommentsDao commentsDao;
  protected int playerId;

  @Override
  public void init()throws ServletException {
    playersDao = PlayersDao.getInstance();
    playerGameStatsDao = PlayerGameStatsDao.getInstance();
    playerAwardsDao = PlayerAwardsDao.getInstance();
    playerSeasonsDao = PlayerSeasonsDao.getInstance();
    userViewHistoryDao = UserViewHistoryDao.getInstance();
    usersDao = UsersDao.getInstance();
    playerRecommendationDao = PlayerRecommendationDao.getInstance();
    playerCommentsDao = PlayerCommentsDao.getInstance();
    commentsDao = CommentsDao.getInstance();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);
    String userName = (String) req.getSession().getAttribute("username");


    playerId = Integer.parseInt(req.getParameter("playerId"));
    if (userName == null || userName.trim().isEmpty()) {
      messages.put("title", "Invalid username.");
    } else {
      messages.put("title", "Player Details For " + userName);
    }

    // Retrieve Players, and store in the request.
    Players player;
    List<PlayerSeasonStats> playerSeasonStatsList;
    List<PlayerAwards> playerAwardsList;
    List<PlayerSeasons> playerChampionList;
    List<Players> playersRecList;
    List<PlayerComments> playerCommentsList;
    Users user = null;
    try {
      player = playersDao.getPlayerById(playerId);
      if (userName != null) {
        UserViewHistory userViewHistory = userViewHistoryDao.getByUserNameAndPlayer(userName, playerId);
        user = usersDao.getUserFromUserName(userName);
        if (userViewHistory == null) {
          userViewHistory = new UserViewHistory(1, player, user);
          userViewHistory = userViewHistoryDao.create(userViewHistory);
        } else {
          int viewCount = userViewHistory.getViewCount() + 1;
          userViewHistory = userViewHistoryDao.updateViewCount(viewCount, userViewHistory);
        }
        playersRecList =
            playerRecommendationDao.getPlayerRecommendations(user.getUserId(), playerId);
      } else {
        playersRecList = playerRecommendationDao.getMostViewedPlayers();
      }
      playerSeasonStatsList = playerGameStatsDao.getPlayerSeasonStats(playerId);
      playerAwardsList = playerAwardsDao.getPlayerAwardByPlayerId(playerId);
      playerChampionList = playerSeasonsDao.getChampionPlayerSeasonss(playerId);
      playerCommentsList = playerCommentsDao.getPlayerCommentsFromPlayer(playerId);

    } catch (SQLException | TasteException e) {
      e.printStackTrace();
      throw new IOException(e);
    }
    req.setAttribute("player", player);
    req.setAttribute("playersRecList", playersRecList);
    req.setAttribute("playerSeasonStatsList", playerSeasonStatsList);
    req.setAttribute("playerAwardsList", playerAwardsList);
    req.setAttribute("playerChampionList", playerChampionList);
    req.setAttribute("playerCommentsList", playerCommentsList);
    req.getRequestDispatcher("/playerdetails.jsp").forward(req, resp);
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String userName = (String) req.getSession().getAttribute("username");
    String commentContent = req.getParameter("comment");
    Players player = null;
    Users user;
    PlayerComments playerComment;
    System.out.println("UserName: " + userName);
    if (userName == null || userName.trim().isEmpty()) {
      req.setAttribute("addPlayerCommentMsg", "Please sign up or login to make comments");
    } else {
      try {
        user = usersDao.getUserFromUserName(userName);
        player = playersDao.getPlayerById(playerId);
        playerComment = new PlayerComments(user, commentContent, player);
        playerComment = playerCommentsDao.create(playerComment);
      } catch (SQLException e) {
        throw new IOException();
      }
      req.setAttribute("addPlayerCommentMsg", "Comment Uploaded");
      req.setAttribute("playerId", player.getPlayerId());
    }
    resp.sendRedirect("/playerdetails?playerId=" + playerId);
  }
}
