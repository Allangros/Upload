package ag.flux;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Flux {

	public static void main(String[] args) {
		Flux f = new Flux();
		f.init();
	}

	public void init() {
		File rep = new File("C://DevFormation/Workspace/Flux/donnee");
		System.out.println(rep.getAbsolutePath());
		File re = new File("../Exemple/");
		File re1 = new File("./donnee");
		System.out.println(re.getAbsolutePath() + " " + re.exists());
		if (re.isDirectory()) {
			System.out.println("----------------------");
			String[] ls = re.list();
			for (int i = 0; i < ls.length; i++) {
				System.out.println(ls[i]);
			}
		}
		if (re1.isDirectory()) {
			System.out.println("----------------------");
			File[] tre = re1.listFiles();
			for (int i = 0; i < tre.length; i++) {
				File test = tre[i];
				if (test.isDirectory()) {
					File[] tre2 = test.listFiles();
					for (int j = 0; j < tre2.length; j++) {
						if (tre2[j].isDirectory()) {

						} else {
							System.out.println(tre2[j].getName());
						}
					}

				} else {
					System.out.println(test.getName());
				}
			}

		}
		if (re1.isDirectory()) {
			System.out.println("---------------------");
			affichageRepertoir(re1);
		}
	}

	public void affichageRepertoir(File re) {
		File[] lf = re.listFiles();
		for (int i = 0; i < lf.length; i++) {
			if (lf[i].isFile()) {
				if (lf[i].getName().toLowerCase().contains(".txt")) {
					// lf[i].getName().toLowerCase().endsWith(".txt");
					System.out.println(lf[i].getAbsolutePath());
					// FileInputStream fi=new FileInputStream(lf[i]); que pour
					// des flux de binaires
					FileReader fr = null;
					BufferedReader bIn = null;
					try {
						fr = new FileReader(lf[i]);
						bIn = new BufferedReader(fr);
						// String[] chaineEnt =new String[(int) lf[i].length()];
						String chaine = bIn.readLine();
						while (chaine != null) {
							System.out.println(chaine);
							chaine = bIn.readLine();
						}
						System.out.println("-----------------------------------------");

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							fr.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				affichageRepertoir(lf[i]);
			}
		}
	}
}
