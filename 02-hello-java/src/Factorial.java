public class Factorial {
  /**
    * Calculates the factorial of a given non-negative integer.
    *
    * @param n the non-negative integer to calculate the factorial of
    * @return the factorial of n
    * @throws IllegalArgumentException if n is negative
    */
  public static long factorial(int n) {
    // assert the precondition
    if (n < 0) {
      throw new IllegalArgumentException("n must be non-negative.");
    }

    long result = 1;
    for (int i = 2; i <= n; i++) {
      result *= i;
    }
    return result;
  }
}
