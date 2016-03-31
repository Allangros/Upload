package ag.autres;

public class TestString {

	public static void main(String[] args) {
		TestString testString = new TestString();
		testString.init();
	}

	public void init() {
		String s1 = "Mon premier String";
		String s2 = "mon premier String";
		int lng = s1.length();
		int lng2 = "mon premier string".length();
		boolean b1 = s1.equals("mon premier String");
		// int comp2 = s1.compareTo(s2);
		int comp1 = "M".compareTo("m");
		System.out.println(comp1);
		// System.out.println(comp2);
		char[] tab = s1.toCharArray();
		System.out.println(tab);
		int majuscule = 'A';
		int minuscule = 'a';
		System.out.println(majuscule + " " + minuscule + " " + (majuscule - minuscule));
		// comparaison chaine de caractere ne pas oublier qu'un caractere peut
		// etre codé en hexadecimal et donc renvoyer une valeur numérique
		System.out.println(s1.substring(3, 7));// choix d'un ensemble de
												// caractere dans une phrase en
												// fonction de leur position
		System.out.println(s1.toUpperCase().substring(3, 7));// Mise en
																// majuscule
																// d'une partie
																// du texte
		System.out.println(s1.toUpperCase().replace("PRE", "PER").substring(3, 7));
		// remplacement plus mise en majuscule d'une,partie,du,texte
		if (s1.contains("PRE")) {
			System.out.println("perdu");
		} else {
			System.out.println("gagné");
		}
		s1 = s1.replace("String", "coucou");
		System.out.println(s1);
		// Attention lors de l'utilisation du replace !!!

		int ind1 = s1.indexOf("c");
		int ind2 = s1.lastIndexOf("c");
		System.out.println(ind1 + " " + ind2);
		// Indexof va renoyer la position du premier caractere ou chaine de
		// caractere dans s1, attention ici string à été remplacé par coucou
		// last index renvoye donc la derniere apparition du caractere
		String a = "a";
		byte[] b = s1.getBytes();
		byte[] z = a.getBytes();
		// le getBytes transforme la codificationen byte :a=65 etc, on a donc
		// une suite de chiffre et on renvoit avec length la longueur de cette
		// suite de caractere. Ideal pour compter.
		System.out.println(z.length);
		System.out.println(b.length);
		System.out.println(s1.length());
		System.out.println(s1.substring(4, 11));
		// portée des variables private pour le String.

		String s3 = "J'aime pas les sushis mais les tartares sont nos amis";
		byte[] g = s3.getBytes();

		int cpta = 0;
		int cpts = 0;
		for (int j = 0; j < g.length; j++) {
			String n = s3.substring(j, j + 1);
			// System.out.println(n);
			if (n.equals("a")) {
				cpta++;
			}
			if (n.equals("s")) {
				cpts++;
			}

		}
		System.out.println(g.length);
		System.out.println(cpta);
		System.out.println(cpts);
		// Autre solution

		String charRecherche = "o";
		int ind = s3.indexOf(charRecherche);
		int cpt = 0;
		while (ind >= 0) {
			cpt++;
			ind = s3.indexOf(charRecherche, ind + 1);
		}
		System.out.println("nombre de " + charRecherche + " = " + Integer.toString(cpt));
		// Le integer.tostring renvoit une chaine de caractere

		cpt = 0;
		char[] tabChar = s3.toCharArray();
		for (int i = 0; i < tabChar.length; i++) {
			if (tabChar[i] == 'o') {
				cpt++;
			}
		}
		System.out.println("nombre de " + charRecherche + " = " + Integer.toString(cpt));

		charRecherche = "tous";
		cpt = 0;
		while (ind >= 0) {
			cpt++;
			ind = s3.indexOf(charRecherche, ind + 1);
		}
		System.out.println("nombre de " + charRecherche + " = " + Integer.toString(cpt));

		s3 = s3.replace("sushis", "blettes");
		System.out.println(s3);
		System.out.println("\"" + s3.trim() + "\"");
		System.out.println("\"\t\t\n" + s3.trim() + "\"");
	}
}
