public class Sieve {
  public static void main(String[] args) {

		final int MAX = 15;
		final boolean[] sieve = new boolean[MAX + 1];

		int numberOfPrimes = 0;

		for (int i = 2; i < sieve.length; i = i + 1) {
			if ( !sieve[i] ) {
				numberOfPrimes = numberOfPrimes + 1;
				// mark all subsequent multiples of i as not-prime
				// since they are divisible by i.
				for (int j = i + i; j < sieve.length; j = j + i)
					sieve[j] = true;
			}
		}

		final int[] primeValues = new int[numberOfPrimes];
		int j = 0;
		for (int i = 2; i < sieve.length; i = i + 1) {
			if ( !sieve[i] ) {
				primeValues[j] = i;
				j = j + 1;
			}
		}

		Check.expect(primeValues, new int[] { 2, 3, 5, 7, 11, 13 });

		System.out.println(primeValues.length + " Primzahlen gefunden!");
		for (int i = 0; i < primeValues.length; i++) {
			System.out.print((i > 0 ? ", " : "") + primeValues[i]);
		}
		System.out.println("");

		bruteforce();
	}

	public static void bruteforce() {
		final int MAX = 15;
		for (int k = 1; k < MAX; k++) {
			// search divisor j
			int j = 2;
			for (; j < k; j++) {
				if ( (k % j) == 0 )
					// we found a divisor!
					break;
			}
			// no divisor found
			if (j >= k)
				System.out.println(k);
		}
	}
}
