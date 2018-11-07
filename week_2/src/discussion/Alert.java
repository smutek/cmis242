package discussion;
/*
 * File: Alert.java
 * Author: Jimmy Smutek
 * Date: November 04, 2018
 * Purpose: Create an Alert subclass of the Message superclass
 *
 * Description: The Alert subclass extends the Message superclass concept by adding new fields
 * and functionality to set a severity level and automatically trigger a flag if the severity
 * level exceeds a set threshold.
 *
 * The FLAG_LEVEL constant provides the threshold against which the severity level is compared.
 * A messageIsFlagged() method evaulates the severity and returns the result of evaluating
 * severity >= FLAG_LEVEL
 */
public class Alert extends Message {
  // Messages above this threshold are flagged
  private static final byte FLAG_LEVEL = 7;
  // An Alert includes a severity level (byte 0-9), and a flagged status (boolean)
  private byte severity;
  private boolean flagged;
  /** Default Constructor */
  Alert() {
    severity = 0;
    flagged = false;
  }
  /**
   * Constructor
   *
   * @param title String
   * @param body String
   * @param severity byte
   */
  Alert(String title, String body, byte severity) {
    // Inherit title and body from superclass
    super(title, body);
    // add panic level
    this.severity = severity;
    // set flagged status
    this.flagged = messageIsFlagged(severity);
  }
  /**
   * Evaluate and return message is flagged status
   *
   * @param alertLevel int
   * @return boolean Flagged status
   */
  private boolean messageIsFlagged(byte alertLevel) {
    // Take alert level byte as input
    // If input greater than or equal to FLAG_LEVEL
    // return true else return false
    return alertLevel >= FLAG_LEVEL;
  }
  /**
   * Get severity
   *
   * @return byte Severity level
   */
  int getSeverity() {
    return severity;
  }
  /**
   * Set severity level
   *
   * @param severity byte
   */
  void setSeverity(byte severity) {
    this.severity = severity;
    setFlagged(this.severity);
  }
  /**
   * Get the currently set flagged status
   *
   * @return boolean Flagged status
   */
  boolean isFlagged() {
    return flagged;
  }
  /**
   * Set flagged status based on current severity level
   *
   * @param severityLevel byte
   */
  private void setFlagged(byte severityLevel) {
    this.flagged = severityLevel >= FLAG_LEVEL;
  }
  /**
   * To String method
   *
   * @return
   */
  @Override
  public String toString() {
    return "Alert{" + "severity=" + severity + ", " + super.toString() + '}';
  }
}
