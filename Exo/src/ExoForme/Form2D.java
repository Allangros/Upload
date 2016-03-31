package ExoForme;

public abstract class Form2D implements Comparable<Form2D> {

	private float dimX;
	private float dimY;
	private float rayon;

	public Form2D() {
	}

	public Form2D(float rayon) {
		this.rayon = rayon;
	}

	public Form2D(float dimX, float dimY) {
		this.dimX = dimX;
		this.dimY = dimY;
	}

	public float getDimX() {
		return dimX;
	}

	public void setDimX(float dimX) {
		this.dimX = dimX;
	}

	public float getDimY() {
		return dimY;
	}

	public void setDimY(float dimY) {
		this.dimY = dimY;
	}

	public float getRayon() {
		return rayon;
	}

	public void setRayon(float rayon) {
		this.rayon = rayon;
	}

	public abstract float perimetre();

	public abstract float surface();

	@Override
	public int compareTo(Form2D autreForm) {

		float surfaceThis = surface();
		float surfaceAutre = autreForm.surface();
		int resultat = 0;
		if (surfaceThis < surfaceAutre) {
			resultat = -1;
		} else if (surfaceThis > surfaceAutre) {

			resultat = 1;
		}
		return resultat;
	}


	@Override
	public String toString() {

		return "surface " + this.getClass().getName().replace(getClass().getPackage().getName() + ".", "") + " : "
				+ surface();
	}
}
