package ag.heritage;

public abstract class Animal {

	private float taille;
	private String nom;
	private float poids;
	private int nbPattes;

	public int getNbPattes() {
		return nbPattes;
	}

	public void setNbPattes(int nbPattes) {
		this.nbPattes = nbPattes;
	}

	public Animal(String nom, float taille, float poids) {
		this.nom = nom;
		this.taille = taille;
		this.poids = poids;
	}

	public Animal() {
		this.nom = "nom";
		this.taille = taille;
		this.poids = poids;

	}

	public abstract String seDeplacer();

	public float getTaille() {
		return taille;
	}

	public void setTaille(float taille) {
		this.taille = taille;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

}
