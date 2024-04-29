package main;

import java.util.Scanner; 

public class Temperature {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the temperature");
		int temperature = sc.nextInt();
		//int temperature = 23;
		if (temperature <= 15)
			System.out.println("bis 15: Es ist kalt ... ");
		else if (temperature < 32)
			System.out.println("Unter 32: Es ist angenehm ... ");
		else
			System.out.println("Ab 32 und darueber: Es ist heiss ... ");

		sc.close(); 
	}

}
