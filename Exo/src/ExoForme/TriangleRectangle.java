package ExoForme;

public class TriangleRectangle extends Triangle {

	public TriangleRectangle(float dimX, float dimY) {
		super(dimX, dimY);
	}

	public TriangleRectangle() {
	}

	@Override
	public float surface() {
		return (float) ((getDimX() * getDimY() / 2));
	}

	@Override
	public float perimetre() {
		return (float) Math.hypot(getDimX(), getDimY()) + getDimY() + getDimX();
	}

	@Override
	public boolean equals(Object obj) {
		boolean z = false;
		if (obj instanceof TriangleRectangle) {
			TriangleRectangle r = (TriangleRectangle) (obj);
			if (r.surface() == this.surface()) {
				z = true;
			}
		}
		return z;
	}

}
