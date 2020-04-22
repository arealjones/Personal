package DesignPatterns.Iterator.treeiteration;

import java.util.*;

public class DepthFirstIterator<T extends Comparable<T>> implements Iterator<T> {
    private Stack<BinaryNode<T>> stack;
    private List<BinaryNode<T>> visited; // put nodes here after both sides checked
    private BinaryNode<T> current;

    public DepthFirstIterator(BinaryTree<T> tree) {
        this.stack = new Stack<>();
        this.visited = new ArrayList<>();
        this.current = tree.root;
        this.dfTraversal();
    }

    private void dfTraversal() {
        while (!this.stack.isEmpty() || this.current != null) {
            while (this.current == null) {
                if (!this.stack.isEmpty()) {
                    this.current = this.stack.pop();
                    this.current = this.current.getRightTree();
                } else break;
            }
            if (this.current != null) {
                this.stack.push(this.current);
                if (!this.visited.contains(this.current))
                    this.visited.add(this.current);
                this.current = this.current.getLeftTree();
            }
        }
    }
    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return !this.visited.isEmpty();
    }
    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public T next() {
        T data = this.visited.get(0).getData();
        this.visited.remove(0);
        return data;
    }

}
