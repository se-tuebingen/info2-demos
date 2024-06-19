// Singly-linked list
public class List {
    ListElem head;

    /* Constructors */
    public List() {
    }

    public List(int item) {
        this.head = new ListElem(item, null);
    }

    /* Insertion methods */
    public void insertFirst(int item) {
        head = new ListElem(item, head);
    }

    public void insertLastRecursive(int item) {  // comfortable call
        if (head == null) {
            head = new ListElem(item, null);
        } else {
            insertLastRecursive(item, head);  // method overload
        }
    }

    private static void insertLastRecursive(int item, ListElem elem) {
        if (elem.next == null) {
            elem.next = new ListElem(item, null);
        } else {
            insertLastRecursive(item, elem.next);  // recursion
        }
    }

    public void insertLastIterative(int item) {
        if (head == null) {  // list is currently empty
            this.head = new ListElem(item, null);
        } else {
            ListElem elem = head;
            while (elem.next != null) {
                elem = elem.next;
            }
            elem.next = new ListElem(item, null);
        }
    }

    public void insert(int pos, int item) {
        if (pos == 0) {  // inserting at the start
            this.head = new ListElem(item, this.head);
        } else {
            ListElem prev = getByIndex(pos - 1);
            if (prev == null) { // index error!
                return;
            }
            prev.next = new ListElem(item, prev.next);
        }
    }

    public void deleteAtIndex(int pos) {
        if (pos == 0) { // deleting the head
            if (head == null) {  // index error!
                return;
            }
            head = head.next;
        } else {
            ListElem prev = getByIndex(pos-1);
            if (prev == null || prev.next == null) { // index error!
                return;
            }
            prev.next = prev.next.next;
        }
    }

    public void appendList(List otherList) {
        if (otherList.head == null) {  // nothing to append
            return;
        }

        ListElem elem;  // element of this list
        ListElem otherElem = otherList.head;

        // find the last element of this list
        if (head == null) {  // this list is currently empty
            this.head = new ListElem(otherElem.item, null);
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
            elem.next = new ListElem(otherElem.item, null);

            elem = elem.next;
            otherElem = otherElem.next;
        }
    }

    /* Find methods */
    public ListElem findByValueIter(int value) {
        ListElem current = this.head;
        while (current != null && current.item != value) {
            current = current.next;
        }
        return current;
    }

    public ListElem findByValueRec(int value) {
        return findByValueRec(value, head);
    }

    private static ListElem findByValueRec(int value, ListElem start) {
        if (start == null) {
            return null;
        } else if (start.item == value) {
            return start;
        } else {
            return findByValueRec(value, start.next);
        }
    }

    public ListElem getByIndex(int pos) {
        if (pos < 0) {
            return null;
        }

        ListElem elem = this.head;
        for (int i = 0; i < pos && elem != null; i++) {
            elem = elem.next;
        }
        return elem;  // null if pos was an invalid index
    }

    /* Print methods */
    public void print() {
        System.out.print("Liste ( ");
        ListElem elem = head;
        while (elem != null) {
            System.out.print(elem.item + " ");
            elem = elem.next;
        }
        System.out.println(")");
    }

    public void printReversed() {
        System.out.print("Liste rückwärts ( ");
        printReversed(this.head);
        System.out.println(" )");
    }

    private static void printReversed(ListElem elem) {
        if (elem != null) {
            printReversed(elem.next);
            System.out.print(elem.item + " ");
        }
    }

    /* Max value methods */
    public int getMaxValueIter() {
        int max = Integer.MIN_VALUE;
        for (ListElem elem = head; elem != null; elem = elem.next) {
            if (elem.item > max) {
                max = elem.item;
            }
        }
        return max;
    }

    public int getMaxValueRec() {
        return getMaxValueRec(head, Integer.MIN_VALUE);
    }

    private int getMaxValueRec(ListElem elem, int max) {
        if (elem == null) {
            return max;
        }
        if (elem.item > max) {
            max = elem.item;
        }
        return getMaxValueRec(elem.next, max);
    }

    public static void main(String[] args) {
        List list = new List();
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
        // list.insertLastRecursive(1000);
        list.insertLastIterative(1000);

        System.out.println("Final max: " + list.getMaxValueIter());

    }

}
