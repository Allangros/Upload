package ag.metier.marchand;

//import ag.metier.stock.PasUnStock;
import ag.metier.stock.StockArrayList;

public class Marchand extends Commercant {
    // private PasUnStock stock;
    private StockArrayList stockPrivee;
    private StockArrayList stockFamille;
    private StockArrayList stock;

    public Marchand() {

        stockPrivee = new StockArrayList();
        stockFamille = new StockArrayList();

    }

    public Marchand(float nb1, float nb2, float nb3) {
        stockPrivee = new StockArrayList();
        stockFamille = new StockArrayList();
        stock = new StockArrayList();
        stock.setLimitedetarace(nb1);
        stockPrivee.setLimitedetarace(nb2);
        stockFamille.setLimitedetarace(nb3);
    }

    // public Marchand(float nb1, float nb2, float nb3) {
    // if (nb1 == 0) {
    // stock = new Stock("stock1");
    // } else {
    // stock = new Stock("stock1", nb1);
    // }
    // stockPrivee = new Stock("stockp", nb2);
    // stockFamille = new Stock("stockf", nb3);
    // }

    public StockArrayList getStockPrivee() {
        return stockPrivee;
    }

    public void setStockPrivee(StockArrayList stockPrivee) {
        this.stockPrivee = stockPrivee;
    }

    public void setStockFamille(StockArrayList stockFamille) {
        this.stockFamille = stockFamille;
    }

    @Override
    public String toString() {
        return getNomDuMarchand();
    }

    public StockArrayList getStockFamille() {
        return stockFamille;
    }

}
