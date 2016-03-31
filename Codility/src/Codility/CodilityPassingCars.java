package Codility;

public class CodilityPassingCars {
	public static void main(String[] args) {
		CodilityPassingCars p = new CodilityPassingCars();
		p.init();
	}

	private void init() {

		int[] tab = { 0, 1, 0, 1, 1 };
		System.out.println(solution(tab));
	}

	public int solution(int[] tab) {
		int cpt = 0;
		int Val = 0;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == 0) {
				Val++;
			} else if (tab[i] == 1) {
				cpt = cpt + Val;
			}
			if (cpt > 1000000000)
				return -1;
		}
		return cpt;
	}
	public int solution2(int[] A) {
		long nb = 0;
		long n=0;
		for (int i = A.length-1; i >= 0; i--) {
			if (A[i] == 1) {
				n++;
			} else {
				nb+=n;
				if (nb > 1000000000) {
					nb=-1;
					break;
				}
			}
		}
		return (int) nb;
	}
}