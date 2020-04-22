import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StringOccurrences {

  /**
   Implement a method, computeStringInfo that consumes a List<Strings>, and returns the following
   information about an individual String in the list:
   • The length of a String, and
   • The number of occurrences of that String in the original list, where occurrances are counted in a
   case-insensitive manner.

   The resulting information should be stored in a Map<String, StringInfo>, where StringInfo
   represents the custom class that you will have to define and implement.

   For example, given the list of Strings: (happy, Easter, bunny, Earth, day, Bunny, DAY)
   The resulting Map should contain:
   happy - length: 5, occurrences: 1
   easter - length: 6, occurrences: 1
   bunny - length: 5, occurrences: 2
   earth - length: 5, occurrences: 1
   day = length: 3, occurrences: 2
   */
  public static class StringInfo {
    private Integer strLength;
    private Integer strOccurence;
    /*
    Constructor for class StringInfo
    @param strLength - an Integer, containing information about the length of a considered String
    @param strOccurence - an Integer, containing information about a number of occurences
    (in a case-insensitive manner) manner of that String in the starting list */
    public StringInfo(Integer strLength, Integer strOccurence) {
      this.strLength = strLength;
      this.strOccurence = strOccurence;
    }
    /*
    Method returns the length of a considered String. @result strLenght
    */
    public Integer getStrLength() { return strLength;
    }
    /*
    Method returns the number of occurrences of a considered String in the starting list. @return strOccurence
    */
    public Integer getStrOccurrence() { return strOccurence;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof StringInfo)) return false;
      StringInfo that = (StringInfo) o;
      return Objects.equals(getStrLength(), that.getStrLength()) &&
          Objects.equals(getStrOccurrence(), that.getStrOccurrence());
    }
    @Override
    public int hashCode() {
      return Objects.hash(getStrLength(), getStrOccurrence()); }

    @Override
    public String toString() {
      return "StringInfo{" +
          "strLength=" + strLength +
          ", strOccurence=" + strOccurence + '}';
    }
  }

  public static class StringStatistics {
    private List<String> elemList = new ArrayList<>();
    private HashMap<String, StringInfo> freqMap = new HashMap<>();
    private static final Integer STARTING_VALUE = 1;

    public Map<String, StringInfo> computeStringInfo(List<String> startingList) {
      Map<String, StringInfo> resultingMap = new HashMap<>();
      int listSize = startingList.size();
      if (startingList == null || startingList.size() == 0) {
        return resultingMap;
      }
      for (String currentStr : startingList) {
        currentStr = currentStr.toLowerCase();
        if (!resultingMap.containsKey(currentStr)) {
          resultingMap.put(currentStr, new StringInfo(currentStr.length(), 1));
        } else {
          resultingMap.put(currentStr, new StringInfo(currentStr.length(), resultingMap.get(currentStr).getStrOccurrence() + 1));
        }
      }
      return resultingMap;
    }
  }

  public static void main(String[] args) {
    StringStatistics myStrStatistics = new StringStatistics();
    myStrStatistics.elemList.add("happy");
    myStrStatistics.elemList.add("Easter");
    myStrStatistics.elemList.add("bunny");
    myStrStatistics.elemList.add("Earth");
    myStrStatistics.elemList.add("day");
    myStrStatistics.elemList.add("Bunny");
    myStrStatistics.elemList.add("day");
    System.out.println("Starting list: ");
    System.out.print(myStrStatistics.elemList);
    Map<String, StringInfo> myResultingMap = new HashMap<>();
    myResultingMap = myStrStatistics.computeStringInfo(myStrStatistics.elemList);
    System.out.println("\nResulting string statistics: ");
    System.out.print(myResultingMap);
  }
}
