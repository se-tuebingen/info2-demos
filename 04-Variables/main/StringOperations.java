package main;
/**
 * Shows a few String operations
 *
 * @author Gerard Pons-Moll
 */
public class StringOperations {
    public static void main(String[] args) {
        String s1 = "first string";
        String s2 = "first string";
        String s3 = "";
        String s4 = new String("first string");

        System.out.println("Concatenation of strings");
        s3 = s1 + s2;
        System.out.println(s3);

        // use .equals() to compare strings, and any object in general
        System.out.println("Are s1 s4 equal with ==");
        System.out.println((s1==s4));
        System.out.println("Are s1 s4 equal with .equals()");
        boolean isEqual = s1.equals(s2);
        System.out.println(isEqual);

        // Find characters, substrings and replace
        System.out.println("Char at position 2");
        System.out.println(s1.charAt(2));
        s1 = "file.txt";

        // Check if file is a .txt file
        System.out.println("Is file ending with .txt");
        System.out.println(s1.endsWith(".txt"));
        System.out.println(s1.substring(2,4));

        s1.replace("f","F");

        // Get the file extension of a file
        System.out.println("Obtain file extension of a file");
        String fileExtension = s1.substring(s1.indexOf("."),s1.length());
        System.out.println(fileExtension);
        //
    }
}