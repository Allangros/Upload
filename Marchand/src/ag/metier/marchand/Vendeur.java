package ag.metier.marchand;

import ag.metier.stock.Stock;

public class Vendeur {
	private Stock stock;
	private Stock stockPrive;
	private Stock stockFamille;

	public Vendeur() {
		stock=new Stock();
		stockPrive=new Stock();
		stockFamille=new Stock();	
	}

	public Stock getStock() {
		return stock;
	}

	public Stock getStockPrive() {
		return stockPrive;
	}

	public void setStockPrive(Stock stockPrive) {
		this.stockPrive = stockPrive;
	}

	public Stock getStockFamille() {
		return stockFamille;
	}

	public void setStockFamille(Stock stockFamille) {
		this.stockFamille = stockFamille;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Vendeur [stock=" + stock + ", stockPrive=" + stockPrive + ", stockFamille=" + stockFamille + "]";
	}

}