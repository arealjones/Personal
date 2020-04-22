package Functional;

import Functional.Book;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxAndMin {
    public static void main(String[] args) {
        Book lotr = new Book("The Lord of the Rings", "Tolkien, J. R. R.", 1954, 8.99f);
        Book alchemist = new Book("The Alchemist", "Coelho, Paul", 1988, 9.99f);
        Book littlePrince = new Book("The Little Prince", "Saint-Exupéry, Antoine de", 1943, 6.50f);
        Book harryPotter = new Book("Harry Potter and the Philosopher's Stone", "Rowling, J. K.", 1997, 7.99f);
        Book divingBell = new Book("The Diving-Bell and the Butterfly", "Bauby, Jean-Dominique", 1997, 7.49f);

        Set<Book> books = Stream.of(lotr, alchemist, littlePrince, harryPotter, divingBell).collect(Collectors.toSet());
        /**
         * Complete each of the following tasks using only Streams and lambda expressions.
         * The Stream docs:
         * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html
         * Comparator docs:
         * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Comparator.html */

        /**
         * Task 1: Use Stream.max() to get the book with the most recent publication date. Use Comparator.comparing to
         * implement the Comparator required by Stream.max(). */
        Book mostRecent = books.stream().max(Comparator.comparing(Book::getYear)).get();
        System.out.println("The most recent book: " + mostRecent.toString());

        /**
         * Task 2: Use Stream.min() to get the book with the oldest publication date. Use Comparator.comparing to
         * implement the Comparator required by Stream.min(). */
        Book oldest = books.stream().min(Comparator.comparing(Book::getYear)).get();
        System.out.println("The oldest book: " + oldest.toString());
    }
}
