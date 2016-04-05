package ag.metier.produit;

import java.io.Serializable;

public abstract class Produit implements Serializable, Comparable<Produit> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int CPT = 0; // Le compteur doit etre dans produit car il sera
	// la quelque soit le produit.

	private int id;

	private float prixUnitaire;
	private String nom;

	public Produit() {
		id = Produit.CPT;
		CPT++;
	}

	public Produit(String nom, float prixUnitaire) {
		id = Produit.CPT;
		this.nom = nom;
		this.prixUnitaire = prixUnitaire;
		CPT++;
	}

	public abstract float getPrix();

	public static int getCPT() {
		return CPT;
	}

	public static void setCPT(int cPT) {
		CPT = cPT;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		if (prixUnitaire > 0f) {
			this.prixUnitaire = prixUnitaire;
		} else if (prixUnitaire <= 0f) {
			System.out.println("Pas Bon");
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return getNom() + " : " + getPrix() + "$";
	}

	public abstract boolean rajoute(Produit e);

	/*
	 * @Override public int compareTo(Produit o) { int retour = 0; if (o
	 * instanceof Consommable) { if (this instanceof Consommable) { retour =
	 * this.getNom().compareTo(o.getNom()); } else if (this instanceof
	 * Alimentaire) { retour = 1; } } else if (o instanceof Alimentaire) { if
	 * (this instanceof Consommable) { retour = 1; } else if (this instanceof
	 * Alimentaire) { retour = this.getNom().compareTo(o.getNom()); }
	 * 
	 * } return retour; }
	 */
}
