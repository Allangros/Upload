package ag.metier.stock;

import java.util.ArrayList;

import ag.metier.produit.Alimentaire;
import ag.metier.produit.Produit;

public class PasUnStock {

	private ArrayList<Produit> monStock;
	private ArrayList<Produit> monStockPrive;
	private ArrayList<Produit> monStockFamille;

	public ArrayList<Produit> getMonStockPrive() {
		return monStockPrive;
	}

	public void setMonStockPrive(ArrayList<Produit> monStockPrive) {
		this.monStockPrive = monStockPrive;
	}

	public ArrayList<Produit> getMonStockFamille() {
		return monStockFamille;
	}

	public void setMonStockFamille(ArrayList<Produit> monStockFamille) {
		this.monStockFamille = monStockFamille;
	}

	public PasUnStock() {
		monStock = new ArrayList<Produit>();
		monStockFamille = new ArrayList<Produit>();
		monStockPrive = new ArrayList<Produit>();
	}

	public ArrayList<Produit> getMonStock() {
		return monStock;
	}

	public void setMonStock(ArrayList<Produit> monStock) {
		this.monStock = monStock;
	}

	public void somme() {
		float somme = 0;
		float somAli = 0;
		float somCon = 0;

		for (int i = 0; i < monStockFamille.size(); i++) {
			System.out.println(monStockFamille.get(i));
		}
		for (Produit produit : monStockFamille) {
			if (produit instanceof Alimentaire) {
				somAli += produit.getPrix();
			} else {
				somCon += produit.getPrix();
			}
			somme = somAli + somCon;

		}
		somme = somAli + somCon;
		System.out.println("Somme Totale = " + somme);
		System.out.println("Somme Alimentaire = " + somAli);
		System.out.println("Somme Consommable = " + somCon);
	}
}