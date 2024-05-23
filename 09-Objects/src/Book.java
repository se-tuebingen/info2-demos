public class Book {
  final String title;
  final String author;
  boolean isBorrowed;

  Book(String title, String author) {
    this.title = title;
    this.author = author;
    this.isBorrowed = false;
  }
  public void borrow() {
    if (isBorrowed) System.out.println("Cannot borrow book: " + title);
    else isBorrowed = true;
  }
}
