package ag.heritage;

public abstract class Mammif�re extends Vertebre {

	public Mammif�re(String nom, float taille, float poids) {
		super(nom, taille, poids);
	}

	public Mammif�re() {
	}
	
	public boolean allaite() {
		return true;
	}
}
