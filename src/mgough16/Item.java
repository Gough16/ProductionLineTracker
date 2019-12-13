package mgough16;

/**
 * This Item interface class forces all classes to implement the functions inside of its class.
 *
 * @author Michael Gough
 * @version 3
 * @since 2019-12-8
 */
public interface Item {

  /**
   * This method gets the int value for ID.
   *
   * @return integer for ID
   */
  int getId();

  /**
   * This method sets the name for the item.
   *
   * @param name of the item
   */
  void setName(String name);

  /**
   * This method gets the name of the product.
   *
   * @return String for the name
   */
  String getName();

  /**
   * This method set the manufacturer name.
   *
   * @param manufacturer of the product
   */
  void setManufacturer(String manufacturer);

  /**
   * This method gets the name of the manufacturer.
   *
   * @return String value of the manufacturer
   */
  String getManufacturer();

}