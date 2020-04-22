package Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MultiRegex {

  // A.
  /**
   * First String matched? Yes
   * Second String matched? Yes
   * Third String matched? Yes
   * Fourth String matched? Yes
   * I dont know.
   */

  public static void main(String[] args) {
    /**
     REGEX GUIDE:
     -   "*" means you can have multiples of the preceding text.
     -   "|" means or. You can have both sides match to be true. */
    Pattern re1 = Pattern.compile("(CS 5004 )*(CCIS 5004 )*(Spring |Summer 2018 )*(Final |Midterm )*(Exam)");
    Matcher matcher1 = re1.matcher("Exam");
    System.out.println(" First String matched? " + matcher1.matches());               // True
    Matcher matcher2 = re1.matcher("CS 5004 Spring 2018 Exam");
    System.out.println(" Second String matched? " + matcher2.matches());
    Matcher matcher3 = re1.matcher("Final Exam");
    System.out.println(" Third String matched? " + matcher3.matches());                // True
    Matcher matcher4 = re1.matcher("CCIS 5004 Final Exam");
    System.out.println(" Fourth String matched? " + matcher4.matches());                 // True
    Matcher matcher6 = re1.matcher("CCIS 5004 CCIS 5004 Final Exam");
    System.out.println(" Fifth String matched? " + matcher6.matches());                  // True
    Matcher matcher7 = re1.matcher("CCIS 5004 CCIS 5004 Final Exam Exam");
    System.out.println(" Sixth String matched? " + matcher7.matches());
    Matcher matcher8 = re1.matcher("CCIS 5004 CCIS 5004 Final Midterm Exam");
    System.out.println(" Seventh String matched? " + matcher8.matches());                 // True
    Matcher matcher9 = re1.matcher("CCIS 5004 Spring Summer 2018 Final Exam");
    System.out.println(" Eighth String matched? " + matcher9.matches());                   // True
    System.out.println("--------------------------------------------------");
    /**
     MATCHER GUIDE:
     - Find checks to see if the pattern occurs at all in the string.
     - Looking at checks to see if the pattern starts at the beginning of the string.
     - Matches checks if the entire string matches the pattern. */
    Pattern re2 = Pattern.compile("(emi)+([a-z]*)(y)");
    Pattern re3 = Pattern.compile("(emi)");
    Matcher matcher13 = re3.matcher("emilily");
    System.out.println(" Tenth String in it? " + matcher13.find());
    System.out.println(" Tenth String start with? " + matcher13.lookingAt());
    Pattern re4 = Pattern.compile("([a-z]*)");
    Matcher matcher11 = re4.matcher("emilily");
    System.out.println(" Eleventh String in it? " + matcher11.find());
    Pattern re5 = Pattern.compile("(y)");
    Matcher matcher12 = re5.matcher("emilily");
    System.out.println(" Twelveth String in it? " + matcher12.find());
    Matcher matcher5 = re2.matcher("emilily");
    if (matcher5.matches()) {
      for (int i = 1; i <= 3; i++) {
        String s = String.format("Found \"%s\" starting at index %d ending at index %d", matcher5.group(i), matcher5.start(i), matcher5.end(i));
        System.out.println(s);
      }
    }

    System.out.println("--------------------------------------------------");
    /**
     REGEX GUIDE:
     -   "\\d" means a digit. "\\D" means not a digit. */
    Pattern ree1 = Pattern.compile("(\\d{3} )*\\d{3}-\\d{4}");

    Matcher matcher10 = ree1.matcher("(206) 505-6756");
    System.out.println(" First String matched? " + matcher10.matches());                            /** Parenthesis are not included in the regex. The ones you see are just there to group. */
    Matcher matcher20 = ree1.matcher("206 206 505-6767");
    System.out.println(" Second String matched? " + matcher20.matches());                           /** This is a perfect example of full usage. */
    Matcher matcher30 = ree1.matcher("206 505-6756");
    System.out.println(" Third String matched? " + matcher30.matches());                            /** This is a perfect example of full usage. */
    Matcher matcher40 = ree1.matcher("505-6756");
    System.out.println(" Fourth String matched? " + matcher40.matches());
    Matcher matcher50 = ree1.matcher("505-6756 505-6756");
    System.out.println(" Fifth String matched? " + matcher50.matches());                            /** This is because the last seven digits are not in parenthesis. */
    Matcher matcher60 = ree1.matcher("505505-6756");
    System.out.println(" Sixth String matched? " + matcher60.matches());                            /** Shows there has to be a space after the first three digits. */

    System.out.println("--------------------------------------------------");

    List<String> ssNums = new ArrayList<>();
    ssNums.add("123-45-6789");
    ssNums.add("678-90-1234");
    ssNums.add("194-04-2019");
    ssNums.add("200-04-2019");
    List<String> modifiedSSNums = ssNums.stream().map(MultiRegex::modify)
        .collect(Collectors.toList());
    modifiedSSNums.stream().forEach(System.out::println);


    System.out.println("--------------------------------------------------");

    /**
     REGEX GUIDE:
     -  "\\s" means any whitespace character. Must be included. It basically is the find but returns a match.
     -  "\\$" means a dollar sign. */
    // Their solution which is incorrect.
    // Pattern one = Pattern.compile("(\\S)*(p)(assword)*(ass)*(swd)*(a\\$\\$)(\\S)*");
    Pattern one = Pattern.compile("(\\S)*([p]((assword)|(ass)|(swd)|(a\\$\\$))\\w*)");
    Matcher matcher90 = one.matcher("12pa$$12");
    System.out.println(matcher90.matches());
    Matcher matcher91 = one.matcher("pa12");
    System.out.println(matcher91.matches());
    Matcher matcher92 = one.matcher("passwordpassword12");
    System.out.println(matcher92.matches());
    Matcher matcher93 = one.matcher("pass12");
    System.out.println(matcher93.matches());
    Matcher matcher94 = one.matcher("pswd");
    System.out.println(matcher94.matches());
    Matcher matcher95 = one.matcher("12pswd12");
    System.out.println(matcher95.matches());
  }
  /*
  Method takes a String represented in the format AAA-GG-SSSS,
  and replaces the first five elements with stars, i.e., ***-**-SSSS. @param ssNumber - input String, that will be modified
  @return obSsNumber - resulting String
  */
  public static String modify (String s){
    StringBuilder resultingString = new StringBuilder("***-**");
    Pattern pattern = Pattern.compile("-\\d{4}");
    Matcher matcher = pattern.matcher(s);
    if (matcher.find()){
      resultingString.append(matcher.group(0));
      return resultingString.toString();
    }
    return null;
  }
}
