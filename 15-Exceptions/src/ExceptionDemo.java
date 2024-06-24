class AMLComplianceException extends Exception {}

public class ExceptionDemo {

  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Our tool requires exactly three arguments <FROM> <TO> <AMOUNT>");
      System.exit(1);
    }
    final String from = args[0];
    final String to = args[1];

    try {
      int amount = Integer.parseInt(args[2]);
      transfer(from, to, amount);
    } catch (NumberFormatException e) {
      System.out.println("Our tool requires the third argument to be a number.");
      System.exit(1);
    } catch (AMLComplianceException e) {
      System.out.println("Cannot send more than 10.000 EUR due to regulatory restrictions.");
      System.exit(1);
    }
  }

  static void transfer(String from, String to, int amount) throws AMLComplianceException {
    validate(amount);
    System.out.println("Sending " + amount + "ct from " + from + " to " + to);
  }

  static void validate(int amount) throws AMLComplianceException {
    if (amount > 10_000_00) {
      throw new AMLComplianceException();
    }
  }
}
