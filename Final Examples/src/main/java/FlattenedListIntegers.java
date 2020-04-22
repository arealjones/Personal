import java.util.ArrayList;
import java.util.List;

public class FlattenedListIntegers {

  public List<Integer> flatten(List<List<Integer>> llp) {
    List<Integer> result = new ArrayList<>();
    for (List<Integer> lp: llp) {
      for(Integer intNumber: lp) {
        if((intNumber % 2 == 0) && !result.contains(intNumber))
          result.add(intNumber);
      }
    }
    return result;
  }

}
