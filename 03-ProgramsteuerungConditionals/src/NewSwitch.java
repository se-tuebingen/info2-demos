package main;
// Shows the new switch syntax.
public class NewSwitch {
    enum Direction {NORTH, SOUTH, EAST, WEST}
    public record Point(int x, int y) {
    }
    public static void main(String[] args) {
        Point p = new Point(2,3);
        printQuadrant(p);
        //return;
        //printDirection();
    }
    // New swtich can return a value, in this case an int
    static void printDirection(){
        Direction myDirection = Direction.EAST;
        int result = switch (myDirection) {
            case NORTH -> 0;
            case SOUTH -> 180;
            case EAST -> 90;
            case WEST -> {
                System.out.println("Go west!");
                yield 270;
            }
        };
        System.out.println(result);
    }
    // Checks if point coordinates are in the first quadrant. This illustrates modern switch syntax
    static void printQuadrant(Point p) {
        // New syntax: checks if p is of type Point first.  When x and y are bigger than 0 returns first.
        switch (p) {
            case Point(var x, var y) when x > 0 && y > 0 ->
                    System.out.println("first");
            default ->
                    System.out.println("other");
            }
        }
    }
