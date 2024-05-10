package main;

/**
 *
 * Illustrates pass by value vs pass by reference
 *
 *     @Author: Gerard Pons-Moll modified from Hendrik Lensch
 */

public class PassAndReturn {
	
	static int numberOfSwaps = 0;

	public static void swap(int x, int y) {
		System.out.println("Inside method. x: " + x + " y: " + y);
		int tmp = x;
		x = y;
		y = tmp;
		System.out.println("Inside method. x: " + x + " y: " + y);
		numberOfSwaps++;
	}

	public static void swap(int[] arr) {
		System.out.println("Inside method. x: " + arr[0] + " y: " + arr[1]);
		int tmp = arr[0];
		arr[0] = arr[1];
		arr[1] = tmp;
		System.out.println("Inside method. x: " + arr[0] + " y: " + arr[1]);
	}

	public static int min( int[] arr) {
		int minV = arr[0]; 
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < minV) {
				minV = arr[i]; 		
			}
		}
		return minV; 
	}

	public static int myF( int x) {
		return x*x; 
	}

	public static void main(String[] args) {
		int a = 3;
		int b = 5;
        // Swap simple variable types (ints) Will the swap take effect outside swap(,)?
		System.out.println("Outside method: " + a + " " + b);
		swap(a,b);
		System.out.println("Outside method after swap: " + a + " " + b);

		// Swap arrays. Will the swap take effect outside swap(,)
		System.out.println("Example with Arrays");
		int[] arr = {3,5};
		System.out.println(arr[0] + " " + arr[1]); 
		swap(arr);
		System.out.println("Outside method after swap: " + arr[0] + " " + arr[1]);
		// And if I call swap(arr[0],arr[1])?

		System.out.println("swap was called " + numberOfSwaps + "times");
		
		// Find the minimum value
		int[] field = {-3, 2, 6, -6, 2, 6};
		System.out.println( "min " + min(field));

		// Double call of function. Debug to see enters.
		// We have seen step over and step in (check debugger)
		a = myF(3);
		b = myF(myF(5));
		System.out.println(a + " " + b);
	}
			

}
