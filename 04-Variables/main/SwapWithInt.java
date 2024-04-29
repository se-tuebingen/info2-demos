package main;
// Code to swap ints without an additional temp variable. Just to answer question in class.
// DO NOT DO THIS IN PRACTICE!! Bad readabilty and unnecesssarily complicated,
public class SwapWithInt {

	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		System.out.println( "before " + a + ", " + b);
		
		// swap
		a = a + b; 
		b = b - a; 
		a = a + b; 
		b = -b; 
		
		System.out.println( "after " + a + ", " + b);
	}

}
