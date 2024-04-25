public class HelloWorld {

  /**
   * Java is a "compiled" language. That is, we first compile this
   * .java file to a "class" file which then can be executed.
   *
   *   javac -d out/ HelloWorld.java
   *
   * This generates a .class file in the folder out/
   * Class files can be interpreted by the Java Virtual Machine (JVM).
   * We can look at the class file with:
   *
   *   javap -c out/HelloWorld.class
   *
   * We can finally run our program by using the following command:
   *
   *   java -cp out/ HelloWorld
   *
   * It tells the JVM to look for class files in folder out/ and start the
   * program, which is stored in the class called HelloWorld.
   */
  public static void main(String[] args) {
    // This is the start of our program vvvvvv

    // This is a "Statement" in imperative programming.
    System.out.println("Hello World!!!");

    // This is the end of our program vvvvvv
  }
}
