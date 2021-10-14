package exam;

public abstract class Equipement {
    private String nom;

    public Equipement(String nom) {
        this.nom = nom;
    }

    public abstract void recevoirValeurSupp(int i);
    public abstract int getValeur();

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
