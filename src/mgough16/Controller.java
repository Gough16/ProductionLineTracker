package mgough16;

//Step 1: Import required packages

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This controller class implements the program.
 *
 * @author Michael Gough
 * @version 3
 * @since 2019-11-30
 */
public class Controller {

  /**
   * Initializing FXML text field for productName
   */
  @FXML
  private TextField textFieldProductName;

  /**
   * Initializing FXML text field for productManufacturer
   */
  @FXML
  private TextField textFieldManufacturer;

  /**
   * Initializing FXML choiceBox for ItemType
   */
  @FXML
  private ChoiceBox<ItemType> choiceBoxItemType;

  /**
   * Initializing FXML TableView for product line
   */
  @FXML
  private TableView<Product> tableViewExistingProducts;

  /**
   * Initializing FXML Table column for product name that will have the product name
   */
  @FXML
  private TableColumn<?, ?> colProductName;

  /**
   * Initializing FXML Table column product manufacturer that will have the name of the
   * manufacturer
   */
  @FXML
  private TableColumn<?, ?> colProductManufacturer;

  /**
   * Initializing FXML Table column for product type that will have the types displayed in it
   */
  @FXML
  private TableColumn<?, ?> colProductType;

  /**
   * Initializing the FXML ListView for produce that hold the products that have been produced
   */
  @FXML
  private ListView<Product> listViewProduce;

  /**
   * Initializing FXML comboBox that has the values for the number of products that can be produced
   */
  @FXML
  private ComboBox<Integer> comboBoxChooseQuantity;

  /**
   * Initializing FXML text area for the production log tab that will store the toString from the
   * ProductionRecord class and show the production record of the products that have been produced
   */
  @FXML
  private TextArea textAreaProductionLog;

  /**
   * Initializing FXML text field for employeeName
   */
  @FXML
  private TextField textFieldEmployeeName;

  /**
   * Initializing FXML text field for employeePassword
   */
  @FXML
  private TextField textFieldEmployeePassword;

  /**
   * Initializing FXML listView for employee info
   */
  @FXML
  private ListView<Employee> listViewEmployeeInfo;

  private Connection conn;
  private String pLQuery;
  private PreparedStatement stmt;
  private ResultSet result;

  /**
   * Declaring ObservableList.
   */
  private ObservableList<Product> products;
  private ObservableList<ProductionRecord> records;

  /**
   * <p> At run time this method: adds values to the comboBox and allows it to be editable gets the
   * Item Type choices and put them to the choice box adds items from the Observable Array list to
   * the table view and list view. </p>
   */
  public void initialize() throws SQLException {

    // Call the initializeDB method at the beginning of the program
    initializeDB();

    // Add items to the comboBox at the start of the program
    comboBoxChooseQuantity.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // Set comboBox to editable
    comboBoxChooseQuantity.setEditable(true);

    // Set the value on the comboBox to the first quantity
    comboBoxChooseQuantity.getSelectionModel().selectFirst();

    //Add item types to the choice box at the start of the program
    for (ItemType itemTypeChoices : ItemType.values()) {
      choiceBoxItemType.getItems().add(itemTypeChoices);
    }

    // Defining the observable list
    products = FXCollections.observableArrayList(loadProductList(products));
    records = FXCollections.observableArrayList(loadProductionLog(records));

    //Call testMultimedia method
    //   testMultimedia();

    //Name, Manufacturer, and Type to the table view
    setupProductLineTable(products);

    //Calls the loadProductList method
    loadProductList(products);

    //Calls the loadProductionLog method
    loadProductionLog(records);

    // Close the DB after making the connection and calling method to load values
    closeDB();

  }


  /**
   * <p>This method initializes the database and connects to it. This method will also set the
   * username and password for the db</p>
   */
  @FXML
  private void initializeDB() {
    try {

      // Database driver and url
      final String Jdbc_Driver = "org.h2.Driver";

      // Register JDBC driver
      Class.forName(Jdbc_Driver);

      // Database Url
      final String Db_Url = "jdbc:h2:./resources/PLTDB";

      // Database credentials
      final String User = "";
      final String Pass = "";
      //try{
      // Properties prop = new Properties();
      //  prop.load(new FileInputStream("resources/properties"));
      //  Pass = prop.getProperty("password");

      //}catch (Exception ps){
      //  System.out.println(ps);
      //}

      // Open a connection with the DB
      conn = DriverManager.getConnection(Db_Url, User, Pass);

    } catch (ClassNotFoundException | SQLException e) {
      // Handle errors for JDBC
      e.printStackTrace();
    }

  }

  /**
   * This method closes the DataBase.
   */
  private void closeDB() {
    try {

      // clean up the environment
      result.close();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * <p> This method prints "added product" when the button "Add Product" is clicked. It also
   * implements the initializeDB method. It also adds products to the table view, and calls
   * addProducts method to add user input values to the db.  </p>
   */
  @FXML
  protected void handleAddProductButtonAction() throws SQLException {

    // Calls initialize DB method to make a connection with the DB so products can be added
    initializeDB();

    //Test the fields in the product line tab to make sure they have a value before entering
    // information into the DB
    if (textFieldProductName.getText().equals("") || textFieldManufacturer.getText()
        .equals("")) {
      Alert error = new Alert(AlertType.WARNING);
      error.setAlertType(AlertType.WARNING);
      //Display an error message to the user for error handling
      error.setContentText("Enter in valid product description");
      error.show(); //Show error
    } else {

      //Initialize the ID value at 0
      int Id = 0;
      // Gets the text and values for product name, manufacturer and type
      String name = textFieldProductName.getText();
      String manufacturer = textFieldManufacturer.getText();
      ItemType type = choiceBoxItemType.getValue();
      Widget product = new Widget(Id, name, manufacturer, type);

      // Calls addProducts method to insert products into the db
      addProductDB(name, manufacturer, type);

      // Add products to the tableView
      tableViewExistingProducts.getItems().add(product);

      // Load product list called when "Add product button" is selected
      loadProductList(products);

      // Prints added product to the console when the button is pressed
      System.out.println("Added Product");

    }


  }

  /**
   * This method adds items from the list view to the production Log when the production button is
   * pressed.
   */
  @FXML
  protected void handleRecordProductionButtonAction() throws SQLException {

    //Throws an error to the user if they haven't selected an item that
    // needs to be produced from the listView
    if (listViewProduce.getSelectionModel().isEmpty() || comboBoxChooseQuantity.getSelectionModel()
        .isEmpty()) {
      Alert error = new Alert(AlertType.WARNING);
      error.setAlertType(AlertType.WARNING);
      //Display an error message to the user for error handling
      error.setContentText("Select a product to produce");
      error.show(); //Show error
    } else {

      //Item count that gets incremented in our array list for serial number
      int itemCount = 0;
      //Get the ID of the product
      Integer productID = listViewProduce.getSelectionModel().getSelectedItem().getId();
      //Gets the product from the list view selection
      Product productProduced = listViewProduce.getSelectionModel().getSelectedItem();
      // Get the selection from the comboBox in the produce tab to use in the for loop
      int comboQuantity = comboBoxChooseQuantity.getSelectionModel().getSelectedIndex();

      // For loop that adds to the text area increments the product count and appends
      // text to the textArea for the productionLog
      for (int productionRunProduct = 0;
          productionRunProduct <= comboQuantity;
          productionRunProduct++) {

        //An array list named productionRun that calls the loadProductionLog
        ArrayList<ProductionRecord> productionRun = new ArrayList<>(loadProductionLog(records));

        //Increments the serial number by one each time a product is added
        String serialNum =
            productProduced.getManufacturer().substring(0, 3) + productProduced.getType().code
                + String
                .format("%05d", itemCount);

        //Takes into account that the array list might have zero values
        if (productionRun.size() == 0) {
          int prodNum = 1;
          ProductionRecord prodRec = new ProductionRecord(productProduced, itemCount++, prodNum++);
          productionRun.add(prodRec);
          addToProductionRecordDB(productID, serialNum);
        } else {
          int prodNum = productionRun.get(productionRun.size() - 1).getProductionNum();
          ProductionRecord pr = new ProductionRecord(productProduced, itemCount++, prodNum++);
          productionRun.add(pr);
          addToProductionRecordDB(productID, serialNum);
        }
        // Prints out "Product recorded" to the console
        System.out.println("Product Recorded");
        // Must call both of these methods when record production ids produced
        loadProductionLog(records);
      }

    }


  }

  /**
   * <p> handleEmployeeMethod that gets the employee information and displays it to the listView.
   * We implement this method by using the UI and the Employee class to get the users information
   * and set it to lowercase, a password, and an email. This information gets printed to a listView
   * by using the toString from the Employee class. </p>
   */
  @FXML
  public void handleAddEmployeeButton() {

    //If/else loop that test the user input for error handling
    if (textFieldEmployeeName.getText().equals("") || textFieldEmployeePassword.getText()
        .equals("")) {
      Alert error = new Alert(AlertType.WARNING);
      error.setAlertType(AlertType.WARNING);
      //Display an error message to the user when the textFields aren't filled
      error.setContentText("Enter in user information");
      error.show();
    } else {
      //Gets the entered information from the user
      Employee employeeInformation = new Employee(textFieldEmployeeName.getText(),
          textFieldEmployeePassword.getText());

      //Displays the employee entered information to the screen
      listViewEmployeeInfo.getItems().add(employeeInformation);
    }


  }

  /**
   * <p>This method Inserts values (name, manufacturer and ItemType) into the DB, and gets called
   * from the "HandleAddProductButtonAction" when the user inputs a product and clicks the button.
   * </p>
   *
   * @param name         takes in the String name from the user input value
   * @param manufacturer takes in the String manufacturer from the user input value
   * @param type         takes in the ItemType that gets selected from the choiceBox
   */
  private void addProductDB(String name, String manufacturer, ItemType type) {

    //InitializeDB when a product is added
    initializeDB();

    //Array of strings named product line that holds the name, manufacturer, and type
    String[] productLine = {name, manufacturer, String.valueOf(type)};

    int index = 1;
    try {
      //Query to insert the product into the DB tables
      pLQuery = "INSERT INTO PRODUCT(NAME, MANUFACTURER, TYPE) VALUES(?, ?, ?)";
      stmt = conn.prepareStatement(pLQuery);
      for (String prod : productLine) {
        stmt.setString(index, prod);
        index++;
      }
      //Execute update
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    closeDB();
  }

  /**
   * This method gets the products produced and inserts the values into the ProductionRecord DB.
   *
   * @param ID        Value ID for the product that is produced
   * @param serialNum serial number for the product produced that contains the manufacturer name,
   *                  type, and number of products produced
   */
  private void addToProductionRecordDB(int ID, String serialNum) {
    //InitializeDB when recording Products
    initializeDB();
    try {
      Date now = new Date();
      //Uses the timestamp object for the date
      Timestamp ts = new Timestamp(now.getTime());

      // Insert products into the ProductionRecord Db based on values from the selected list view
      pLQuery = "INSERT INTO PRODUCTIONRECORD(PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED) VALUES(?, ?, ?)";
      stmt = conn.prepareStatement(pLQuery);

      // Set the values into the index of the DB
      stmt.setInt(1, ID);
      stmt.setString(2, serialNum);
      stmt.setTimestamp(3, ts);

      // execute update
      stmt.executeUpdate();

      // Add catch
    } catch (Exception e) {
      e.printStackTrace();
    } finally {

      // Close DB
      closeDB();
    }
  }

  /**
   * <p> This method is used to load the product list from the Product DB. We select the items from
   * the index in the array and assign them to objects. We then add those objects into the
   * ObservableList and set the items to the list view and tableView </p>
   *
   * @param products takes in the observable array list
   * @return the product line that contains the values that get selected from the DB
   * @throws SQLException sql statement exception
   */
  private ObservableList<Product> loadProductList(ObservableList<Product> products)
      throws SQLException {

    // Call initializeDB method
    initializeDB();

    // Add product objects to this productLine observable arrayList
    ObservableList<Product> productLine = FXCollections.observableArrayList();

    // Query to select values from the product DB
    pLQuery = "SELECT * FROM PRODUCT";
    stmt = conn.prepareStatement(pLQuery);
    result = stmt.executeQuery();

    //While loop that gets the items from the DB column index and assigns them to objects
    while (result.next()) {

      //These lines correspond to the DB table columns
      int Id = result.getInt(1);
      String name = result.getString(2);
      String type = result.getString(3);
      String manufacturer = result.getString(4);
      Product productObj = new Product(Id, name, manufacturer, ItemType.valueOf(type));

      //Adding the productObj to the productLine observable arrayList
      productLine.add(productObj);
    }

    //Setting the items from the  Product db into the listView UI
    listViewProduce.setItems(products);

    //Return product line to the observable array list
    return productLine;

  }


  /**
   * <p> This method will load the production items from the ProductionRecord DB. We get the items
   * from the DB and append them to the text area. </p>
   *
   * @param records for the observableList ProductionRecord
   * @return the values of the ObservableList for the ProductionRecord
   * @throws SQLException sql statement exception
   */
  private ObservableList<ProductionRecord> loadProductionLog(
      ObservableList<ProductionRecord> records) throws SQLException {

    //Initialize the DB
    initializeDB();

    //Add productionRecord products to the observableList record List
    ObservableList<ProductionRecord> recordList = FXCollections.observableArrayList();

    //Select values from the ProductionRecord DB
    pLQuery = "SELECT * FROM PRODUCTIONRECORD";
    stmt = conn.prepareStatement(pLQuery);
    result = stmt.executeQuery();

    //While loop the gets values that are stored in the DB col
    while (result.next()) {

      //Selecting values from the database and adding them to the objects
      int prodNum = result.getInt(1);
      int productID = result.getInt(2);
      String serialNum = result.getString(3);
      Timestamp dateProd = result.getTimestamp(4);
      //Add items selected from the database into the observable array list
      recordList.add(new ProductionRecord(prodNum, productID, serialNum, dateProd));
    }

    //Call the showProduction method
    showProduction(recordList);
    return recordList;
  }

  /**
   * <p> This method is use to showProduction to the text area. We do so by passing the
   * ObservableList
   * of ProductionRecord items into the parameters. we then loop the the List and append the text of
   * the items to the text area to display the ProductionRecord. </p>
   *
   * @param recordList for the array list values
   */
  private void showProduction(ObservableList<ProductionRecord> recordList) {

    //Initialize Db values for the text area
    initializeDB();

    //Clear the text area before appending values to it
    textAreaProductionLog.clear();

    //For loop that prints to the productionLog to the text area and appends the text

    for (ProductionRecord objects : recordList) {
      //Append text to the textArea
      textAreaProductionLog.appendText(objects.toString());
    }

  }

  /**
   * <p>This method sets the values of the observable array list to the column it also adds the
   * items to the table and list view. </p>
   *
   * @param products Takes observable list products
   */
  private void setupProductLineTable(ObservableList<Product> products) {

    // Set the sell value with the observable array list value
    colProductName.setCellValueFactory(new PropertyValueFactory<>("Name"));
    colProductManufacturer.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
    colProductType.setCellValueFactory(new PropertyValueFactory<>("Type"));

    // Set the items from the observable array list to the table view
    tableViewExistingProducts.setItems(products);
  }

//  /**
//   * This method demonstrates the functionality of the UI, required part of Week 8, issue 3.
//   */
//  private static void testMultimedia() {
//    AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",
//        "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
//    Screen newScreen = new Screen("720x480", 40, 22);
//    MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,
//        MonitorType.LCD);
//    //"New ArrayList <MultimediaControl>" creates a warning, but is sample code in the project
//    ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();
//    productList.add(newAudioProduct);
//    productList.add(newMovieProduct);
//    for (MultimediaControl p : productList) {
//      System.out.println(p);
//      p.play();
//      p.stop();
//      p.next();
//      p.previous();
//    }
//  }

}

