package vdd.ascenceur;

import java.util.ArrayList;

import vdd.main.Main;

public class ListeAscenseur extends ArrayList<Asc> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListeAscenseur(Main main) {
				for (int i = 0; i < 6; i++) {
					Asc0 a = new Asc0(main);
					a.start();
					add(a);
				}
	}
}
