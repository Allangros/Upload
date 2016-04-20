package ag.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainSQL {
	public static void main(String[] args) {
		MainSQL m = new MainSQL();
		// m.createetudiant();
		m.insertEtudiant();
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
