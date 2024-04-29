package main; 

import java.util.Scanner; 

class TestNumbersArithmetic {
	/* 
	 * Es werden numerische Berechnungen durchgef�hrt und die auch die definierten 
	 * Konstanten INFINITY und NaN (not-a-number) ueberpruefen
	 * Es werden vorgestellt: 
	 * - Division bei float
	 * - Vergleiche mit Konstanten POSITIVE_INFINITY und NaN
	 * Autor: hn, Aug.2010)
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		float fvar1, fvar2,  // Eingabevariablen fuer Divisionsrechnung
		      fresult;       // Ergebnis Division


		/* -- Eingabe ... */
		System.out.println("Wert_1: ");
		fvar1 = sc.nextFloat();
		System.out.println("Wert_2: ");
		fvar2 = sc.nextFloat();
		
		sc.close(); 
		
		fresult = fvar1 / fvar2;
		
		/* -- Ausgabe ... */
		System.out.println("Resultat = " + fresult);
		if (fresult == Float.POSITIVE_INFINITY) 
			System.out.println("Infinity:: Division durch Null = " + 
			                   Float.POSITIVE_INFINITY);
		else if (fresult == Float.NaN) 
			System.out.println("NaN:: Division durch Null = " + 
			                   Float.NaN);
		else
			System.out.println("Wert_1 / Wert_2 = " + fresult + 
			                   " ( != " + Float.NaN + " )");
	} // end main
} // end class TestNumbersArithmetic