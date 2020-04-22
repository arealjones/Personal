import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BorrowedBooksStats {

  /** Book Class. */
  public class Book {
    private String title;
    private Person author;

    public Book(String title, Person author) {
      this.title = title;
      this.author = author;
    }

    public String getTitle() {
      return this.title;
    }


    public Person getAuthor() {
      return this.author;
    }
  }

  /** Person class. */
  class Person {
    private String firstName;
    private String lastName;
    private int yearOfBirth;


    public Person(String firstName, String lastName, int yearOfBirth) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.yearOfBirth = yearOfBirth;
    }

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public int getYearOfBirth() {
      return yearOfBirth;
    }
  }

  /** Patron class that extends Person. */
  public class Patron extends Person {
    private List<Book> borrowedBooks = new ArrayList<>();

    public Patron(String firstName, String lastName, int yearOfBirth, List<Book> borrowedBooks) {
      super(firstName, lastName, yearOfBirth);
      this.borrowedBooks = borrowedBooks;
    }

    public List<Book> getBorrowedBooks() {
      return borrowedBooks;
    }
  }

  /** Library class. */
  public class Library {
    private Map<Book, Integer> borrowedBooksStatistics = new HashMap<>();
    private final Integer STARTING_VALUE = 1;

    public Library(Map<Book, Integer> borrowedBooksStatistics) {
      this.borrowedBooksStatistics = borrowedBooksStatistics;
    }

    public Map<Book, Integer> getBorrowedBooksStatistics() {
      return borrowedBooksStatistics;
    }
    public Map<Book, Integer> getAggregatedStatistics(List<Patron> patrons){
      Map<Book, Integer> resultingStatistics = new HashMap<>();
      int listSize = patrons.size();
      if (patrons == null || patrons.size() == 0) {
        return resultingStatistics;
      }
      for (Patron patron: patrons) {
        for (Book book : patron.getBorrowedBooks()) {
          if (!resultingStatistics.containsKey(book)) {
            resultingStatistics.put(book, (STARTING_VALUE));
          } else {
          resultingStatistics.put(book, (resultingStatistics.get(book) + STARTING_VALUE));
          }
        }
      }
      return resultingStatistics;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Library)) return false;
      Library library = (Library) o;
      return Objects.equals(getBorrowedBooksStatistics(), library.getBorrowedBooksStatistics());
    }

    @Override
    public int hashCode() {
      return Objects.hash(getBorrowedBooksStatistics()); }

    @Override
    public String toString() {
      return "Library{" + "borrowedBooksStatistics=" + borrowedBooksStatistics + '}';
    }
  }
}
