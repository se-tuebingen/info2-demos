// Doubly-linked list element
public class ListElemDL {
    int item;
    ListElemDL prev;
    ListElemDL next;

    public ListElemDL(int newItem, ListElemDL prev, ListElemDL next) {
        this.item = newItem;
        this.prev = prev;
        this.next = next;
    }
}