package exo1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
  private List<Guitar> guitars;

  public Inventory() {
    guitars = new LinkedList<>();
  }

  public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
    //TODO
  }
  
  public Guitar getGuitar(String serialNumber) {
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = i.next();
      //TODO
    }
    return null;
  }
  
  public Guitar search(Guitar searchGuitar) {
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = i.next();
      // Ignore serial number since that's unique
      // Ignore price since that's unique
      String builder = searchGuitar.getBuilder();
      if ((builder != null) && (!builder.equals("")) &&
          (!builder.equals(guitar.getBuilder())))
        continue;
      String model = searchGuitar.getModel();
      //TODO
    //TODO return 
    }
    return null;
  }
  
}
