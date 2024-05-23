import javax.swing.*;
import java.awt.*;

class Posn {
  final int x; final int y;
  Posn(int x, int y) { this.x = x; this.y = y; }
}

interface Shape {
  void draw(Graphics g);
}
class Circle implements Shape {
  final int radius; final Posn center;
  Circle(int r, Posn c) { radius = r; center = c; }
  public void draw(Graphics g) {
    g.drawOval(center.x - radius,
      center.y - radius,
      2 * radius, 2 * radius);
  }
}
class Rectangle implements Shape {
  final Posn upperLeft;
  final Posn lowerRight;
  Rectangle(Posn ul, Posn lr) { upperLeft = ul; lowerRight = lr; }
  public void draw(Graphics g) {
    g.drawRect(upperLeft.x, upperLeft.y,
      lowerRight.x - upperLeft.x,
      lowerRight.y - upperLeft.y);
  }
}

class ShapePanel extends JPanel {
  private Shape[] shapes;

  public ShapePanel(Shape[] shapes) {
    this.shapes = shapes;
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Shape shape : shapes) {
        shape.draw(g);
    }
  }
}

public class AlgebraicDatatypes {

  public static void draw(Shape s) {
    if (s instanceof Rectangle) {
      var r = (Rectangle) s;

    } else if (s instanceof Circle) {
      var c = (Circle) s;
    }
  }

  public static void main(String[] args) {
    Shape s1 = new Rectangle(new Posn(20, 10), new Posn(90, 85));
    Shape s2 = new Circle(15, new Posn(30, 40));

    // Like in Racket, we can also pattern match in Java:

    // switch (s2) {
    //   case Rectangle r -> System.out.println(r.lowerRight);
    //   case Circle c -> System.out.println(c.radius);
    //   default -> System.out.println("Unknown shape");
    // }

    Shape[] shapes = new Shape[] { s1, s2 };

    JFrame frame = new JFrame("Shapes");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new ShapePanel(shapes));
    frame.setSize(400, 400);
    frame.setVisible(true);
  }
}
