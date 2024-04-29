package main;

import java.util.Scanner;

public class TestNumbers {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		byte a, b;

		a = sc.nextByte();
		b = sc.nextByte();

		// Addition executed in java as int.
		// Cast is necessary afterwards
		byte sum = (byte) (a + b);

		System.out.println(sum);

		sc.close();

	}

}
