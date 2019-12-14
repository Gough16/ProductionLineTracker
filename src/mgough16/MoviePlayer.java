package mgough16;

/**
 * This Movie Player class extends product and implements media control.
 *
 * @author Michael Gough
 * @version 3
 * @since 2019-11-30
 */
public class MoviePlayer extends Product implements MultimediaControl {

  /**
   * Initializing the fields for the MoviePlayer class.
   */
  private Screen screen;
  private MonitorType monitorType;
  private String resolution;
  private int refreshRate;
  private int responseTime;

  /**
   * This MoviePlayer constructor sets the itemType to Visual.
   *
   * @param name         accepts the name
   * @param manufacturer accepts the manufacturer
   * @param screen       accepts the screen
   * @param monitorType  accepts the monitorType
   */
  public MoviePlayer(int Id, String name, String manufacturer, Screen screen,
      MonitorType monitorType) {
    super(Id, name, manufacturer, ItemType.VISUAL);

     // find bugs marks this as unused fields, but we are required
     // to have them by the sprint guidelines for the replit test (performance and correctness)
     //
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
    this.screen = screen;
    this.monitorType = monitorType;

  }

  /**
   * A toString that returns the screen and monitorType.
   */
  @Override
  public String toString() {
    return super.toString() + "\n" + (screen + "\n" + "Monitor Type: " + monitorType);
  }

  /**
   * <p> Implementing the play method from MultimediaControl interface
   * Prints "Playing movie" to the screen. </p>
   */
  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  /**
   * <p>Implementing the stop method from MultimediaControl interface
   * Prints "Stopping movie" to the screen. </p>
   */
  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  /**
   * <p>Implementing the next method from MultimediaControl interface
   * Prints "Next movie" to the screen. </p>
   */
  @Override
  public void next() {
    System.out.println("Next movie");
  }

  /**
   * <p>Implementing the previous method from MultimediaControl interface
   * Prints "Previous movie" to the screen. </p>
   */
  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

}
