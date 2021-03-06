package ag.metier.produit;

import java.io.Serializable;

public class Conso extends Produit implements Serializable,Comparable<Produit>{


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int qte;

    public Conso() {
        super();
    }

    public Conso(String nom, int qte, float PrixUnitaire) {
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
        if (obj instanceof Conso) {
            Conso e=(Conso) obj;
            b=(this.getNom().equals(e.getNom()));
        }
        return b;
    }

    @Override
    public boolean rajoute(Produit e) {
        boolean ok = false;
        if (e instanceof Conso && e.getNom().equals(this.getNom())) {
            Conso a = (Conso) e;
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
        if (o instanceof Conso) {
                retour = this.getNom().compareTo(o.getNom());
            } else if (o instanceof Alimentaire) {
                retour = -1;
            }

        return retour;
    }
}

