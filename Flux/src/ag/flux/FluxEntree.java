package ag.flux;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class FluxEntree {
	public static void main(String[] args) {
		FluxEntree f = new FluxEntree();
		f.init();
	}

	public void init() {
		InputStreamReader entreeStandard = new InputStreamReader(System.in);
		LineNumberReader resLecture = new LineNumberReader(entreeStandard);
		String chemins = null;
		PrintWriter out = null;
		// System.out.println(s);
		try {
			chemins = resLecture.readLine();

			File reper = new File(chemins);
			File resultat = new File("./Resultat.txt");
			out = new PrintWriter(resultat);
			if (chemins.startsWith(".")) {
				System.out.println("c'un chemin relatif");
			} else {
				System.out.println("c'est une chemin absolu");
			}

			if (reper.exists()) {
				if (reper.isDirectory()) {
					System.out.println(reper.getAbsolutePath());
					System.out.println("C'est un rep je peux commencer la recherche");
					String suffixe = resLecture.readLine();
					//System.out.println(suffixe);
					rechercheFichier(chemins, suffixe, out);
				} else {
					System.out.println("C'est un file je pex pas commencer le programme");
				}
			} else {
				System.out.println("le dossier/ficier n'existe pas, je peux pas commencerdonn");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		out.close();

	}

	private void rechercheFichier(String chemins, String suffixe, PrintWriter out) {
		File file = new File(chemins);
		File[] tabFichier = file.listFiles();
		for (File file2 : tabFichier) {
			if (file2.isDirectory()) {
				rechercheFichier(file2.getAbsolutePath(), suffixe, out);
			} else {
				if (file2.getName().toLowerCase().endsWith(suffixe.toLowerCase())) {
					FileReader reader = null;
					BufferedReader buf = null;
					try {
						reader = new FileReader(file2);
						buf = new BufferedReader(reader);
						String chaine = buf.readLine();
						while (chaine != null) {
							remplirResultat(chaine, out);
							chaine = buf.readLine();
						}

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							reader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					out.flush();// Permet de transmettre les données au disque
				}
			}
		}
	}

	private void remplirResultat(String chaine, PrintWriter out) {
		out.println(chaine);
	}
}

// String root="./"+s;
// File f = new File("./Resultat.txt");
// PrintWriter out = new PrintWriter(f);
//
// // out.close();
//
// File rep = new File("C://DevFormation/Workspace/Flux/donnee");
// System.out.println(rep.getAbsolutePath());
// File re = new File("../Exemple/");
// File re1 = new File("./donnee");
// System.out.println(re.getAbsolutePath() + " " + re.exists());
//
// if (re1.isDirectory()) {
// System.out.println("---------------------");
// affichageRepertoir(re1, out);
// out.close();
// }
// }
//
// public void affichageRepertoir(File re, PrintWriter out) {
// File[] lf = re.listFiles();
// for (int i = 0; i < lf.length; i++) {
// if (lf[i].isFile()) {
// if (lf[i].getName().toLowerCase().contains(".txt")) {
// // lf[i].getName().toLowerCase().endsWith(".txt");
// System.out.println(lf[i].getAbsolutePath());
// // FileInputStream fi=new FileInputStream(lf[i]); que pour
// // des flux de binaires
// FileReader fr = null;
// BufferedReader bIn = null;
// try {
// fr = new FileReader(lf[i]);
// bIn = new BufferedReader(fr);
// // String[] chaineEnt =new String[(int) lf[i].length()];
// String chaine = bIn.readLine();
// while (chaine != null) {
// out.println(chaine);
// chaine = bIn.readLine();
// }
// System.out.println("-----------------------------------------");
//
// } catch (FileNotFoundException e) {
// e.printStackTrace();
// } catch (IOException e) {
// e.printStackTrace();
// } finally {
// try {
// fr.close();
// } catch (FileNotFoundException e) {
// e.printStackTrace();
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
// }
// } else {
// out.println("Fichier Suivant");
// affichageRepertoir(lf[i], out);
// }
// }
// }
// }
// sur la console on écrit le chemin d'un répertoire, à la deuxieme on lit
// le type de fichier, il faut lire tout le repertoir ainsi que tous les
// repertoirs inférieurs afin d'aller chercher les fichiers
// qu'ilscontiennent. S'il y a un fichier alors copier toutes les lignes de
// tous les fichiers dans le resultat.txt
