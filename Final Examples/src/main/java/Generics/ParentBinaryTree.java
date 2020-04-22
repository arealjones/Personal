package Generics;

public class ParentBinaryTree {

  // INTERFACE
  interface PBT<N> {
    /**
     // B. The library should provide a method to create a new PBT given a value for the root node.
     */
    static <X> PBT<X> create(X value){
      return new PBTHead<>(value);
    }
    Integer edgesToRoot(N value) throws InvalidArgumentException;
    void add(N value);
    void remove(N value);
  }

  // EXCEPTION
  public static class InvalidArgumentException extends Exception {
    public InvalidArgumentException(String message) {
      super(message);
    }
  }

  /**
  // A. PBT nodes can hold any Java reference type. So we can have a node containing any object, e.g.,
  //Integer or String or a user defined Java class. THIS MEANS THAT IT HAS TO BE GENERIC.
   */
  public static class PBTHead<N> implements PBT<N> {
    private Node<N> root;

    public PBTHead(N val) {
      this.root = new Node<>(val, null, null, null);
    }
    /**
      // C. The library should provide a method that returns the total number of nodes in the PBT.
     */
    @Override
    public Integer edgesToRoot(N value) throws InvalidArgumentException {
      if (noTree() || root.isEmpty()) {
        throw new InvalidArgumentException("Empty PBT");
      } else if (root.contains(value)) {
        return root.getNumberOfEdgesToRoot(value);
      } else {
        throw new InvalidArgumentException("PBT must contain value");
      }
    }

    private boolean noTree() {
      return root == null;
    }

    /**
    // D.
    // Checks if there is any nodes in the tree.
    // If there are, checks if the root has a value.
    // Otherwise, it will add a new node.
     */
    @Override
    public void add(N value) {
      if (noTree()) {
        root = new Node<>(value, null, null, null);
      } else if (root.contains(value)) {
        return;
      } else {
        root.addNewNode(value, null);
      }
    }

    /**
    // E.
     */
    @Override
    public void remove(N value) {
      if (noTree() || root.isEmpty() || !root.contains(value)) { // If there isn't a tree, node, or value for the root.
        return;
      } else if (root.getVal().equals(value)) { // If the head has the value to be removed.
        if (root.isLeaf()) {
          root.setVal(null);
        } else if (root.isEmptyLeft()) {
          root = root.getRight();
        } else if (root.isEmptyRight()) {
          root = root.getLeft();
        } else {
          Node<N> oldRight = root.getRight();
          root = root.getLeft();
          root.setParent(null); // old left is now root
          root.addToRightMost(oldRight);
        }
      } else {
        root.removeValue(value, null);
      }
    }

    // NODE
    public class Node<N> {
      private Node<N> right;
      private Node<N> left;
      private N val;
      private Node<N> parent;
      public Node(N val, Node<N> left, Node<N> right, Node<N> parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
      }

      public Node<N> getRight() {
        return right;
      }

      public void setRight(Node<N> right) {
        this.right = right;
      }

      public Node<N> getLeft() {
        return left;
      }

      public void setLeft(Node<N> left) {
        this.left = left;
      }

      public N getVal() {
        return val;
      }

      public void setVal(N val) {
        this.val = val;
      }

      public Node<N> getParent() {
        return parent;
      }

      public void setParent(Node<N> parent) {
        this.parent = parent;
      }

      public boolean isEmpty() { return this.val == null
          && this.left == null
          && this.right == null && this.parent == null;
      }
      public boolean contains(N value) {
        return (this.val == null ? false : this.val.equals(value))
            || (this.left == null ? false : this.left.contains(value))
            || (this.right == null ? false : this.right.contains(value));
      }

      // requires: this.contains(value) == true
      public Integer getNumberOfEdgesToRoot(N value) {
        if (this.val.equals(value)) {
          return this.countParentEdges();
        } else if (!isEmptyRight() && this.right.contains(value)) { // Checks the right side. It cant be empty and has to have a value.
          return this.right.getNumberOfEdgesToRoot(value);
        } else {
          return this.left.getNumberOfEdgesToRoot(value); // If the right side doesnt have anything then it will look at the left side.
        }
      }
      public boolean isEmptyLeft() {
        return this.left == null;
      }
      public boolean isEmptyRight() {
        return this.right == null;
      }
      // If the parent equals null or 0 then return 1 + counting the parent edges.
      private Integer countParentEdges() {
        return parent == null ? 0 : 1 + this.parent.countParentEdges();
      }

      public void addNewNode(N value, Node<N> parent) {
        // Checks if the value is null.
        if (val == null) {
        this.val = value;
        this.parent = parent;
        } else if (isEmptyRight()) { // If it is not null, then checks if the right is empty first.
          this.right = new Node<>(value, null, null, this);
        } else if (isEmptyLeft()) { // If right is full, then it goes to the left.
          this.left = new Node<>(value, null, null, this);
        } else if (this.left.countNodes() < this.right.countNodes()) { // If both the left and right has nodes, then it checks if the left has less.
          this.left.addNewNode(val, this);
        } else {
          this.right.addNewNode(value, this);
        }
      }

      private Integer countNodes() {
        if (isEmptyLeft() && isEmptyRight()) {
          return 1;
        } else if (isEmptyLeft() && !isEmptyRight()) {
          return 1 + this.right.countNodes();
        } else if (!isEmptyLeft() && isEmptyRight()) {
          return 1 + this.left.countNodes(); } else {
          return 1 + this.left.countNodes() + this.right.countNodes(); }
      }
      // required: !this.isEmpty() && this.contains(value)
      public void removeValue(N value, Node<N> newParent) { if (this.val.equals(value)) {
        removeThisNode(newParent);
      } else if (!isEmptyLeft() && this.left.contains(value)) {
        this.left.removeValue(value, this);
      } else if (!isEmptyRight() && this.right.contains(value)) {
        this.right.removeValue(value, this); }
      }
      // Checks that it is at the end of the tree and also has a value.
      public boolean isLeaf() {
        return isEmptyLeft() && isEmptyRight() && val != null;
      }
      private void removeThisNode(Node<N> newParent) {
        if (isLeaf()) {
          removeLeafNode(newParent);
        } else if (isEmptyLeft() && !isEmptyRight()) {
          this.right.setParent(newParent);
          updateParent(newParent, this.right);
          nullify();
        } else if (!isEmptyLeft() && isEmptyRight()) {
          this.left.setParent(newParent);
          updateParent(newParent, this.left);
          nullify();
        } else {
          this.left.setParent(newParent);
          updateParent(newParent, this.left);
          this.left.addToRightMost(this.right);
          nullify();
        }
      }

      private void nullify() { this.val = null; this.left = null; this.right = null; this.parent = null;
      }

      private void removeLeafNode(Node<N> newParent) {
        updateParent(newParent, null);
        this.setVal(null);
        this.setParent(null);
      }

      private void updateParent(Node<N> newParent, Node<N> newChild) {
        if (newParent == null) {
        return;
      } else if (newParent.isEmptyLeft()) {
        newParent.setRight(newChild);
      } else if (newParent.isEmptyRight()) {
        newParent.setLeft(newChild);
      } else if (newParent.getLeft().getVal().equals(this.val)) {
        newParent.setLeft(newChild); } else {
        newParent.setRight(newChild); }
      }
      public void addToRightMost(Node<N> tree) { Node<N> current = this;
        while (current.right != null) {
          current = current.right;
        }
        tree.setParent(current);
        current.right = tree;
      }
    }
  }
}

