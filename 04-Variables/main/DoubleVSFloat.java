package main; 

class DoubleVSFloat {
	/**
	 * Program shows precision problem computing with float und double
	 * Author: Hendrik Lensch **/
	 
	public static void main(String[] args) {
	
		double 	a = 300.1d,  // Help variables
				b = 400.1d, 
				c = 200.1d, 
				d = 600.1d, 
				e = 10.d;
				
		double y1, y2; 
		
		y1 = b * (a * b + e - c * d) * d;
		System.out.println(y1);   // liefert Ausgabe: fast 0
		y2 = b * a * b * d + b * e * d - b * c * d * d;
		System.out.println(y2);   // liefert Ausgabe: 0d
		
		
	//   float f = 3.1415927f; 
		
	} // end main
} // end class DoubleVSFloat