// Singly-linked list with foot
public class ListWithFoot extends List {
    ListElem foot;

    /* Constructors */
    public ListWithFoot() {
    }

    public ListWithFoot(int item) { // single-element list
        this.head = new ListElem(item, null);
        this.foot = head;
    }

    /* Insertion methods */
    public void insertFirst(int item) {
        head = new ListElem(item, head);
        if (foot == null) { // empty list
            foot = head;
        }
    }

    public void insertLast(int item) {
        // This is now fast with foot, no need for iterative/recursive solution
        ListElem newElem = new ListElem(item, null);
        if (head == null) {
            head = newElem;
        } else {
            foot.next = newElem;
        }
        foot = newElem;
    }

    public void insertLastRecursive(int item) { // no need for iterative/recursive solution
        insertLast(item);
    }

    public void insertLastIterative(int item) { // no need for iterative/recursive solution
        insertLast(item);
    }

    public void insert(int pos, int item) {
        ListElem elem = new ListElem(item, null);
        if (pos == 0) {  // inserting at the start
            if (this.head == null) { // empty list, so we are also inserting at the end
                this.foot = elem;
            }
            elem.next = this.head;
            this.head = elem;
        } else {
            ListElem prev = getByIndex(pos-1);
            if (prev == null) {
                return; // index error! pos is either too large or negative
            }
            if (prev.next == null) { // inserting at the end
                this.foot = elem;
            }
            elem.next = prev.next;
            prev.next = elem;
        }
    }

    public void deleteAtIndex(int pos) {
        // Note the analogous structure of the `if` and `else` branches
        if (pos == 0) { // deleting the head
            if (head == null) {  // index error!
                return;
            }
            if (head == foot) { // there's one elem only, list is empty after deletion
                foot = null;
            }
            head = head.next;
        } else {
            ListElem prev = getByIndex(pos-1);
            if (prev == null || prev.next == null) {
                return; // index error!
            }
            if (prev.next == foot) {  // deleting the foot
                foot = prev;
            }
            prev.next = prev.next.next;
        }
    }

    public void appendList(ListWithFoot list) {
        for (ListElem elem = list.head; elem != null; elem = elem.next)
            insertLast(elem.item);  // this is now fast with foot
    }

    public static void main(String[] args) {
        ListWithFoot list = new ListWithFoot();
        for (int i = 0; i < 42; i++) {
            list.print();
            list.insertLast(i + 1);
        }
        list.print();
    }
}
