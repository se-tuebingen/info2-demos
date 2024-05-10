package main.subp1;

public class Test {
	
	public static int foo = 11; 
	
	public static void testFoo(int a) {
		if (a == 11) {
			System.out.println("happy"); 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println( foo ); 
		
		testFoo( foo ); 
	}

}
