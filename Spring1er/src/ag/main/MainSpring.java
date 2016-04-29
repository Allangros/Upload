package ag.main;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ag.beans.SocieteDevLogiciel;

public class MainSpring {
	public static void main(String[] args) {
		MainSpring m = new MainSpring();
		m.init();
	}

	private void init() {

		Logger logger = Logger.getLogger(this.getClass().getName());
		ApplicationContext appContext = (ApplicationContext) new ClassPathXmlApplicationContext("SimpleBean.xml");
		SocieteDevLogiciel societe = (SocieteDevLogiciel) appContext.getBean("societeDevLogiciel");

		logger.info("Chef Developpeur: " + societe.getChefDeveloppeur().getNom());
		logger.info("Developpeur: " + societe.getDeveloppeur().getNom());

	}

}
