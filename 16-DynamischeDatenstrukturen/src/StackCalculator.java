public class StackCalculator {

	public static void main(String[] args) {
		String s = "2689*-/9+";
		double result = calculateRPN(s);
		System.out.println(s+" = "+result);
		result = 2./(6.-8.*9.)+9.;
		System.out.println("2/(6-8*9)+9 = "+result);
	}

	public static double calculateRPN(String expression) {
		char[] symbols = expression.toCharArray();
		StackViaList s = new StackViaList();
        for (char symbol : symbols) {
            if (symbol >= '0' && symbol <= '9') {
                s.push(symbol - '0');
            } else {
                double b = s.pop();
                double a = s.pop();
                switch (symbol) {
                    case '+':
                        s.push(a + b);
                        break;
                    case '-':
                        s.push(a - b);
                        break;
                    case '*':
                        s.push(a * b);
                        break;
                    case '/':
                        s.push(a / b);
                        break;
                }
            }
        }
		return s.pop();
    }
}
