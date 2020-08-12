import dal.CommentsDao;
import dal.PlayerCommentsDao;
import dal.PlayerGameStatsDao;
import dal.PlayersDao;
import dal.UsersDao;
import java.sql.SQLException;
import java.util.List;
import model.Comments;
import model.PlayerComments;
import model.PlayerSeasonStats;
import model.Players;
import model.Users;

public class Tester {
  public static void main(String[] args) throws SQLException {
    PlayerGameStatsDao  playerGameStatsDao = PlayerGameStatsDao.getInstance();
    PlayerCommentsDao playerCommentsDao = PlayerCommentsDao.getInstance();
    CommentsDao commentsDao = CommentsDao.getInstance();
    PlayersDao playersDao = PlayersDao.getInstance();
    UsersDao usersDao = UsersDao.getInstance();

    List<PlayerSeasonStats> playerSeasonStatsList = playerGameStatsDao.getPlayerSeasonStats(1);
    PlayerSeasonStats seasonStats = playerSeasonStatsList.get(0);
    System.out.println(seasonStats.getSeason());

//    PlayersDao playersDao = PlayersDao.getInstance();
//    Players player = playersDao.getPlayerById(1);
//    System.out.println(player.getName());

//    List<PlayerComments> playerCommentsList = playerCommentsDao.getPlayerCommentsFromPlayer(3);
//    for (PlayerComments comments: playerCommentsList) {
//      System.out.println(comments.getCreated());
//    }

    Players players = playersDao.getPlayerById(1);
    Users users = usersDao.getUserFromUserId(1);
    PlayerComments playerComment = new PlayerComments(users, "Use 1 commenting for player 1",
        players);

    System.out.println(playerComment.getUser().getUsername());
    System.out.println(playerComment.getPlayer().getName());

  }
}
