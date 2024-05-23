public class Stoves1 {
  int stove1 = 0;
  int stove2 = 0;
  int stove3 = 0;
  int stove4 = 0;

  public void increase(int stove) {
    if (stove <= 0 || stove > 4) {
      throw new IllegalArgumentException("Not a valid stove");
    }
    switch (stove) {
      case 1 -> stove1 = Math.min(stove1 + 1, 9);
      case 2 -> stove2 = Math.min(stove2 + 1, 9);
      case 3 -> stove3 = Math.min(stove3 + 1, 9);
      case 4 -> stove4 = Math.min(stove4 + 1, 9);
    }
  }
}
