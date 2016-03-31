package ExoForme;

public class Tableau {
	private Form2D[] tab;

	public Tableau() {
		this.tab = null;
	}

	public Tableau(int nb) {
		this.tab = new Form2D[nb];
	}

	public Form2D[] getTab() {
		return tab;
	}

	public void setTab(Form2D[] tab) {
		this.tab = tab;
	}

	public void ajoutAuBout(Form2D forme) {
		Form2D[] titi = new Form2D[tab.length + 1];

		for (int i = 0; i < tab.length; i++) {
			titi[i] = tab[i];
		}
		titi[tab.length] = forme;
		tab = titi;
	}

	public void AffichageTab() {
		for (int i = 0; i < tab.length; i++) {
			System.out.println(("case n° " + i + " " + tab[i] + ", "));

		}
		System.out.println(" ");
	}

	public void ajoutAuMilieu(int nb, Form2D forme) {

		Form2D[] newTab = new Form2D[tab.length + 1];
		if (nb > 0 && nb < tab.length && tab != null && forme != null && forme instanceof Form2D) {
			for (int i = 0; i < nb; i++) {
				newTab[i] = tab[i];
			}
			newTab[nb] = forme;
			for (int i = nb; i < newTab.length - 1; i++) {
				newTab[i + 1] = tab[i];
			}
			tab = newTab;

		} else {
			tab = null;

		}
	}
	public void suppAuBout() {
		Form2D[] pTab = new Form2D[31];
		for (int i = 0; i < pTab.length; i++) {
			pTab[i] = tab[i];
		}
		tab=pTab;
	}
	public void suppAuMilieu( int nb) {

		Form2D[] mTab = new Form2D[30];
		for (int i = 0; i < nb; i++) {
			mTab[i] = tab[i];
		}

		for (int i = nb; i < mTab.length; i++) {
			mTab[i] = tab[i + 1];
		}
		tab=mTab;

	}
}
