package main;
// Class illustrates a few simple methods and how to document a function
public class SimpleMethods {

	static void myPrint(float a, float b) {
		System.out.println("(" + a + ", " + b + ")");
	}
	// How to document (I should be able to use without looking at code!)
	/** Returns the minimum of two numbers
	 * @param a
	 * @param b
	 * @return The minimum number
	 */
	static float min(float a, float b) {
		if (a < b)
			return a;
		else
			return b;
	}
	static float myFunction(float x) {
		return (3.f * x + 2.f);
	}

	static int min(int a, int b) {
		if (a < b)
			return a;
		else
			return b;
	}
	
	static boolean isSmaller(int a, int b) {
		return (a < b); 
	}

	public static void main(String[] args) {

		float x = -3.244f;

//		float y = 3.f * x + 2.f;
//		float z = 3.f * y + 2.f; 
//		float w = 2.f * z + 2.f; 
		float y, z, w;

		y = myFunction(x);
		z = myFunction(y);
		w = myFunction(z);

		System.out.println(x + " " + y + " " + z + " " + w);

		myPrint(x, y);

		System.out.println("min: " + min(x, y));
		
		System.out.println("min: " + min(3, 8));

	}

}
