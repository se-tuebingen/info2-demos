package main;

import java.util.Scanner;

public class ggTE {

	public static void main(String[] args) {
		/* Program zur demonstration des ggT-Algorithmus mit while-Schleife
		 * Author: Hendrik Lensch
		 */
		Scanner sc = new Scanner(System.in);

		System.out.print("ggT"); 
		System.out.print("Gib erste Zahl ein:  ");
		int a = sc.nextInt();
		System.out.print("Gib zweite Zahl ein: ");
		int b = sc.nextInt();
		
		int z = a % b;  // Rest nach Division von a und b
		while (z != 0) {
			a = b;
			b = z;
			z = a % b;
		}
		
		System.out.println("Der ggT ist: " + b);
				
		sc.close(); 
	}

}