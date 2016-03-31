package ag.metier.marchand;

import ag.metier.stock.StockArrayList;

public class Commercant {

	private String nomDuMarchand;
	private StockArrayList monStock;

	public Commercant() {
		monStock = new StockArrayList();
	}

	public String getNomDuMarchand() {
		return nomDuMarchand;
	}

	public void setNomDuMarchand(String nomDuMarchand) {
		this.nomDuMarchand = nomDuMarchand;
	}

	public StockArrayList getMonStock() {
		return monStock;
	}

	public void setMonStock(StockArrayList monStock) {
		this.monStock = monStock;
	}

	@Override
	public String toString() {
		return nomDuMarchand;
	}

}
