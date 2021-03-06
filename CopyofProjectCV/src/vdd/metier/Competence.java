package vdd.metier;

public class Competence {
	private String type;
	private String detail;
	private String niveau;
	private String idEtudiant;
	private Etudiant etudiant;
	private ListeCompetence listeCom;

	public Competence() {
		idEtudiant = "-1";
		type = "";
		detail = "";
		niveau = "";
	}

	public Competence(String idEtudiant, String type, String detail, String niveau) {
		this.idEtudiant = idEtudiant;
		this.type = type;
		this.detail = detail;
		this.niveau = niveau;
	}

	public Competence(Etudiant etudiant, String type, String detail, String niveau) {
		this.etudiant = etudiant;
		this.type = type;
		this.detail = detail;
		this.niveau = niveau;

	}

	public String getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(String idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

}
