package ag.metierVDD;

import com.sun.corba.se.impl.orbutil.fsm.NameBase;

public class Pile {

	private int[] p;
	private int sp;

	public Pile() {
		this()
	}

	public boolean estVide() {
		return true;
	}

	public boolean estPlein() {
		return false;
	}

	public void empiler(int val) {
	}

	public int depiler() {
		return 0;
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
}