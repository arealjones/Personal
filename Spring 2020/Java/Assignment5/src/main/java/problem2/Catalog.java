package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Catalog is an object that contains a collection of items made by authors, recording artists,
 * or bands. */
public class Catalog {
  private List<AbstractItems> items;

  /**
   * Constructor that creates an empty catalog. */
  public Catalog() {
    this.items = new ArrayList<>();
  }

  /**
   * Constructor that creates a catalog with already determined items.
   * @param items The items in the collection. */
  public Catalog(List<AbstractItems> items) {
    this.items = items;
  }

  /**
   * Searches the catalog for the keyword and returns a new array with the items containing the
   * keyword.
   * @param keyword The word to be searched.
   * @return A new array with the items that contained the keyword. */
  public List<AbstractItems> search(String keyword) {
    List<AbstractItems> newlist = new ArrayList<>();
    for (int i=0; i<items.size(); i++) {
      if (items.get(i).getTitle().toLowerCase().contains(keyword.toLowerCase())) {
        newlist.add(items.get(i));
      }
    }
    return newlist;
  }

  /**
   * Searches the catalog for the author and returns a new array with the items that the author
   * wrote.
   * @param author The author to be searched for.
   * @return A new array with the items that contained the keyword. */
  public List<AbstractItems> search(Author author) {
    List<AbstractItems> newlist = new ArrayList<>();
    for (int i=0; i<items.size(); i++) {
      if ((items.get(i).getCreator() instanceof Author) &&
          (items.get(i). getCreator() == author)) {
        newlist.add(items.get(i));
      }
    }
    return newlist;
  }

  /**
   * Searches the catalog for the artist and returns a new array with the items that the artist
   * created.
   * @param artist The artist to be searched for.
   * @return A new array with the items that contained the keyword. */
  public List<AbstractItems> search(RecordingArtist artist) {
    List<AbstractItems> newlist = new ArrayList<>();
    for (int i=0; i<items.size(); i++) {
      if (items.get(i).getCreator() instanceof RecordingArtist) {
        if (items.get(i).getCreator() == artist) {
          newlist.add(items.get(i));
        }
      }
      else if (items.get(i).getCreator() instanceof Band) {
        if (items.get(i).getCreator().bandContainsArtist(artist)) {
          newlist.add(items.get(i));
        }
      }
    }
    return newlist;
  }

  /**
   * Adds a new item to the collection.
   * @param item A item such as a book or piece of music. */
  public void addItem(AbstractItems item) {
    items.add(item);
  }

  /**
   * Checks if the item exists in the collection. If it does, it will remove it, otherwise it will
   * throw an exception.
   * @param item An item to be removed.
   * @throws IllegalArgumentException Thrown if the item doesnt exists in the collection. */
  public void removeItem(AbstractItems item) throws IllegalArgumentException {
    if (items.contains(item)) {
      items.remove(item);
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Returns true or false based on if the current object is the same as the one being compared.
   * @param o The object being compared.
   * @return Returns true or false. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Catalog catalog = (Catalog) o;
    return Objects.equals(items, catalog.items);
  }

  /**
   * Returns true or false based on if the location of the object are the same.
   * @return Returns true or false. */
  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    return "Collection Contains: " + items.size() + " items.";
  }
}
