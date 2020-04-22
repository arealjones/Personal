package Functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FilterAndObjects {

    private static Book adjustPrice(Book book, Function<Book, Book> adjuster) {
        return adjuster.apply(book);
    }

    public static void main(String[] args) {
        Book b1 = new Book("A Book", "An Author", 1990, 4.99f);
        Book b2 = new Book("Book 2", "An Author", 1991, 8.99f);
        Book b3 = new Book("Book 3", "An Author", 2019, 14.99f);

        List<Book> books = Arrays.asList(b1, b2, b3);

        /**
         * Complete each of the following exercises using only Streams and lambda expressions.
         * Check your work by printing the output. For tasks 1 & 2, use Streams to print.
         * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html */

        // Exercise 1

        // 1. Make a new List containing only books published before a certain date
        List<Book> oldBooks = books.stream().filter(book -> book.getYear() < 1995).collect(Collectors.toList());

        // 2. Make a new List containing only books in a particular price range
        List<Book> inRange = books.stream().filter(book -> book.getPrice() >= 5 && book.getPrice() <= 10)
                .collect(Collectors.toList());

        // 3. Get the total price of all books in the list
        Double totalPrice = books.stream().mapToDouble(book -> book.getPrice()).sum();

        // 4. Get the average price of all books in the list
        OptionalDouble avgPrice = books.stream().mapToDouble(book -> book.getPrice()).average();


        /**
         * Exercise 2
         * Add two function objects to the FunctionalBook class:
         *  - Discount a book by 10% (same as prev slide)
         *  - Double the price of the book
         * Add a static method to the FunctionalBook class:
         *    Book adjustPrice(Book book, Function<Book, Book> adjuster)
         * Could be used to either decrease or increase the price **/
        Function<Book, Book> discount = b -> new Book(b.getTitle(), b.getAuthor(), b.getYear(), b.getPrice() * 0.9f);
        Function<Book, Book> doublePrice = b -> new Book(b.getTitle(), b.getAuthor(), b.getYear(), b.getPrice() * 2);
        Book discountB1 = FilterAndObjects.adjustPrice(b1, discount);
        Book expensiveB1 = FilterAndObjects.adjustPrice(b1, doublePrice);
        System.out.println("Original price = " + b1.getPrice());
        System.out.println("Discount price = " + discountB1.getPrice());
        System.out.println("Double price = " + expensiveB1.getPrice());


        List<Double> listDoubles = new ArrayList<>();
        listDoubles.add(5.50);
        listDoubles.add(17.33);
        listDoubles.add(5.77);
        listDoubles.add(25.12);
        listDoubles.add(4.80);
        listDoubles.add(3.58);
        listDoubles.stream()
            .map((Double element) -> element.intValue())
            .filter((Integer value) -> value < 10) .forEach(System.out::println);
    }
}
