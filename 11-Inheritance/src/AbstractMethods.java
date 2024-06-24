abstract class BankAccount {
  protected int balance;

  public BankAccount(int balance) {
    this.balance = balance;
  }

  public void deposit(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Invalid amount");
    }
    balance += amount;
  }

  public int balance() {
    return this.balance;
  }

  // Method to be overridden, not implemented here
  public abstract int calculateMonthlyFees();

  public String report() {
    return
      "Balance: " + Currency.EUR(balance()) + "\n" +
      "Monthly Fee: " + Currency.EUR(calculateMonthlyFees());
  }
}

class Currency {
  public static String EUR(int amountInCents) {
    int euros = amountInCents / 100;
    int cents = amountInCents % 100;
    return String.format("%d,%02d €", euros, cents);
  }
}

class SavingsAccount extends BankAccount {
  private final float interestRate;

  public SavingsAccount(int balance, float interestRate) {
    super(balance);
    this.interestRate = interestRate;
  }

  public void addInterest() {
    int interest = Math.round(balance * interestRate);
    balance += interest;
  }

  @Override
  public int calculateMonthlyFees() {
    // For example, a savings account might have a fixed monthly fee
    return 500;
  }
}

class CheckingAccount extends BankAccount {
  private final int limit;

  public CheckingAccount(int balance, int limit) {
    super(balance);
    this.limit = limit;
  }

  public void withdraw(int amount) {
    if (amount > balance + limit) {
      throw new IllegalArgumentException("Limit exceeded");
    }
    balance -= amount;
  }

  @Override
  public int calculateMonthlyFees() {
    // For example, a checking account might have fees based on the balance
    if (balance < 1000) {
      return 1000; // Higher fee if balance is below a certain threshold
    } else {
      return 0; // No fee if balance is above a certain threshold
    }
  }
}


public class AbstractMethods {
  public static void main(String[] args) {
    SavingsAccount savings = new SavingsAccount(1000, 0.05f);
    var checking = new CheckingAccount(2000, 500);

    savings.deposit(500);
    savings.addInterest();
    System.out.println(savings.balance());

    checking.deposit(300);           // Method on BankAccount
    checking.withdraw(2500);         // Method on CheckingAccount
    System.out.println(checking.balance()); // Method on BankAccount

    System.out.println(checking.report());
  }
}
