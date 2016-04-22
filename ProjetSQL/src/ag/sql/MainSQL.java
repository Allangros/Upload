package ag.sql;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ag.metier.Formation;
import ag.metier.ListeFormation;

public class MainSQL {
	public static void main(String[] args) {
		MainSQL m = new MainSQL();
		m.init();
	}

	private void init() {
		createetudiant();
		// insertEtudiant();
		//ListeFormation listeFormation = lectureDom();
		//insertFormation(listeFormation);
		// selectFormation();

	}

	private void selectFormation() {
		Connection conne = null;
		ResultSet res = null;
		Statement statement = null;
		String requete = "";

		String login = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String urlBDD = "jdbc:mysql://localhost/bddcv";
		try {
			conne = DriverManager.getConnection(urlBDD, login, password);
			statement = conne.createStatement();
			requete = "SELECT * FROM formation;";
			statement.executeQuery(requete);
			res = statement.getResultSet();
			boolean encore = res.first();
			while (encore) {
				String id = res.getString(1);
				String date = res.getString("dateFormation");
				String lieu = res.getString("lieuFormation");
				String domaine = res.getString("domaineFormation");
				System.out.println(id + " " + date + " " + lieu + " " + domaine);
				encore = res.next();
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	private void insertFormation(ListeFormation listeFormation) {
		Connection conne = null;
		ResultSet res = null;
		Statement statement = null;
		String requete = "";

		String login = "Active";
		String password = "VDDMichel";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String urlBDD = "jdbc:mysql://www.psyeval.fr/bddCV";
		try {
			conne = DriverManager.getConnection(urlBDD, login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < listeFormation.size(); i++) {
			Formation formation = listeFormation.get(i);
			requete = "INSERT INTO formation " + //
					"(dateFormation,lieuFormation,domaineFormation)" + //
					"VALUES (" + //
					"'" + formation.getDateFormation() + "'," + //
					"'" + formation.getLieuFormation() + "'," + //
					"'" + formation.getDomaineFormation() + "'" + //
					");";
			try {
				statement = conne.createStatement();
				statement.executeUpdate(requete);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}

	private void insertEtudiant() {
		Connection conne = null;
		ResultSet res = null;
		Statement statement = null;
		String requete = "";

		String login = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String urlBDD = "jdbc:mysql://localhost/bddcv";
		try {
			conne = DriverManager.getConnection(urlBDD, login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		requete = "INSERT INTO etudiant" + //
				"(id,nom,prenom,metier,mail)" + //
				"VALUES (" + //
				"'1'," + //
				"'nom'," + //
				"'prenom'," + //
				"'metier'," + //
				"'mail' " + //
				");";
		try {
			statement = conne.createStatement();
			statement.executeUpdate(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	private ListeFormation lectureDom() {
		ListeFormation listeFormation = new ListeFormation();
		File fLecture = new File("src/xml/listeFormation.xml");
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
					String nom = eFormation.getAttribute("dateFormation");
					String prenom = eFormation.getAttribute("lieuFormation");
					String metier = eFormation.getAttribute("domaineFormation");
					Formation form = new Formation(nom, prenom, metier);
					listeFormation.add(form);
					System.out.println(nom + " " + prenom + " " + metier + " ");
				}
			}

		} catch (ParserConfigurationException e) {

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listeFormation;
	}

	private void createetudiant() {
		Connection conne = null;
		ResultSet res = null;
		Statement statement = null;
		String requete = "";

		String login = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String urlBDD = "jdbc:mysql://localhost/bddcv";
		try {
			conne = DriverManager.getConnection(urlBDD, login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		requete = "CREATE TABLE etudiant" + //
				"(id INT NOT NULL PRIMARY KEY," + //
				"nom VARCHAR(30)," + //
				"prenom VARCHAR(30)," + //
				"metier VARCHAR(30)," + //
				"mail VARCHAR(30)" + //
				");";
		try {
			statement = conne.createStatement();
			statement.executeUpdate(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}
}
