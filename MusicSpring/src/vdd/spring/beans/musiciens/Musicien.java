package vdd.spring.beans.musiciens;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import vdd.spring.beans.instruments.Instrument;
import vdd.spring.exception.JouerException;

@Component("Musicien")

public class Musicien implements Joueur {
	
	@Value("{morceau}")
	private String morceau;

	private String nom;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	@Value("{instrument}")
	private Instrument instrument;

	public void jouerMorceau() throws JouerException {
		System.out.print(nom+" joue " + morceau + " : ");
		instrument.jouer();
	}

	public void setMorceau(String morceau) {
		this.morceau = morceau;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public void arranger() {
		System.out.println("Arrangement de l'instrument avant utilisation");
	}

	public void nettoyer() {
		System.out.println("Nettoyage de l'instrument après utilisation");
	}

	public String getMorceau() {
		return morceau;
	}

	public Instrument getInstrument() {
		return instrument;
	}
}
