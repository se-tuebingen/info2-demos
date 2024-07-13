// In this file, we started from the singly linked list that we had
// before, which was only defined on int and generalized it in class
// to end up with a generic version.
//
//
public class List<T> {

  Node<T> head;

  /* Constructors */
  public List() {
  }

  public List(T value) {
    this.head = new Node<T>(value, null);
  }

  /* Insertion methods */
  public void insertFirst(T value) {
    head = new Node<T>(value, head);
  }

  public void insertLastRecursive(T value) {  // comfortable call
    if (head == null) {
      head = new Node<T>(value, null);
    } else {
      insertLastRecursive(value, head);  // method overload
    }
  }

  private static <T> void insertLastRecursive(T value, Node<T> elem) {
    if (elem.next == null) {
      elem.next = new Node<T>(value, null);
    } else {
      insertLastRecursive(value, elem.next);  // recursion
    }
  }

  public void insertLastIterative(T value) {
    if (head == null) {  // list is currently empty
      this.head = new Node<T>(value, null);
    } else {
      Node<T> elem = head;
      while (elem.next != null) {
        elem = elem.next;
      }
      elem.next = new Node<T>(value, null);
    }
  }

  public void insert(int pos, T value) {
    if (pos == 0) {  // inserting at the start
      this.head = new Node<T>(value, this.head);
    } else {
      Node<T> prev = getByIndex(pos - 1);
      if (prev == null) { // index error!
        return;
      }
      prev.next = new Node<T>(value, prev.next);
    }
  }

  public void deleteAtIndex(int pos) {
    if (pos == 0) { // deleting the head
      if (head == null) {  // index error!
        return;
      }
      head = head.next;
    } else {
      Node<T> prev = getByIndex(pos - 1);
      if (prev == null || prev.next == null) { // index error!
        return;
      }
      prev.next = prev.next.next;
    }
  }

  public void appendList(List<T> otherList) {
    if (otherList.head == null) {  // nothing to append
      return;
    }

    Node<T> elem;  // element of this list
    Node<T> otherElem = otherList.head;

    // find the last element of this list
    if (head == null) {  // this list is currently empty
      this.head = new Node<T>(otherElem.value, null);
      elem = this.head;
      otherElem = otherElem.next;
    } else {
      // move along the chain to the last element
      elem = this.head;
      while (elem.next != null) {
        elem = elem.next;
      }
    }

    // then sequentially link new elements to the end
    while (otherElem != null) {
      elem.next = new Node<T>(otherElem.value, null);

      elem = elem.next;
      otherElem = otherElem.next;
    }
  }

  /* Find methods */
  public Node<T> findByValueIter(T value) {
    Node<T> current = this.head;
    while (current != null && current.value != value) {
      current = current.next;
    }
    return current;
  }

  public Node<T> findByValueRec(T value) {
    return findByValueRec(value, head);
  }

  private static <T> Node<T> findByValueRec(T value, Node<T> start) {
    if (start == null) {
      return null;
    } else if (start.value == value) {
      return start;
    } else {
      return findByValueRec(value, start.next);
    }
  }

  public Node<T> getByIndex(int pos) {
    if (pos < 0) {
      return null;
    }

    Node<T> elem = this.head;
    for (int i = 0; i < pos && elem != null; i++) {
      elem = elem.next;
    }
    return elem;  // null if pos was an invalid index
  }

  /* Print methods */
  public void print() {
    System.out.print("Liste ( ");
    Node<T> elem = head;
    while (elem != null) {
      System.out.print(elem.value + " ");
      elem = elem.next;
    }
    System.out.println(")");
  }

  public void printReversed() {
    System.out.print("Liste rückwärts ( ");
    printReversed(this.head);
    System.out.println(" )");
  }

  private static <T> void printReversed(Node<T> elem) {
    if (elem != null) {
      printReversed(elem.next);
      System.out.print(elem.value + " ");
    }
  }


  /* Max value methods */

  // here we abstract over minValue and the comparison since T is not int
  // anymore:
  T getMaxValueIter(T minValue, BinaryFunction<T, T, Boolean> greater) {
    T max = minValue;
    for (Node<T> elem = head; elem != null; elem = elem.next) {
      if (greater.call(elem.value, max)) {
        max = elem.value;
      }
    }
    return max;
  }

  public T getMaxValueRec(T minValue, BinaryFunction<T, T, Boolean> greater) {
      return getMaxValueRec(head, minValue, greater);
  }

  private T getMaxValueRec(Node<T> elem, T max, BinaryFunction<T, T, Boolean> greater) {
    if (elem == null) {
      return max;
    }
    if (greater.call(elem.value, max)) {
      max = elem.value;
    }
    return getMaxValueRec(elem.next, max, greater);
  }

  public static void main(String[] args) {
    List<Integer> list = new List<Integer>();
    for (int i = 0; i < 8; i++) {
      list.print();
      list.insertFirst(i + 1);
    }
    list.insertLastIterative(100);
    list.print();
    list.insertLastRecursive(200);
    list.print();

    //    for (int i = 0; i < 100000; i++) {
    //      list.insertFirst(i + 1);
    //    }

    list.insertLastIterative(1000);

    // Here we now have to choose the min value and greater comparison operator
    System.out.println("Final max: " + list.getMaxValueIter(Integer.MIN_VALUE, (x, y) -> x > y));

    var list2 = list.map(n -> n + 1);
    list.print();
    list2.print();
  }

   T reduce(BinaryFunction<T, T, T> f) {
     if (this.head == null) return null;
     T accu = this.head.value;
     Node<T> node = this.head.next;
     while (node != null) {
         accu = f.call(accu, node.value);
         node = node.next;
     }
     return accu;
   }

   <U> List<U> map(final UnaryFunction<T, U> f) {
     final List<U> li = new List<>();
     Node<T> node = this.head;
     while (node != null) {
       li.insertLastIterative(f.call(node.value));
       node = node.next;
     }
     return li;
   }
}


interface BinaryFunction<T, U, V> {
    V call(final T a, final U b);
}

interface UnaryFunction<T, U> {
  U call(T a);
}
