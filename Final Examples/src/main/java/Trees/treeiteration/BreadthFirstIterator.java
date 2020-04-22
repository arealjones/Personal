package Trees.treeiteration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BreadthFirstIterator<T extends Comparable<T>> implements Iterator<T> {
    private List<BinaryNode<T>> queue;

    public BreadthFirstIterator(BinaryTree<T> tree) {
        this.queue =  new ArrayList<>();
        this.queue.add(tree.root);
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
        return this.queue.size() > 0;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public T next() {
        // Add child nodes to the queue
        BinaryNode<T> first = this.queue.get(0);
        if (first.getLeftTree()!= null)
            this.queue.add(first.getLeftTree());
        if (first.getRightTree() != null)
            this.queue.add(first.getRightTree());
        T data = first.getData();
        // Take the processed node off the queue
        this.queue.remove(0);
        return data;
    }
}
