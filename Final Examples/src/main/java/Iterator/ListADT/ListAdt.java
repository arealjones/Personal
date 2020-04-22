package Iterator.ListADT;

import java.util.Objects;

/**
 * A generic list ADT. The underlying implementation is a recursive linked list.
 * @param <T> */
public class ListAdt<T> implements IListAdt<T> {
    private ILinkedList<T> head;

    /**
     * Private constructor for the List. */
    private ListAdt() {
        this.head = new EmptyNode<>();
    }

    /**
     * Creates an empty List.
     * @return An empty List. */
    public static ListAdt createEmpty() {
        return new ListAdt<>();
    }

    /**
     * Get the item at the specified index.
     * @param index The index of the item to retrieve.
     * @return The item at the index.
     * @throws IndexOutOfBoundsException If the index is out of bounds. */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= this.head.count() || index < 0)
            throw new IndexOutOfBoundsException();
        int i = 0;
        ILinkedList<T> current = this.head;
        while (i != index) {
            current = current.getRest();
            i++;
        }
        return current.getItem();
    }

    /**
     * Add an item to the end of the list.
     * @param item The item to add. */
    @Override
    public void append(T item) throws IndexOutOfBoundsException {
        this.head = this.head.insertAt(item, this.head.count());
    }

    /**
     * Insert an item at the specified index.
     * @param item The item to insert.
     * @param index The index to insert at.
     * @throws IndexOutOfBoundsException If the index is out of bounds. */
    @Override
    public void insert(T item, int index) throws IndexOutOfBoundsException {
        this.head = this.head.insertAt(item, index);
    }

    /**
     * The number of items in the list.
     * @return The number of items in the list. */
    @Override
    public int size() {
        return this.head.count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListAdt<?> listAdt = (ListAdt<?>) o;
        return Objects.equals(head, listAdt.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }

    @Override
    public String toString() {
        return "ListAdt{" +
                "head=" + head +
                '}';
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator. */
    @Override
    public java.util.Iterator iterator() {
        return new ListIterator<>(this);
    }
}
