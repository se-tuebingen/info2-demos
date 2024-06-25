import binary.*;


public class Playground {

  public static void main(String[] args) {

    //      b
    //     / \
    //    a   c
    var simpleNodes = Node.node(Node.leaf('a'), 'b', Node.leaf('c'));
    var simpleTree = new Tree(simpleNodes);


    simpleTree.preorder(System.out::println);

    // is equivalent to

    simpleTree.preorder(el -> System.out.println(el));

    // which is equivalent to

    simpleTree.preorder(new Tree.Traversal() {
      public void visit(char c) {
        System.out.println(c);
      }
    });

    // which is equivalent to

    class PrintTraversal implements Tree.Traversal {
      public void visit(char c) {
        System.out.println(c);
      }
    }

    simpleTree.preorder(new PrintTraversal());


    simpleTree.preorder(el -> System.out.println(el));
    System.out.println("---");
    simpleTree.inorder(el -> System.out.println(el));


    assert(simpleTree.search('a') == simpleNodes.left);
    assert(simpleTree.search('b') == simpleNodes);
    assert(simpleTree.search('c') == simpleNodes.right);

    Tree sorted = new Tree();

    sorted.insert('c');
    sorted.insert('a');
    sorted.insert('b');
    sorted.insert('e');

    sorted.print();

    sorted.delete('c');
    sorted.print();

    sorted.delete('a');
    sorted.print();
  }
}
