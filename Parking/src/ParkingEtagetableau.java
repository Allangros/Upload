
public class ParkingEtagetableau {

	Voiture[] tabVoit;

	public static void main(String[] args) {
		ParkingEtagetableau parkingEtageTableau = new ParkingEtagetableau();
		parkingEtageTableau.init();
	}

	public static final int NB_VOITURE = 50;

	public void init() {

		CalculParking parc = new CalculParking(NB_VOITURE);
		parc.CreationTab();
		parc.AffichageTab();
		CalculParking park = new CalculParking(8,200);
		parc.TriageTab();
		
		// int etage = 0;
		// float pas = 0.5f;
		// float valMini = 1.5f;
		// float valMax = 5f;
		// float[] vh = { 1.6f, 1.7f, 1.8f, 1.9f, 2.4f };
		// float lgr = 2f;
		// // int cpt1 = 0;
		// // int cpt2 = 0;
		// int[] cpt = new int[9];
		//
		// for (int k = 0; k < vh.length; k++) {
		// lgr = vh[k];
		// int etageSelectionne = -1;
		// if (lgr < valMini) {
		// etageSelectionne = -1;
		// } else {
		// if (lgr > valMax) {
		// etageSelectionne = 0;
		// } else {
		// for (float i = valMini; i < valMax + pas; i += pas) {
		// etage = (int) (i / pas - 2);
		// if (lgr >= i && lgr < i + pas) {
		// etageSelectionne = etage;
		// break;
		// }
		//
		// }
		//
		// }
		//
		// }
		// System.out.println("lgr = " + lgr + " = " + etageSelectionne);
		//
		// // if (etageSelectionne == 1) {
		// // cpt[1]++;
		//
		// // }
		// // if (etageSelectionne == 2){
		// // cpt[2]++;
		// // System.out.println(cpt[1]);
		// // }
		// for (int i = 0; i < cpt.length; i++) {
		//
		// if (etageSelectionne == i) {
		// cpt[i]++;
		// System.out.println(cpt[i]);
		// }
		// }
		// }
	}
}
