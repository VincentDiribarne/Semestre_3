package Guitar;

import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Guitar> guitars;

    public Inventory() {
        guitars = new ArrayList<>();
    }

    public void addGuitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood) {
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
            if ((searchGuitar.getConstructeur() != null) && (!searchGuitar.getConstructeur().equals(guitar.getBois2()))) continue;
            if ((searchGuitar.getModele() != null) && (!searchGuitar.getModele().equals("")) && (!searchGuitar.getModele().equals(guitar.getModele()))) continue;
            if ((searchGuitar.getType() != null) && (!searchGuitar.getType().equals(guitar.getType()))) continue;
            if ((searchGuitar.getBois1() != null) && (!searchGuitar.getBois1().equals(guitar.getBois1()))) continue;
            if ((searchGuitar.getBois2() != null) && (!searchGuitar.getBois2().equals(guitar.getBois2()))) continue;

            return searchGuitar;
        }
        return null;
    }


}
