package ag.main;

import java.util.logging.Logger;

import ag.beans.Deve;
import ag.beans.Develop;
import ag.beans.SocieteDev;
import ag.metier.Developpeur;
import ag.metier.SocieteDevLogiciel;

public class MainSpring {
	public static void main(String[] args) {
		MainSpring m = new MainSpring();
		m.init();
		// m.initSans();
	}

	private void init() {

		Logger logger = Logger.getLogger(this.getClass().getName());
		SocieteDevLogiciel societe = new SocieteDevLogiciel();
		Developpeur olivier = new Developpeur();
		olivier.setNom("Olivier");
		olivier.setAnneesExp(7);
		Developpeur marc = new Developpeur();
		marc.setNom("Marc");
		marc.setAnneesExp(10);
		societe.setChefDeveloppeur(marc);
		societe.setDeveloppeur(olivier);

		logger.info("Chef Developpeur: " + societe.getChefDeveloppeur().getNom());
		logger.info("Developpeur: " + societe.getDeveloppeur().getNom());

	}

	public void initSans() {
		Logger logger = Logger.getLogger(this.getClass().getName());
		Deve societe = new SocieteDev();
		Develop olivier = new Develop("Olivier", 7);
		Develop marc = new Develop("marc", 10);
		societe.chefDevelop("marc", 10);
		societe.develop("olivier", 7);
//		logger.info("Chef Developpeur: " + societe.getChefDevelop().getNom());
//		logger.info("Developpeur: " + societe.getDevelop().getNom());
	}
}
