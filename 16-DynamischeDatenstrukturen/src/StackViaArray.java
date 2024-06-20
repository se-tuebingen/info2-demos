public class StackViaArray {
    private final int MAX_HEIGHT = 1000;
    private final int[] stack = new int[MAX_HEIGHT];
    private int height = 0;

    public void push(int value) {
        stack[height++] = value;
    }

    public int pop() {
        if (height == 0) return 0;
        return stack[--height];
    }

    public boolean isEmpty() {     // Stack leer?
        return height == 0;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < height; i++)
            ret.append(stack[i]).append(" | ");
        return ret.toString();
    }

    public static void main(String[] args) {
        StackViaArray s = new StackViaArray();

        /* -- write numbers into the stack */
        s.push(1);
        s.push(19);
        s.push(200);

        /* -- pop and print as long as there are more elements */
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}