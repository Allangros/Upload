package ag.metier;

public class Formation {

	private String dateFormation;
	private String lieuFormation;
	private String domaineFormation;

	public Formation() {

		dateFormation = "";
		lieuFormation = "";
		domaineFormation = "";
	}

	public Formation(String date, String lieu, String domaine) {

		this.dateFormation = date;
		this.lieuFormation = lieu;
		this.domaineFormation = domaine;
	}

	public String getDateFormation() {
		return dateFormation;
	}

	public void setDateFormation(String dateFormation) {
		this.dateFormation = dateFormation;
	}

	public String getLieuFormation() {
		return lieuFormation;
	}

	public void setLieuFormation(String lieuFormation) {
		this.lieuFormation = lieuFormation;
	}

	public String getDomaineFormation() {
		return domaineFormation;
	}

	public void setDomaineFormation(String domaineFormation) {
		this.domaineFormation = domaineFormation;
	}

}
