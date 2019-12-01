package mGough16;

/**
 * This Item interface class gets the items and sets them.
 *
 * @author Michael Gough
 * @version 2
 * @since 2019-11-30
 */
public interface Item {

  //Item class fields
  int getId();

  void setName(String name);

  String getName();

  void setManufacturer(String manufacturer);

  String getManufacturer();

}