package Codility;

import java.util.ArrayList;

public class CodilityProfit {

	public static void main(String[] args) {
		CodilityProfit pro = new CodilityProfit();
		pro.init();
	}

	public void init() {
		int[] A = { 23171, 21011, 21123, 21366, 21013, 21367 };
		ArrayList intList = new ArrayList<Integer>();
		for (int intValue : A) {
			intList.add(intValue);
		}
		// ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(A));
		// Integer[] B = A.clone();
		int cpt = 0;
		int Valmax = 0;
		for (int i = 0; i < A.length - 1; i++) {
			cpt++;
			int lol = (int) intList.get(cpt)- A[i];
			Valmax = Math.max(Valmax, lol);

			// for (int j = i + 1; j < A.length; j++) {
			// Valmax = (int) Math.max(Valmax, A[j] - A[i]);
			// }
		}
		System.out.println(Valmax);
	}

}
