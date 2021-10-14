package Guitar;

public class FindGuitarTester {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        initializeInventory(inventory);
    }

    public static void initializeInventory(Inventory inventory) {
        inventory.addInstrument(new Guitar("11277", 3999.95, new GuitarSpec(Builder.COLLINGS, "CJ", Type.ACOUSTIC, 6, Wood.INDIAN_ROSEWOOD, Wood.SITKA)));
        inventory.addInstrument(new Mandoline("V95693", 1499.95, new MandolinSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, Style.A, Wood.ALDER, Wood.ALDER)));
        inventory.addInstrument(new Guitar("V9512", 1549.95, new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER)));
        inventory.addInstrument(new Guitar("122784", 5495.95, new GuitarSpec(Builder.MARTIN, "D-18", Type.ACOUSTIC, 6, Wood.MAHOGANY, Wood.ADIRONDACK)));
        inventory.addInstrument(new Guitar("76531", 6295.95, new GuitarSpec(Builder.MARTIN, "OM-28", Type.ACOUSTIC, 6, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK)));
        inventory.addInstrument(new Guitar("70108276", 2295.95, new GuitarSpec(Builder.GIBSON, "Les Paul", Type.ELECTRIC, 6, Wood.MAHOGANY, Wood.MAHOGANY)));
        inventory.addInstrument(new Guitar("82765501", 1890.95, new GuitarSpec(Builder.GIBSON, "SG '61 Reissue", Type.ELECTRIC, 6, Wood.MAHOGANY, Wood.MAHOGANY)));
        inventory.addInstrument(new Mandoline("77023", 6275.95, new MandolinSpec(Builder.MARTIN, "D-28", Type.ACOUSTIC, Style.A, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK)));
        inventory.addInstrument(new Guitar("1092", 12995.95, new GuitarSpec(Builder.OLSON, "SJ", Type.ACOUSTIC, 12, Wood.INDIAN_ROSEWOOD, Wood.CEDAR)));
        inventory.addInstrument(new Guitar("566-62", 8999.95, new GuitarSpec(Builder.RYAN, "Cathedral", Type.ACOUSTIC, 12, Wood.COCOBOLO, Wood.CEDAR)));
        inventory.addInstrument(new Mandoline("6 29584", 2100.95, new MandolinSpec(Builder.PRS, "Dave Navarro Signature", Type.ELECTRIC, Style.F, Wood.MAHOGANY, Wood.MAPLE)));
    }
}
