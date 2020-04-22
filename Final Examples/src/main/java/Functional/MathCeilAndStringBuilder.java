package Functional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MathCeilAndStringBuilder {

  public static void main (String[] args) {
    List<Double> listDoubles = new ArrayList<>();
    listDoubles.add(171.98);
    listDoubles.add(223.45);
    listDoubles.add(345.79);
    listDoubles.add(545.77);
    listDoubles.add(121.33);
    listDoubles.stream().map((Double element) -> Math.ceil(element)).filter((Double value) -> value < 225.00).forEach(System.out::println);
    List<String> phoneNums = new ArrayList<>();
    phoneNums.add("(206) 123-5678");
    phoneNums.add("(425) 345-6789");
    phoneNums.add("(505) 5676789");
    phoneNums.add("(206) 3456789");
    List<String> areaCodes = phoneNums.stream().map(MathCeilAndStringBuilder::getAreaCodes).collect(Collectors.toList());
    areaCodes.stream().forEach(System.out::println);
  }
  /*
  Method takes a String represented in the format (DDD) DDD DDDD, and extracts the first three digits, e.g., extract the area code. @param phoneNumber - input String, that will be modified
  @return areaCode - resulting area code
  */
  public static String getAreaCodes (String s) {
    StringBuilder resultingString = new StringBuilder();
    Pattern pattern = Pattern.compile("(\\d{3})");
    Matcher matcher = pattern.matcher(s);
    if (matcher.find()) {
      resultingString.append(matcher.group(0));
      return resultingString.toString();
    }
    return null;
  }
}
