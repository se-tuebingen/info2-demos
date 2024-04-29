package main;

import java.util.Scanner;

public class ggT {

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
	
		while (a != b) {
			if (a < b)
				b = b - a; 
			else  
				a = a - b; 
		}
		System.out.println("Der ggT ist: " + b);
		
		sc.close(); 
	}

}
