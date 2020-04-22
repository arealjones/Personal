package Generics;

/**
 A friend of yours is having trouble implementing a circular list. A circular list is similar to a doubly linked lists but
 • the last element of a circular list has its next field pointing to the first element of the circular list
 • the first element of a circular list has its previous field pointing to the last element of the circular list.
 */

public class CircularLinkedList {

  /** Represents one node in a circular list */
  class Node<E> {
    private E data;
    private Node<E> previous;
    private Node<E> next;

    public Node(E data, Node<E> previous, Node<E> next){ this.data = data;
      this.previous = previous;
      this.next = next;
    }

    public E getData() { return data; }

    public void setData(E data) { this.data = data; }

    public Node<E> getPrevious() { return previous; }

    public void setPrevious(Node<E> previous) { this.previous = previous; }

    public Node<E> getNext() { return next; }

    public void setNext(Node<E> next) { this.next = next; }
  }



  /** Represents a circular list of nodes */
  class CList<T> {
    private Node<T> head;
    public CList() {
      this.head = new Node(null, null, null);
      this.head.setPrevious(this.head);
      this.head.setNext(this.head);
    }

    public Node<T> getHead() { return head; }

    public void setHead(Node<T> head) { this.head = head; }

    /**
     A. Design the method isEmpty() for CList that returns true if the list is empty and false otherwise.
     */

    public Boolean isEmpty() {
      return (this.head.getData() == null) && (this.head.getNext() == this.head);
    }

    /**
     B. Design the method void addToFront(T element) for CList that adds element to the front of the list.
     */
    public void addToFront(T element) {
      // Need to always check if it is empty.
      if (this.isEmpty()) {
        this.head.setData(element);
      } else {
        // Create a new node.
        Node<T> newHead = new Node<>(element, null, null);
        // Create a temp node for the last node.
        Node<T> last = this.head.getPrevious();
        // Setting the new heads previous node to the last.
        newHead.setPrevious(last);
        // Setting the last nodes next to the new head.
        last.setNext(newHead);
        newHead.setNext(this.head);
        this.head.setPrevious(newHead);
        this.head = newHead;
      }
    }

    /**
     C. Design the method void addToBack(T element) for CList that adds element to the end of the list.
     */
    public void addToBack(T element) {
      if (this.isEmpty()) {
        this.head.setData(element);
      } else {
        Node<T> newLast = new Node<>(element, null, null);
        Node<T> oldLast = this.head.getPrevious();
        newLast.setPrevious(oldLast);
        newLast.setNext(this.head);
        oldLast.setNext(newLast);
        this.head.setPrevious(newLast);
      }
    }

    /**
     D. Design the method void removeFromFront() for CList that removes the front (first) element of the list.
     */
    public void removeFromFront() {
      if (this.isEmpty()) {
        return;
        // This is checking if there is only one node.
      } else if ((this.head.getNext() == this.head) && (this.head.getData() != null)) {
        this.head.setData(null);
      } else {
        Node<T> newHead = this.head.getNext();
        newHead.setPrevious(this.head.getPrevious());
        this.head.getPrevious().setNext(newHead);
        this.head = newHead;
      }
    }

    /**
     E. Design the method void removeFromBack() for CList that removes the back (last) element of the list.
     */
    public void removeFromBack() {
      if (isEmpty()) {
        return;
      } else if ((this.head.getNext() == this.head) && (this.head.getData() != null)) {
        this.head.setData(null);
      } else {
        Node<T> newLast = this.head.getPrevious().getPrevious();
        newLast.setNext(this.head);
        this.head.setPrevious(newLast);
      }
    }

    /**
     F. Design the method int size() for CList that returns the total number of elements in the list.
     */
    public int size() {
      int counter = 0;
      if (isEmpty()) {
        return counter;
        // Need to make sure the head has data.
      } else if ((this.head.getNext() == this.head) && (this.head.getData() != null)) {
        counter = 1;
      } else {
        counter++;
        Node<T> current = this.head.getNext();
        while (current != this.head) {
          counter++;
          current = current.getNext();
        }
      }
      return counter;
    }
  }

}
