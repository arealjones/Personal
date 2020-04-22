package Functional;

import Functional.Book;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingAndJoining {
    public static void main(String[] args) {
        Book lotr1 = new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954, 6.99f);
        Book lotr2 = new Book("The Two Towers", "J.R.R. Tolkien", 1954, 6.99f);
        Book lotr3 = new Book("The Return of the King", "J.R.R. Tolkien", 1955, 6.99f);
        Book alice1 = new Book("Alice's Adventures in Wonderland", "Lewis Carroll", 1865, 4.99f);
        Book alice2 = new Book("Through the Looking Glass", "Lewis Carroll", 1871, 3.99f);

        List<Book> books = Stream.of(lotr1, lotr2, lotr3, alice1, alice2).collect(Collectors.toList());
        /**
         * Complete each of the following tasks using only Streams and lambda expressions.
         * The Stream docs:
         * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html
         * The Collectors docs:
         * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Collectors.html */

        /**
         * Task 1: Use Collectors.groupingBy to group the books by author. The output should be a Map with the
         * author as key and a list of Books as value. */
        Map<String, List<Book>> booksByAuthor = books.stream().collect(Collectors.groupingBy(Book::getAuthor));
        System.out.println(booksByAuthor);

        /**
         * Task 2: Use Collectors.joining plus any additional Stream methods to return a comma separated list of the
         * titles of the books in the list. */
        String titles = books.stream().map(book -> book.getTitle()).collect(Collectors.joining(", "));
        System.out.println(titles);
    }
}
