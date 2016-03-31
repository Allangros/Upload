package ag.metier.stock;

import ag.metier.produit.Alimentaire;
import ag.metier.produit.Consommable;
import ag.metier.produit.Produit;

import java.util.ArrayList;

public class StockArrayList extends ArrayList<Produit> {
	
    public static int NUM_STOCK = 0;

    private String nom;
    private float mtTotalStock;
    private float limitePrix;

    public StockArrayList() {
        nom = "stock" + Integer.toString(NUM_STOCK);
        setLimitedetarace(0);
        NUM_STOCK++;
        mtTotalStock = 0;
    }

    public StockArrayList(String nom) {
        this.nom = nom;
        setLimitedetarace(0);
        NUM_STOCK++;
    }

    public StockArrayList(String nom, float limitedetarace) {
        this.nom = nom;
        this.setLimitedetarace(limitedetarace);
        if (limitedetarace == 0) {
            this.limitePrix = Float.POSITIVE_INFINITY;
        }
        mtTotalStock = 0;
        NUM_STOCK++;
    }

    public static int getNUM_STOCK() {
        return NUM_STOCK;
    }

    public static void setNUM_STOCK(int nUM_STOCK) {
        NUM_STOCK = nUM_STOCK;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.nom;
    }

    public float getLimitedetarace() {
        return limitePrix;
    }

    public void setLimitedetarace(float limite) {
        this.limitePrix = Math.abs(limite);
        if (limite == 0) {
            this.limitePrix = Float.POSITIVE_INFINITY;
        }
    }

    public float somme() {
        float somme = 0;
        for (int i = 0; i < this.size(); i++) {
            somme += this.get(i).getPrix();
        }
        return somme;
    }

    @Override
    public void add(int nb, Produit e) {
        float somme = mtTotalStock + e.getPrix();
        if (somme <= limitePrix || limitePrix == 0) {
            super.add(nb, e);
            mtTotalStock = somme;
        }
    }

    @Override
    public boolean add(Produit e) {
        boolean depassePas = false;
        float somme = e.getPrix() + mtTotalStock;
        if (somme <= limitePrix || limitePrix == 0) {
            if (contains(e)) {
                Produit p = get(indexOf(e));
                p.rajoute(e);
            } else {
                depassePas = super.add(e);
                if (depassePas) {
                    mtTotalStock = somme;
                }
            }
        }
        return depassePas;
    }

    public boolean addold(Produit e) {
        boolean depassePas = false;
        float somme = e.getPrix() + mtTotalStock;
        if (somme <= limitePrix || limitePrix == 0) {
            Produit produitExiste = rechercherProduit(e);
            if (produitExiste != null) {
                depassePas = produitExiste.rajoute(e);
            } else {
                depassePas = super.add(e);
                if (depassePas) {
                    this.setMtTotalStock(somme);
                }
            }
        }
        return depassePas;
    }

    private Produit rechercherProduit(Produit e) {
        Produit produitTrouve = null;
        for (Produit produit : this) {
            if (produit.getNom().equals(e.getNom())) {
                if (produit instanceof Alimentaire && e instanceof Alimentaire || produit instanceof Consommable && e instanceof Consommable) {
                    produitTrouve = produit;
                    break;
                }
            }
        }
        return produitTrouve;
    }

/*    private int indexOf(Produit e) {

        int b = -1;
        for (int i = 0; i < size(); i++) {
            Produit produit = get(i);
            if (produit.getNom().equals(e.getNom())) {
                if (produit instanceof Alimentaire && e instanceof Alimentaire || produit instanceof Consommable && e instanceof Consommable) {
                    b = i;
                    break;
                }
            }
        }
        return b;
    }*/

    @Override
    public Produit remove(int nb) {

        if (nb < 0) {
        } else {
            Produit e = super.get(nb);

            this.setMtTotalStock(this.getMtTotalStock() - e.getPrix());
        }

        return null;
    }

    @Override
    public boolean remove(Object o) {
        boolean moinsProd = false;
        Produit e = (Produit) o;
        moinsProd = super.remove(e);
        if (moinsProd) {
            this.setMtTotalStock(this.getMtTotalStock() - e.getPrix());
        }
        return moinsProd;
    }

    public float getMtTotalStock() {
        return mtTotalStock;
    }

    public void setMtTotalStock(float mtTotalStock) {
        this.mtTotalStock = mtTotalStock;
    }

    public float getLimitePrix() {
        return limitePrix;
    }

    public void setLimitePrix(float limitePrix) {
        this.limitePrix = limitePrix;
    }

    @Override
    public void clear() {
        this.setMtTotalStock(0);
        super.clear();
    }

/*    public float moyenne(Produit p, Produit q) {
        float moyenne = 0;
        if (p instanceof Alimentaire) {
            Alimentaire a = (Alimentaire) p;
            Alimentaire b = (Alimentaire) q;
            moyenne = ((a.getPrix() + b.getPrix()) / (a.getPoids() + b.getPoids()));
        }
        if (p instanceof Consommable) {
            Consommable a = (Consommable) p;
            Consommable b = (Consommable) q;
            moyenne = ((a.getPrix() + b.getPrix()) / (a.getQte() + b.getQte()));

        }
        return moyenne;
    }*/

 /*   @Override
    public int indexOf(Object o) {
        int b = -1;
        if (o instanceof Produit) {
            b = this.indexOf((Produit) o);
        }
        return b;
    }

    @Override
    public boolean contains(Object o) {
        boolean b = false;
        if (o instanceof Produit) {
            if (indexOf((Produit) o) >= 0) {
                b = true;
            }
        }
        return b;
    }*/

    // public float getLimitedetarace() {
    // return limitedetarace;
    // }
    //
    // public void setLimitedetarace(float limitedetarace) {
    // this.limitedetarace = limitedetarace;
    // }

    // public void somme() {
    // float somme = 0;
    // float somAli = 0;
    // float somCon = 0;
    //
    // for (int i = 0; i < stock.size(); i++) {
    // System.out.println(stock.get(i));
    // }
    // for (Produit produit : stock) {
    // if (produit instanceof Alimentaire) {
    // somAli += produit.getPrix();
    // } else {
    // somCon += produit.getPrix();
    // }
    // somme = somAli + somCon;
    //
    // }
    // somme = somAli + somCon;
    // System.out.println("Somme Totale = " + somme);
    // System.out.println("Somme Alimentaire = " + somAli);
    // System.out.println("Somme Consommable = " + somCon);
    // }
}
