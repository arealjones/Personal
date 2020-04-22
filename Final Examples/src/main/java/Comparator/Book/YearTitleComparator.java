package Comparator.Book;

import Comparator.Book.Book;

import java.util.Comparator;

public class YearTitleComparator implements Comparator<Book> {
    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     * @throws NullPointerException if an argument is null and this
     *                              comparator does not permit null arguments
     * @throws ClassCastException   if the arguments' types prevent them from
     *                              being compared by this comparator.
     */
    @Override
    public int compare(Book o1, Book o2) {
        // Compare by year, use title as a tie breaker
        if (o1.getYear().equals(o2.getYear()))
            return o1.getTitle().compareTo(o2.getTitle());
        return o1.getYear().compareTo(o2.getYear());
    }
}
