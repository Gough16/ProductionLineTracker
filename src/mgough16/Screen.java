package mgough16;

/**
 * Screen class implements the ScreenSpec and gets the resolution, refresh rate and response time.
 *
 * @author Michael Gough
 * @version 2
 * @since 2019-11-30
 */

public class Screen implements ScreenSpec {

  private String resolution;
  private int refreshRate;
  private int responseTime;

  Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  @Override
  public String getResolution() {
    return resolution;
  }

  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  @Override
  public int getResponseTime() {
    return responseTime;
  }

  public String toString() {
    return "Screen:" + "\n" + "Resolution: " + this.resolution + "\n" + "Refresh rate: "
        + this.refreshRate + "\n" + "Response time: " + this.responseTime;
  }

}
