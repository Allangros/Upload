package vdd.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import vdd.metier.Competence;
import vdd.metier.Etudiant;
import vdd.metier.Experience;
import vdd.metier.Formation;
import vdd.metier.FormationScolaire;
import vdd.metier.ListeCompetence;
import vdd.metier.ListeEtudiant;
import vdd.metier.ListeExperience;
import vdd.metier.ListeFormation;
import vdd.metier.ListeFormationScolaire;

/**
 * Servlet implementation class ServletListeFormation
 */
@WebServlet("/ServletListeFormationA")
public class ServletListeFormation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListeFormation() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

	private void chargerListeEtudiants(ListeFormation listeFormation) {
		File fXmlEtudiant = new File("../workspace/CopyofProjectCV/WebContent/WEB-INF/xml/listeEtudiant.xml");

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			final Document document = builder.parse(fXmlEtudiant);
			final Element racine = document.getDocumentElement();
			final NodeList nodeListeForm = racine.getChildNodes();
			for (int i = 0; i < nodeListeForm.getLength(); i++) {
				if (nodeListeForm.item(i).getNodeType() == Node.ELEMENT_NODE) {
					final Element fFormation = (Element) nodeListeForm.item(i);
					final NodeList nodeListeEtudiant = nodeListeForm.item(i).getChildNodes();
					int idFormation = Integer.valueOf(fFormation.getAttribute("id")).intValue();
					Formation formation = listeFormation.get(idFormation);
					for (int j = 0; j < nodeListeEtudiant.getLength(); j++) {
						if (nodeListeEtudiant.item(j).getNodeType() == Node.ELEMENT_NODE) {
							final Element eEtudiant = (Element) nodeListeEtudiant.item(j);
							String sNom = eEtudiant.getAttribute("nom");
							String sPrenom = eEtudiant.getAttribute("prenom");
							String sMail = eEtudiant.getAttribute("mail");
							String sMetier = eEtudiant.getAttribute("metier");
							String sCv = eEtudiant.getAttribute("cv");
							Etudiant etudiant = new Etudiant(sNom, sPrenom, sMail, sMetier, sCv, formation);
							formation.getListeEtudiant().add(etudiant);
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}

	private ListeFormation chargerListeFormationSQL() {
		ListeFormation listeFormation = new ListeFormation();
		Connection con = null;
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		// chargement du pilote
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String login = "Active";
			String password = "VDDMichel";
			// connection a la base de données
			String DBurl = "jdbc:mysql://www.psyeval.fr/bddCV";
			con = DriverManager.getConnection(DBurl, login, password);
			stmt = con.createStatement();
			requete = "SELECT * FROM formation";
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			while (trouve) {
				int id = set.getInt("idFormation");
				String date = set.getString("dateFormation");
				String lieu = set.getString("lieuFormation");
				String domaine = set.getString("domaineFormation");
				Formation formation = new Formation(id, date, lieu, domaine);
				chargerListeEtudiantsSQL(formation, con);
				listeFormation.add(formation);
				trouve = set.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeFormation;
	}

	private ListeEtudiant chargerListeEtudiantsSQL(Formation formation, Connection con) {
		ListeEtudiant listeEtudiant = new ListeEtudiant();
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		// chargement du pilote
		try {
			stmt = con.createStatement();
			requete = "SELECT * FROM etudiant WHERE idFormation=" + formation.getIdFormation() + ";";
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			while (trouve) {
				int id = set.getInt("id");
				String nom = set.getString("nom");
				String prenom = set.getString("prenom");
				String mail = set.getString("mail");
				String metier = set.getString("metier");
				Etudiant etudiant = new Etudiant(nom, prenom, mail, metier, formation, id);
				chargerListeCompetenceSQL(etudiant, con);
				chargerListeFormationSQL(etudiant, con);
				chargerListeExperienceSQL(etudiant, con);

				formation.getListeEtudiant().add(etudiant);
				trouve = set.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeEtudiant;

	}

	private void chargerListeExperienceSQL(Etudiant etudiant, Connection con) {
		ListeExperience listeExperience = new ListeExperience();
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		// chargement du pilote
		try {
			stmt = con.createStatement();
			requete = "SELECT * FROM experience WHERE idEtudiant=" + etudiant.getId() + ";";
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			while (trouve) {
				int id = set.getInt("id");
				String date = set.getString("dateExp");
				String entreprise = set.getString("entreprise");
				String poste = set.getString("poste");
				String description = set.getString("description");
				Experience experience = new Experience(id, date, entreprise, poste, description);
				etudiant.getListeExperience().add(experience);
				trouve = set.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private void chargerListeFormationSQL(Etudiant etudiant, Connection con) {
		ListeFormationScolaire listeFormationSco = new ListeFormationScolaire();
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		// chargement du pilote
		try {
			stmt = con.createStatement();
			requete = "SELECT * FROM formation_scolaire WHERE idEtudiant=" + etudiant.getId() + ";";
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			while (trouve) {
				int id = set.getInt("id");
				String date = set.getString("date");
				String diplome = set.getString("diplome");
				String ecole = set.getString("ecole");
				FormationScolaire formSco = new FormationScolaire(id, date, diplome, ecole);
				etudiant.getListeFormationScolaire().add(formSco);
				trouve = set.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private void chargerListeCompetenceSQL(Etudiant etudiant, Connection con) {
		ListeCompetence listeCompetence = new ListeCompetence();
		ResultSet set = null;
		Statement stmt = null;
		String requete = "";
		// chargement du pilote
		try {
			stmt = con.createStatement();
			requete = "SELECT * FROM competence WHERE idEtudiant=" + etudiant.getId() + ";";
			set = stmt.executeQuery(requete);
			boolean trouve = set.first();
			while (trouve) {
				int id = set.getInt("id");
				String type = set.getString("type");
				String detail = set.getString("detail");
				String niveau = set.getString("niveau");
				Competence competence = new Competence(etudiant, type, detail, niveau);
				etudiant.getListeCompetence().add(competence);
				trouve = set.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private ListeFormation chargerListeFormationXml() {
		ListeFormation listeFormation = new ListeFormation();
		File fXmlFormation = new File("../workspace/CopyofProjectCV/WebContent/WEB-INF/xml/listeFormation.xml");

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			final Document document = builder.parse(fXmlFormation);
			final Element racineListeFormation = document.getDocumentElement();
			final NodeList nodeListeFormation = racineListeFormation.getChildNodes();
			for (int i = 0; i < nodeListeFormation.getLength(); i++) {
				if (nodeListeFormation.item(i).getNodeType() == Node.ELEMENT_NODE) {
					final Element eFormation = (Element) nodeListeFormation.item(i);
					String sDate = eFormation.getAttribute("dateFormation");
					String sLieu = eFormation.getAttribute("lieuFormation");
					String sDomaine = eFormation.getAttribute("domaineFormation");
					Formation formation = new Formation(i, sDate, sLieu, sDomaine);
					synchronized (listeFormation) {
						listeFormation.add(formation);
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		return listeFormation;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		File file = new File("");
		System.out.println(file.getAbsolutePath());
		ListeFormation listeFormation = chargerListeFormationSQL();
		//chargerListeEtudiants(listeFormation);
		session.setAttribute("listeForm", listeFormation);
		PrintWriter out = response.getWriter();
		File fHtml = new File("C:/DevFormation/workspace/CopyofProjectCV/WebContent/WEB-INF/page/pageListeFormation.html");
		BufferedReader buf = new BufferedReader(new FileReader(fHtml));
		String line = buf.readLine();
		while (line != null) {
			if (line.contains("%%date%%") || line.contains("%%lieu%%") || line.contains("%%domaine%%")
					|| line.contains("%%name%%") || line.contains("%%valeur%%")) {
				affListeFormation(out, line, listeFormation);
			} else {
				out.println(line);
			}
			line = buf.readLine();
		}
	}

	private void affListeFormation(PrintWriter out, String line, ListeFormation listeFormation) {
		for (int i = 0; i < listeFormation.size(); i++) {
			Formation formation = listeFormation.get(i);
			String ligneAAfficher = line;
			ligneAAfficher = ligneAAfficher.replace("%%name%%", "bFormation");
			ligneAAfficher = ligneAAfficher.replace("%%valeur%%", Integer.toString(i));
			ligneAAfficher = ligneAAfficher.replace("%%date%%", formation.getDateFormation());
			ligneAAfficher = ligneAAfficher.replace("%%lieu%%", formation.getLieuFormation());
			ligneAAfficher = ligneAAfficher.replace("%%domaine%%", formation.getDomaineFormation());
			out.println(ligneAAfficher);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ListeFormation listeFormation = (ListeFormation) session.getAttribute("listeForm");
		String sSel = request.getParameter("bFormation");
		System.out.println(sSel);
		Formation formation = listeFormation.get(Integer.valueOf(sSel).intValue());
		session.setAttribute("formation", formation);

		File fHtml = new File("C:/DevFormation/workspace/CopyofProjectCV/WebContent/WEB-INF/page/pageListeEtudiant.html");
		PrintWriter out = response.getWriter();
		BufferedReader buf = new BufferedReader(new FileReader(fHtml));
		String line = buf.readLine();
		while (line != null) {
			if (line.contains("%%name%%")) {
				for (int i = 0; i < formation.getListeEtudiant().size(); i++) {
					Etudiant etudiant = formation.getListeEtudiant().get(i);
					String ligneAAfficher = line;
					ligneAAfficher = ligneAAfficher.replace("%%name%%", "bEtudiant");
					ligneAAfficher = ligneAAfficher.replace("%%valeur%%", Integer.toString(i));
					ligneAAfficher = ligneAAfficher.replace("%%nom%%", etudiant.getNom() + " " + etudiant.getPrenom());
					ligneAAfficher = ligneAAfficher.replace("%%prenom%%", etudiant.getPrenom());
					ligneAAfficher = ligneAAfficher.replace("%%mail%%", etudiant.getMail());
					ligneAAfficher = ligneAAfficher.replace("%%metier%%", etudiant.getMetier());
					out.println(ligneAAfficher);
				}
			} else {
				out.println(line);
			}
			line = buf.readLine();
		}
	}
}
