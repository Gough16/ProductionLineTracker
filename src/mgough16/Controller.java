package mgough16;

//Step 1: Import required packages

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
 * @version 2
 * @since 2019-11-30
 */
public class Controller {

  @FXML
  private TextField textFieldProductName;

  @FXML
  private TextField textFieldManufacturer;

  @FXML
  private ChoiceBox<ItemType> choiceBoxItemType;

  @FXML
  private TableView<Product> tableViewExistingProducts;

  @FXML
  private TableColumn<?, ?> colProductName;

  @FXML
  private TableColumn<?, ?> colProductManufacturer;

  @FXML
  private TableColumn<?, ?> colProductType;

  @FXML
  private ListView<Product> listViewProduce;

  @FXML
  private ComboBox<Integer> comboBoxChooseQuantity;

  @FXML
  private TextArea textAreaProductionLog;

  @FXML
  private TextField textProductionNum;

  @FXML
  private TextField textProductID;

  @FXML
  private TextField textSerialNum;

  @FXML
  private TextField textDateProduced;

  /**
   * <p> This method prints "added product" when the button Add Product is clicked It also
   * implements the initializeDB method It also adds products to the table view.  </p>
   */
  @FXML
  protected void handleAddProductButtonAction() {
    //Establish Database connection
    initializeDB();

    //Gets the text entered text from the user, and adds it to the table view
    Widget productAdded =
        new Widget(
            textFieldProductName.getText(), textFieldManufacturer.getText(),
            choiceBoxItemType.getValue());
    tableViewExistingProducts.getItems().add(productAdded);

    //Load product list called when "Add product button" is selected
//    loadProductList();

    //Print added product to the console when the button is pressed
    System.out.println("Added Product");

  }

  /**
   * This method adds items from the list view to the production Log when the production button is
   * pressed.
   */
  @FXML
  protected void handleRecordProductionButtonAction() {

    //Setting productProduced equal to the selected items in the listView
    Product productProduced = listViewProduce.getSelectionModel().getSelectedItem();
    int comboQuantity = comboBoxChooseQuantity.getSelectionModel().getSelectedIndex();

    //Number of Products produced
    int itemCount = 0;

    //For loop that adds to the text area increments the product count and appends
    //text to the textArea for the productionLog
    for (int productionRunProduct = 0;
        productionRunProduct <= comboQuantity;
        productionRunProduct++) {
      ProductionRecord pr = new ProductionRecord(productProduced, itemCount++);

      System.out.println(pr.toString());
      textAreaProductionLog.appendText(pr.toString());
      textAreaProductionLog.appendText("\n");
    }

    //Prints out "Product recorded" to the console
    System.out.println("Product Recorded");

    //Must call both of these methods when record production ids produced
//    loadProductionLog();
//    showProduction();

  }

  /**
   * This method initialized the database and connects to it The method will allow the addition of
   * products into the database.
   */
  @FXML
  private void initializeDB() {
    //Database driver and url
    final String Jdbc_Driver = "org.h2.Driver";
    final String DB_Url = "jdbc:h2:./resources/PLTDB";

    //    //Database credentials
    final String User = "";
    final String Pass = "";
    //try{
    // Properties prop = new Properties();
    //  prop.load(new FileInputStream("resources/properties"));
    //  PASS = prop.getProperty("password");

    //}catch (Exception ps){
    //  System.out.println(ps);
    //}

    try {
      //Step 2: Register JDBC driver
      Class.forName(Jdbc_Driver);

      //Step 3: Open a connection
      Connection conn = DriverManager.getConnection(DB_Url, User, Pass);

      //Step 4: Execute a query
      Statement stmt = conn.createStatement();

      String sql = "INSERT INTO Product (type, manufacturer, name)VALUES('AUDIO', 'Apple', 'iPod')";

      stmt.executeUpdate(sql);

      //Step 5: clean up the environment
      stmt.close();
      conn.close();

    } catch (ClassNotFoundException | SQLException e) {
      //Handle errors for JDBC
      e.printStackTrace();
    }

  }

  /**
   * At run time this method: adds values to the comboBox and allows it to be editable gets the Item
   * Type choices and put them to the choice box adds items from the Observable Array list to the
   * table view and list view.
   */
  public void initialize() {

    //Add items to the comboBox
    comboBoxChooseQuantity.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    //Set comboBox to editable
    comboBoxChooseQuantity.setEditable(true);

    //Set the value on the comboBox to the first quantity
    comboBoxChooseQuantity.getSelectionModel().selectFirst();

    //Add item types to the choice box
    for (ItemType itemTypeChoices : ItemType.values()) {
      choiceBoxItemType.getItems().add(itemTypeChoices);
    }

    //Call testMultimedia
    testMultimedia();

    //Creating an Observable list to hold the content of
    // Name, Manufacturer, and Type to the table view
    ObservableList<Product> data = productList();
    setupProductLineTable(data);

    //Calls the loadProductList method
    loadProductList(data);

    //Calls the loadProductionLog method
    loadProductionLog();

  }

  private void loadProductionLog() {
  }

  /**
   * This method demonstrates the functionality of the UI.
   */
  public static void testMultimedia() {
    AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",
        "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    Screen newScreen = new Screen("720x480", 40, 22);
    MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,
        MonitorType.LCD);
    ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();
    productList.add(newAudioProduct);
    productList.add(newMovieProduct);
    for (MultimediaControl p : productList) {
      System.out.println(p);
      p.play();
      p.stop();
      p.next();
      p.previous();
    }
  }

  /**
   * This method adds values from the observable array list to the list view.
   */
  private void loadProductList(ObservableList<Product> data) {
    //add data from the observable array list to the list view
    listViewProduce.setItems(data);
  }

  /**
   * This method adds values to the observable array list.
   */
  private ObservableList<Product> productList() {
    return FXCollections.observableArrayList(
        new Product("iPod", "Apple", ItemType.AUDIO),
        new Product("iPhone", "Apple", ItemType.AUDIO_MOBILE),
        new Product("AirPods", "Apple", ItemType.AUDIO)
    );
  }

  /**
   * This method sets the values of the observable array list to the column it also adds the items
   * to the table and list view.
   */
  private void setupProductLineTable(ObservableList<Product> data) {

    //set the sell value with the observable array list value
    colProductName.setCellValueFactory(new PropertyValueFactory<>("Name"));
    colProductManufacturer.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
    colProductType.setCellValueFactory(new PropertyValueFactory<>("Type"));

    //set the items from the observable array list to the table view
    tableViewExistingProducts.setItems(data);
  }

}

