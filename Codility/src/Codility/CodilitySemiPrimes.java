package Codility;

import java.util.ArrayList;

public class CodilitySemiPrimes {

	public static void main(String[] args) {
		CodilitySemiPrimes csm = new CodilitySemiPrimes();
		csm.init();
	}

	public void init() {
		int N = 26;
		int[] P = { 1, 4, 16 };
		int[] Q = { 26, 10, 20 };
		int[] res = new int[P.length];

		ArrayList<Integer> primes = new ArrayList<Integer>();

		for (int j = 1; j < N; j++) {
			boolean pri = true;
			for (int i = 2; i < j; i++) {
				if (j % i == 0) {
					pri = false;
					break;
				}
			}
			if (pri) {
				primes.add(j);
			}
		}
		//System.out.println(primes);
		//System.out.println(primes.size());

		ArrayList<Integer> semiPrimes = new ArrayList<Integer>();
		for (int i = 1; i < primes.size(); i++) {
			for (int j = 1; j < primes.size(); j++) {
				int G = primes.get(i) * primes.get(j);
				if (G > N) {

				} else if (semiPrimes.contains(G)) {

				} else {
					semiPrimes.add(G);
				}
			}
		}
		//System.out.println(semiPrimes);
		for (int i = 0; i < P.length; i++) {
			ArrayList<Integer> semiPrimes2 = new ArrayList<Integer>();
			int val1 = P[i];
			int val2 = Q[i];
			for (int j = 0; j < semiPrimes.size(); j++) {
					int b=(int)semiPrimes.get(j);

				if (b >= val1 && b <= val2) {
				semiPrimes2.add(semiPrimes.get(j));
				}

			}
			res[i] = semiPrimes2.size();
			System.out.println(semiPrimes2);
		}
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
