public class Account {
  private double balance;

  public Account(double initialBalance) {
    this.balance = initialBalance;
  }
  public void withdraw(double amount) {
    if (amount > 0 && hasSufficientBalance(amount)) {
      balance -= amount;
      System.out.println("Withdrawn: " + amount);
    } else {
      System.out.println("Insufficient funds.");
    }
  }

  // This is a private helper method, not accessible from the outside
  private boolean hasSufficientBalance(double amount) {
      return balance >= amount;
  }
}
