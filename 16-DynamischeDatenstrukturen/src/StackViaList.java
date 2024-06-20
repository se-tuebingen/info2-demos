public class StackViaList {
    private ListElemFloatingPoint top = null;

    public void push(double value) {
        top = new ListElemFloatingPoint(value, top);
    }

    public double pop() {
        if (top == null)
            return Double.NaN;
        double value = top.item;
        top = top.next;
        return value;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (ListElemFloatingPoint l = top; l != null; l = l.next)
            ret.append(l.item).append(" ");
        return ret.toString();
    }

    public static void main(String[] args) {
        StackViaList s = new StackViaList();

        s.push(111);
        System.out.println(s.toString());
        s.push(222);
        System.out.println(s.toString());
        s.push(333);
        System.out.println(s.toString());
        s.pop();
        System.out.println(s.toString());
        s.pop();
        System.out.println(s.toString());
        s.pop();
        System.out.println(s.toString());
        s.pop();
        System.out.println(s.toString());

    }
}
