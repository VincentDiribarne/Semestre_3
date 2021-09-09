package exo1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private final ArrayList<Guitar> guitars;

    public Inventory() {
        guitars = new ArrayList<>();
    }

    public void addGuitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) {
        guitars.add(new Guitar(serialNumber, price, builder, model, type, backWood, topWood));
    }


    public Guitar getGuitar(String serialNumber) {
        for (Guitar guitar : guitars) {
            if (guitar.getNumeroSerie().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public Guitar search(Guitar searchGuitar) {
        for (Guitar guitar : guitars) {
            String builder = searchGuitar.getConstructeur();
            if ((builder != null) && (!builder.equals("")) && (!builder.equals(guitar.getConstructeur())))
                continue;

            String model = searchGuitar.getModele();
            if ((model != null) && (!model.equals("")) && (!model.equals(guitar.getModele())))
                continue;

            String type = searchGuitar.getType();
            if ((type != null) && (!type.equals("")) && (!type.equals(guitar.getType())))
                continue;

            String backWood = searchGuitar.getBois1();
            if ((backWood != null) && (!backWood.equals("")) && (!backWood.equals(guitar.getBois1())))
                continue;

            String topWood = searchGuitar.getBois2();
            if ((topWood != null) && (!topWood.equals("")) && (!topWood.equals(guitar.getBois2())))
                continue;

            return guitar;
        }
        return null;
    }

}
