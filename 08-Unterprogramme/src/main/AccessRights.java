package main;
/**
 * Illustrates access modifiers public, private. Methods are called from TestClass.java main
 *
 *     @Author: Gerard Pons-Moll
 */
public class AccessRights {
    private int privateVar = 2;
    public int publicVar;
    public void publicMethod(){
        System.out.println("Public method was called");
        System.out.println("I can call the private method from within the class" +
                "not from the world (e.g. main in TestClass)");
        privateMethod();
    }
    private void privateMethod(){
        System.out.println("Private method was called");
        System.out.println("The private var is: " + privateVar);
    }
}
