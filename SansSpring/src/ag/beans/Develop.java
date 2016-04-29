package ag.beans;

public class Develop {
	private String nom;
	private int anneesExp;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAnneesExp() {
		return anneesExp;
	}

	public void setAnneesExp(int anneesExp) {
		this.anneesExp = anneesExp;
	}

	public Develop(String nom, int anneesExp) {
		this.nom = nom;
		this.anneesExp = anneesExp;
	}

}
