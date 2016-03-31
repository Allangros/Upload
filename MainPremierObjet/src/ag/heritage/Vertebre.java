package ag.heritage;

public abstract class Vertebre extends Animal {

	public Vertebre(String nom, float taille, float poids) {
		super(nom, taille, poids);

	}

	public Vertebre() {
		super();
	}

	public int nbOS() {
		return 100;
	}
}
