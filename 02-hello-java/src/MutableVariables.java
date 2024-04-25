public class MutableVariables {
  public static void main(String[] args) {

    // These are constant definitions:
    final int MATE_PRICE = 120;
    final int DEPOSIT_CRATE = 450;
    final int DEPOSIT_BOTTLES = 15;

    // This is a mutable variable that holds values of type int:
    int total = 0;

    // add price of the bottles
    total = total + (24 * MATE_PRICE);
    // add deposit for the bottles
    total = total + (24 * DEPOSIT_BOTTLES);
    // add deposit for the crate
    total = total + DEPOSIT_CRATE;

    System.out.println(total);
  }
}
