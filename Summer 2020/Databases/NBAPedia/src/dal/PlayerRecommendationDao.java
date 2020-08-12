package dal;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Players;
import org.apache.mahout.cf.taste.common.NoSuchUserException;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class PlayerRecommendationDao {
  private static final String user = "root";
  // Password for the user.
  private static final String password = "password";
  // URI to your database server. If running on the same machine, then this is "localhost".
  private static final String hostName = "localhost";
  // Port to your database server. By default, this is 3307.
  private static final int port= 3306;
  // Name of the MySQL schema that contains your tables.
  private static final String schema = "NBAPedia";
  // Default timezone for MySQL server.
  private static final String timezone = "UTC";

  private static final int NUMBEROFRECOMMENDATIONS= 4;

  private static PlayerRecommendationDao instance = null;
  public static PlayerRecommendationDao getInstance() {
    if(instance == null) {
      instance = new PlayerRecommendationDao();
    }
    return instance;
  }

  public List<Players> getPlayerRecommendations(int userId, int playerId)
      throws SQLException, TasteException {
    List<Integer> playerIdList = new ArrayList<>();
    List<Players> playerList = new ArrayList<>();
    PlayersDao playersDao = PlayersDao.getInstance();
    this.playerBasedRecommendation(userId,playerId, playerIdList);
    if (playerIdList.size() < NUMBEROFRECOMMENDATIONS) {
      this.userBasedRecommendation(userId, playerId, playerIdList);
    }
    if (playerIdList.size() < NUMBEROFRECOMMENDATIONS) {
      this.getMostViewedPlayersHelper(NUMBEROFRECOMMENDATIONS - playerIdList.size(), playerIdList);
    }
    for (int id: playerIdList) {
      Players player = playersDao.getPlayerById(id);
      playerList.add(player);
    }
    return playerList;
  }

  private void playerBasedRecommendation(int userId, int playerId, List<Integer> playerIdList)
      throws SQLException, TasteException {
    DataModel model = this.dbConnectionHelper();
    ItemSimilarity itemSimilarity = new EuclideanDistanceSimilarity(model);
    Recommender itemRecommender = new GenericItemBasedRecommender(model, itemSimilarity);
    List<RecommendedItem> itemRecommendations;
    try {
      itemRecommendations = itemRecommender.recommend(userId, NUMBEROFRECOMMENDATIONS);
    } catch (NoSuchUserException e) {
      return;
    }
    for (RecommendedItem itemRecommendation : itemRecommendations) {
      int curId = (int) itemRecommendation.getItemID();
      if (playerId != curId) {
        playerIdList.add(curId);
//        System.out.println("Item: " + itemRecommendation.getItemID());
      }
    }
  }


  private void userBasedRecommendation(int userId, int playerId, List<Integer> playerIdList)
      throws SQLException, TasteException {
    DataModel model = this.dbConnectionHelper();
    UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(model);
    UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(5, userSimilarity, model);
    Recommender recommender = new GenericUserBasedRecommender(model, userNeighborhood,
        userSimilarity);
    List<RecommendedItem> recommendedItemList;
    try {
      recommendedItemList = recommender.recommend(userId, NUMBEROFRECOMMENDATIONS);
    } catch (NoSuchUserException e) {
      return;
    }
    for (RecommendedItem itemRecommendation : recommendedItemList) {
      int curId = (int) itemRecommendation.getItemID();
      if (playerId != curId) {
        playerIdList.add(curId);
//        System.out.println("Item: " + itemRecommendation.getItemID());
      }
      if (playerIdList.size() > NUMBEROFRECOMMENDATIONS) {
        return;
      }
    }
  }

  public List<Players> getMostViewedPlayers() throws SQLException {
    List<Integer> playerIdList = new ArrayList<>();
    List<Players> playerList = new ArrayList<>();
    PlayersDao playersDao = PlayersDao.getInstance();
    this.getMostViewedPlayersHelper(NUMBEROFRECOMMENDATIONS, playerIdList);
    for (int id: playerIdList) {
      Players player = playersDao.getPlayerById(id);
      playerList.add(player);
    }
    return playerList;
  }

  private void getMostViewedPlayersHelper(int numberOfPlayersToGet, List<Integer> playerIdList)
      throws SQLException {
    UserViewHistoryDao userViewHistoryDao = UserViewHistoryDao.getInstance();
    List<Integer> result = userViewHistoryDao.getMostViewedPlayers(numberOfPlayersToGet);
    for (int id: result) {
      playerIdList.add(id);
    }
  }

  private DataModel dbConnectionHelper() throws SQLException {
    MysqlDataSource source = new MysqlDataSource();
    source.setServerName(this.hostName);
    source.setUser(this.user);
    source.setPassword(password);
    source.setDatabaseName(this.schema);
    source.setServerTimezone(timezone);
    source.setURL("jdbc:mysql://" + this.hostName + ":" + this.port + "/" + this.schema + "?useSSL=false");
    DataModel model = new MySQLJDBCDataModel(source, "UserViewHistory",
        "UserId", "PlayerId", "ViewCount", timezone);
    return model;
  }

//  public static void main(String args[]) throws IOException, TasteException, SQLException {
//    PlayerRecommendationDao playerRecommendationDao = PlayerRecommendationDao.getInstance();
//    List<Players> playersList = playerRecommendationDao.getPlayerRecommendations(96, 4);
//    for (Players player: playersList) {
//      System.out.println(player.getName());
//    }
//  }
}