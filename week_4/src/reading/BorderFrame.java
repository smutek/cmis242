package reading;
/*
 * File: BorderFrame.java
 * Author: Jimmy Smutek
 * Date: November 12, 2018
 * Purpose:
 */

import java.awt.*;
import javax.swing.*;

public class BorderFrame extends NiceFrame {
  public BorderFrame() {
    super("Border Frame", 300, 200);
    setLayout(new BorderLayout());
    add(BorderLayout.NORTH, new JButton("North"));
    add(BorderLayout.SOUTH, new JButton("South"));
    add(BorderLayout.EAST, new JButton("East"));
    add(BorderLayout.WEST, new JButton("West"));
    add(BorderLayout.CENTER, new JButton("Center"));
  }

  public static void main(String[] args) {
    BorderFrame f = new BorderFrame();
    f.display();
  }
}
