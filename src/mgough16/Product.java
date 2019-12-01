package mgough16;

/**
 * Product Class has fields, constructor, and methods to get the product entered by the user.
 *
 * @author Michael Gough
 * @version 2
 * @since 2019-11-30
 */

public class Product implements Item {

  private int Id;
  private ItemType Type;
  private String Manufacturer;
  private String Name;

  Product(String name, String manufacturer, ItemType type) {
    this.Name = name;
    this.Manufacturer = manufacturer;
    this.Type = type;
  }

  //toString to print the name, manufacturer, and type
  public String toString() {
    return "Name: " + Name + "\n" + "Manufacturer: " + Manufacturer + "\n" + "Type: "
        + Type;
  }

  public int getId() {
    return Id;
  }

  public String getManufacturer() {
    return Manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    Manufacturer = manufacturer;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public ItemType getType() {
    return Type;
  }

  public void setType(ItemType type) {
    Type = type;
  }

}



