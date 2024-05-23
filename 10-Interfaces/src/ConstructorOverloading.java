class Point2D {
  final int x;
  final int y;
  Point2D(int x, int y) { this.x = x; this.y = y; }
  Point2D() { this.x = 0; this.y = 0; }
}

public class ConstructorOverloading {

  public static void main(String[] args) {
    var p1 = new Point2D();
    var p2 = new Point2D(3, 4);
  }
}
