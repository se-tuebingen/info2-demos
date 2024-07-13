// Singly-linked list (from last week)
public class IntList {

  IntNode head;

  /* Constructors */
  public IntList() {
  }

  public IntList(int value) {
    this.head = new IntNode(value, null);
  }

  /* Insertion methods */
  public void insertFirst(int value) {
    head = new IntNode(value, head);
  }

  public void insertLastRecursive(int value) {  // comfortable call
    if (head == null) {
      head = new IntNode(value, null);
    } else {
      insertLastRecursive(value, head);  // method overload
    }
  }

  private static void insertLastRecursive(int value, IntNode elem) {
    if (elem.next == null) {
      elem.next = new IntNode(value, null);
    } else {
      insertLastRecursive(value, elem.next);  // recursion
    }
  }

  public void insertLastIterative(int value) {
    if (head == null) {  // list is currently empty
      this.head = new IntNode(value, null);
    } else {
      IntNode elem = head;
      while (elem.next != null) {
        elem = elem.next;
      }
      elem.next = new IntNode(value, null);
    }
  }

  public void insert(int pos, int value) {
    if (pos == 0) {  // inserting at the start
      this.head = new IntNode(value, this.head);
    } else {
      IntNode prev = getByIndex(pos - 1);
      if (prev == null) { // index error!
        return;
      }
      prev.next = new IntNode(value, prev.next);
    }
  }

  public void deleteAtIndex(int pos) {
    if (pos == 0) { // deleting the head
      if (head == null) {  // index error!
        return;
      }
      head = head.next;
    } else {
      IntNode prev = getByIndex(pos - 1);
      if (prev == null || prev.next == null) { // index error!
        return;
      }
      prev.next = prev.next.next;
    }
  }

  public void appendList(IntList otherList) {
    if (otherList.head == null) {  // nothing to append
      return;
    }

    IntNode elem;  // element of this list
    IntNode otherElem = otherList.head;

    // find the last element of this list
    if (head == null) {  // this list is currently empty
      this.head = new IntNode(otherElem.value, null);
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
      elem.next = new IntNode(otherElem.value, null);

      elem = elem.next;
      otherElem = otherElem.next;
    }
  }

  /* Find methods */
  public IntNode findByValueIter(int value) {
    IntNode current = this.head;
    while (current != null && current.value != value) {
      current = current.next;
    }
    return current;
  }

  public IntNode findByValueRec(int value) {
    return findByValueRec(value, head);
  }

  private static IntNode findByValueRec(int value, IntNode start) {
    if (start == null) {
      return null;
    } else if (start.value == value) {
      return start;
    } else {
      return findByValueRec(value, start.next);
    }
  }

  public IntNode getByIndex(int pos) {
    if (pos < 0) {
      return null;
    }

    IntNode elem = this.head;
    for (int i = 0; i < pos && elem != null; i++) {
      elem = elem.next;
    }
    return elem;  // null if pos was an invalid index
  }

  /* Print methods */
  public void print() {
    System.out.print("Liste ( ");
    IntNode elem = head;
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

  private static void printReversed(IntNode elem) {
    if (elem != null) {
      printReversed(elem.next);
      System.out.print(elem.value + " ");
    }
  }

  /* Max value methods */
  public int getMaxValueIter() {
    int max = Integer.MIN_VALUE;
    for (IntNode elem = head; elem != null; elem = elem.next) {
      if (elem.value > max) {
        max = elem.value;
      }
    }
    return max;
  }

  public int getMaxValueRec() {
    return getMaxValueRec(head, Integer.MIN_VALUE);
  }

  private int getMaxValueRec(IntNode elem, int max) {
    if (elem == null) {
      return max;
    }
    if (elem.value > max) {
      max = elem.value;
    }
    return getMaxValueRec(elem.next, max);
  }

  public static void main(String[] args) {
    IntList list = new IntList();
    for (int i = 0; i < 8; i++) {
      list.print();
      list.insertFirst(i + 1);
    }
    list.insertLastIterative(100);
    list.print();
    list.insertLastRecursive(200);
    list.print();

    for (int i = 0; i < 100000; i++) {
      list.insertFirst(i + 1);
    }

    list.insertLastIterative(1000);

    System.out.println("Final max: " + list.getMaxValueIter());
  }
}

