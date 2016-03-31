package ag.main;

public class Main {

	public static void main(String[] args) throws PileException {
		Main m = new Main();
		m.init();
	}

	public void init() throws PileException {
		Pile p1 = new Pile();
		p1.empiler(12);
		p1.afficher();
		System.out.println("-------------------");
		p1.depiler();
		p1.afficher();
		boolean pvid = p1.estVide();
		System.out.println(pvid);
		for (int i = 0; i < 10; i++) {
			p1.empiler(i + 1);
		}
		p1.afficher();
		System.out.println(p1.getSp());
		System.out.println(p1.estPleine());
		try {
			for (int i = 0; i < 100; i++) {
				p1.empiler(i);
			}
		} catch (PilePleineException e) {
			System.out.println(e.getMessage());
			p1.afficher();
		}
	}

}
