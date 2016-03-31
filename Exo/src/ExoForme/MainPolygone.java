package ExoForme;

public class MainPolygone {

	Form2D[] tabForm;
	Form2D[] tab;
	Form2D[] tabForm2;

	public static void main(String[] args) {
		MainPolygone mainPolygone = new MainPolygone();
		mainPolygone.init();

	}

	public void init() {

		Tableau t = new Tableau(30);
		t.getTab()[4] = new Cercle(4);
		Cercle C = new Cercle(45);
		t.ajoutAuBout(C);
		t.AffichageTab();
		Form2D r2 = new Rectangle(12, 33);
		t.ajoutAuMilieu(9, r2);
		t.AffichageTab();
		t.suppAuBout();
		t.AffichageTab();
		t.suppAuMilieu(9);
		t.AffichageTab();
		//
		// Rectangle r = new Rectangle(12, 33);
		// Carre a = new Carre(45, 0);
		// Cercle c2 = new Cercle(34);
		// Form2D f = new Cercle(45);
		// Form2D x = new Cercle(48);

		// Form2D r3 = new Rectangle(11, 33);
		// boolean resultatF = C.equals(r);
		// // System.out.println(resultatF);
		// boolean resultatV = c2.equals(c2);
		// // System.out.println(resultatV);
		// boolean resultatEgal = c2.equals(C);
		// // System.out.println(resultatEgal);
		// boolean res1 = r2.equals(r);
		// boolean res2 = r2.equals(r3);
		// System.out.println(res1);
		// System.out.println(res2);
		// Form2D[] rechTab = { C, r, a, c2, x, r2, r3 };
		//
		// CreationTab();
		// float somme = Surface();
		// System.out.println("Somme des surfaces = " + somme);
		// // Triage();
		// tri(tabForm);
		// AffichageTab(tabForm);
		// this.getClass().getPackage();
		// // repaint();
		// // affichage();
		// Form2D forme = new Cercle(15);
		// tabForm = ajoutAuBout(tabForm, forme);
		// AffichageTab(tabForm);
		// System.out.println(tabForm.length);
		// tabForm = ajoutAuMilieu(tabForm, 5, forme);
		//
		// AffichageTab(tabForm);
		//
		// System.out.println(tabForm.length);
		//
		// tabForm = suppAuBout(tabForm);
		// AffichageTab(tabForm);
		// System.out.println(tabForm.length);
		//
		// tabForm = suppAuMilieu(tabForm, 7);
		// AffichageTab(tabForm);
		// System.out.println(tabForm.length);
		// Form2D test=new Rectangle(12f,17f);
		// contain(rechTab, c2);
	}

	// public boolean contain(Form2D[] tab, Form2D forme) {
	// boolean z = false;
	// for (int i = 0; i < tab.length; i++) {
	// z = false;
	// if (forme.equals(tab[i])) {
	// z = true;
	// }
	// System.out.println("test " + i + " " + z);
	// }
	// return z;
	// }



	

	// private boolean Recherche(Form2D[] tab) {
	// boolean z = false;
	// for (int i = 0; i < tab.length; i++) {
	// Form2D test=tab[i];
	// if (test.equals(obj)) {
	// z = true;
	// }
	//
	// System.out.println("test " + i + " " + z);
	// }
	// return z;
	// }





	private float Surface() {

		float surfacetotale = 0f;
		for (int j = 0; j < tabForm.length; j++) {
			surfacetotale = surfacetotale + tabForm[j].surface();

		}
		return surfacetotale;
	}

	float[] tabTriage = new float[30];

	// On peut faire le trie en utilisant les objets directement.
	// public void Triage() {
	// boolean ab = true;
	// float temp;
	// for (int i = 0; i < tabForm.length; i++) {
	// tabTriage[i] = tabForm[i].surface();
	// System.out.println("surface uniquement : " + tabTriage[i]);
	// }
	// while (ab) {
	// ab = false;
	// for (int i = 0; i < tabTriage.length - 1; i++) {
	// if (tabTriage[i] > tabTriage[i + 1]) {
	// temp = tabTriage[i];
	// tabTriage[i] = tabTriage[i + 1];
	// tabTriage[i + 1] = temp;
	// ab = true;
	// }
	// }
	// }
	// }

	public Form2D[] tri(Form2D[] tab) {
		boolean b = true;
		while (b) {
			b = false;
			for (int i = 0; i < tab.length - 1; i++) {
				if (tab[i].compareTo(tab[i + 1]) > 0) {
					Form2D a = tab[i];
					tab[i] = tab[i + 1];
					tab[i + 1] = a;
					b = true;
				}

				// for (int i = 0; i < tab.length; i++) {
				// System.out.print(((float) tab[i].surface()) + " , ");
				// }
				// System.out.println("");
				// }

			}
		}
		return tab;
	}

	// Avec l'object on peut donc afficher des tableaux qui ne sont pas
	// forcément des tableaux de forme 2D

}