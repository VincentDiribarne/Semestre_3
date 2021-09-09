package exo1;

public class Guitar {
    private final String numeroSerie;
    private final double prix;
    private final String constructeur;
    private final String modele;
    private final String type;
    private final String bois1;
    private final String bois2;

    public Guitar(String numeroSerie, double prix, String constructeur, String modele, String type, String bois1, String bois2) {
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

    public String getConstructeur() {
        return constructeur;
    }

    public String getModele() {
        return modele;
    }

    public String getType() {
        return type;
    }

    public String getBois1() {
        return bois1;
    }

    public String getBois2() {
        return bois2;
    }
}
