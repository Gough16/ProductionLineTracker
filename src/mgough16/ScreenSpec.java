package mgough16;

/**
 * ScreenSpec interface holds the fields for resolution, refresh rate, and response time.
 *
 * @author Michael Gough
 * @version 3
 * @since 2019-11-30
 */
public interface ScreenSpec {

  /**
   * <p>Getter methods for resolution, Issue 3 creates a warning for
   * this method being public but it is required for the project. </p>
   *
   * @return
   */
  String getResolution();

  /**
   * <p>Getter methods for refresh rate, Issue 3 creates a warning for
   * this method being public but it is required for the project. </p>
   *
   * @return
   */
  int getRefreshRate();

  /**
   * <p>Getter methods for response time, Issue 3 creates a warning for
   * this method being public but it is required for the project. </p>
   *
   * @return
   */
  int getResponseTime();

}
