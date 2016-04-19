package Codility;

import java.util.ArrayList;

public class FibFrog {

	public static void main(String[] args) {
		FibFrog f = new FibFrog();
		f.init();
	}

	public int init() {
		int[] A = { 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0 };
		int N = A.length;
		int res = 0;
		ArrayList<Integer> fib = getFibo(N);
		ArrayList<Integer> pos0 = new ArrayList<Integer>();
		ArrayList<Integer> pos1 = null;
		while (pos0.size() > 0) {
			pos1 = rechPosPossible(fib, A, pos0);
			pos0.add(-1);
			if (pos1.get(pos1.size() - 1) == A.length) {
				// Arrivée
			} else {
				pos0.clear();
				pos0.addAll(pos1);
				pos1.clear();
			}
		}
		return res;
	}

	public ArrayList<Integer> rechPosPossible(ArrayList<Integer> fib, int[] A, ArrayList<Integer> pos0) {
		int p = -1;
		ArrayList<Integer> positionTrouvee = new ArrayList<Integer>();
		sortie: for (Integer posDebut : pos0) {
			for (Integer nbFibonacci : fib) {
				int saut = posDebut + nbFibonacci;
				if (saut < A.length) {
					if (A[saut] == 1) {
						positionTrouvee.add(saut);
					}
				} else {
					if (saut == A.length) {
						positionTrouvee.add(saut);
						break sortie;
					} else {
						break;
					}
				}
			}
		}
		for (int i = 0; i < fib.size(); i++) {
			int v = p + fib.get(i);
			if (A[v] == 1) {
				pos.add(v);
			}
		}
		return pos;
	}

	public ArrayList<Integer> getFibo(int N) {
		ArrayList<Integer> fib = new ArrayList<Integer>();
		fib.add(1);
		fib.add(2);
		int CPT = 1;
		while (fib.get(CPT) <= N) {
			fib.add(fib.get(CPT) + fib.get(CPT - 1));
			CPT++;
		}
		System.out.println(fib.toString());
		return fib;
	}
}
