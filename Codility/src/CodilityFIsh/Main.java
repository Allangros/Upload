package CodilityFIsh;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.init();
	}

	public int init() {
		int vie = 0;
		int[] A = { 4, 3, 2, 1, 5 };
		int[] B = { 0, 1, 0, 0, 0 };
		ArrayList<Integer> des = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (des.size() == 0) {
				if (B[i] == 0) {
					vie++;
				} else
					des.add(A[i]);

			} else {
				if (B[i] == 1) {
					des.add(A[i]);
				} else {
					for (int j = des.size(); j <= 0; j--) {
						if (A[i] == des.get(j)) {
							des.remove(j);
						}
					}

				}
			}

		}

		return (vie + des.size());
	}

}