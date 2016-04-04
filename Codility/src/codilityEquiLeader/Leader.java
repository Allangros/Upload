package codilityEquiLeader;

public class Leader {

	public static void main(String[] args) {
		Leader l = new Leader();
		l.init();
	}

	public void init() {
		int[] A = { 4, 3, 4, 4, 4, 2 };
		int cpt = 0;
		int x1 = 0;
		int x2 = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j <= i; j++) {
				x1 = (int) Math.max(x1, A[j]);
			}
			for (int j = i + 1; j < A.length; j++) {
				x2 = (int) Math.max(x2, A[j]);
			}
			if (x1 == x2) {
				cpt++;
			}
		}
		System.out.println(cpt);
	}

}
