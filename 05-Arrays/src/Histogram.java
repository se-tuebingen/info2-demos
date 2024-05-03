public class Histogram {
  public static void main(String[] args) {

    // compute the histogram of the probability a
    // dice roll shows a number
    final int TOTAL_ROLLS = 1000;

    final int D = 123;

    final int[] rolls = new int[D];

    final int l = rolls.length;
    System.out.println(l);

    for (int i = 0; i < TOTAL_ROLLS; i = i + 1) {
      int randomRoll = (int)(Math.random() * D);
      rolls[randomRoll] = rolls[randomRoll] + 1;
    }
    for (int roll : rolls) {
      System.out.println(roll);
    }
  }
}

// In the lecture, we first hardcoded the 6 sides of a die using
// individual variables.
//
//    int die1 ... int die6
//
// Then update and look up needed to look like:
//
//    switch (2) {
//      case 0: die1 = die1 + 1; break;
//      case 1: die2 = die2 + 1; break;
//      case 2: die3 = die3 + 1; break;
//      case 3: die4 = die4 + 1; break;
//      case 4: die5 = die5 + 1; break;
//      case 5: die6 = die6 + 1; break;
//      default: throw new IllegalArgumentException("Wrong die roll");
//    }
//
//    System.out.println(die1);
//    System.out.println(die2);
//    System.out.println(die3);
//    System.out.println(die4);
//    System.out.println(die5);
//    System.out.println(die6);
//
// In our final implementation above, we simply need to change the constant `D`
// to create the histogram for different-sided dice.
