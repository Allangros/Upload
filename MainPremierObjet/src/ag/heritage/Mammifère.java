package ag.heritage;

public abstract class Mammifère extends Vertebre {

	public Mammifère(String nom, float taille, float poids) {
		super(nom, taille, poids);
	}

	public Mammifère() {
	}
	
	public boolean allaite() {
		return true;
	}
}
