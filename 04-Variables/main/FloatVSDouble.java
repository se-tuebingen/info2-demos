package main; 

class FloatVSDouble {
	/**
	 * Das Programm zeigt Genauigkeitsprobleme beim Rechnen mit double und double 
	 * Autor: Hendrik Lensch **/
	 
	public static void main(String[] args) {
	
		float 	a = 300.1f,  // Hilfsvariablen 
				b = 400.1f, 
				c = 200.1f, 
				d = 600.1f, 
				e = 10.f;
				
		float y1, y2; 
		
		y1 = b * (a * b + e - c * d) * d;
		System.out.println(y1);   // liefert Ausgabe: 1875.7812f
		y2 = b * a * b * d + b * e * d - b * c * d * d;
		System.out.println(y2);   // liefert Ausgabe: 0f	
		
	} // end main
} // end class FloatVSDouble