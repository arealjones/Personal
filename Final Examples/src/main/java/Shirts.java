public class Shirts {

  /**
   You are part of a startup company that sells customized t-shirts. The company plans to have a
   webpage for their products and the current plan is to start the webpage selling plain t-shirts.
   A customer can select the following properties for their t-shirt.

   Size can be one of
   • S for small
   • M for medium
   • L for large
   • XL for extra large
   • XXL for extra extra large

   Style can be one of
   • Slim
   • Long Sleeve
   • Sleeveless
   • Oversize

   Neck Style can be one of
   • Round
   • V
   • Crew

   Once the customer has selected an option for each property (customers must select exactly one
   option for each property) the website must calculate the cost of the t-shirt. The cost is
   calculated as follows.

   All t-shirts start at a base price of 5 dollars. Then for each option selected we apply the
   following conditions on the base price.

   • Size
   – S no additions to base price
   – M no additions to base price
   – L adds 50 cents to base price
   – XL adds 50 cents to base price
   – XXL adds 1 dollar to base price

   • Style
   – Slim no additions to base price
   – Long Sleeve adds 1% to the base price, i.e., (add 0.01 × base)
   – Sleeveless no additions to base price
   – Oversize adds 2% to the base price, i.e., (add 0.02 × base)

   • Neck Style
   – Round no additions to base price
   – V adds 50 cents to base price
   – Crew adds 75 cents to base price

   Provide any Java code that you would add to your answer for part (a) in order to calculate the
   cost of t-shirt. You may assume that for all classes described in your solution to part (a) you
   have the typical constructor, setters and getters as well as equals() and hashCode() methods.
   */

//  public Double totalCost() {
//    return this.base
//      + this.size.addedCost(this.base)
//      + this.style.addedCost(this.base)
//      + this.neckStyle.addedCost(this.base);
//  }
//  // In Asize
//  public Double cost(Integer base){ return this.addedCost;
//  }
//  // In AStyle
//  public Double cost(Integer base){ return base * this.percentCost;
//  }
//  // In ANeckStyle
//  public Double cost(Integer base){ return this.addedCost;
//  }

  /**
   The store has launched and the company would like to add some more properties and options for their t-shirts.

   For Styles we now have the following new styles
   • Muscle adds 2 dollars to the price
   • Longline adds 1 dollar to the price

   For Size we not have the following new sizes
   • Small Petite, adds 3% to the base price, i.e., (add 0.03 × base)
   • XL Long, adds 4% to the base price, i.e., (add 0.04 × base)

   We are expanding and we are adding graphic t-shirts. For graphic t-shirts we are adding a new
   property called Kinds
   • Basic these are the original t-shirts that have not graphics on them
   • Graphic these t-shirts have a single print on them and add 5% more to the total price
   • Embellished these t-shirts have more material on them and a graphic and add 10% more to the total price

   Provide any additional code needed for calculating a t-shirt’s total cost.
   You only need to show new classes that are added to your solution.
   If you want to refer to a class from part (a) use the class name only, do not re-produce the whole class.
   */

//  // In AStyleAddCost
//  public Double cost(Integer base) {
//    return this.addedCost;
//  }
//
//  // Even better if common code from Abstract classes gets reused,
//  // i.e, On Abstract class for adding cost and one for adding percentages
//
//  // In ATshirt
//  public Double cost() {
//    return perc * (this.base + this.size.addedCost(this.base) + this.style.addedCost(this.base) + this.neckStyle.addedCost(this.base));
//  }
//
//  // In Basic
//  public Graphic(...) {
//    super(...);
//    this.perc = 1.00;
//  }
//  // In Graphic
//  public Graphic(...) {
//    super(...);
//    this.perc = 1.05;
//  }
//  // In Embellised
//  public Graphic(...) {
//    super(...);
//    this.perc = 1.10;
//  }

  /**
   We now want to allow customers to have a cart so that they can place all their t-shirts with
   their configurations and calculate the total amount due because of all the items in the cart.
   The cart must allow for any number of different t-shirt configurations. The cart should also
   allow the number of t-shirts (quantity) for each t-shirt configuration in the cart.
   Provide the Java code for your solution on how to represent a cart. Your solution should also
   allow a client to obtain the total amount due for a cart.
   */

  //  public class Cart {
//    private List<LineItems> items;
//
//    public Cart(List<LineItems> items) {
//      this.items = items;
//    }
//
//    public Double getTotal() {
//      return items.stream().map(l -> l.total()).reduce(0.0, new BinaryOperator<Double>() {
//        @Override
//        public Double apply(Double aDouble, Double aDouble2) {
//          return aDouble + aDouble2;
//        }
//      });
//    }
//  }
//  public class LineItems {
//    private Integer quantity;
//    private Tshirt tshirt;
//    public LineItems(Integer quantity, Tshirt tshirt) {
//      this.quantity = quantity;
//      this.tshirt = tshirt;
//    }
//    public Double total() {
//      return quantity * tshirt.totalCost();
//    }
//  }
}
