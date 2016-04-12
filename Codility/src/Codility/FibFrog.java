package Codility;

import java.util.ArrayList;

public class FibFrog {

	public static void main(String[] args) {
		FibFrog f = new FibFrog();
		f.init();
	}

	public void init() {
		int[] A = { 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0 };
		int N = A.length;
		ArrayList<Integer> fib = getFibo(N);

		testJump(fib, A);
	}

	private void testJump(ArrayList fib, int[] A) {
		if (fib.contains(A.length)) {

		}

	}

	public ArrayList<Integer> getFibo(int N) {
		ArrayList<Integer> fib = new ArrayList<Integer>();
		fib.add(1);
		fib.add(1);
		int CPT = 1;
		while (fib.get(CPT) <= N) {
			fib.add(fib.get(CPT) + fib.get(CPT - 1));
			CPT++;
		}
		System.out.println(fib.toString());
		return fib;
	}
}
