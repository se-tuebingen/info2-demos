public class QueueViaList {
    ListElem head;
    ListElem tail;

    public void enqueue(int item) {
        if (tail == null) {
            tail = new ListElem(item, null);
            head = tail;
        } else {
            tail.next = new ListElem(item, null);
            tail = tail.next;
        }
    }

    public int dequeue() {
        if (head == null) {
            return 0; // queue is empty
        }
        int item = head.item;
        head = head.next;
        return item;
    }

    public static void main(String[] args) {
        QueueViaList queue = new QueueViaList();
        for (int i = 0; i < 42; i++) {
            queue.enqueue(i + 1);
        }


        for (int i = 0; i < 42; i++) {
            System.out.println(queue.dequeue());
        }
    }
}