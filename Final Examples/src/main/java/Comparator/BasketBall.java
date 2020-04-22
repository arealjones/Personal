package Comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BasketBall {

  public static class Player {
    private String name;
    private Integer age;
    private Double height;
    private String club;
    public Player(String name, Integer age, Double height, String club) {
      this.name = name;
      this.age = age;
      this.height = height;
      this.club = club;
    }
    public String getName() {
      return name;
    }
    public Integer getAge() {
      return age;
    }
    public Double getHeight() {
      return height;
    }
    public String getClub() {
      return club;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      if (other == null || getClass() != other.getClass()) return false; Player player = (Player) other;
      return Objects.equals(name, player.name)
          && Objects.equals(age, player.age)
          && Objects.equals(height, player.height) && Objects.equals(club, player.club);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, age, height, club);
    }
    @Override
    public String toString() {
      return "Player{" + "name:’" + name + '\'' + ", club=’" + club + '}';
    }
  }

  /**
   Using map to split them up by club.
   */

//  public static void main(String[] args) {
//    List<Player> players = new ArrayList<>();
//    players.add(new Player("LeBron James", 33, 6.8, "Cleveland Cavaliers"));
//    players.add(new Player("Kevin Durant", 29, 6.9, "Golden State Warriors"));
//    players.add(new Player("Stephen Curry", 30, 6.3, "Golden State Warriors"));
//
//    Comparator<Player> name = new Comparator<Player>() {
//      @Override
//      public int compare(Player o1, Player o2) {
////        System.out.println(o1.getName());
////        System.out.println(o2.getName());
//        return o1.getName().compareTo(o2.getName()); }
//    };
//
//    System.out.println("Players:" + players);
//    players.sort(name);
//    //System.out.println(players);
//    System.out.println("Players again: " + players.stream().map(Player::getClub).collect
//        (Collectors.toList()));
//  }


  /**
   Using filter to get a specific height.
   */

  public static void main(String[] arg) {
    List<Player> players = new ArrayList<>();
    players.add(new Player("LeBron James", 33, 6.8, "Cleveland Cavaliers"));
    players.add(new Player("Kevin Durant", 29, 6.9, "Golden State Warriors"));
    players.add(new Player("Stephen Curry", 30, 6.3, "Golden State Warriors"));
    players.add(new Player("Carmelo Anthony", 33, 6.8, "Oklahoma City Thunder"));

    Comparator<Player> club = new Comparator<Player>() {
      @Override
      public int compare(Player o1, Player o2) {
        return o1.getClub().compareTo(o2.getClub());
      }
    };
    players.sort(club);

    players.stream().filter((Player val) -> val.getAge() >= 30 && val.getHeight() >= 6.8)
        .forEach(System.out::println);

    List resultingPlayers = players.stream().filter((Player val) -> val.getHeight() > 6.3)
        .map(Player::getName)
        .collect(Collectors.toList());

    System.out.println("Filtered players: " + resultingPlayers);
  }

}
