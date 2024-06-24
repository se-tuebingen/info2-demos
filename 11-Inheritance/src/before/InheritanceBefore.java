package before;

interface Account {
  int balance();
  void deposit(int amount);
}

class SavingsAccount implements Account {
  private int balance;
  private final float interestRate;

  public SavingsAccount(int balance, float interestRate) {
    this.balance = balance;
    this.interestRate = interestRate;
  }

  public void deposit(int amount) {
    if (amount < 0) { throw new IllegalArgumentException("Invalid deposit amount"); }
    balance += amount;
  }

  public void addInterest() {
    int interest = Math.round(balance * interestRate);
    balance += interest;
  }

  public int balance() { return this.balance; }
}

class CheckingAccount implements Account {
  private int balance;
  private final int limit;

  public CheckingAccount(int balance, int limit) {
    this.balance = balance;
    this.limit = limit;
  }

  public void deposit(int amount) {
    if (amount < 0) { throw new IllegalArgumentException("Invalid deposit amount"); }
    balance += amount;
  }

  public void withdraw(int amount) {
    if (amount > balance + limit) { throw new IllegalArgumentException("Limit exceeded"); }
    balance -= amount;
  }

  public int balance() { return this.balance; }
}

public class InheritanceBefore {
  public static void main(String[] args) {
    SavingsAccount savings = new SavingsAccount( 1000, 0.05f);
    CheckingAccount checking = new CheckingAccount(2000, 500);

    savings.deposit(500);
    savings.addInterest();
    System.out.println(savings.balance());

    checking.deposit(300);
    checking.withdraw(2500);
    System.out.println(checking.balance());
  }
}
