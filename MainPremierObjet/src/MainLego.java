
public class MainLego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lego monPremierLego = null;
		monPremierLego = new Lego("mon Premier Lego", 12, 7, 3);
		monPremierLego.renommerMonLego("Mon premier lego");
		Lego monSecondLego = new Lego("mon second lego", 15, 3, 5);
		monSecondLego.renommerMonLego("Mon second lego");
		// Les deux legos ont les mêmes propriétés à cet instant mais ils sont
		// différents
		// jumeaux mais différents
		monPremierLego.largeur = 5;
		int coul = 2;
		monSecondLego.couleur = coul;
		monSecondLego.longueur = monPremierLego.largeur;
		// Appelle de la méthode Initialise mon lego et autres
		int long1 = 12;
		int lar1 = 5;
		int cou1 = 3;
		monPremierLego.initialiseMonLego(long1, lar1, cou1);
		monSecondLego.initialiseMonLego(13, 24, 3);
		monSecondLego.peindreMonLego(7);
		System.out.println("couleur 1er lego " + monPremierLego.getCouleur());
		System.out.println("couleur 2ème lego " + monSecondLego.getCouleur());

		System.out.println("longueur 1er lego " + monPremierLego.longueur);
		System.out.println("longueur 2ème lego " + monSecondLego.longueur);
		System.out.println("largeur 1 lego " + monPremierLego.largeur);
		System.out.println("largeur 2 lego " + monSecondLego.largeur);
	}

}
