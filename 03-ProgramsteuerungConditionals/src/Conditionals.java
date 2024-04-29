package main;


public class Conditionals {
	
	public static void main(String[] args) {
	
		boolean a; 
		
		a = false; 
		
		int i = 3; 
		
		if ((4 < i) || (3 < 8)) {   // complex condition
			System.out.println("true block"); 
		}
		else {
			System.out.println("false block"); 
		}
		System.out.println("end"); 
	}
}