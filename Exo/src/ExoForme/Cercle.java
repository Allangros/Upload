package ExoForme;

public class Cercle extends Disque {

	public Cercle() {
		super();
	}

	public Cercle(float rayon) {
		super(rayon);
	}

	@Override
	public float perimetre() {
		return (float) (2 * Math.PI * getRayon());
	}

	@Override
	public float surface() {
		return (float) (Math.pow(getRayon(), 2) * Math.PI);

	}

	@Override
	public String toString() {
		return super.toString() + " je suis un cercle ";
	}

	@Override
	public boolean equals(Object obj) {
		boolean z = false;
		if (obj instanceof Cercle) {
			Cercle r = (Cercle) (obj);
			if (r.surface() == this.surface()) {
				z = true;
			}
		}
		return z;
	}

}
