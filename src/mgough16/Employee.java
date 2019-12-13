package mgough16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p> This Employee class is used for the employee tab in the UI and helps set the values to the
 * information that the user has entered. </p>
 *
 * @author Michael Gough
 * @version 3
 * @since 2019-11-30
 */
public class Employee {

  /**
   * Initialize String values that will be used throughout the program for Employee.
   */
  String name;
  String username;
  String password;
  String email;

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
      String[] fullName = name.split(" ");
      //String value to the first character of the first name and the characters of the last name
      String firstAndLastName = fullName[0].substring(0, 1) + toCapital(fullName[1]);
      //String value for the first name, and last name with a dot inbetween.. all lowercase
      String firstNameDotLastName = fullName[0].toLowerCase() + "." + fullName[1].toLowerCase();
      setUsername(
          firstAndLastName);  //Calls set username method and passes firstInitialLastName
      setEmail(firstNameDotLastName); //Calls the set email method and passes firstName.LastName
    } else {
      setUsername("default");
      setEmail("user");
    }

    //if statement for setting the password and calling isValidPassword
    if (isValidPassword(password)) {
      this.password = password;
    } else {
      this.password = "pw";
    }
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
   * Method for getting the user inputted userName.
   *
   * @return returns a String value of the name
   */
  public String getUsername() {
    return this.username;
  }

  /**
   * Method used to check the name that the user entered.
   *
   * @param name used to check the userName
   * @return returns a true or false value for the name being a valid format
   */
  private boolean checkName(String name) {
    /*
    * Uses regex to check the users input to see if it passes
    */
    String regex = ".+ .+";
    Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    Matcher matcher = pattern.matcher(name);
    return matcher.matches();
  }

  /**
   * <p> set the email field to the first name, then a period, then the last name (all lowercase)
   * followed by @oracleacademy.Test. </p>
   *
   * @param name String name used for the email
   */
  private void setEmail(String name) {
    /*
    * Sets the email with the value of the users name with an email type String at the end of it.
    */
    this.email = name + "@oracleacademy.Test";
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
   * Method for checking if the password is valid.. uses a regular expression to check the pattern.
   *
   * @param password accepts the string value for password
   * @return a boolean value of true or false if the password passed our regex
   */
  private boolean isValidPassword(String password) {
    /*
    * Regular expression used to test if the user password is valid
    */
    String regex = "^(?=.*[!@#$%^&*()\\-+=]+.*)(?=.*[A-Z]+.*)(?=.*[a-z]+.*)[\\x21-\\x7e]{3,}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(password);
    boolean found = matcher.find();
    return found;
  }

  /**
   * Method that is used to set the word to a capital and contain lower cases.
   *
   * @param word used to set the values to lower and uppercase
   * @return returns a String
   */
  private String toCapital(String word) {
    word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    return word;
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
