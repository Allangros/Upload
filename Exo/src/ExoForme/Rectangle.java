package ExoForme;

public class Rectangle extends Polygone {

	public Rectangle(float dimX, float dimY) {
		super(dimX, dimY);
	}

	public Rectangle() {
		super();
	}

	@Override
	public float perimetre() {
		return (float) (2 * (getDimX() + getDimY()));
	}

	@Override
	public float surface() {
		return (float) (getDimX() * getDimY());
	}

	@Override
	public boolean equals(Object obj) {
	//z&=....
		boolean z = false;
		if (obj instanceof Rectangle) {
			Rectangle r = (Rectangle) (obj);
			if (r.surface() == this.surface()) {
				z = true;
			}
		}

		return z;
	}

}
