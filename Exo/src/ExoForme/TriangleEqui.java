package ExoForme;

public class TriangleEqui extends Triangle {

	@Override
	public float perimetre() {
		return (float) (3*getDimX());
	}

	@Override
	public float surface() {
		return (float) ((getDimX()*getDimX())/2);
	}

}
