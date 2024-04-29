package main;

public class For {

	public static void main(String[] args) {
		int n = 10;
		
		//for (int i = 0; i < n; i++) {
		for (int i = 0; i < n; ++i) {
			System.out.println("loop " + i);
		}
		
		int m = 4;
		
		// Nexted loop
		
		int counter = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				System.out.println("i = " + i + " j = " + j);
				++counter;
			}
		}
		System.out.println("Gesamtzahl Durchlaeufe: " + counter);
		
	}

}