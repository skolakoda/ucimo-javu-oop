package guitarshop2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
  private List guitars;

  public Inventory() {
    guitars = new LinkedList();
  }

  public void addGuitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood) {
    guitars.add(new Guitar(serialNumber, price, builder, model, type, backWood, topWood));
  }

  public Guitar getGuitar(String serialNumber) {
    Iterator i = guitars.iterator();
    while (i.hasNext()) {
	    Guitar guitar = (Guitar)i.next();
	    if (guitar.getSerialNumber().equals(serialNumber)) return guitar;
    }
    return null;
  }

  public List search(Guitar searchGuitar) {
    List matchingGuitars = new LinkedList();
    Iterator i = guitars.iterator(); 
    while (i.hasNext()) {
      Guitar guitar = (Guitar)i.next();
      // Ignore serial number and price since that's unique
      if (searchGuitar.getBuilder() != guitar.getBuilder()) continue;
      String model = searchGuitar.getModel().toLowerCase();
      if ((model != null) && (!model.equals("")) && (!model.equals(guitar.getModel().toLowerCase()))) continue;
      if (searchGuitar.getType() != guitar.getType()) continue;
      if (searchGuitar.getBackWood() != guitar.getBackWood()) continue;
      if (searchGuitar.getTopWood() != guitar.getTopWood()) continue;
      matchingGuitars.add(guitar);
    }   
    return matchingGuitars;
  }
}
