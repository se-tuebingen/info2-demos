// Only for illustration of application possibilities of stacks.
// This is a more advanced calculator which has two stacks (main and auxiliary) so it can compute
// more complex formulas where one variable can appear in several places, like the quadratic formula.
public class StackCalculatorAdv {
    private final StackViaList s = new StackViaList();
    private final StackViaList aux = new StackViaList();

    public static void main(String[] args) {
        StackCalculatorAdv sc = new StackCalculatorAdv();
        double a = 3;
        double b = 4;
        double c = -5;
        sc.push(c);
        sc.push(b);
        sc.push(a);
        solveQuadraticEquation(sc);
        double x1 = sc.pop();
        double x2 = sc.pop();
        System.out.println("Result with StackCalculator is x1 = " + x1 + ", x2 = " + x2);

        double sqrtd = Math.sqrt(b * b - 4 * a * c);
        x1 = (-b + sqrtd) / (2 * a);
        x2 = (-b - sqrtd) / (2 * a);
        System.out.println("Result should be: x1 = " + x1 + ", x2 = " + x2);
    }

    public static void solveQuadraticEquation(StackCalculatorAdv sc) {
        // comments show: state of aux stack | state of main stack, with the top facing the | sign
        sc.dup(); // | a a b c
        sc.stow(); // a | a b c
        sc.div(); // a | b/a c
        sc.push(2); // a | 2 b/a c
        sc.div(); // a | b/(2*a) c
        sc.swap(); // a | c b/(2*a)
        sc.unstow(); // | a c b/(2*a)
        sc.div(); // | c/a b/(2*a)
        sc.swap(); // | b/(2*a) c/a
        sc.dup(); // | b/(2*a) b/(2*a) c/a
        sc.stow(); // b/(2*a) | b/(2*a) c/a
        sc.sqr(); // b/(2*a) | (b/(2*a))**2 c/a
        sc.swap(); // b/(2*a) | c/a (b/(2*a))**2
        sc.sub(); // b/(2*a) | (b/(2*a))**2-c/a
        sc.sqrt(); // b/(2*a) | √((b/(2*a))**2-c/a)
        sc.unstow(); // | b/(2*a) √((b/(2*a))**2-c/a)
        sc.dup(); // | b/(2*a) b/(2*a) √((b/(2*a))**2-c/a)
        sc.stow(); // b/(2*a) | b/(2*a) √((b/(2*a))**2-c/a)
        sc.swap(); // b/(2*a) | √((b/(2*a))**2-c/a) b/(2*a)
        sc.dup(); // b/(2*a) | √((b/(2*a))**2-c/a) √((b/(2*a))**2-c/a) b/(2*a)
        sc.unstow(); // | b/(2*a) √((b/(2*a))**2-c/a) √((b/(2*a))**2-c/a) b/(2*a)
        sc.sub(); // | -b/(2*a)+√((b/(2*a))**2-c/a) √((b/(2*a))**2-c/a) b/(2*a)
        sc.stow(); // -b/(2*a)+√((b/(2*a))**2-c/a) | √((b/(2*a))**2-c/a)  b/(2*a)
        sc.add(); // -b/(2*a)+√((b/(2*a))**2-c/a) | b/(2*a)+√((b/(2*a))**2-c/a)
        sc.neg(); // -b/(2*a)-√((b/(2*a))**2-c/a) | -b/(2*a)+√((b/(2*a))**2-c/a)
        sc.unstow(); // | -b/(2*a)-√((b/(2*a))**2-c/a) -b/(2*a)+√((b/(2*a))**2-c/a)
    }

    public void push(double value) {
        s.push(value);
    }

    public void stow() {
        aux.push(s.pop());
    }

    public void unstow() {
        s.push(aux.pop());
    }

    public void add() {
        double a = s.pop();
        double b = s.pop();
        s.push(a + b);
    }

    public void mul() {
        double a = s.pop();
        double b = s.pop();
        s.push(a * b);
    }

    public void div() {
        double a = s.pop();
        double b = s.pop();
        s.push(b / a);
    }

    public void sub() {
        double a = s.pop();
        double b = s.pop();
        s.push(b - a);
    }

    public void sqrt() {
        double a = s.pop();
        s.push(Math.sqrt(a));
    }

    public void drop() {
        s.pop();
    }

    public double pop() {
        return s.pop();
    }

    public void dup() {
        double a = s.pop();
        s.push(a);
        s.push(a);
    }

    public void sqr() {
        double a = s.pop();
        s.push(a * a);
    }

    public void swap() {
        double a = s.pop();
        double b = s.pop();
        s.push(a);
        s.push(b);
    }

    public void neg() {
        s.push(-s.pop());
    }
}
