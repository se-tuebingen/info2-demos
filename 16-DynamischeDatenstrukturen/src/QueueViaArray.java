public class QueueViaArray {
    private final int MAX_LENGTH = 1000;
    private final int[] arr = new int[MAX_LENGTH];
    int head;
    int tail;

    public void enqueue(int item) {
        if (tail + 1 == head) {
            return; // queue is full
        }
        arr[tail++] = item;
        tail %= arr.length;
    }

    public int dequeue() {
        int item = arr[head++];
        head %= arr.length;
        return item;
    }

    public static void main(String[] args) {
        QueueViaArray queue = new QueueViaArray();
        for (int i = 0; i < 42; i++) {
            queue.enqueue(i + 1);
        }

        for (int i = 0; i < 42; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
