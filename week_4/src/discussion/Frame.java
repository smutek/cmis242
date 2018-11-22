package discussion;
/*
 * File: Frame.java
 * Author: Jimmy Smutek
 * Date: November 16, 2018
 * Purpose: Main program frame
 */

import javax.swing.*;

public class Frame extends JFrame {

  static final int WIDTH = 550, HEIGHT = 350;

  /**
   * Frame Constructor
   */
  public Frame() {
    super("Hours Worked");
    setFrame(WIDTH, HEIGHT);
  }

  public Frame(String title) {
    super(title);
    setFrame(WIDTH, HEIGHT);
  }

  public Frame(String title, int width, int height) {
    super(title);
    setFrame(width, height);
  }

  public void display() {
    setVisible(true);
  }

  private void setFrame(int width, int height) {
    setSize(width, height);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}
