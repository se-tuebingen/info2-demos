import java.util.Arrays;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Exceptions {


  public static void main(String[] args) {
    // useFirst(new int[] {});
    //    handling(new int[]{1, 2, 3});    // 0
    //    handling(new int[]{1, 2, 3, 4}); // 4
    foo();
  }

  static void stop() {
    var somethingBad = true;

    if (somethingBad) {
      throw new RuntimeException("Stop!");
    }
    System.out.println("Normally, we would continue here.");

  }

  static void commonExceptions(String exceptionType) {

    switch (exceptionType) {
      // NullPointerExceptions
      case "NPE":
        String str = null;
        int length = str.length();

      case "ArrayIndexOutOfBounds":
        int[] numbers = {1, 2, 3};
        int number = numbers[3];

      case "Arithmetic":
        int result = 10 / 0;

      case "ClassCast":
        Object obj = Integer.valueOf(100);
        String asString = (String) obj;

      case "IllegalArgument":
        int[] originalArray = {1, 2, 3, 4, 5};
        int[] copy = Arrays.copyOfRange(originalArray, 3, 2);

      case "NumberFormat":
        int num = Integer.parseInt("124abc");

      case "IndexOutOfBounds":
        String hello = "hello";
        char ch = hello.charAt(10);

      case "NegativeArraySize":
        int[] array = new int[-5];
    }
  }

  static void checkedException1() {
    try {
      FileReader fileReader = new FileReader("nonexistentfile.txt");
    } catch (FileNotFoundException e) {
      System.out.println("Sorry, cannot find nonexistentfile.txt");
    }
  }

  static void checkedException() throws FileNotFoundException {
    FileReader fileReader = new FileReader("nonexistentfile.txt");
  }
  static void otherFunction() {
    try { checkedException(); }
    catch (FileNotFoundException e) {
      System.out.println("Sorry, cannot find file.");
    }
  }

  static void handling(int[] numbers) {
    int number;
    try {
      number = numbers[3];
    } catch (IndexOutOfBoundsException e) {
      number = 0;
    }
    System.out.println("Number: " + number);
  }

  static int getFirst(int[] numbers) {
    return numbers[0]; // throws IndexOutOfBounds
  }
  static void useFirst(int[] numbers) {
    int n;
    try { n = getFirst(numbers); }
    catch (IndexOutOfBoundsException e) { n = 0; }

    for (int i = 0; i < n; i++) {
      System.out.print("Hi");
    }
    System.out.print("\n");
  }

  static void alreadyHandled() {
    try { useFirst(new int[] {}); }
    catch (IndexOutOfBoundsException e) {
      System.out.println("Catch again.");
    }
  }

  static void openFile(String path) throws FileNotFoundException {}

  static void acquireResources() {}
  static void cleanupResources() {}

  static void rethrow() throws FileNotFoundException {
    acquireResources();
    try {
      openFile("doesnotexist.txt");
      cleanupResources();
    }
    catch (Exception e) {
      cleanupResources();
      throw e;
    }
  }

  static void rethrowFinally() throws FileNotFoundException {
    acquireResources();
    try {
      openFile("doesnotexist.txt");
    } finally {
      cleanupResources();
    }
  }

  public static class MyResource implements AutoCloseable {
    public MyResource() {
        System.out.println("resource acquired");
    }

    @Override
    public void close() {
        System.out.println("resource closed");
    }

    public void use() {
        System.out.println("Doing something with resource");
    }
  }

  static void resources() {
    try (MyResource resource = new MyResource()) {
      resource.use();
    }
  }

  // User Defined Exceptions

  static class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String accountNumber) {
        super("Insufficient funds for " + accountNumber);
    }
  }

  static class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
      this.accountNumber = accountNumber;
      this.balance = initialBalance;
    }

    public String getAccountNumber() {
      return accountNumber;
    }

    public double getBalance() {
      return balance;
    }

    public void deposit(double amount) {
      if (amount > 0) {
        balance += amount;
      }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
      if (amount > balance) {
        throw new InsufficientFundsException(accountNumber);
      }
      balance -= amount;
    }

    public static void main(String[] args) {
      BankAccount account = new BankAccount("12345", 1000.00);

      try {
        account.withdraw(1500.00);
      } catch (InsufficientFundsException e) {
        System.out.println("Withdrawal failed: " + e.getMessage());
      }
    }
  }


  // Which handler catches the exception?

  static void whichHandler() {
    class ExcA extends RuntimeException {}
    class ExcB extends RuntimeException {}

    try {
      try {
        throw new ExcB();
      } catch (ExcA e) { System.out.println("Exception A"); }
    } catch (ExcB e) { System.out.println("Exception B"); }
  }

  static void multipleCatches() {
    class ExcA extends RuntimeException {
    }
    class ExcB extends RuntimeException {
    }

    try {
      throw new ExcB();
    } catch (ExcA e) {
      System.out.println("Exception A");
    } catch (ExcB e) {
      System.out.println("Exception B");
    } finally {
      System.out.println("Leaving scope");
    }
  }

  static void foo() {
    int x = 1;
    try { bar(); }
    catch (RuntimeException e) { System.out.println("handled"); }
    System.out.println("In foo: " + x);
  }

  static void bar() {
    int x = 42;
    throw new RuntimeException();
    //    System.out.println("In bar: " +x);
    //    return;
  }


}
