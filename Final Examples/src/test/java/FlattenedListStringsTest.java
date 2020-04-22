import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class FlattenedListStringsTest {
  private List<String> list1 = new ArrayList<>();
  private List<String> list2 = new ArrayList<>();
  private List<String> list3 = new ArrayList<>();
  private List<List<String>> gtList1 = new ArrayList<>();
  private List<List<String>> gtList2 = new ArrayList<>();
  private List<List<String>> gtList3 = new ArrayList<>();
  private List<String> resList1 = new ArrayList();
  private List<String> resList2 = new ArrayList();
  private FlattenedListPairs myFTList = new FlattenedListPairs();

  @Before
  public void setUp() throws Exception {
    gtList1.add(list1);
    gtList1.add(list1);
    gtList1.add(list1);
    list2.add("a");
    list2.add("b");
    list2.add("b");
    list2.add("b");

    list3.add("a");
    list3.add("c");

    gtList2.add(list2);
    gtList2.add(list3);

    gtList3.add(list2);

    resList1.add("a");
    resList1.add("b");
    resList1.add("c");

    resList2.add("a");
    resList2.add("b");
  }

  @Test
  public void testNullFlattening() {
    //Testing the flattening of an empty list
//    Assert.assertEquals(list1, myFTList.flatten(gtList1));
  }
//
//  @Test
//  public void TestFlatteningTheListWithRepeatedElems() {
//  //Testing the flattening of list of single list with repeated elements
//    Assert.assertEquals(resList2, myFTList.flatten(gtList3));
//  }
//
//  @Test
//  public void testDuplicatenFlattening() {
//    //Testing the flattening of a list with duplicate elements
//    Assert.assertEquals(resList1, myFTList.flatten(gtList2));
//  }
}