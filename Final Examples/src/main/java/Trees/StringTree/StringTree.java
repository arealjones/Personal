package Trees.StringTree;

public class StringTree {
  public StringTreeNode root;

  public StringTree (String data, String dataLeft, String dataRight) {
    StringTreeNode leftChild = new StringTreeNode(dataLeft);
    StringTreeNode rightChild = new StringTreeNode(dataRight);
    this.root = new StringTreeNode(data, leftChild, rightChild);
  }

  public StringTreeNode getRoot(){
    return this.root;
  }

}
