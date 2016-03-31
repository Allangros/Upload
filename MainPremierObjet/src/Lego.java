
public class Lego {
	String nomDuLego;
	int longueur;
	int largeur;
	int couleur;

	Lego() {
		this.nomDuLego = "";
		this.longueur = 10;
		this.largeur = 5;
		this.couleur = 0;
	}

	Lego(String nomDuLego, int longueur, int largeur, int couleur) {
		this.nomDuLego = nomDuLego;
		this.longueur = longueur;
		this.largeur = largeur;
		this.couleur = couleur;
	}

	void initialiseMonLego(int longueur, int largeur, int couleur) {

		this.longueur = longueur;
		this.largeur = largeur;
		this.couleur = couleur;
	}

	// Méthode pour renommer légo avec usage d'une chaine de caractère
	void renommerMonLego(String nom) {
		this.nomDuLego = nom;
	}

	void peindreMonLego(int coul) {
		couleur = coul;
	}

	int getCouleur() {
		return this.couleur;
	}

	// meme chose que peindre
	void setCouleur(int couleur) {
		this.couleur = couleur;
	}

	int getLongueur() {
		return this.longueur;
	}

	public String getNomDuLego() {
		return nomDuLego;
	}

	public void setNomDuLego(String nomDuLego) {
		this.nomDuLego = nomDuLego;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	void setLongueur(int longueur) {
		this.longueur = longueur;
	}

}
