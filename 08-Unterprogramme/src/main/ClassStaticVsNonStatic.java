package main;

/**
 *     Class to illustrate the difference of static vs non-static variables and methods
 *     This will become much clearer after seeing OOP
 *
 *     @Author: Gerard Pons-Moll
 */

public class ClassStaticVsNonStatic {
 static private int staticVar = 0;
 private int nonStaticVar = 0;
 public static void changeStaticVar(){
     staticVar++;
     // The instruction below is not allowed because the variable is non-static
     // and method is static
     // nonStaticVar++;
 }
 //Non-static method
 public void changeNonStaticVar(){
     nonStaticVar++;
     this.nonStaticVar++; //equivalent.
 }
    public static void main(String[] args) {
        // Generate two instances of the class (objects)
        ClassStaticVsNonStatic obj = new ClassStaticVsNonStatic();
        ClassStaticVsNonStatic obj1 = new ClassStaticVsNonStatic();

        // Changing this static variable has en effect in all instances of the class
        ClassStaticVsNonStatic.staticVar = 10;
        System.out.println(obj1.staticVar);

        // Static variable can be changed from any instance
        obj.staticVar = 5;
        System.out.println(obj1.staticVar);

        // or within methods
       obj.changeStaticVar();
       System.out.println(obj1.staticVar);

       if (obj.staticVar == ClassStaticVsNonStatic.staticVar){
           System.out.println("Of course, this condition is always true");
       }

       // This operation affects only obj but not obj1, because nonStaticVar
        // is bound to the object / instance and not the class
       obj.changeNonStaticVar();
       System.out.println("Obj1 nonStaticVar:" + obj1.nonStaticVar);
       System.out.println("Obj nonStaticVar:" + obj.nonStaticVar);
    }

}
