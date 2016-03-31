
public class CalculParking {

	private Voiture[] tab;
	private Voiture[][] tab2;

	public CalculParking() {
		this.tab = null;
	}

	public CalculParking(int nb) {
		this.tab = new Voiture[nb];
	}

	public CalculParking(int etage, int places) {
		this.tab2 = new Voiture[etage][places];
	}

	public void CreationTab() {
		for (int i = 0; i < tab.length; i++) {
			float z = (float) (10 * Math.random());
			Voiture v1 = null;
			if (z > 0 && z <= 1.5) {
				v1 = new Moto(z);
			} else if (z > 1.5 && z <= 4) {
				v1 = new Citadine(z);
			} else if (z > 4 && z <= 6) {
				v1 = new Monospace(z);
			} else if (z > 6 && z <= 10) {
				v1 = new Limousine(z);
			} else if (z < 0 || z > 10) {
				v1 = null;
			}
			tab[i] = v1;
		}
	}

	public void AffichageTab() {
		for (int i = 0; i < tab.length; i++) {
			System.out.println(("case n° " + i + " " + tab[i] + ", "));

		}
		System.out.println(" ");
	}

	public void TriageTab() {
		int etage = -1;
		float pas = 0.5f;
		float valMini = 1.5f;
		float valMax = 10f;
		for (int i = 0; i < tab.length; i++) {
			Voiture voit = tab[i];
			float lg = voit.getLongueur();
			if (lg < valMini) {
				System.out.println("Véhicule non pris en charge");
			} else if (lg > valMax) {
				System.out.println("go rdc");
			} else {
				for (float j = valMini; j < valMax + pas; j += pas) {
					etage = (int) (j / pas - 2);
					if (lg >= j && lg < j + pas) {
						System.out.println("go l'etage " + etage);
						break;
					}
				}

			}
		}
	}
}
