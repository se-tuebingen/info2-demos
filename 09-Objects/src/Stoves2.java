public class Stoves2 {
  int[] stoves = new int[] { 0, 0, 0, 0 };

  public void increase(int stove) {
    final var offset = stove - 1;
    if (offset < 0 || offset >= stoves.length) {
      throw new IllegalArgumentException("Not a valid stove");
    }
    stoves[offset] = Math.min(stoves[offset] + 1, 9);
  }
}
