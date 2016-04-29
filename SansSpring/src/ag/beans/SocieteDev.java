package ag.beans;

public class SocieteDev implements Deve{

	@Override
	public Develop chefDevelop(String nom, int anneesExp) {
		return new Develop(nom, anneesExp);
	}

	@Override
	public Develop develop(String nom, int anneesExp) {
		return new Develop(nom, anneesExp);
	}

	
}
