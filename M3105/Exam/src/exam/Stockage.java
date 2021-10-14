package exam;

import java.util.ArrayList;
import java.util.List;

public class Stockage extends Equipement {
    private List<Equipement> equipements;
    private String nom;

    public Stockage(String nom) {
        super(nom);
        equipements = new ArrayList<>();
    }

    public void ajouterEquipement(Equipement equipement) {
        equipements.add(equipement);
    }

    public void recevoirValeurSupp(int i) {
        for (Equipement equipement: equipements) {
            equipement.recevoirValeurSupp(i);
        }
    }


    public void affiche() {
        System.out.println("Le " +getNom()+ " contient : ");
        for (Equipement equipement: equipements) {
            System.out.println(" - " +equipement);
        }
    }

    public void afficheValeur() {
        System.out.println("Le" +getNom()+ "contient des objets d'une valeur totale de " +getValeur());
    }

    public void afficheObjetsDeValeurMin(int i) {

    }

    //Generate
    @Override
    public String toString() {
        return "Stockage : [" + "nom = '" + super.toString() + ']';
    }

    @Override
    public String getNom() {
        return nom;
    }
    
    @Override
    public int getValeur() {
        int total = 0;
        for (Equipement equipement: equipements) {
            total += equipement.getValeur();
        }
        return total;
    }

}
