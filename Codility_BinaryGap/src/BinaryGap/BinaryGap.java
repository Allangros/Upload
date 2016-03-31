package BinaryGap;

public class BinaryGap {

	public static void main(String[] args) {
		BinaryGap b = new BinaryGap();
		b.init();
	}

	public void init() {

		System.out.println(solutionString(17));
		System.out.println(solutionString(9));
		System.out.println(solutionString2(529));
		System.out.println(solution2(17));
	}

	public int solutionString(int N) {

		int n = 0;
		String nombre = Integer.toBinaryString(N);
		nombre = nombre.replace("0", " ");
		nombre.trim();
		String[] ls = nombre.split("1");
		for (int i = 0; i < ls.length; i++) {
			n = Math.max(ls[i].length(), n);
		}
		return n;
	}

	public int solutionString2(int N) {

		int n = 0;
		String s = Integer.toBinaryString(N);
		int i = 0;
		for (int j = 0; j < s.length(); j++) {
			if (s.substring(i, i + 1).equals("1")) {
				break;
			}
		}
		int cpt = 0;
		for (int j = i + 1; j < s.length(); j++) {
			if (s.substring(j, j + 1).equals("0")) {
				cpt++;
			} else {
				if (cpt > n) {
					n = cpt;
				}
				cpt = 0;
			}
		}
		return n;
	}

	public int solution3(int N) {
		int n = 0;
		String s = Integer.toBinaryString(N);
		s = s.replace("0", " ").trim();
		String comp = " ";
		for (int i = 0; i < 29; i++) {
			if (!s.contains(comp)) {
				break;
			}
			comp += " ";
		}
		System.out.println(s);
		return n;
	}

	public int solution4(int N) {
		int n = 0;
		String s = Integer.toBinaryString(N);
		int deb = s.indexOf("1");
		int suivant = deb;
		while (suivant < s.length()) {
			suivant = s.indexOf("1", deb + 1);
			if (suivant < 0) {
				break;
			} else {
				n = Math.max(n, (suivant - deb - 1));
				deb = suivant;
			}
		}
		System.out.println(s);
		return n;
	}

	public int solution2(int N) {
		int n = 0;
		int cpt = 0;
		boolean demarre = false;
		while (N > 0) {
			int reste = N % 2;
			if (reste == 1) {
				if (!demarre) {
					n = 0;
					demarre = true;
				} else {
					n = Math.max(n, cpt);
				}
				cpt = 0;
			} else {
				cpt++;
			}
			N = N / 2;
		}

		return n;
	}

}
