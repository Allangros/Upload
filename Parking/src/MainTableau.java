
public class MainTableau {

	public static void main(String[] args) {
		// Tableau

		int[] tableau1 = new int[12];
		int[] tableau2;
		boolean[] tBoolean = new boolean[5];
		tableau2 = new int[12];
		int[] tableau3 = { 1, 2, 3, 4, 5, 6 };
		for (int indice = 0; indice <= 11; indice++) {
			System.out.println(tableau1[indice]);
		}
		System.out.println(tableau3.length);
		System.out.print("tableau 1 = {");
		for (int i = 0; i < tableau1.length; i++) {
			System.out.print(tableau1[i]);
			if (i < tableau1.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("};");
		for (int i = 0; i < tableau3.length; i++) {

		}
		for (int i = 0; i < tBoolean.length; i++) {
			tBoolean[i] = true;
		}
		for (int i = 0; i < tBoolean.length; i++) {
			System.out.print(tBoolean[i] + " ");
		}

		// Tableau N dimension
		int[][] image = new int[4][5];
		System.out.println("");
		System.out.println("lg image " + image.length);
		System.out.println("lg image 2eme dim " + image[0].length);
		System.out.println(image[1][2]);

		int[][] autre = { { 1, 2, 7 }, { 3, 4, 8 }, { 33, 44, 85 }, { 311, 24, 38 } };
		// System.out.println(autre.length + " " + autre[0].length);
		// System.out.println(autre[1][0]);

		// System.out.println("-------------------------");

		// for (int i = 0; i <= autre.length; i++) {
		// System.out.print(autre[0][i] + ", ");
		// }
		// System.out.println("");

		// for (int i = 0; i <= autre.length; i++) {
		// System.out.print(autre[1][i] + ", ");
		// }
		// System.out.println("");

		for (int i = 0; i < autre.length; i++) {
			int[] tab = autre[i];
			// System.out.print(tab[0]+", ");
			// System.out.print(tab[1]+", ");
			// System.out.println(tab[2]);

			for (int j = 0; j < tab.length; j++) {
				System.out.print(tab[j]);
				if (j < tab.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("");
		}

	}
}
