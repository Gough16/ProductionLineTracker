package mgough16;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the main class of the Production Line Tracker Program.
 *
 * @author Michael Gough
 * @version 1
 * @since 2019-10-07
 */

public class Main extends Application {
  //Inspection analysis for quality in your code:
  //Analyze inspect code, if no suspects found then that
  //Is a good sign that we have done the right thing
  //file, settings, plugins, find bugs... if 0 bugs then we
  //are in good work
  //control,alt,l to check for style guide

  /**
   * This is where the Javafx program starts.
   *
   * @param primaryStage stage object primaryStage.
   * @throws Exception throws an exception on input error.
   */

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Production Line Tracker");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }

  /**
   * This is the main method for the program.
   *
   * @param args this parameter is not used in the program.
   */
  public static void main(String[] args) {
    launch(args);
  }

}