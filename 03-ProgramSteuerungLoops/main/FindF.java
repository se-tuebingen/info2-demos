package main;

public class FindF {
	public static void main(String[] args) {

		String s = "Finished files are the result of years of scientific study combined with the experience of years!";

		int countF = 0;

		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) == 'F') || (s.charAt(i) == 'f'))
				countF++;
		}
		System.out.println("Found " + countF + " Fs.");
	}

}
