package CommandLine.EmailLetterTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Immutable class that takes a row of a CSV file and returns a list of the individual headers or
 * fields to be processed during parsing time in combination with templates.
 */
public class CSV {
    private String headerRow;

    /**
     * Constructor for the CSV class
     * @param headerRow The row of data being passed into the class to be processed.
     */
    public CSV(String headerRow) {
        this.headerRow = headerRow;
    }
    
    /**
     * Takes the input row and breaks it into an ArrayList of different fields.
     * @return An ArrayList of the different headers
     */
    public ArrayList<String> getLineAsList() {
        String[] elements = this.headerRow.split("\",\"");
        return new ArrayList<>(Arrays.asList(elements));
    }

    /**
     * Returns true if the current object is the same as the one being compared.
     * @param o The object being compared.
     * @return True if they are the same, false otherwise. */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CSV csv = (CSV) o;
        return Objects.equals(headerRow, csv.headerRow);
    }

    /**
     * Returns the hashcode of the object.
     * @return Returns the hashcode of the object. */
    @Override
    public int hashCode() {
        return Objects.hash(headerRow);
    }

    /**
     * Returns a string explaining what is in the current line.
     * @return Returns a string explaining what is in the current line. */
    @Override
    public String toString() {
        return "The current line being parsed is: " + headerRow + '.';
    }
}
