package exo1;

public class FindGuitarTester {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        initializeInventory(inventory);
        Guitar whatErinLikes = new Guitar("", 0, "", "CJ", "acoustic", "", "Sitka");
        Guitar guitar = inventory.search(whatErinLikes);

        if (guitar != null) {
            System.out.println("Erin, you might like this " +
                    guitar.getConstructeur() + " " + guitar.getModele() + " " +
                    guitar.getType() + " guitar:\n   " +
                    guitar.getBois1() + " back and sides,\n   " +
                    guitar.getBois2() + " top.\nYou can have it for only $" +
                    guitar.getPrix() + "!");
        } else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }
    }

    public static void initializeInventory(Inventory inventory) {
        inventory.addGuitar("11277", 3999.95, "Collings", "CJ", "acoustic", "Indian Rosewood", "Sitka");
        inventory.addGuitar("V95693", 1499.95, "Fender", "Stratocastor", "electric", "Alder", "Alder");
        inventory.addGuitar("V9512", 1549.95, "Fender", "Stratocastor", "electric", "Alder", "Alder");
        inventory.addGuitar("122784", 5495.95, "Martin", "D-18", "acoustic", "Mahogany", "Adirondack");
        inventory.addGuitar("76531", 6295.95, "Martin", "OM-28", "acoustic", "Brazilian Rosewood", "Adriondack");
        inventory.addGuitar("70108276", 2295.95, "Gibson", "Les Paul", "electric", "Mahogany", "Maple");
        inventory.addGuitar("82765501", 1890.95, "Gibson", "SG '61 Reissue", "electric", "Mahogany", "Mahogany");
        inventory.addGuitar("77023", 6275.95, "Martin", "D-28", "acoustic", "Brazilian Rosewood", "Adirondack");
        inventory.addGuitar("1092", 12995.95, "Olson", "SJ", "acoustic", "Indian Rosewood", "Cedar");
        inventory.addGuitar("566-62", 8999.95, "Ryan", "Cathedral", "acoustic", "Cocobolo", "Cedar");
        inventory.addGuitar("6 29584", 2100.95, "PRS", "Dave Navarro Signature", "electric", "Mahogany", "Maple");
    }
}
