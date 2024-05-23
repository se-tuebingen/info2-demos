class Point2D {
  int x;
  int y;

  Point2D(int xValue, int yValue) {
    System.out.println(this.x);
    this.x = xValue;
    this.y = yValue;
  }
}
class Item {}
class ShoppingCart {
  Item[] items;
  ShoppingCart() {
    this.showShoppingCart();
    items = new Item[16];
  }
  void showShoppingCart() {
    for (Item item : items) {
      System.out.println(item);
    }
  }
}

public class Constructors {
  public static void main(String[] args) {
    new Point2D(17, 34);

    //new ShoppingCart();

    //    var p = new Point2D();
    //    System.out.println(p.x); // 0
    //    p.x = 3; //
    //    p.y = 7;
    //    System.out.println(p.x); // 3
  }
}
