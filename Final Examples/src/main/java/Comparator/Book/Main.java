package Comparator.Book;

import Comparator.Book.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static String printListOfBooks(List<Book> books) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < books.size(); i++) {
            message.append(String.format("%d %s", i, books.get(i).toString()));
            if (i < books.size() - 1)
                message.append(System.lineSeparator());
        }
        return message.toString();
    }

    public static void main(String[] args) {
        Book lotr = new Book("The Lord of the Rings", "Tolkien, J. R. R.", 1954);
        Book alchemist = new Book("The Alchemist", "Coelho, Paul", 1988);
        Book littlePrince = new Book("The Little Prince", "Saint-Exupéry, Antoine de", 1943);
        Book harryPotter = new Book("Harry Potter and the Philosopher's Stone", "Rowling, J. K.", 1997);
        Book divingBell = new Book("The Diving-Bell and the Butterfly", "Bauby, Jean-Dominique", 1997);

        List<Book> books = new ArrayList<>();
        books.add(lotr);
        books.add(alchemist);
        books.add(littlePrince);
        books.add(harryPotter);
        books.add(divingBell);

        System.out.println("Original order:");
        System.out.println(Main.printListOfBooks(books));


        System.out.println(System.lineSeparator() + "Sorted order (using compareTo)");
        Collections.sort(books);
        System.out.println(Main.printListOfBooks(books));

        System.out.println(System.lineSeparator() + "Sort by author");
        Collections.sort(books, new AuthorComparator());
        System.out.println(Main.printListOfBooks(books));

        System.out.println(System.lineSeparator() + "Sort by year (title as tie break");
        Collections.sort(books, new YearTitleComparator());
        System.out.println(Main.printListOfBooks(books));

    }
}
