package Functional;

import Functional.Book;

import java.util.Comparator;
import java.util.stream.Stream;

public class Sorting {
    public static void main(String[] args) {
        Book lotr = new Book("The Lord of the Rings", "Tolkien, J. R. R.", 1954, 8.99f);
        Book alchemist = new Book("The Alchemist", "Coelho, Paul", 1988, 9.99f);
        Book littlePrince = new Book("The Little Prince", "Saint-Exupéry, Antoine de", 1943, 6.50f);
        Book harryPotter = new Book("Harry Potter and the Philosopher's Stone", "Rowling, J. K.", 1997, 7.99f);
        Book divingBell = new Book("The Diving-Bell and the Butterfly", "Bauby, Jean-Dominique", 1997, 7.49f);

        /**
         * Complete each of the following tasks using only Streams and lambda expressions.
         * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html */

        /** Task 1 - "natural order" sorting. In the Stream docs, take a look at the sorting method. Use the sorting
         * method plus any other Stream methods necessary to print the above books in natural order. **/
        System.out.println("In natural sorted order:");
        Stream.of(lotr, alchemist, littlePrince, harryPotter, divingBell)
                .sorted().forEach(System.out::println);

        /** Task 2 - custom sorting. In the Stream docs, take a look at the overloaded sorting method (the version that
         * accepts a Comparator. Implement a Comparator class that will order Books by price then use the Stream API to
         * print the above books in price order, lowest to highest. */
        System.out.println("Sorted by price:");
        Stream.of(lotr, alchemist, littlePrince, harryPotter, divingBell)
                .sorted(new PriceComparator()).forEach(System.out::println);

        /** Task 3 - custom sorting. Sort by price as in task 2 but this time, use Comparator.comparing. */
        System.out.println("Sorted by price:");
        Stream.of(lotr, alchemist, littlePrince, harryPotter, divingBell)
                .sorted(Comparator.comparing(Book::getPrice)).forEach(System.out::println);
    }

    private static class PriceComparator implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            if (o1.getPrice() == o2.getPrice())
                return 0;
            if (o1.getPrice() < o2.getPrice())
                return -1;
            return 1;
        }
    }
}
