import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlattenedListIntegersTest {

  private List<Integer> list1 = new ArrayList<>();
  private List<Integer> list2 = new ArrayList<>();
  private List<Integer> list3 = new ArrayList<>();
  private List<List<Integer>> gtList1 = new ArrayList<>();
  private List<List<Integer>> gtList2 = new ArrayList<>();
  private List<List<Integer>> gtList3 = new ArrayList<>();
  private List<Integer> resList1 = new ArrayList();
  private List<Integer> resList2 = new ArrayList();
  private FlattenedListIntegers myFTList = new FlattenedListIntegers();

  @Before
  public void setUp() throws Exception {
    gtList1.add(list1);
    gtList1.add(list1);
    gtList1.add(list1);
    list2.add(7);
    list2.add(4);
    list2.add(5);
    list2.add(8);
    gtList2.add(list2);
    list3.add(10);
    list3.add(15);
    list3.add(10);
    gtList3.add(list2);
    gtList3.add(list3);
    resList1.add(4);
    resList1.add(8);
    resList2.add(4);
    resList2.add(8);
    resList2.add(10);
  }

  @Test
  public void testNullFlattening() {
    //Testing the flattening of an empty list
    Assert.assertEquals(list1, myFTList.flatten(gtList1));
  }

  @Test
  public void TestFlatteningNoRepeatedElements() {
    //Testing the flattening of list of a list without duplicate elements
    Assert.assertEquals(resList2, myFTList.flatten(gtList3));
  }

  @Test
  public void testDuplicatenFlattening() {
    //Testing the flattening of a list with duplicate elements
    Assert.assertEquals(resList1, myFTList.flatten(gtList2));
  }

}