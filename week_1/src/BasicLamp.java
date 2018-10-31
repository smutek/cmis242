/*
 * File: BasicLamp.java
 * Author: Jimmy Smutek
 * Date: October 28, 2018
 * Purpose: Create a BasicLamp Object
 */

import java.awt.Color;

public class BasicLamp implements Lamp {

  boolean lampPoweredOn;
  boolean lampPluggedIn;
  boolean lampHasFunctionalBulb;
  Color lampColor;

  /** Construct a default BasicLamp Object */
  BasicLamp() {
    lampPoweredOn = false;
    lampPluggedIn = false;
    lampHasFunctionalBulb = true;
    lampColor = Color.black;
  }

  /**
   * Construct a custom BasicLamp object
   *
   * @param lampPoweredOn boolean
   * @param lampPluggedIn boolean
   * @param lampHasFunctionalBulb boolean
   * @param lampColor Color
   */
  public BasicLamp(
      boolean lampPoweredOn,
      boolean lampPluggedIn,
      boolean lampHasFunctionalBulb,
      Color lampColor) {
    this.lampPoweredOn = lampPoweredOn;
    this.lampPluggedIn = lampPluggedIn;
    this.lampHasFunctionalBulb = lampHasFunctionalBulb;
    this.lampColor = lampColor;
  }
  /**
   * Get lampPoweredOn state
   *
   * @return boolean
   */
  @Override
  public boolean isLampPoweredOn() {
    return lampPoweredOn;
  }
  /**
   * Set lampPoweredOn sate
   *
   * @param lampPoweredOn boolean
   */
  @Override
  public void setLampPoweredOn(boolean lampPoweredOn) {
    this.lampPoweredOn = lampPoweredOn;
  }
  /**
   * Get lampPluggedIn state
   *
   * @return boolean
   */
  @Override
  public boolean isLampPluggedIn() {
    return lampPluggedIn;
  }
  /**
   * Set lampPluggedIn sate
   *
   * @param lampPluggedIn boolean
   */
  @Override
  public void setLampPluggedIn(boolean lampPluggedIn) {
    this.lampPluggedIn = lampPluggedIn;
  }
  /**
   * Get lampHasFunctionalBulb state
   *
   * @return boolean
   */
  @Override
  public boolean getLampHasFunctionalBulb() {
    return lampHasFunctionalBulb;
  }
  /**
   * Set lampHasFunctionalBulb sate
   *
   * @param lampHasFunctionalBulb boolean
   */
  @Override
  public void setLampHasFunctionalBulb(boolean lampHasFunctionalBulb) {
    this.lampHasFunctionalBulb = lampHasFunctionalBulb;
  }
  /**
   * Get lampColor state
   *
   * @return Color
   */
  @Override
  public Color getLampColor() {
    return lampColor;
  }
  /**
   * Set lampColor state
   *
   * @param lampColor Color
   */
  @Override
  public void setLampColor(Color lampColor) {
    this.lampColor = lampColor;
  }
  /**
   * Create String representation of BasicLamp Object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "BasicLamp{"
        + "lampPoweredOn="
        + lampPoweredOn
        + ", lampPluggedIn="
        + lampPluggedIn
        + ", lampHasFunctionalBulb="
        + lampHasFunctionalBulb
        + ", lampColor="
        + lampColor
        + '}';
  }
}
