package ag.heritage;

public class Paresseux extends Vertebre {

	private float vit;

	public Paresseux() {
		super("Ai", 1f, 10f);
		vit = 0.1f;
	}

	public Paresseux(String nom, float taille, float poids) {
		super(nom, taille, poids);
		vit = 0.1f;
	}

	public float getVit() {
		return vit;
	}

	public void setVit(float vit) {
		this.vit = vit;
	}

	@Override
	public String seDeplacer() {
		return "ramper";
	}

}
