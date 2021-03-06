package jul.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;// s'ajoute avec le buildpath, prendre serveur tom4
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import jul.metier.Etudiants;
import jul.metier.Formation;
import jul.metier.ListeEtudiant;
import jul.metier.ListeFormation;

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
	private ListeEtudiant listeEtudiant;


	public ServletListeFormation() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init() throws ServletException {
		listeFormation = new ListeFormation();
		chargerListeFormation();
		chargerListeEtudiant();
		// charge la liste des formations
	}

	private void chargerListeEtudiant() {
		File fLecture = new File("C:/DevFormation/Workspace/Copy of Project_Cv/WebContent/WEB-INF/xml/listeEtudiant.xml");
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(fLecture);

			Element racine = document.getDocumentElement();
			NodeList list = racine.getChildNodes();
			int nbList = list.getLength();
			for (int i = 0; i < nbList; i++) {
				if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element eFormation = (Element) list.item(i);
					NodeList lFormation = eFormation.getChildNodes();
					String id = eFormation.getAttribute("id");
					for (int j = 0; j < lFormation.getLength(); j++) {
						if (lFormation.item(j).getNodeType() == Node.ELEMENT_NODE) {
							Element eEtudiant = (Element) lFormation.item(j);
							String nom = eEtudiant.getAttribute("nom");
							String prenom = eEtudiant.getAttribute("prenom");
							String metier = eEtudiant.getAttribute("metier");
							String mail = eEtudiant.getAttribute("mail");
							String commentaire = eEtudiant.getTextContent();
							System.out.println(nom + " " + prenom + " " + mail + " " + metier + " ");
						}
					}
				}
			}

		} catch (ParserConfigurationException e) {

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void chargerListeFormation() {
		BufferedReader reader = null;
		File file = new File("C:/DevFormation/Workspace/Copy of Project_Cv/WebContent/WEB-INF/xml/formation.xml");
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
		// r�cup�ration des param�tres d'utilisateurs
		// contr�ler les param�tres utilisateurs
		// cr�er un flux de sortie
		// charger la page html � afficher
		// envoyer cette page dans le flux de sortie.
		PrintWriter out = response.getWriter();
		File file = new File(
				"C:/DevFormation/Workspace/Copy of Project_Cv/WebContent/WEB-INF/Page/pageListeFormation.html");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		while (line != null) {
			if (line.contains("%%date%%") || line.contains("%%lieu%%") || line.contains("%%domaine%%")
					|| line.contains("%%name%%") || line.contains("%%valeur%%")) {
				affListeFormation(out, line);

			} else {
				out.println(line);
			}
			line = reader.readLine();

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		File file = new File(
				"C:/DevFormation/Workspace/Copy of Project_Cv/WebContent/WEB-INF/Page/pageEtudiant.html");
		BufferedReader buf=new BufferedReader(new FileReader(file));
		String line = buf.readLine();
		while (line != null) {
			for (Etudiants etudiant : listeEtudiant) {
				
			}
		}
	}

	private void affListeFormation(PrintWriter out, String line) {
		for (int i = 0; i < listeFormation.size(); i++) {
			Formation formation = listeFormation.get(i);
			String lineAAfficher = line;
			// out.println("<tr><th style=\"width: 5%\">sel</th><th
			// style=\"width: 20%\">" + formation.getDateFormation() + "</th><th
			// style=\"width 50%\">" + formation.getLieuFormation() + "</th><th
			// style=\"width: 30%\">" + formation.getDomaineFormation() +
			// "</th></tr>");
			// out.println("<tr>");
			// out.println("<th style=\"width:5%\">sel</td>");
			// out.println("<th style=\"width:30%\">" +
			// formation.getDateFormation() + "</th>");
			// out.println("<th style=\"width:30%\">" +
			// formation.getLieuFormation() + "</th></tr>");
			// out.println("<th style=\"width:30%\">" +
			// formation.getDomaineFormation() + "</th></tr>");
			// out.println("</tr>");
			lineAAfficher = lineAAfficher.replace("%%date%%", formation.getDateFormation());
			lineAAfficher = lineAAfficher.replace("%%lieu%%", formation.getLieuFormation());
			lineAAfficher = lineAAfficher.replace("%%domaine%%", formation.getDomaineFormation());
			lineAAfficher = lineAAfficher.replace("%%valeur%%", Integer.toString(i));
			lineAAfficher = lineAAfficher.replace("%%name%%", "un chiffre");
			out.println(lineAAfficher);
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
