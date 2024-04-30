public class Check {

  static class ExpectException extends RuntimeException {
    final Object expected;
    final Object got;

    ExpectException(Object expected, Object got) {
      super("Expected " + expected.toString() + " but got " + got.toString());
      this.expected = expected;
      this.got = got;
    }
  }

  public static void expect(boolean got, boolean expected) {
    if (got != expected) {
      throw new ExpectException(expected, got);
    }
  }

  public static void expect(int got, int expected) {
    if (got != expected) {
      throw new ExpectException(expected, got);
    }
  }

  public static void expect(String got, String expected) {
    if (!got.equals(expected)) {
      throw new ExpectException(expected, got);
    }
  }

  public static void expect(int[] got, int[] expected) {
    if (got.length != expected.length) throw new ExpectException(expected, got);
    for (int i = 0; i < got.length; i++) {
      expect(got[i], expected[i]);
    }
  }
}
