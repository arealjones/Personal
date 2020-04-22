package DesignPatterns.Visitor;

/**
 I found this example on tutorialspoint so do not copy exactly.
 In Visitor pattern, we use a visitor class which changes the executing algorithm of an element class. */
public class ComputerPartExample {

  /** Computer Part Interface. */
  public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
  }

  /** Keyboard. */
  public static class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
      computerPartVisitor.visit(this);
    }
  }

  /** Monitor. */
  public static class Monitor implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
      computerPartVisitor.visit(this);
    }
  }

  /** Mouse. */
  public static class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
      computerPartVisitor.visit(this);
    }
  }

  /** Computer.
   Calls all of the smaller parts of the computer in the constructor. */
  public static class Computer implements ComputerPart {
    ComputerPart[] parts;
    public Computer() {
      parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor() };
    }
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
      for (int i = 0; i < parts.length; i++) {
        parts[i].accept(computerPartVisitor);
      }
      computerPartVisitor.visit(this);
    }
  }

  /** Computer Part Visitor Interface. */
  public interface ComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);
  }

  /** Computer Part Display Visitor. */
  public static class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Computer computer) {
      System.out.println("Displaying Computer.");
    }
    @Override
    public void visit(Mouse mouse) {
      System.out.println("Displaying Mouse.");
    }
    @Override
    public void visit(Keyboard keyboard) {
      System.out.println("Displaying Keyboard.");
    }
    @Override
    public void visit(Monitor monitor) {
      System.out.println("Displaying Monitor.");
    }
  }


  public static void main(String[] args) {
    ComputerPart computer = new Computer();
    computer.accept(new ComputerPartDisplayVisitor());
  }

}
