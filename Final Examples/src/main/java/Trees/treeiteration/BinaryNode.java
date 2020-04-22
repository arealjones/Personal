package Trees.treeiteration;

import java.util.Objects;

public class BinaryNode<T> {
  private T data;

  private BinaryNode<T> leftTree;

  private BinaryNode<T> rightTree;

  public BinaryNode(T data) {
    this(data, null, null);
  }

  public BinaryNode(T data, BinaryNode<T> leftTree, BinaryNode<T> rightTree) {
    this.data = data;
    this.leftTree = leftTree;
    this.rightTree = rightTree;
  }

  public T getData() {
    return this.data;
  }

  public BinaryNode<T> getLeftTree() {
    return this.leftTree;
  }

  public BinaryNode<T> getRightTree() {
    return this.rightTree;
  }

  public void setLeftTree(BinaryNode<T> node) {
    this.leftTree = node;
  }

  public void setRightTree(BinaryNode<T> node) {
    this.rightTree = node;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BinaryNode<?> that = (BinaryNode<?>) o;
    return Objects.equals(getData(), that.getData()) &&
            Objects.equals(getLeftTree(), that.getLeftTree()) &&
            Objects.equals(getRightTree(), that.getRightTree());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getData(), getLeftTree(), getRightTree());
  }
}
