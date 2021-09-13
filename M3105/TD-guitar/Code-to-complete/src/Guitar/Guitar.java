package Guitar;

public class Guitar {
    private final String numeroSerie;
    private final double prix;
    private final Builder constructeur;
    private final String modele;
    private final Type type;
    private final Wood bois1;
    private final Wood bois2;

    public Guitar(String numeroSerie, double prix, Builder constructeur, String modele, Type type, Wood bois1, Wood bois2) {
        this.numeroSerie = numeroSerie;
        this.prix = prix;
        this.constructeur = constructeur;
        this.modele = modele;
        this.type = type;
        this.bois1 = bois1;
        this.bois2 = bois2;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public double getPrix() {
        return prix;
    }

    public Builder getConstructeur() {
        return constructeur;
    }

    public String getModele() {
        return modele;
    }

    public Type getType() {
        return type;
    }

    public Wood getBois1() {
        return bois1;
    }

    public Wood getBois2() {
        return bois2;
    }
}
