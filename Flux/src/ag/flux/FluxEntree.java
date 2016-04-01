package ag.flux;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class FluxEntree {
	public static void main(String[] args) throws IOException {
		FluxEntree f = new FluxEntree();
		f.init();
	}

	public void init() throws IOException {
		InputStreamReader entreeStandard = new InputStreamReader(System.in);
		LineNumberReader resLecture = new LineNumberReader(entreeStandard);
		String s = resLecture.readLine();
		System.out.println(s);
		File f = new File("./Test.txt");
		PrintWriter out = new PrintWriter(f);
		out.println("TOTO");
		out.close();
	}
	// sur la console on écrit le chemin d'un répertoire, à la deuxieme on lit
	// le type de fichier, il faut lire tout le repertoir ainsi que tous les
	// repertoirs inférieurs afin d'aller chercher les fichiers
	// qu'ilscontiennent. S'il y a un fichier alors copier toutes les lignes de
	// tous les fichiers dans le resultat.txt
}
