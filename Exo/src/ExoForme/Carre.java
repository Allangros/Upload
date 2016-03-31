package ExoForme;

public class Carre extends Rectangle {

	public Carre() {
		super();
	}

	public Carre(float dimX, float dimY) {
		super(dimX, dimY);
	}

	@Override
	public float perimetre() {
		return (float) (4 * getDimX());
	}

	@Override
	public float surface() {
		return (float) (getDimX() * getDimX());
	}

	@Override
	public boolean equals(Object obj) {
		boolean z = false;
		if (obj instanceof Carre) {
			Carre r = (Carre) (obj);
			if (r.surface() == this.surface()) {
				z = true;
			}
		}
		return z;
	}

}
