package mGough16;

/**
 * This Movie Player class extends product and implements media control.
 *
 * @author Michael Gough
 * @version 2
 * @since 2019-11-30
 */

public class MoviePlayer extends Product implements MultimediaControl {

  //Movie Player fields
  private Screen screen;
  private MonitorType monitorType;
  private String resolution;
  private int refreshRate;
  private int responseTime;

  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
    this.screen = screen;
    this.monitorType = monitorType;

  }

  @Override
  public String toString() {
    return super.toString() + "\n" + (screen + "\n" + "Monitor Type: " + monitorType);
  }

  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  @Override
  public void next() {
    System.out.println("Next movie");
  }

  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

}
