package ExoForme;

public class DemiCercle extends Disque {

	public DemiCercle() {
	}

	@Override
	public float perimetre() {
		return (float) ((2 * Math.PI * getRayon()) + 2 * getRayon()) / 2;
	}

	@Override
	public float surface() {
		return (float) (((float) Math.pow(getRayon(), 2) * Math.PI) / 2);
	}



}
