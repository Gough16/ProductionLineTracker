package mgough16;
/**
 * This AudioPlayer class extends Product and implements MultimediaControl.
 *
 * @author Michael Gough
 * @version 2
 * @since 2019-11-30
 */
public class AudioPlayer extends Product implements MultimediaControl {

  /**
   * <p> Add Fields supportedAudioFormats and supportedPlaylistFormats
   * Code style creates a warning for the two to be "final" modifier but issue 2 doesnt require it.
   * </p>
   */
  private String supportedAudioFormats;
  private String supportedPlaylistFormats;

  /**
   * Default constructor for the AudioPlayer class.
   *
   * @param name                     accepts the String name
   * @param manufacturer             accepts the string manufacture
   * @param supportedAudioFormats    accepts the supportedAudioFormats String
   * @param supportedPlaylistFormats accepts the supportedPlaylistFormats
   */
  public AudioPlayer(int Id, String name, String manufacturer, String supportedAudioFormats,
      String supportedPlaylistFormats) {

    //Call the parent constructor
    super(Id, name, manufacturer, ItemType.AUDIO);
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;

  }

  /**
   * To string that returns the supported formats.
   */
  public String toString() {
    return super.toString() + "\n" + ("Supported Audio Formats: " + this.supportedAudioFormats
        + "\n" + "Supported Playlist Formats: " + this.supportedPlaylistFormats);
  }

  /**
   * <p>Implementing the play method from MultimediaControl interface
   * Prints "playing" to the screen. </p>
   */
  @Override
  public void play() {
    System.out.println("Playing");
  }

  /**
   * <p>Implementing the stop method from MultimediaControl interface
   * Prints "Stopping" to the screen. </p>
   */
  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  /**
   * <p>Implementing the next method from MultimediaControl interface
   * Prints "Next" to the screen. </p>
   */
  @Override
  public void next() {
    System.out.println("Next");
  }

  /**
   * <p>Implementing the previous method from MultimediaControl interface
   * Prints "Previous" to the screen. </p>
   */
  @Override
  public void previous() {
    System.out.println("Previous");
  }

}