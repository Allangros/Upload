package ag.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.TreeMap;

import ag.metier.marchand.Marchand;
import ag.metier.produit.Alimentaire;
import ag.metier.produit.Conso;
import ag.metier.produit.Produit;
import ag.metier.stock.Stock;
import ag.metier.stock.StockArrayList;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		// m.save();
		// m.recup();
		m.saveMarchand();
	}

	private void saveMarchand() {
		Marchand robert = new Marchand(0,0,200);
		robert.setNomDuMarchand("Robert");
		for (int i = 0; i < 10; i++) {
			robert.getStockFamille().add(new Alimentaire("Aliment" + i, 2, i + 1));
			robert.getMonStock().add(new Conso("Conso" + i, 2, i + 1));
			robert.getStockPrivee().add(new Alimentaire("Aliment" + i, 2, i + 1));
		}
		File fMarchand = new File("marchand.ser");
		ObjectOutputStream o = null;
		try {
			o = new ObjectOutputStream(new FileOutputStream(fMarchand));
			o.writeObject(robert);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				o.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void recup() {
		File file = new File("alimentaire.ser");
		ObjectInputStream objIn = null;
		try {
			objIn = new ObjectInputStream(new FileInputStream(file));
			Alimentaire alimentaire = (Alimentaire) objIn.readObject();
			System.out.println(alimentaire.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void save() {
		StockArrayList stock = new StockArrayList();
		// Alimentaire a = new Alimentaire("banana", 2.5f, 2.5f);
		// File FileAlimentaire = new File("alimentaire.ser");
		// ObjectOutputStream obj = null;
		// try {
		// obj = new ObjectOutputStream(new FileOutputStream(FileAlimentaire));
		// obj.writeObject(a);
		// } catch (IOException e) {
		// e.printStackTrace();
		// } finally {
		// try {
		// obj.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }

		InputStreamReader entreeStandard = new InputStreamReader(System.in);
		LineNumberReader resLecture = new LineNumberReader(entreeStandard);
		// System.out.println("nom du produit");
		// Produit p = null;
		// String nom = null;
		// String type = null;
		// float PrixUnitaire = 0f;
		CreaProd(stock);
		for (Produit produit : stock) {
			System.out.println(produit.toString());
		}

	}

	private void CreaProd(StockArrayList stock) {

		InputStreamReader entreeStandard = new InputStreamReader(System.in);
		LineNumberReader resLecture = new LineNumberReader(entreeStandard);

		String nom = null;
		String type = null;
		int qte = 0;
		float poids = 0f;
		String type2 = "Alimentaire";
		float PrixUnitaire = 0f;
		System.out.println("nom du Produit");
		try {
			nom = resLecture.readLine();
			while (!nom.equals("")) {
				System.out.println("type du Produit");

				type = resLecture.readLine();
				System.out.println(type);
				if (type.equals(type2)) {
					Alimentaire alimentaire = new Alimentaire();
					alimentaire.setNom(nom);
					System.out.println("poids du Produit");
					alimentaire.setPoids(Float.valueOf(resLecture.readLine()).floatValue());
					System.out.println("Prix Unitaire du Produit");
					alimentaire.setPrixUnitaire(PrixUnitaire = Float.valueOf(resLecture.readLine()).floatValue());
					stock.add(alimentaire);
				} else if (type.equals("Conso")) {
					Conso conso = new Conso();
					conso.setNom(nom);
					System.out.println("qte du Produit");
					conso.setQte(Integer.valueOf(resLecture.readLine()).intValue());
					System.out.println("Prix Unitaire du Produit");
					conso.setPrixUnitaire(Float.valueOf(resLecture.readLine()).floatValue());

					stock.add(conso);
				}
				System.out.println("saisir nouveau nom");
				nom = resLecture.readLine();
				if (nom.equals("")) {
					break;
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void lireConsole() {

		InputStreamReader entreeStandard = new InputStreamReader(System.in);
		LineNumberReader resLecture = new LineNumberReader(entreeStandard);

		String nom = null;
		String type = null;
		int qte = 0;
		float poids = 0f;
		String type2 = "Alimentaire";
		float PrixUnitaire;
		System.out.println("nom du Produit");
		try {
			nom = resLecture.readLine();
			if (nom != null) {
				System.out.println("type du Produit");

				type = resLecture.readLine();
				System.out.println(type);
				if (type.equals(type2)) {
					System.out.println("poids du Produit");
					poids = Float.valueOf(resLecture.readLine()).intValue();
					System.out.println("Prix Unitaire du Produit");
					PrixUnitaire = Float.valueOf(resLecture.readLine()).intValue();
				} else if (type.equals("Conso")) {
					System.out.println("qte du Produit");
					qte = Integer.valueOf(resLecture.readLine());
					System.out.println("Prix Unitaire du Produit");
					PrixUnitaire = Float.valueOf(resLecture.readLine()).intValue();
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
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
