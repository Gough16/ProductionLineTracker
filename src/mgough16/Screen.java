package mgough16;

/**
 * Screen class implements the ScreenSpec and gets the resolution, refresh rate and response time.
 *
 * @author Michael Gough
 * @version 2
 * @since 2019-11-30
 */
public class Screen implements ScreenSpec {

  /**
   * Initializing private fields for the Screen class.
   */
  private String resolution;
  private int refreshRate;
  private int responseTime;

  /**
   * Constructor for class Screen that sets the resolution, refreshRate and responseTime.
   *
   * @param resolution   accepts String for the resolution of the screen
   * @param refreshRate  accepts int for the refreshRate of the screen
   * @param responseTime accepts int for the responseTime of the screen
   */
  Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  /**
   * Method getResolution that gets the inputted resolution.
   *
   * @return String value of the Screens resolution
   */
  @Override
  public String getResolution() {
    return resolution;
  }

  /**
   * Method getRefreshRate that get the inputted refreshRate.
   *
   * @return int value of the Screens refreshRate
   */
  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  /**
   * Method getResponseTime that gets the inputted response time of the screen.
   *
   * @return int value for the Screens responseTime
   */
  @Override
  public int getResponseTime() {
    return responseTime;
  }

  /**
   * toString that prints a string for the resolution, refreshRate, and responseTime.
   *
   * @return String value for the screen
   */
  public String toString() {
    return "Screen:" + "\n" + "Resolution: " + this.resolution + "\n" + "Refresh rate: "
        + this.refreshRate + "\n" + "Response time: " + this.responseTime;
  }

}
