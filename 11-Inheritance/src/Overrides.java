class Person {
  public String greeting() { return "Hello!"; }
  public void sayHello(String name) {
    System.out.println(greeting() + " " + name);
  }
}

class EmojiPerson extends Person {
  // 👋
  private final String wavingHand = "\uD83D\uDC4B";

  // This shows that also concrete methods can be overridden
  @Override
  public String greeting() { return wavingHand + " " + super.greeting(); }
}

public class Overrides {

  public static void main(String[] args) {
    Person p1 = new Person();
    Person p2 = new EmojiPerson();

    p1.sayHello("Jonathan");
    p2.sayHello("Gerard");
    System.out.println(p2.getClass());
  }

}
