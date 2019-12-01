package mGough16;

/**
 * This ItemType Enum stores the information for each itemType that gets used by our choice box
 *
 * @author Michael Gough
 * @version 2
 * @since 2019-11-30
 */

public enum ItemType {

  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

  public String code;

  ItemType(String code) {
    this.code = code;
  }


}