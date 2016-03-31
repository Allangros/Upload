package ag.heritage;

public class MainAnimal {

	public static void main(String[] args) {
		MainAnimal mainAnimal = new MainAnimal();
		mainAnimal.init();
	}

	public void init() {
		Tigre Tigre1 = new Tigre("animal inconnu", 0.7f, 35f);
		Tigre tigre = new Tigre();
		tigre.setNom("Tigrou");
		System.out.println(tigre.getNbPattes());
		Paresseux Ai1 = new Paresseux();
		Ai1.setNom("Scoubidou");
		System.out.println(Ai1.seDeplacer());

		Animal tigre2 = new Tigre();
		System.out.println(tigre2.seDeplacer());
	}
}
