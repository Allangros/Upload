
public class exo_etage_limo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float gogo = 4.5f;
		int etage = 1;
		for (float x1 = 1.5f; x1 < 5f; x1 = x1 + 0.5f) {
			if (gogo >= x1 && gogo < (x1 + 0.5f)) {

				System.out.println("go etage " + etage);

			}
			etage++;
		}
		if (gogo >= 5f) {
			System.out.println("go rdc");

		}

		// Autre solution
		float pas = 0.5f;
		float valMini = 1.5f;
		float valMax = 5;
		if (gogo < valMini) {
			System.out.println("Véhicule non pris en charge");
		} else if (gogo > valMax) {
			System.out.println("go rdc");
		} else {
			for (float i = valMini; i < valMax + pas; i += pas) {
				etage = (int) (i / pas - 2);
				if (gogo >= i && gogo < i + pas) {
					System.out.println("go l'etage " + etage);
					break;
				}
			}

		}

	}

}
