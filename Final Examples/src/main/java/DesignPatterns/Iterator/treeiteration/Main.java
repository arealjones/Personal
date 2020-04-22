package DesignPatterns.Iterator.treeiteration;

public class Main {

  public static void main(String[] args) {
    BinaryTree<String> stringTree = new BinaryTree<>();

    stringTree.insert("C");
    stringTree.insert("A");
    stringTree.insert("B");
    stringTree.insert("Q");
    stringTree.insert("O");
    stringTree.insert("D");
    stringTree.insert("X");

    /**
     * The tree structure:
     *     C
     *  A      Q
     *    B  O   X
     *        D
     */

     System.out.println("Default iterator");
     for (String letter: stringTree) {
       System.out.println(letter);
     }

      // BF: C, A, Q, B, O, X, D
     System.out.println("Breadth first iteration");
     BreadthFirstIterator<String> bfi = new BreadthFirstIterator<>(stringTree);
     while (bfi.hasNext())
       System.out.println(bfi.next());

      // DF: C, A, B, Q, O, D, X
    System.out.println("Depth first iteration");
    DepthFirstIterator<String> dfi = new DepthFirstIterator<>(stringTree);
    while (dfi.hasNext())
      System.out.println(dfi.next());

  }

}
