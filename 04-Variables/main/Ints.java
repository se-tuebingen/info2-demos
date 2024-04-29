package main;

public class Ints {

	public static void main(String[] args) {

		byte b = 0;
		// Increments in bit by bit
		// Show the modular nature of the 2-complement representation. At 127 (2^{n-1)) turns to the most negative
		//  and increases until 0 and starts again
		for (int i = 0; i < 512; i++) {
			System.out.println(i + ": " + b);
			b++;
		}
	}
}