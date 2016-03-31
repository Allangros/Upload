package ExoForme;

public class TriangleIsocel extends Triangle {

	@Override 
	public float perimetre(){
		return (float) (Math.hypot(getDimX()/2,getDimY()*2)*2)+getDimY();
	}

	@Override
	public float surface() {
		return (float) (getDimX()*getDimY())/2;
	}
	
}
