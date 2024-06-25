package binary;

public class Tree {

  private Node root = null;

  public Tree() { this.root = null; }

  public Tree(Node root) { this.root = root; }

  public interface Traversal {
    void visit(char content);
  }

  public void preorder(Traversal t) {
    preorder(root, t);
  }

  public void inorder(Traversal t) {
    inorder(root, t);
  }

  public void postorder(Traversal t) {
    postorder(root, t);
  }

  /**
   * Inserts a node with the given content into tree t.
   * If t was sorted, the modified tree is again sorted.
   */
  public void insert(char content) {
    if (root == null) { root = Node.leaf(content); }
    else { insertInto(Node.leaf(content), root); }
  }

  /**
   * Searches a node in the tree that is labelled with `content`.
   * Returns `null` if no such node can be found.
   * Does not modify the tree.
   */
  public Node search(char content) {
    return search(content, root);
  }

  /**
   * Deletes the
   */
  public void delete(char content) {
    if (root == null) return;
    else root = deleteFrom(content, root);
  }

  public void print() {
    print(root);
    System.out.print("\n");
  }


  // Implementation Details
  // ----------------------




  private void preorder(Node n, Traversal t) {
    if (n == null) return;

    t.visit(n.item);
    preorder(n.left, t);
    preorder(n.right, t);
  }

  private void inorder(Node n, Traversal t) {
    if (n == null) return;

    inorder(n.left, t);
    t.visit(n.item);
    inorder(n.right, t);
  }

  private void postorder(Node n, Traversal t) {
    if (n == null) return;

    postorder(n.left, t);
    postorder(n.right, t);
    t.visit(n.item);
  }

  private void print(Node n) {
    if (n == null) return;

    System.out.print("{");
    print(n.left);
    System.out.print(";");
    System.out.print(n.item);
    System.out.print(";");
    print(n.right);
    System.out.print("}");
  }

  /**
   * Only returns the correct result, if the
   * given tree is sorted!
   */
  private Node search(char content, Node n) {
    if (n == null) return null;

    if (n.item > content) {
      return search(content, n.left);
    } if (n.item < content) {
      return search(content, n.right);
    } else return n;
  }

  private void insertInto(Node newNode, Node t) {
    // Insert into left subtree
		if (newNode.item <= t.item) {
			if (t.left == null) { t.left = newNode; }
			else { insertInto(newNode, t.left); }

    // Insert into right subtree
		} else {
			if (t.right == null) { t.right = newNode; }
			else { insertInto(newNode, t.right); }
		}
  }

  private Node deleteFrom(char content, Node node) {
    if (node == null) return node;

    if (content < node.item) {
      node.left = deleteFrom(content, node.left);
    } else if (content > node.item) {
      node.right = deleteFrom(content, node.right);
    } else if (content == node.item){
      if (node.left == null) {
        return node.right;
      } else if (node.right == null) {
        return node.left;
      } else {
        // `node` is the one we want to delete.
        // It has two children:
        // 1) Exctract the inorder successor (smallest in the right subtree)
        Node successor = extractLeftMostNode(node.right, node);
        // 2) Update node with info from successor
        node.item = successor.item;
      }
    }
    return node;
  }

  private Node extractLeftMostNode(Node node, Node parent) {
    // no node available, that is further left
    if (node.left == null) {
      // replace node with its right-child
      if (node.item < parent.item) {
        parent.left = node.right;
      } else {
        parent.right = node.right;
      }
      return node;
    }
    else return extractLeftMostNode(node.left, node);
  }
}
