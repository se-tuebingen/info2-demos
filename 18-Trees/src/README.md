In these notes we are always just using binary trees (type `Node`) 
with an artificial payload of type `char` at each node.
In general, trees can also be structured completely different, like

    interface Node {}

    class Binary implements Node {
      char item;
      Node left;
      Node right;
    }

    class Ternary implements Node {
      String name;
      int otherField;

      Node first;
      Node second;
      Node third;
    }

where not only we have different arities, but also the payload
differs between the different types of nodes.

Typically, we can distinguish 

- trees that are used as a backing data structure to support specific operations  (one example are binary search trees),
- trees that directly model domain knowledge.

One example of the latter kind are "abstract syntax trees". That is, trees, that
represent a program. For example, we can represent arithmetic expressions as


    interface Expr {}
    
    class Add implements Expr {
      final Expr left;
      final Expr right
      Add(Expr left, Expr right) { this.left = left; this.right = right; }
    }
    
    class Num implements Expr {
      final int value;
      Num(int value) { this.value = value; }
    }

which (accidentally) also is a binary tree where `Add` has two nodes representing
the left-hand-side and right-hand-side of `lhs + rhs` and `Num` is a leaf node that
is labelled with the integer value. 

For example, the expression `(1 + 2) + 3` can be represented by the tree:

    new Add(new Add(new Lit(1), new Lit(2)), new Lit(3))


 
