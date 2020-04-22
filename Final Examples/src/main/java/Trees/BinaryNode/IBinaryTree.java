package Trees.BinaryNode;

public interface IBinaryTree<T extends Comparable<T>> {
  void makeEmpty();

  boolean isEmpty();

  boolean contains(T x);

  T findMin();

  T findMax();

  void insert(T x);

  void remove(T x);
}
