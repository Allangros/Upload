package ag.metier;

public class Tour {

	private String nom;
	private Lego[] maTour;
	private Lego legoType;

	public Tour() {

	}

	public Tour(String nom, Lego legoType) {
		this.nom = nom;
		this.legoType = legoType;
		this.maTour = new Lego[1000];
		for (int i = 0; i < maTour.length; i++) {
			// Lego leLego= new
			// Lego(legoType.getHauteur(),legoType.getNbPicotLong(),legoType.getNbPicotLarg(),legoType.getCouleur()){
			Lego leLego = new Lego(legoType);
			maTour[i] = leLego;
		}
	}
	

public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Lego[] getMaTour() {
		return maTour;
	}

	public void setMaTour(Lego[] maTour) {
		this.maTour = maTour;
	}

}
