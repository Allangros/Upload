package ag.metier.produit;

public class Alimentaire extends Produit implements Comparable<Produit>{


    private float poids;

    public Alimentaire() {
        super();
    }

    public Alimentaire(String nom, float poids, float PrixUnitaire) {
        super(nom, PrixUnitaire);
        this.poids = poids;
    }

    @Override
    public float getPrix() {
        return getPrixUnitaire() * getPoids();
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        if (poids >= 0) {
            this.poids = poids;
        } else {
            this.poids = 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean b = false;

        if (obj instanceof Alimentaire) {
            Alimentaire e = (Alimentaire) obj;
            b = this.getNom().equals(e.getNom());
        }
        return b;
    }

    @Override
    public int hashCode() {
        return this.getNom().hashCode();
    }

    @Override
    public boolean rajoute(Produit e) {
        boolean ok = false;
        if (e instanceof Alimentaire && e.getNom().equals(this.getNom())) {
            Alimentaire a = (Alimentaire) e;
            this.setPrixUnitaire((this.getPrix() + e.getPrix()) / (this.getPoids() + a.getPoids()));
            ok = true;
        }
        return ok;
    }

    @Override
    public int compareTo(Produit o) {
        int retour=0;
        if (o instanceof Alimentaire) {
            retour = this.getNom().compareTo(o.getNom());
        } else if (o instanceof Consommable) {
                retour = 1;
        }
        return retour;
    }
}

