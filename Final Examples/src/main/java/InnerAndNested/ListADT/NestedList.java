package InnerAndNested.ListADT;

import java.util.Iterator;
import java.util.Objects;

public class NestedList<T> implements IListAdt<T> {

    private ILinkedListIterable<T> head;

    private NestedList() {
        this.head = new EmptyNode<>();
    }

    public static NestedList createEmpty() {
        return new NestedList();
    }

    /**
     * Get the item at the specified index.
     * @param index The index of the item to retrieve.
     * @return The item at the index.
     * @throws IndexOutOfBoundsException If the index is out of bounds. */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.head.count())
            throw new IndexOutOfBoundsException();
        int i = 0;
        ILinkedListIterable<T> current = this.head;
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
    public void append(T item) {
        this.head = this.head.insertAt(item, this.size());
    }

    /**
     * Insert an item at the specified index.
     * @param item  The item to insert.
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

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator. */
    @Override
    public Iterator<T> iterator() {
        //return new ListIterator<>(this);
        return new LinkedListIterator<>(this.head);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NestedList<?> that = (NestedList<?>) o;
        return Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }

    @Override
    public String toString() {
        return "NestedList{" +
                "head=" + head +
                '}';
    }

    private interface ILinkedListIterable<T> extends Iterable<T> {

        static ILinkedListIterable createEmpty() {
            return new EmptyNode<>();
        }

        /**
         * Gets the number of elements in the list.
         * @return THe number of elements in the list. */
        int count();

        /**
         * Get the item at the head of the list.
         * @return The item at the head of the list or null if the list is empty. */
        T getItem();

        /**
         * Get the rest of the list.
         * @return The rest of the list or null if the list is empty. */
        ILinkedListIterable<T> getRest();

        /**
         * Inserts an element at the specified index.
         * @param item  The item to insert.
         * @param index The index to insert at.
         * @return The linked list with the new item inserted.
         * @throws IndexOutOfBoundsException If the specified index is out of bounds. */
        ILinkedListIterable<T> insertAt(T item, int index) throws IndexOutOfBoundsException;

    }

    private static class ElementNode<T> implements ILinkedListIterable<T> {
        private T item;
        private ILinkedListIterable<T> rest;

        public ElementNode(T item, ILinkedListIterable<T> rest) {
            this.item = item;
            this.rest = rest;
        }

        /**
         * Gets the number of elements in the list.
         * @return THe number of elements in the list. */
        @Override
        public int count() {
            return 1 + this.rest.count();
        }

        /**
         * Get the item at the head of the list.
         * @return The item at the head of the list or null if the list is empty. */
        @Override
        public T getItem() {
            return this.item;
        }

        /**
         * Get the rest of the list.
         * @return The rest of the list or null if the list is empty. */
        @Override
        public ILinkedListIterable<T> getRest() {
            return this.rest;
        }

        /**
         * Inserts an element at the specified index.
         * @param item  The item to insert.
         * @param index The index to insert at.
         * @return The linked list with the new item inserted.
         * @throws IndexOutOfBoundsException If the specified index is out of bounds. */
        @Override
        public ILinkedListIterable<T> insertAt(T item, int index) throws IndexOutOfBoundsException {
            if (index == 0)
                return new ElementNode<>(item, this);
            return new ElementNode<>(this.item, this.rest.insertAt(item, index - 1));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ElementNode<?> that = (ElementNode<?>) o;
            return Objects.equals(getItem(), that.getItem()) &&
                    Objects.equals(getRest(), that.getRest());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getItem(), getRest());
        }

        @Override
        public String toString() {
            return "ElementNode{" +
                    "item=" + item +
                    ", rest=" + rest +
                    '}';
        }

        @Override
        public Iterator<T> iterator() {
            return new LinkedListIterator<>(this);
        }
    }

    private static class EmptyNode<T> implements ILinkedListIterable<T> {

        /**
         * Gets the number of elements in the list.
         * @return THe number of elements in the list. */
        @Override
        public int count() {
            return 0;
        }

        /**
         * Get the item at the head of the list.
         * @return The item at the head of the list or null if the list is empty. */
        @Override
        public T getItem() {
            return null;
        }

        /**
         * Get the rest of the list.
         * @return The rest of the list or null if the list is empty. */
        @Override
        public ILinkedListIterable<T> getRest() {
            return null;
        }

        /**
         * Inserts an element at the specified index.
         * @param item  The item to insert.
         * @param index The index to insert at.
         * @return The linked list with the new item inserted.
         * @throws IndexOutOfBoundsException If the specified index is out of bounds. */
        @Override
        public ILinkedListIterable<T> insertAt(T item, int index) throws IndexOutOfBoundsException {
            if (index != 0)
                throw new IndexOutOfBoundsException();
            return new NestedList.ElementNode<>(item, this);
        }

        @Override
        public int hashCode() {
            return 31;
        }

        @Override
        public boolean equals(Object obj) {
            return this.getClass() == obj.getClass();
        }

        @Override
        public String toString() {
            return "{Empty Node}";
        }

        @Override
        public Iterator<T> iterator() {
            return new LinkedListIterator<>(this);
        }
    }

    private static class LinkedListIterator<T> implements Iterator<T> {
        public ILinkedListIterable<T> currentNode;

        public LinkedListIterator(ILinkedListIterable<T> currentNode) {
            this.currentNode = currentNode;
        }

        @Override
        public boolean hasNext() {
            return this.currentNode.count() > 0;
        }

        @Override
        public T next() {
            T item = currentNode.getItem();
            this.currentNode = currentNode.getRest();
            return item;
        }
    }
}
