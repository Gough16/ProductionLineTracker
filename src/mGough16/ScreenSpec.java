package mGough16;

/**
 * ScreenSpec interface holds the fields for resolution, refresh rate, and response time.
 *
 * @author Michael Gough
 * @version 2
 * @since 2019-11-30
 */
public interface ScreenSpec {

  //Issue 3 calls for methods to be public, code style creates a warning for these three methods
  public String getResolution();

  public int getRefreshRate();

  public int getResponseTime();


}
