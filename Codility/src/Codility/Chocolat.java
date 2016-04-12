package Codility;

public class Chocolat {

	public static void main(String[] args) {
		Chocolat c = new Chocolat();
		c.init();
	}

	public void init() {
		int N = 10;
		int M = 4;
		int[] boite = new int[N];
		int cpt = 1;
		int p=0;
		for (int i = 0; i < boite.length; i++) {
			boite[i] = 1;
		}
		for (int i = 0; i < boite.length; i++) {
			boite[0] = 0;
			p =p+M;
			if (p > N-1) {
				p = p % N;
				if (boite[p] == 0) {
					break;
				}else {
					boite[p]=0;
					cpt++;
				}
			} else {
				if (boite[p] == 0) {
					break;

				}else{
					boite[p]=0;
					cpt++;
				}
			}
			System.out.println(cpt);
		}

	}
}
