package after;


class Account {
  protected int balance;

  public Account(int balance) {
    this.balance = balance;
  }

  public void deposit(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Invalid deposit amount");
    }
    balance += amount;
  }

  public int balance() {
    return this.balance;
  }
}

class SavingsAccount extends Account {
  private final float interestRate;

  public SavingsAccount(int balance, float interestRate) {
    super(balance);
    this.interestRate = interestRate;
  }

  public void addInterest() {
    int interest = Math.round(balance * interestRate);
    balance += interest;
  }
}

class CheckingAccount extends Account {
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
}

public class InheritanceAfter {
  public static void main(String[] args) {
    SavingsAccount savings = new SavingsAccount(10_00, 0.005f);
    var checking = new CheckingAccount(2000, 500);

    savings.deposit(500);
    savings.addInterest();
    System.out.println(savings.balance());

    checking.deposit(300);           // Method on BankAccount
    checking.withdraw(2500);         // Method on CheckingAccount
    System.out.println(checking.balance()); // Method on BankAccount
    checking.equals(checking);
  }
}
