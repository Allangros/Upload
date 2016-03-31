package ag.metier.produit;

public class Consommable extends Produit implements Comparable<Produit>{


    private int qte;

    public Consommable() {
        super();
    }

    public Consommable(String nom, int qte, float PrixUnitaire) {
        super(nom, PrixUnitaire);
        this.qte = qte;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        if (qte > 0) {
            this.qte = qte;
        } else {
            this.qte = 0;
        }
    }

    @Override
    public float getPrix() {
        return getPrixUnitaire() * getQte();
    } 

    @Override
    public boolean equals(Object obj) {
        boolean b = false;
        if (obj instanceof Consommable) {
            Consommable e=(Consommable) obj;
            b=(this.getNom().equals(e.getNom()));
        }
        return b;
    }

    @Override
    public boolean rajoute(Produit e) {
        boolean ok = false;
        if (e instanceof Consommable && e.getNom().equals(this.getNom())) {
            Consommable a = (Consommable) e;
            this.setPrixUnitaire((this.getPrix() + e.getPrix()) / (this.getQte() + a.getQte()));
            ok = true;
        }
        return ok;
    }

    @Override
    public int hashCode() {
        return this.getNom().hashCode();
    }

    @Override
    public int compareTo(Produit o) {
        int retour=0;
        if (o instanceof Consommable) {
                retour = this.getNom().compareTo(o.getNom());
            } else if (o instanceof Alimentaire) {
                retour = -1;
            }

        return retour;
    }
}

