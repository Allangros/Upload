package ag.autre;

public class MainAutre {

	public static void main(String[] args) {
		MainAutre m = new MainAutre();
		m.init();
	}

	public void init() {
		StationService total = new StationService(1000);
		GrandeSurface auchan = new GrandeSurface(10000);
		Voiture v1 = new Voiture(40);
		v1.prendreEssence(auchan);
		Voiture v2 = new Voiture(60);
		v2.prendreEssence(total);
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(auchan);
		System.out.println(total);
	}
}
