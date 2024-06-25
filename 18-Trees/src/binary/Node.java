package binary;

public class Node {
  public char item;
  public Node left;
  public Node right;

  public Node(Node left, char item, Node right) {
    this.left = left;
    this.item = item;
    this.right = right;
  }

  public static Node leaf(char item) {
    return new Node(null, item, null);
  }

  public static Node node(Node left, char item, Node right) {
    return new Node(left, item, right);
  }
}




