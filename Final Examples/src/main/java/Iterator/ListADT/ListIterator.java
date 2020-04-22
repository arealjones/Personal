package Iterator.ListADT;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<T> implements Iterator<T> {
    private IListAdt<T> list;
    private int current;

    public ListIterator(IListAdt<T> list) {
        this.list = list;
        this.current = 0;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     * @return {@code true} if the iteration has more elements */
    @Override
    public boolean hasNext() {
        return this.current < this.list.size();
    }

    /**
     * Returns the next element in the iteration.
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements */
    @Override
    public T next() {
        T item = this.list.get(this.current);
        this.current++;
        return item;
    }
}
