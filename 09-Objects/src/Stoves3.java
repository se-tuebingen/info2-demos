
class Stove {
  int heat = 0;
  void increase() {
    heat = Math.min(heat + 1, 9);
  }
}

public class Stoves3 {
  Stove[] stoves = new Stove[] {
    new Stove(), new Stove(),
    new Stove(), new Stove() };

  public void increase(int stove) {
    final var offset = stove - 1;
    if (offset < 0 || offset >= stoves.length) {
      throw new IllegalArgumentException("Not a valid stove");
    }
    stoves[offset].increase();
  }
}
