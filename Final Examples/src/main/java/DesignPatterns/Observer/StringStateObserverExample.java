package DesignPatterns.Observer;

import DesignPatterns.Observer.StringStateObserverExample.BinaryObserver.OctalObserver;
import java.util.ArrayList;
import java.util.List;

/**
 I found this example on tutorialspoint so do not copy exactly.
 Observer pattern is used when there is one-to-many relationship between objects such as if one
 object is modified, its depenedent objects are to be notified automatically. */
public class StringStateObserverExample {

  /** Observer.
   -----------------------------------------------------------------------------------------------*/
  public static abstract class Observer {
    protected Subject subject;
    public abstract void update();
  }

  /** Subject.
   -----------------------------------------------------------------------------------------------*/
  public static class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
      return state;
    }

    public void setState(int state) {
      this.state = state;
      notifyAllObservers();
    }

    public void attach(Observer observer){
      observers.add(observer);
    }

    public void notifyAllObservers(){
      for (Observer observer : observers) {
        observer.update();
      }
    }
  }

  /** Binary Observer.
   -----------------------------------------------------------------------------------------------*/
  public static class BinaryObserver extends Observer{
    public BinaryObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
    }

    @Override
    public void update() {
      System.out.println( "Binary String: " + Integer.toBinaryString(subject.getState()));
    }

    /** Octal Observer.
     -----------------------------------------------------------------------------------------------*/
    public static class OctalObserver extends Observer {
      public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
      }

      @Override
      public void update() {
        System.out.println( "Octal String: " + Integer.toOctalString(subject.getState()));
      }
    }
  }

  /** Hexa Observer.
   -----------------------------------------------------------------------------------------------*/
  public static class HexaObserver extends Observer {
    public HexaObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
    }

    @Override
    public void update() {
      System.out.println( "Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
  }

  /** Testing.
   -----------------------------------------------------------------------------------------------*/
  public static void main(String[] args) {
    Subject subject = new Subject();
    new HexaObserver(subject);
    new OctalObserver(subject);
    new BinaryObserver(subject);
    System.out.println("First state change: 15");
    subject.setState(15);
    System.out.println("Second state change: 10");
    subject.setState(10);
  }




}
