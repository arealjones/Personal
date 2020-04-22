package Functional;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** A bunch of random examples of streams and functions as objects. Use this as syntax reference.
 **/
public class MiscExamples {

  public static List<Book> publishedBefore(List<Book> books, int year) {
    return books.stream().filter(b -> b.getYear() < year).collect(Collectors.toList());
  }


  public static List<Book> inPriceRange(List<Book> books, float lowest, float highest) {
    return books.stream().filter(b -> b.getPrice() >= lowest && b.getPrice() <= highest)
        .collect(Collectors.toList());
  }

  private static Function<Book, Book> discountBook = b -> {
    Book newBook = new Book(b.getTitle(),b.getAuthor(),b.getYear(), b.getPrice() * 0.9f);
    return newBook;
  };

  private static Function<Book, Book> doublePrice = b -> {
    Book newBook = new Book(b.getTitle(),b.getAuthor(),b.getYear(), b.getPrice() * 2);
    return newBook;
  };

  private static Book adjustPrice(Book book, Function<Book, Book> adjuster) {
    return adjuster.apply(book);
  }

  public static void main(String[] args) {
    Book b1 = new Book("A Book", "An Author", 1990, 4.99f);
    Book b2 = new Book("Book 2", "An Author", 1991, 8.99f);
    Book b3 = new Book("Book 3", "An Author", 2019, 14.99f);

    // Populate a list of books
    List<Book> books = new LinkedList<>(Arrays.asList(b1, b2, b3));

    // Use map to create a list of string representations of books
    List<String> bookStr = books.stream().map(s -> s.toString()).collect(Collectors.toList());

    // Use filter and map to apply a 10% discount to books published before 2000
    List<Book> cheapBook = books.stream().filter(b -> b.getYear() < 2000)
        .map(discountBook::apply).collect(Collectors.toList());

    // Use mapToInt and min to find the publication date of the oldest book
    books.stream().mapToInt(b -> b.getYear()).min();

    // Use mapToDouble and average to get the average price of the books
    books.stream().mapToDouble(b -> b.getPrice()).average();

    // Three different ways to get the combined price of all the books in the list
    double totalReduce = books.stream().mapToDouble(b -> b.getPrice()).reduce(0, (p1, p2) -> p1 + p2);
    double totalSum = books.stream().mapToDouble(b -> b.getPrice()).sum();
    double totalBinary = books.stream().mapToDouble(b -> b.getPrice()).reduce(0,
        new DoubleBinaryOperator() {
          @Override
          public double applyAsDouble(double left, double right) {
            return left + right;
          }
        });

    System.out.println("The following totals should be the same: " + totalBinary + " = " + totalSum + " = " + totalReduce);

    OptionalDouble average = books.stream().mapToDouble(b -> b.getPrice()).average();

    System.out.println("Books between $5 and $20:");
    MiscExamples.inPriceRange(books, 5, 20).forEach(System.out::println);

    System.out.println("Books published before 1990");
    MiscExamples.publishedBefore(books, 1990).forEach(System.out::println);

    System.out.println("Books published before 2020");
    MiscExamples.publishedBefore(books, 2020).forEach(System.out::println);

    System.out.println("Published before 1995");
    List<Book> oldBooks  =  books.stream().filter(book -> book.getYear() < 1995).collect(Collectors.toList());
    oldBooks.forEach(System.out::println);

    System.out.println("Price between $5 and $10");
    List<Book> midBooks = books.stream().filter(book -> book.getPrice() >= 5 && book.getPrice() <= 10).collect(Collectors.toList());
    midBooks.forEach(System.out::println);

    Book cheaper = MiscExamples.adjustPrice(b1, discountBook);

    System.out.println(MiscExamples.discountBook.apply(b1).toString());

    System.out.println(Stream.iterate(2, i -> i * i).limit(3).count());
    System.out.println(Stream.iterate(2, i -> i * i).limit(3).mapToInt(i -> i).sum());

  }

}
