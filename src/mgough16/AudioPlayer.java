package mgough16;


/**
 * This AudioPlayer class extends Product and implements MultimediaControl.
 *
 * @author Michael Gough
 * @version 2
 * @since 2019-11-30
 */
public class AudioPlayer extends Product implements MultimediaControl {

  //Add Fields supportedAudioFormats and supportedPlaylistFormats
  //Code style creates a warning for the two to be "final" modifier but issue 2 doesnt require it
  private String supportedAudioFormats;
  private String supportedPlaylistFormats;

  /**
   * This overloaded constructor overrides the super constructor.
   */
  public AudioPlayer(String name, String manufacturer, String supportedAudioFormats,
      String supportedPlaylistFormats) {

    //Call the parent constructor
    super(name, manufacturer, ItemType.AUDIO);
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

  @Override
  public void play() {
    System.out.println("Playing");
  }

  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  @Override
  public void next() {
    System.out.println("Next");
  }

  @Override
  public void previous() {
    System.out.println("Previous");
  }

}