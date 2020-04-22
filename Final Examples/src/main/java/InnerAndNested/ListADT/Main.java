package InnerAndNested.ListADT;

import Comparator.Book.Book;

public class Main {
    public static void main(String[] args) {
        Book lotr = new Book("The Lord of the Rings", "Tolkien, J. R. R.", 1954);
        Book alchemist = new Book("The Alchemist", "Coelho, Paul", 1988);
        Book littlePrince = new Book("The Little Prince", "Saint-Exupéry, Antoine de", 1943);
        Book harryPotter = new Book("Harry Potter and the Philosopher's Stone", "Rowling, J. K.", 1997);
        Book divingBell = new Book("The Diving-Bell and the Butterfly", "Bauby, Jean-Dominique", 1997);

        IListAdt<Book> books = NestedList.createEmpty();
        books.append(lotr);
        books.append(alchemist);
        books.append(littlePrince);
        books.append(harryPotter);
        books.append(divingBell);

        for (Book b: books) {
            System.out.println(b.toString());
        }
    }
}
