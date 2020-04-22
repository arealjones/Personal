package DesignPatterns.Iterator;

/**
 I found this example on tutorialspoint so do not copy exactly.
 This pattern is used to get a way to access the elements of a collection object in sequential
 manner without any need to know its underlying representation. */
public class ContainerExample {

  /** Iterator Interface.
   -----------------------------------------------------------------------------------------------*/
  public interface Iterator {
    public boolean hasNext();
    public Object next();
  }

  /** Container Interface.
   -----------------------------------------------------------------------------------------------*/
  public interface Container {
    public Iterator getIterator();
  }

  /** Name Repository. Has a nested iterator in it.
   -----------------------------------------------------------------------------------------------*/
  public static class NameRepository implements Container {
    public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

    @Override
    public Iterator getIterator() {
      return new NameIterator();
    }

    /** Name Iterator. */
    private class NameIterator implements Iterator {
      int index;
      @Override
      public boolean hasNext() {
        if(index < names.length) {
          return true;
        }
        return false;
      }

      @Override
      public Object next() {
        if(this.hasNext()) {
          return names[index++];
        }
        return null;
      }
    }
  }

  /** Testing.
   -----------------------------------------------------------------------------------------------*/
  public static void main(String[] args) {
    NameRepository namesRepository = new NameRepository();
    Iterator iter = namesRepository.getIterator();
    while (iter.hasNext()) {
      String name = (String)iter.next();
      System.out.println("Name : " + name);
    }
  }


}
