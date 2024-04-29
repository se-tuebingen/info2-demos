package main;

public class ComparePrecision {

	public static void main(String[] args) {

		float f = .3f;

		float accu = 0.f;
		float product = 0.f;

		int iteration = 0;

		while (Math.abs(accu - product) <= 1.f) {
			iteration++;
			accu += f;
			product = iteration * f;
		}
		
		System.out.println( " err > 1 bei Iteration " + iteration); 
		System.out.println( "accu: " + accu + " product:" + product); 

	}

}
