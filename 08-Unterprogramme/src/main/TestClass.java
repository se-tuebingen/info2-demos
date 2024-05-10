package main;
import main.subp1.Test;
public class TestClass {
    public static void main(String[] args) {
        AccessRights obj = new AccessRights();
        obj.publicMethod();
        System.out.println(obj.publicVar);
        // obj.privateMethod();                 -- not allowed
        // System.out.println(obj.privateVar);  -- not allowed

        // Using an imported package
        main.subp1.Test.testFoo(11);
    }
}
