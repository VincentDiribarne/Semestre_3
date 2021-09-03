package exo5;

import java.util.List;

public class FindGuitarTester {

	public static void main(String[] args) {
		// Set up Rick's guitar inventory
		//TODO:
	}

	public static void initializeInventory(Inventory inventory) {
        inventory.addInstrument(new Guitar("11277", 3999.95,
                new GuitarSpec(Builder.COLLINGS, "CJ", 6, Type.ACOUSTIC, Wood.INDIAN_ROSEWOOD, Wood.SITKA)));
      inventory.addInstrument(new Mandolin("V95693", 1499.95,
                new MandolinSpec(Builder.FENDER, "Stratocastor", Style.A, Type.ELECTRIC, Wood.ALDER, Wood.ALDER)));
      inventory.addInstrument(new Guitar("V9512", 1549.95,
                new GuitarSpec(Builder.FENDER, "Stratocastor", 6, Type.ELECTRIC, Wood.ALDER, Wood.ALDER)));
      inventory.addInstrument(new Guitar("122784", 5495.95,
                new GuitarSpec(Builder.MARTIN, "D-18", 6, Type.ACOUSTIC, Wood.MAHOGANY, Wood.ADIRONDACK)));
      inventory.addInstrument(new Guitar("76531", 6295.95,
                new GuitarSpec(Builder.MARTIN, "OM-28", 6, Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK)));
      inventory.addInstrument(new Guitar("70108276", 2295.95,
                new GuitarSpec(Builder.GIBSON, "Les Paul", 6, Type.ELECTRIC, Wood.MAHOGANY, Wood.MAHOGANY)));
      inventory.addInstrument(new Guitar("82765501", 1890.95,
                new GuitarSpec(Builder.GIBSON, "SG '61 Reissue", 6, Type.ELECTRIC, Wood.MAHOGANY, Wood.MAHOGANY)));
      inventory.addInstrument(new Mandolin("77023", 6275.95,
                new MandolinSpec(Builder.MARTIN, "D-28", Style.A, Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK)));
      inventory.addInstrument(new Guitar("1092", 12995.95,
                new GuitarSpec(Builder.OLSON, "SJ", 12, Type.ACOUSTIC, Wood.INDIAN_ROSEWOOD, Wood.CEDAR)));
      inventory.addInstrument(new Guitar("566-62", 8999.95,
                new GuitarSpec(Builder.RYAN, "Cathedral", 12, Type.ACOUSTIC, Wood.COCOBOLO, Wood.CEDAR)));
      inventory.addInstrument(new Mandolin("6 29584", 2100.95,
                new MandolinSpec(Builder.PRS, "Dave Navarro Signature", Style.F, Type.ELECTRIC, Wood.MAHOGANY, Wood.MAPLE)));
	}

}
