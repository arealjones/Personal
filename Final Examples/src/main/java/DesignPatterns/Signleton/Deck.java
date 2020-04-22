package DesignPatterns.Signleton;

public class Deck {

  /**
  You are asked to design a deck of cards for a card game. The deck of cards consists of 52 cards.
  Each card has a value and a suite.

  A value for a card can be any number from 2 to 10 or one of the special values A, J, Q, or K.
  A suite can be one of hearts, diamonds, clubs or spades.

  A deck of cards consists of:
  13 cards whose suite is hearts for each of the possible card values,i.e.,A,2,3,4,5,6,7,8,9,10,J,Q,K
  13 cards whose suite is diamonds for each of the possible card values,i.e.,A,2,3,4,5,6,7,8,9,10,J,Q,K
  13 cards whose suite is spades for each of the possible card values,i.e.,A,2,3,4,5,6,7,8,9,10,J,Q,K
  13 cards whose suite is clubs for each of the possible card values,i.e.,A,2,3,4,5,6,7,8,9,10,J,Q,K
  */

  /**
   * Provide the implementation of your library’s method that clients are supposed to use in order
   * to obtain a valid deck of cards. You only need to show the code for your method. You may assume
   * constructors, getters and setters as well as standard implementations of equals and hashCode
   * for your classes.
   */

//  public static List<Card> getDeck() {
//    List<Card> deck = new ArrayList<>();
//    Suite[] suites = {Clubs.getInstance(), Spades.getInstance(), Hearts.getInstance(),
//        Diamonds.getInstance()
//    };
//    Value[] vals = {Ace.getInstance(), Two.getInstance(), Three.getInstance(), Four.getInstance(),
//        Five.getInstance(), Six.getInstance(), Seven.getInstance(), Eight.getInstance(),
//        Nine.getInstance(), Ten.getInstance(), Jack.getInstance(), Queen.getInstance(), King.getInstance()
//        };
//    for (Suite s : suites) {
//      for (Value val : vals) {
//      deck.add(new Card(s, val));
//      }
//    }
//    return deck;
//  }

  /**
   In order to show to your manager how other developers can use your library for a deck of cards
   provide a method that would consume a list of cards and would calculate the total score of the
   list of cards based on the following scoring scale

   Card Value A=1 2=2 3=3 4=4 5=5 6=6 7=7 8=8 9=9 10=10 J=-1 Q=-2 K=-3
  */

//  public static int score(List<Card> hand) {
//      Map<Value, Integer> cardToScore = new HashMap<>();
//      cardToScore.put(Ace.getInstance(), 1);
//      cardToScore.put(Two.getInstance(), 2);
//      cardToScore.put(Three.getInstance(), 3);
//      cardToScore.put(Four.getInstance(), 4);
//      cardToScore.put(Five.getInstance(), 5);
//      cardToScore.put(Six.getInstance(), 6);
//      cardToScore.put(Seven.getInstance(), 7);
//      cardToScore.put(Eight.getInstance(), 8);
//      cardToScore.put(Nine.getInstance(), 9);
//      cardToScore.put(Ten.getInstance(), 10);
//      cardToScore.put(Jack.getInstance(), -1);
//      cardToScore.put(Queen.getInstance(), -2);
//      cardToScore.put(King.getInstance(), -3);
//      int result = 0;
//      for (Card card : hand) {
//        result += cardToScore.get(card.getValue());
//      }
//      return result;
//    }

}
