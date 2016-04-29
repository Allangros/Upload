package vdd.metier;

public class Etudiant {

	private String nom;
	private String prenom;
	private String mail;
	private String metier;
	private String cv;

	private int id;

	private Formation formation;
	private ListeCompetence listeCompetence;
	private ListeFormationScolaire listeFormationScolaire;
	private ListeExperience listeExperience;

	public Etudiant(String nom, String prenom, String mail, String metier, Formation formation, int id) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.metier = metier;
		this.formation = formation;
		this.id = id;
		listeCompetence = new ListeCompetence();
		listeExperience = new ListeExperience();
		listeFormationScolaire = new ListeFormationScolaire();

	}

	public Etudiant(String nom, String prenom, String mail, String metier, String cv, Formation formation) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.metier = metier;
		this.cv = cv;
		this.formation = formation;
		listeCompetence = new ListeCompetence();
		listeExperience = new ListeExperience();
		listeFormationScolaire = new ListeFormationScolaire();

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMetier() {
		return metier;
	}

	public void setMetier(String metier) {
		this.metier = metier;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ListeCompetence getListeCompetence() {
		return listeCompetence;
	}

	public void setListeCompetence(ListeCompetence listeCompetence) {
		this.listeCompetence = listeCompetence;
	}

	public ListeFormationScolaire getListeFormationScolaire() {
		return listeFormationScolaire;
	}

	public void setListeFormationScolaire(ListeFormationScolaire listeFormationScolaire) {
		this.listeFormationScolaire = listeFormationScolaire;
	}

	public ListeExperience getListeExperience() {
		return listeExperience;
	}

	public void setListeExperience(ListeExperience listeExperience) {
		this.listeExperience = listeExperience;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

}
