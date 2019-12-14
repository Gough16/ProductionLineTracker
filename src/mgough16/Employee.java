package mgough16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p> This Employee class is used for the employee tab in the UI and helps set the values to the
 * information that the user has entered. </p>
 *
 * @author Michael Gough
 * @version 3
 * @since 2019-12-13
 */
public class Employee {

  /**
   * Initialize String values that will be used throughout the program for Employee.
   */
  private final String name;
  private final String password;
  private String username;
  private String email;

  /**
   * Employee class constructor sets the name that is used for the username and password values.
   *
   * @param name     for the user name they enter
   * @param password for verifying the user password
   */
  Employee(String name, String password) {
    this.name = name;
    //Call checkName to see if the name contains spaces
    if (checkName(name)) {
      String[] enteredName = name.split(" ");

      //String value to the first character of the first name and the characters of the last name
      String firstAndLastName = enteredName[0].substring(0, 1) + toCapital(enteredName[1]);

      //String value for the first name, and last name with a dot in between.. all lowercase
      String firstNameDotLastName = enteredName[0].toLowerCase() + "." + enteredName[1].toLowerCase();

      //Calls set username method and passes firstInitialLastName
      setUsername(firstAndLastName);

      //Calls the set email method and passes firstName.LastName
      setEmail(firstNameDotLastName);
    } else {
      //if the user name and password entered by the user are not in the correct format, they will
      //be given a default userName and password
      setUsername("user1");
      setEmail("email1");
    }

    //if statement for setting the password and calling isValidPassword
    if (isValidPassword(password)) {
      //Set the password when the password is valid
      this.password = password;
    } else {
      //Set the password field to pw
      this.password = "pw";
    }
  }

  /**
   * Method for getting the user inputted userName.
   *
   * @return returns a String value of the name
   */
  public String getUsername() {
    return this.username;
  }

  /**
   * setUserName method that will set the username to the name (first initial and last name).
   *
   * @param name setting the user name
   */
  private void setUsername(String name) {
    this.username = name;
  }

  /**
   * Method used to check the name that the user entered.
   *
   * @param name used to check the userName
   * @return returns a true or false value for the name being a valid format
   */
  private boolean checkName(String name) {

    // Uses regex to check the users input to see if it passes
    String regularExpression = ".+ .+";
    //Check the pattern of our regularExpression
    Pattern pattern = Pattern.compile(regularExpression, Pattern.MULTILINE);
    Matcher match = pattern.matcher(name);
    return match.matches();
  }

  /**
   * Method for getting the Email.
   *
   * @return returns a String associated with the email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * <p> set the email field to the first name, then a period, then the last name (all lowercase)
   * followed by @oracleacademy.Test. </p>
   *
   * @param name String name used for the email
   */
  private void setEmail(String name) {
    // Sets the email with the value of the users name with an email type String at the end of it.
    this.email = name + "@oracleacademy.Test";
  }

  /**
   * Method for checking if the password is valid.. uses a regular expression to check the pattern.
   *
   * @param password accepts the string value for password
   * @return a boolean value of true or false if the password passed our regex
   */
  private boolean isValidPassword(String password) {
    // Regular expression used to test if the user password is valid
    String regularExpression = "^(?=.*[!@#$%^&*()\\-+=]+.*)(?=.*[A-Z]+.*)(?=.*[a-z]+.*)[\\x21-\\x7e]{3,}$";
    //Checks the pattern of the regular expression
    Pattern pattern = Pattern.compile(regularExpression);
    Matcher match = pattern.matcher(password);
    boolean validPassword = match.find();
    return validPassword;
  }

  /**
   * Method that is used to set the word to a capital and contain lower cases.
   *
   * @param character used to set the values to lower and uppercase
   * @return returns a String
   */
  private String toCapital(String character) {
    character = character.substring(0, 1).toUpperCase() + character.substring(1).toLowerCase();
    return character;
  }

  /**
   * toString to return a string containing the name, username, email and password.
   *
   * @return string that has the String fields from this class
   */
  public String toString() {
    return "Employee Details : " + "\n" + "Name : " + name + "\n" + "Username : " + username
        .toLowerCase() + "\n" + "Email : " + email + "\n" + "Initial Password : " + password;
  }

}
