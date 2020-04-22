import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SaltedVersionStringOccurrences {

  /**
   Implement a method, computeStringInfo that consumes a List<Strings>, and returns the following
   information about those Strings in the list:
   • The salted version of a String in the original list, where the salting denotes an operation where every String is appended by its own hashcode.
   • The length of the original String in the list.

   The resulting information should be stored in a Map<String, SaltedString>, where Salted String
   represents the custom class that you will have to define yourselves.

   For example, given the list of Strings: (happy, Easter, bunny, Earth)
   with corresponding hashcodes: (17, 221, 13, 111)
   The resulting Map should contain:
   happy - happy17, length: 5
   easter - Easter221, length: 6
   bunny - bunny13, length: 5
   earth - Earth111, length: 5
   */

  /**Salted String. */
  public static class SaltedString {
    private String saltedString;
    private Integer strLength;

    public SaltedString(String originalString) {
      StringBuilder helperStringBuilder = new StringBuilder();
      helperStringBuilder = helperStringBuilder.append(originalString).append(originalString.hashCode());
      this.saltedString = helperStringBuilder.toString();
      this.strLength = originalString.length();
    }

    public String getSaltedString() {
      return saltedString;
    }
    public Integer getStrLength() { return strLength;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof SaltedString)) return false;
      SaltedString that = (SaltedString) o;
      return Objects.equals(getSaltedString(), that.getSaltedString()) &&
          Objects.equals(getStrLength(), that.getStrLength());
    }

    @Override
    public int hashCode() {
      return Objects.hash(getSaltedString(), getStrLength());
    }

    @Override
    public String toString() {
      return "SaltedString{" + "saltedString=" + saltedString + ", strLength=" + strLength + '}';
    }
  }

  /**String Salter. */
  public static class StringSalter {
    private List<String> elemList = new ArrayList<>();
    private HashMap<String, SaltedString> saltedStrings = new HashMap<>();

    public Map<String, SaltedString> computeSaltedStrings(List<String> startingList) {
      Map<String, SaltedString> resultingMap = new HashMap<>();
      int listSize = startingList.size();
      if (startingList == null || startingList.size() == 0) {
        return resultingMap;
      }
      for (String currentStr : startingList) {
        if (!resultingMap.containsKey(currentStr)) {
          resultingMap.put(currentStr, new SaltedString(currentStr));
        }
      }
      return resultingMap;
    }
  }

  public static void main(String[] args) {
    StringSalter myStrSalter = new StringSalter();
    myStrSalter.elemList.add("happy");
    myStrSalter.elemList.add("Easter");
    myStrSalter.elemList.add("bunny");
    myStrSalter.elemList.add("Earth");
    myStrSalter.elemList.add("Bunny");
    System.out.println("Starting list: " + myStrSalter.elemList);
    Map<String, SaltedString> myResultingMap = new HashMap<>();
    myResultingMap = myStrSalter.computeSaltedStrings(myStrSalter.elemList);
    System.out.println("\nResulting salted strings: " + myResultingMap);
  }




  }
