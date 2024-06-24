package subtyping;

class Person {
  private String name;
  Person(String name) { this.name = name; }
  String getName() {
    System.out.println("Called getName in Person");
    return this.name;
  }
}

class Student extends Person {
  private String id;
  Student(String name, String id) {
    super(name);
    this.id = id;
  }
  String getId() { return this.id; }

  String getName() {
    System.out.println("Called getName in Student");
    return "STUDENTXYZ"; // super.getName();
  }
}

class Prof extends Person {
  private String id;
  Prof(String name, String id) {
    super(name);
    this.id = id;
  }
  String getId() { return this.id; }
}

public class TypeEquality {
  static void greet(Person p) {
    System.out.println("Hello " + p.getName());
  }

  public static void main(String[] args) {

    Person p = new Person("Klaus Tester");
    System.out.println(p.getName());

    Student s = new Student("Jonathan", "123456");
    System.out.println(s.getName());

    // Runtime Class <: Compile time class
    //

    greet((Person) s);

    // upcasts are safe
    // ----------------
    Student s1 = new Student("Jonathan B.", "3188468");
    s1.getId(); // Ok
    Person p2 = (Person) s;
    // p2.getId(); // Not Ok


    // We can cast p2 down to a student, again.
    // Typically, we would check that this is safe before.
    if (p2 instanceof Student) {
      Student s2 = (Student) p2;
    }

    // Here we have an example, where a downcast is not safe
    // and will crash at runtime.
    Prof p3 = new Prof("Jonathan B.", "3188468");
    // upcast (safe)
    Person person = (Person) p3;

    if (person instanceof Student) {
      // downcast (unsafe)
      // would crash if we wouldn't check for it before.
      // try commenting out the `if` and observe the crash.
      Student s2 = (Student) person;
    } else {
      System.out.println("Not a student");
    }
  }
}
