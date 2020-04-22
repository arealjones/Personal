package Iterator.ListADT;

public interface IListAdt<T> extends Iterable<T> {

    /**
     * Get the item at the specified index.
     * @param index The index of the item to retrieve.
     * @return The item at the index.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    T get(int index) throws IndexOutOfBoundsException;

    /**
     * Add an item to the end of the list.
     * @param item The item to add.
     */
    void append(T item);

    /**
     * Insert an item at the specified index.
     * @param item The item to insert.
     * @param index The index to insert at.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
     void insert(T item, int index) throws IndexOutOfBoundsException;

    /**
     * The number of items in the list.
     * @return The number of items in the list.
     */
     int size();
}
