package subtyping;

class Item {
    void checkOut() {
        System.out.println("Item checked out");
    }
}

class Book extends Item {
    void checkOut() {
        System.out.println("Book checked out");
    }
}

class DVD extends Item {
    void checkOut() {
        System.out.println("DVD checked out");
    }
}

public class Polymorphism {


  public static void checkoutAll(Item[] items) {
    for (Item i : items) {
      i.checkOut();
    }
  }

  public static void main(String[] args) {
    var examples = new Item[] { new Book(), new DVD(), new Item() };
    checkoutAll(examples);
  }
}
