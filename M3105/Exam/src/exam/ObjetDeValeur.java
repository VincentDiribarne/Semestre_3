package exam;

public class ObjetDeValeur extends Equipement{
    private String nom;
    private int valeur;

    public ObjetDeValeur(String nom) {
        this(nom, 0);
    }

    public ObjetDeValeur(String nom, int valeur) {
        super(nom);
        this.valeur = valeur;
    }

    public void recevoirValeurSupp(int i) {
        valeur += i;
    }

    public int getValeur() {
        return valeur;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
