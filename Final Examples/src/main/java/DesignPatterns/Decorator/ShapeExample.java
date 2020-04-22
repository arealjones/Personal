package DesignPatterns.Decorator;

/**
 I found this example on tutorialspoint so do not copy exactly.
 This pattern creates a decorator class which wraps the original class and provides additional
 functionality keeping class methods signature intact. */
public class ShapeExample {

  /** Shape Interface.
   -----------------------------------------------------------------------------------------------*/
  public interface Shape {
    void draw();
  }

  /** Rectangle.
   -----------------------------------------------------------------------------------------------*/
  public static class Rectangle implements Shape {
    @Override
    public void draw() {
      System.out.println("Shape: Rectangle");
    }
  }

  /** Circle.
   -----------------------------------------------------------------------------------------------*/
  public static class Circle implements Shape {
    @Override
    public void draw() {
      System.out.println("Shape: Circle");
    }
  }

  /** Shape Decorator.
   -----------------------------------------------------------------------------------------------*/
  public static abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
      this.decoratedShape = decoratedShape;
    }

    public void draw(){
      decoratedShape.draw();
    }
  }

  /** Red Shape Decorator.
   -----------------------------------------------------------------------------------------------*/
  public static class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
      super(decoratedShape);
    }

    @Override
    public void draw() {
      decoratedShape.draw();
      setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
      System.out.println("Border Color: Red");
    }
  }


  /** Testing.
   -----------------------------------------------------------------------------------------------*/
  public static void main(String[] args) {
    Shape circle = new Circle();
    Shape redCircle = new RedShapeDecorator(new Circle());
    Shape redRectangle = new RedShapeDecorator(new Rectangle());
    System.out.println("Circle with normal border");
    circle.draw();
    System.out.println("\nCircle of red border");
    redCircle.draw();
    System.out.println("\nRectangle of red border");
    redRectangle.draw();
  }

}
