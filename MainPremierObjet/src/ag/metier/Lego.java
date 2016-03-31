package ag.metier;

public class Lego {

	private float hauteur;
	private int nbPicotLong;
	private int nbPicotLarg;
	private String couleur;
	private float Dimension;
	private int nb;

	Lego() {
		this.couleur = "blanc";
		// this.longueur = calculDimension(nbPicotLong);
		// this.largeur = calculDimension(nbPicotLarg);
		this.hauteur = 0.8f;
		this.nbPicotLong = 4;
		this.nbPicotLarg = 2;
		this.Dimension = 0f;

	}

	public Lego(Lego autreLego) {
		this.hauteur = autreLego.getHauteur();
		this.nbPicotLong = autreLego.getNbPicotLong();
		this.nbPicotLarg = autreLego.getNbPicotLarg();
		this.couleur = autreLego.getCouleur();
	}

	public Lego(String couleur, float hauteur, int nbPicotLong, int nbPicotLarg) {
		this.couleur = couleur;
		// this.longueur = longueur;
		// this.largeur = largeur;
		this.hauteur = hauteur;
		this.nbPicotLong = nbPicotLong;
		this.nbPicotLarg = nbPicotLarg;
		// this.longueur = nbPicotLong * 0.75f;
		// this.largeur = nbPicotLarg * 0.75f;

	}

	//
	// Lego(String couleur, float hauteur, float longueur, float largeur) {
	// this.couleur = couleur;
	// this.hauteur = hauteur;
	// nbPicotLong = calculNbPicot(longueur);
	// nbPicotLarg = calculNbPicot(largeur);
	// }

	float calculDimension(int nb) {
		return this.Dimension = nb * 0.75f;
	}

	public float getLargeur() {
		return calculDimension(nbPicotLarg);
	}

	// public int calculNbPicot(float Dim) {
	// int valeurDeRetour = -1;
	// if (Dim > 0) {
	// float n = Dim / 0.75f;
	// int nb = (int) n;
	// if (n - nb <= 0.5f) {
	// valeurDeRetour = (nb);
	// } else
	// valeurDeRetour = nb + 1;
	// }
	// return valeurDeRetour;
	// }

	// public void setLargeur(int largeur) {
	// this.largeur = largeur;
	// }
	//
	public float getLongueur() {
		return calculDimension(nbPicotLong);
	}

	//
	// public void setLongueur(float longueur) {
	// this.longueur = longueur;
	// }
	//
	public void setNbPicotLong(int nbPicotLong) {
		this.nbPicotLong = nbPicotLong;
	}

	public void setNbPicotLarg(int nbPicotLarg) {
		this.nbPicotLarg = nbPicotLarg;
	}

	public float getHauteur() {
		return hauteur;
	}

	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}

	public int getNbPicotLong() {
		return nbPicotLong;
	}

	public int getNbPicotLarg() {
		return nbPicotLarg;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

}
