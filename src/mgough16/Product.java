package mgough16;

/**
 * Product Class has fields, constructor, and methods to get the product entered by the user.
 *
 * @author Michael Gough
 * @version 3
 * @since 2019-11-30
 */
public class Product implements Item {

  /**
   * Initialize the fields: ID, Type, Manufacturer, and Name for the Product class.
   */
  private int Id;
  private ItemType Type;
  private String Manufacturer;
  private String Name;

  /**
   * Product class constructor that.
   *
   * @param name         accepts String name
   * @param manufacturer accepts String manufacturer
   * @param type         accepts String type
   */
  Product(int Id, String name, String manufacturer, ItemType type) {
    this.Id = Id;
    this.Name = name;
    this.Manufacturer = manufacturer;
    this.Type = type;
  }

  /**
   * toString  that will return a string of the product entered by the user.
   *
   * @return String with the name, manufacturer, and type of product
   */
  public String toString() {
    return "Name: " + Name + "\n" + "Manufacturer: " + Manufacturer + "\n" + "Type: "
        + Type;
  }

  /**
   * Method getID that gets the products ID.
   *
   * @return integer value of the ID
   */
  public int getId() {
    return Id;
  }

  /**
   * Method getManufacturer that gets the products manufacturer.
   *
   * @return String value of the manufacturer
   */
  public String getManufacturer() {
    return Manufacturer;
  }

  /**
   * Method that sets the manufacturer of the product.
   *
   * @param manufacturer of the product
   */
  public void setManufacturer(String manufacturer) {
    Manufacturer = manufacturer;
  }

  /**
   * Method that gets the name of the product.
   *
   * @return String value of the products name
   */
  public String getName() {
    return Name;
  }

  /**
   * Method that sets the name value of the product.
   *
   * @param name of the item
   */
  public void setName(String name) {
    Name = name;
  }

  /**
   * Method that gets the itemType of the product.
   *
   * @return ItemType
   */
  public ItemType getType() {
    return Type;
  }

  /**
   * Method that sets the ItemType of the product.
   *
   * @param type of the item
   */
  public void setType(ItemType type) {
    Type = type;
  }

}



