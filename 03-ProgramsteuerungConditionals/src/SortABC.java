//package main;

import java.util.Scanner;

public class SortABC {

	public static void main(String[] args) {
		/* read in and sort 3 integers */
		Scanner sc = new Scanner(System.in);

		int a, b, c;
		System.out.println("The program reads 3 integers and sorts them\n");
		System.out.println("Number 1: ");
		a = sc.nextInt();
		System.out.println("Number 2: ");
		b = sc.nextInt();
		System.out.println("Number 3: ");
		c = sc.nextInt();
		// sort here 
		int temp;

		// Swap if necessary a > b
		if (a > b) {
			temp = a; 
			a = b; 
			b = temp; 
		}
		// Here always a < b

		if (a>c) {
			temp = a;
			a = c; 
			c = temp; 
		}

		// Here always a < c

		if (b > c) {
			temp = b; 
			b = c;
			c = temp; 
		}

		// Here always b < c, hence a < b < c
		System.out.println("result: " + a + " < " + b + " < " + c);
		
		sc.close(); 
	}

}
