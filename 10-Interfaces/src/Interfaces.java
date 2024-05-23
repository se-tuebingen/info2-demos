interface Account {
  void withdraw(int amount);
  void deposit(int amount);
  int getBalance();
}


class AccountFactory {
  public static Account makeAccount(int initial, int limit) {
    return new AdvancedAccount(initial, limit);
  }
}

class SimpleAccount implements Account {
  private int balance;
  SimpleAccount(int initial) { balance = initial; }
  public void withdraw(int amount) {
    balance = balance - amount;
  }
  public void deposit(int amount) {
    balance = balance + amount;
  }
  public int getBalance() { return balance; }
}

class AdvancedAccount implements Account {
  private int balance;
  private int limit;
  AdvancedAccount(int initial, int limit) {
    this.balance = initial;
    this.limit = limit;
  }
  public void withdraw(int amount) {
    var newBalance = balance - amount;
    if (newBalance < limit) {
      throw new RuntimeException("Not enough limit.");
    } else {
      balance = newBalance;
    }
  }
  public void deposit(int amount) {
    balance = balance + amount;
  }
  public int getBalance() { return balance; }
}


class NoAccount { // no implements here
  public void withdraw(int amount) {}
  public void deposit(int amount) {}
  public int getBalance() { return 0; }
}


public class Interfaces {
  public static void user(Account account) {
    System.out.println("Balance: " + account.getBalance());
    account.deposit(1000); // 10 EUR
    System.out.println("Balance: " + account.getBalance());
  }

  public static void transfer(Account from, Account to, int amount) {
    from.withdraw(amount);
    to.deposit(amount);
  }

  public static void main(String[] args) {
    // incompatible types: NoAccount cannot be converted to Account
    //   Account acc = new NoAccount();

    var simple = new SimpleAccount(0);
    user(simple);

    var mary = new AdvancedAccount(1000_00, -200_00);
    var peter = new SimpleAccount(0);
    transfer(mary, peter, 13_49);
  }
}
