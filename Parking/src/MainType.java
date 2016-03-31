
public class MainType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a = 0x7F;
		byte b = 1;
		int c = a + b;
		System.out.println(c);
		int d = 5;
		int e = c + d;
		System.out.println(c + " + " + d + " = " + e);
		int f = 0x7FFFFFFF;
		f++;
		System.out.println(f);
		int g = 100;
		int h = 7;
		float patate = 2.4f;
		float j = g / h * patate;
		System.out.println(j);
		int l = g / h;
		System.out.println(l);
		float m = l * patate;
		System.out.println(m);
		float k = patate * g / h;
		System.out.println(k);
		float n = g;
		n = n / h * patate;
		System.out.println(n);

		int o = 15;
		int entiere = o / 7;
		int reste = o - entiere * 7;
		System.out.println("partie entiere " + entiere + " reste = " + reste);
		int rest = o % 7;
		System.out.println("rest = " + rest);

		double p = (100l + 12) / 5f; // le fait de mettre le 5 en float réduit
										// la précision
		System.out.println(p);

		boolean vrai = true;
		boolean faux = false;
		boolean resultat = vrai & faux;
		System.out.println(resultat);
		boolean resultat2 = vrai | faux;
		System.out.println(resultat2);
		int q = 0xF0;
		int r = 0x0F;
		int s = q | r;
		System.out.println(s);

		char t = 'é';
		System.out.println(t);
		int u = t + 1;
		System.out.println(t + " " + u);
		char v = '\u0061';
		System.out.println(v);

		if (k == j) {
			System.out.println("c'est bon");
		} else {
			System.out.println("c'est pas top");
		}

		if (5 > 4 && 7 < 12) {
			System.out.println("OK");
		}

		if (!(5l < 4d) && 7 < 12f) {
			System.out.println("OK");
		}

		double w = 100d / 3d; // le double contient beaucoup plus de décimal que
								// le float donc il est obligatoirement
								// different
		float x = 100f / 3f;
		if (w == x) {
			System.out.println("ok");
		} else {
			System.out.println("pas ok");
		}
		boolean y = w == x;
		System.out.println(y);

		float z = ((float) g) / h * patate; // force g a devenir float :
											// castage,
		// mettre des parenthese pour caste
		// toute la ligne.
		System.out.println(z);

		int toto = 82;
		switch (toto) {
		case 10:
			System.out.println("nul");
			break;
		case 50:
			toto = 72;
			System.out.println("bof " + toto);
			break;
		case 52:
			System.out.println("nice");
			break;
		default:
			// toto=84

			System.out.println("valeur de toto incorrecte, édité à " + toto);
		}

		// egalement combiné deux cases soit break:

		switch (toto) {
		case 82:
			System.out.println("je peux acheter 82 pommes a 1 euro");
		case 83:
			System.out.println("je peux acheter 83 pommes a 1 euro");
		case 84:
			System.out.println("je peux acheter 84 pommes à un euro mais pas plus !");
			break;
		default:
			System.out.println("pas assez d'argent");
		}
		int lng = 4;

		if (lng == 2) {
			System.out.println("go etage 1");
		} else if (lng == 3) {
			System.out.println("go etage 2");
		} else if (lng == 4) {
			System.out.println("go etage 3");
		} else if (lng == 5) {
			System.out.println("go etage 4");
		} else if (lng == 6) {
			System.out.println("go etage 5");
		} else if (lng == 7) {
			System.out.println("go etage 6");
		} else if (lng == 8) {
			System.out.println("go etage 7");
		}
		for (int indice = 0; indice < 8; indice++) {
			if (lng == indice) {
				int etage = indice - 1;
				System.out.println("je vais a l'étage " + etage);
			}
		}
		float gogo = 5.5f;
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
		}
	}