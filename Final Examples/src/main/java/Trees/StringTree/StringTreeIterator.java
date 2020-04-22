package Trees.StringTree;

import Iterator.ContainerExample.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringTreeIterator implements Iterator {
  private List<String> treeList = new ArrayList<>();
  private int listIndex = 0;

  public StringTreeIterator (StringTreeNode root) {
    populateTreeList(treeList, root);
    treeList.sort(values);
  }

  /**
   * Populate treeList with tree values.
   */
  private void populateTreeList (List treeList, StringTreeNode node) {
    if (!node.isEmpty()) {
      treeList.add(node.getData());
      populateTreeList(treeList, node.getLeft());
      populateTreeList(treeList, node.getRight());
    }
  }

  private Comparator<String> values = new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
      if (o1 == null) {
        return -1;
      }
      if (o2 == null) {
        return 1;
      }
      if (o1.equals(o2)) {
        return 0;
      }
      return o1.compareTo(o2);
    }
  };

  public boolean hasNext () {
    return !treeList.isEmpty();
  }

  public String next() {
    listIndex ++;
    if (treeList.size() != listIndex - 1) {
      System.out.println("I’m here:" +listIndex +treeList.size());
      return treeList.get(listIndex);
    } else
      return null;
  }


  public void remove() {
    throw new UnsupportedOperationException("Don’t even think about it!");
  }
}
