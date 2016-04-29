package ag.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ag.metier.Formation;
import ag.metier.ListeFormation;

/**
 * Servlet implementation class ServletListeFormation
 */
@WebServlet("/ListeFormation")
public class ServletListeFormation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */

	private ListeFormation listeFormation;

	public ServletListeFormation() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		listeFormation = new ListeFormation();
		// charge la liste des formations
		BufferedReader reader = null;
		File file = new File("/Projet_Cv_Perso/WebContent/WEB-INF/xml/formation.xml");
		try {
			reader = new BufferedReader(new FileReader(file));
			String chaine = reader.readLine();
			while (chaine != null) {
				if (chaine.contains("<Formation")) {
					String date = extraitAtt(chaine, "dateFormation='");
					String lieu = extraitAtt(chaine, "lieuFormation='");
					String domaine = extraitAtt(chaine, "domaineFormation='");
					Formation formation = new Formation(date, lieu, domaine);
					listeFormation.add(formation);
				} else if (chaine.contains("</ListeFormation")) {
					for (Formation formation : listeFormation) {
						System.out.println(formation.toString());
					}
				}
				chaine = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private String extraitAtt(String line, String ch) {
		String res = "";
		String newLine = line.replace("\"", "'");
		int deb = newLine.indexOf((ch));
		int fin = newLine.indexOf("'", deb + ch.length());
		res = newLine.substring(deb + ch.length(), fin);
		return res;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// récupération des paramètres d'utilisateurs
		// contrôler les paramètres utilisateurs
		// créer un flux de sortie
		// charger la page html à afficher
		// envoyer cette page dans le flux de sortie.
		// PrintWriter out1 = response.getWriter();
		// out1.println("j'affiche quelque chose");

		//listeFormation = new ListeFormation();

		PrintWriter out = response.getWriter();
		File file = new File("../Workspace/Projet_Cv_Perso/WebContent/WEB-INF/page/pageListeFormation.html");
		System.out.println(file.exists());
		BufferedReader reader = null;
		String line = null;

		
		
//		try {
//			reader = new BufferedReader(new FileReader(file));
//			line = reader.readLine();
//			while (line != null) {
//				if (line.contains("%%name%%")) {
//					String date = extraitAttHtml(line, "%%date%%");
//					String lieu = extraitAttHtml(line, "%%lieu%%");
//					String domaine = extraitAttHtml(line, "%%domaine%%");
//				}
//				line = reader.readLine();
//				// out1 = response.getWriter();
//				// out1.println(line);
//			}
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				reader.close();
//				// out1.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
	}
	private void affListeFormation(PrintWriter out){
		for (Formation formation : listeFormation) {
			out.println("<tr>");
			out.println("<td style=\"width: 5%\">sel</>");
			out.println("<tr>");
			out.println("<tr>");
			out.println("<tr>");
		}
	}

	private String extraitAttHtml(String line, String ch) {
		String res = "";
		String newLine = line.replace("\"", "%");
		int deb = newLine.indexOf((ch));
		int fin = newLine.indexOf("%", deb + ch.length());
		res = newLine.substring(deb + ch.length(), fin);
		return res;
	}

}
