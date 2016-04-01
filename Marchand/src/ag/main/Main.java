package ag.main;

import java.util.Collections;
import java.util.TreeMap;

import ag.metier.marchand.Marchand;
import ag.metier.produit.Alimentaire;
import ag.metier.produit.Conso;
import ag.metier.produit.Produit;
import ag.metier.stock.Stock;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.init();
	}

	public void init() {
		// System.out.println(Produit.CPT);
		Alimentaire banane = new Alimentaire("Banane", 3.5f, 0.99f);
		// System.out.println(Produit.CPT);
		Conso enveloppe = new Conso("Enveloppe", 50, 0.1f);
		// System.out.println(Produit.CPT);
		Alimentaire fraise = new Alimentaire("Fraise", 0.5f, 2.99f);
		Alimentaire patate = new Alimentaire("Patate", 5f, 0.66f);
		Alimentaire saucisson = new Alimentaire("Justin Bridou", 10f, 15.2f);
		// ArrayList<Produit> Apu.getStock() = new ArrayList<Produit>();
		Alimentaire patate2 = new Alimentaire("Patate", 15f, 0.75f);
		Marchand Apu = new Marchand();

		// Map
		TreeMap<String, Produit> treeMap = new Stock();

		treeMap.put(banane.getNom(), banane);
		treeMap.put(enveloppe.getNom(), enveloppe);
		treeMap.put(fraise.getNom(), fraise);
		treeMap.put(patate.getNom(), patate);
		treeMap.put(saucisson.getNom(), saucisson);
		if (treeMap.containsKey(patate2.getNom())) {
			rajouteDansTreeMap(treeMap, patate2);
		}

		// Set<Entry<String, Produit>> set = treeMap.entrySet();
		//
		// for (Entry<String, Produit> entry : set) {
		// System.out.println(entry.getValue());
		// }
		String s = treeMap.toString();
		System.out.println(s);
		System.exit(0);

		Apu.getStockFamille().add(banane);
		Apu.getStockFamille().add(enveloppe);
		Apu.getStockFamille().add(fraise);
		System.out.println(Apu.getStockFamille().somme());
		Apu.getStockFamille().remove(banane);
		// Apu.getStockFamille().clear();
		Apu.getStockFamille().add(patate);
		Apu.getStockFamille().add(saucisson);
		Apu.getStockFamille().add(3, patate2);

		System.out.println(Apu.getStockFamille().contains(banane));
		System.out.println(Apu.getStockFamille().indexOf(enveloppe));
		System.out.println(Apu.getStockFamille().somme());
		System.out.println(Apu.getStockFamille().indexOf(fraise));
		System.out.println(Apu.getStockFamille().indexOf(patate));
		System.out.println(Apu.getStockFamille().indexOf(saucisson));
		System.out.println(patate.equals(patate2));
		System.out.println(patate.compareTo(patate2));
		Collections.sort(Apu.getStockFamille());
		for (Produit produit : Apu.getStockFamille()) {
			System.out.println(produit);
		}

		/*
		 * for(int i=0; i<Apu.getStockFamille().size();i++){ Produit
		 * produit=Apu.getStockFamille().get(i); }
		 */
	}

	private void rajouteDansTreeMap(TreeMap<String, Produit> treeMap, Alimentaire patate2) {
		Produit produit = treeMap.get(patate2.getNom());
		produit.rajoute(patate2);
	}
}
