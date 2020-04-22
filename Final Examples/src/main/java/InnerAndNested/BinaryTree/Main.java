package InnerAndNested.BinaryTree;

public class Main {

  public static void main(String[] args) {
    NestedBinaryTree<String> stringTree = new NestedBinaryTree<>();

    stringTree.insert("C");
    stringTree.insert("A");
    stringTree.insert("B");

    System.out.println(stringTree.contains("A"));
  }

}
