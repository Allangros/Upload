package ag.heritage;

public class Perroquet extends Vertebre {

	private int nbPattes;

	public Perroquet() {
		super();
	}

	public Perroquet(String nom, float taille, float poids) {
		super(nom, taille, poids);
		setNbPattes(2);
	}

	@Override
	public String seDeplacer() {
		return "voler";
	}
}
