package mGough16;

import java.util.Date;

/**
 * This ProductionRecord Class gets the information from the user sets it to the production record
 * information
 *
 * @author Michael Gough
 * @version 2
 * @since 2019-11-30
 */

public class ProductionRecord {

  //private fields for the production record products
  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced;

  ProductionRecord(int productID) {
    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  ProductionRecord(int productionNumber, int productID, String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  ProductionRecord(Product productProduced, int itemCount) {
    serialNumber =
        productProduced.getManufacturer().substring(0, 3) + productProduced.getType().code + String
            .format("%05d", itemCount);
    dateProduced = new Date();

  }

  /**
   * This method gets the production number and returns it
   *
   * @return product number
   */
  public int getProductionNum() {
    return productionNumber;
  }

  /**
   * This method sets the production number
   *
   * @param productionNumber the production Number
   */
  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  /**
   * This method gets the production number and returns it
   *
   * @return product ID
   */
  public int getProductID() {
    return productID;
  }

  /**
   * This method sets the production ID
   *
   * @param productID the product ID
   */
  public void setProductID(int productID) {
    this.productID = productID;
  }

  /**
   * This method gets the production number and returns it
   *
   * @return product number
   */
  public String getSerialNum() {
    return serialNumber;
  }

  /**
   * This method sets the serial Number
   *
   * @param serialNumber the Serial Number
   */
  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * This method gets the production Date and returns it
   *
   * @return the date produced
   */
  public Date getProdDate() {
    return dateProduced;
  }

  /**
   * This method sets the product Date
   *
   * @param dateProduced the date produced
   */
  public void setProdDate(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  /**
   * This method returns a string with the productNumber, productID, serialNumber, and dateProduced
   *
   * @return the toString with the value related to the product
   */
  @Override
  public String toString() {
    return "Prod. Num: " + productionNumber + " Product ID: " + productID + " Serial Num: "
        + serialNumber + " Date: " + dateProduced;
  }

}