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
            if (noMatch(searchGuitar.getConstructeur(), guitar.getConstructeur())) continue;
            if (noMatch(searchGuitar.getModele(), guitar.getModele())) continue;
            if (noMatch(searchGuitar.getType(), guitar.getType())) continue;
            if (noMatch(searchGuitar.getBois1(), guitar.getBois1())) continue;
            if (noMatch(searchGuitar.getBois2(), guitar.getBois2())) continue;
            return guitar;
        }
        return null;
    }

    private boolean noMatch(String searched, String realDrop) {
        if (searched == null || searched.equals("")) return false;
        
        return !searched.equals(realDrop);
    }

}
