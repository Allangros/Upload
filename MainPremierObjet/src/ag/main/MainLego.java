package ag.main;

import ag.metier.Lego;

public class MainLego {
	public static void main(String[] args) {
		MainLego mainLego = new MainLego();
		mainLego.init();
	}

	private void init() {
		// int nbPicotLarg;
		// int nbPicotLong;
		// Lego Lego1 = null;
		// Lego1 = new Lego();
		// System.out.println(Lego1.setCouleur);
		// System.out.println(Lego1.setLargeur);
		// System.out.println(Lego1.setHauteur);
		Lego Lego2 = null;
		Lego2 = new Lego("vert", 0.8f, 4, 2);
		// System.out.println(Lego2.getCouleur());
		// Lego2.calculDimension(Lego2.nbPicotLong);
		// Lego2.longueur = Lego2.Dimension;
		// Autre méthode pour assigner la valeur du calcul à la longueur :
		// Lego2.setLongueur(Lego2.Dimension);
		// Lego2.calculDimension(Lego2.nbPicotLarg);
		// Lego2.largeur = Lego2.Dimension;
		System.out.println("La longueur suivant le nombre de picot es de : " + Lego2.getLongueur());
		System.out.println("la largeur suivant le nmbre de picot est de : " + Lego2.getLargeur());
		// System.out.println(Lego2.calculNbPicot(Lego2.largeur));
		// System.out.println(Lego2.calculNbPicot(Lego2.longueur));

		Lego[] tour = new Lego[100];

		for (int i = 0; i < tour.length; i++) {
			// Lego monLego = new Lego("blanc", 0.8f, 4, 2);
			// tour[i] = monLego;
			tour[i] = new Lego("blanc", 0.8f, 4, 2);
		}
		String tabcouleur[] = { "blanc", "rouge", "vert", "bleu", "jaune", "noir" };
		int[] cptcouleur = new int[tabcouleur.length];
		for (int j = 0; j < tour.length; j++) {
			Lego Lego = tour[j];
			int indice = (int) (Math.random() * tabcouleur.length);
			String couleurAleatoire = tabcouleur[indice];
			Lego.setCouleur(couleurAleatoire);

			int cpt = cptcouleur[indice];
			cpt++;
			cptcouleur[indice] = cpt;

		}
		int cptmax = 0;
		for (int k = 0; k < cptcouleur.length; k++) {
			System.out.println(cptcouleur[k]);
			if (cptmax < cptcouleur[k]) {
				cptmax = cptcouleur[k];
			}

		}
		System.out.println("cptmax = " + cptmax);

		for (int i = 0; i < cptcouleur.length; i++) {

		}
		Lego[][] tourcouleur = new Lego[tabcouleur.length][cptmax];
		for (int i = 0; i < tour.length; i++) {
			Lego Lego = tour[i];
			String couleur = Lego.getCouleur();
			int indiceCouleur = -1;
			for (int j = 0; j < tabcouleur.length; j++) {
				String couleurDuTableau = tabcouleur[j];
				if (couleur.equals(couleurDuTableau)) {
					indiceCouleur = j;
					break;
				}
			}
			for (int j = 0; j < tourcouleur[0].length; j++) {
				Lego Lego3 = tourcouleur[indiceCouleur][j];
				if (Lego3 == null) {
					tourcouleur[indiceCouleur][j] = Lego;
					break;
				}
			}
		}
		// Afficher le résultats. Entendu for for et print sans ln. Avec des
		// virgules et des break si nécéssaire chercher une
		// solution,

		for (int i = 0; i < tourcouleur.length; i++) {
			for (int j = 0; j < tourcouleur[0].length; j++) {
				Lego Lego = tourcouleur[i][j];
				if (Lego != null) {
					System.out.print(Lego.getCouleur().substring(0, 1));
				} else {
					break;
				}
			}
			System.out.println("");
		}
	}
}
