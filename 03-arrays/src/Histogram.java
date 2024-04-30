public class Histogram {
  public static void main(String[] args) {
    // compute the histogram of the probability a
    // dice roll shows a number
    final int TOTAL_ROLLS = 1000;
    final int[] rolls = new int[] {0, 0, 0, 0, 0, 0};

    for (int i = 0; i < TOTAL_ROLLS; i = i + 1) {
      int randomRoll = (int)(Math.random() * 6);
      rolls[randomRoll] = rolls[randomRoll] + 1;
    }
    for (int roll : rolls) {
      System.out.println(roll);
    }
  }
}
