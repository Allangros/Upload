package vdd.spring.beans.main;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vdd.spring.beans.musiciens.Joueur;

public class MainSpring {

	private static final Logger logger = Logger.getLogger(MainSpring.class);

	public static void main(String[] args) {

		// 1. Chargement du conteneur
		ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "orchestre.xml" });

		// 2. Recupération d'un bean
		Joueur musicien = (Joueur) appContext.getBean("Olivier");
		Joueur musicien2 = (Joueur) appContext.getBean("GEORGE_MICKAEL");
		Joueur yoyo	=(Joueur) appContext.getBean("DADDY_DJ");
		Joueur swag	=(Joueur) appContext.getBean("LOUIS_PRIMA");
		Joueur batman =(Joueur) appContext.getBean("Louis");
		// 3. Manipulation du bean
		musicien.jouerMorceau();
		musicien2.jouerMorceau();
		yoyo.jouerMorceau();
		swag.jouerMorceau();
		batman.jouerMorceau();
		appContext.close();
	}
}
