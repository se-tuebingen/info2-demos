

//         Typabstraktion
//               vvv
public class Node<T> {
              //  ^
              // Typparameter
  T value;
//^
//Typvariable
  Node<T> next;

  // We declared this method to show that a subclass can implement
  // it for an instantiation of T (see end of file)
  // public abstract T add(T first, T second);

  public Node(T value, Node<T> next) {
    this.value = value;
    this.next = next;
  }

  public static void main(String[] args) {
    //              IntegerNode
    Node<Integer> list1 = new Node<Integer>(1, new Node<Integer>(2, null));

    Node<Boolean> list2 = new Node<Boolean>(true, new Node<Boolean>(false, null));

    System.out.println(and(list2));

    if (list2.value) { System.out.println(list1.value + 1); }


    System.out.println(Node.<Integer> id(42) + 1);
    System.out.println(Node.<Boolean> id(true));

  }

  static <T> T id(T x) { return x; }


  static boolean and(Node<Boolean> l) {
    return l.value && l.next.value;
  }

  static <T> String addLists(Node<T> list) {
    return list.value.toString() + list.next.value.toString();
  }

}



// This is to show that the subclass IntegerNode can instantiate T to Integer
// in its superclass:

//class IntegerNode extends Node<Integer> {
//
//  @Override
//  public Integer add(Integer first, Integer second) {
//    return first + second;
//  }
//}
