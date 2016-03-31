package ag.main;

public class Pile {
	public static int NB_MAX = 10;
	private int[] p;
	private int sp = 0;

	public Pile(int taille) {
		NB_MAX=taille;
		p = new int[taille];
		sp = -1;
	}

	public Pile() {
		this(NB_MAX);
	}

	public boolean estVide() {
		return sp == -1;

	}

	public boolean estPleine() {
		return sp == p.length - 1;
	}

	public void empiler(int val) throws PilePleineException {
		if (estPleine()) {
			throw new PilePleineException();
		}
		sp++;
		p[sp] = val;
	}

	public int depiler() throws PileVideException {
		if (estVide()) {
			throw new PileVideException();
		}
		sp--;
		return p[sp + 1];
	}

	public int[] getP() {
		return p;
	}

	public void setP(int[] p) {
		this.p = p;
	}

	public int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public void afficher() {
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}
	}
}
