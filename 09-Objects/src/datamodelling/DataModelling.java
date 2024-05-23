package datamodelling;

record Book(String title, String author, boolean isBorrowed) {}

public class DataModelling {

  public static void main(String[] args) {

    final String[] titles = new String[] { "Effective Java", "Pragmatic Programmer" };
    final String[] authors = new String[] { "Joshua Bloch", "David Thomas and Andrew Hunt" };
    final boolean[] isBorrowed = new boolean[] { true, false };

    var books = new Book[] {
      new Book("Effective Java", "Joshua Bloch", true),
      new Book("Pragmatic Programmer", "David Thomas and Andrew Hunt", false)
    };

    System.out.println(books[0].title());

    var book = new Object() {
      String title = "Effective Java";
      String author = "Joshua Bloch";
      boolean isBorrowed = false;

      void borrow() {
        if (isBorrowed) System.out.println("Cannot borrow book: " + title);
        else isBorrowed = true;
      }
    };

    book.borrow();
    book.borrow();
  }
}
