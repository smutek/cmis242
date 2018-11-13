package reading;
/*
 * File: GridFrame.java
 * Author: Jimmy Smutek
 * Date: November 12, 2018
 * Purpose:
 */

import java.awt.*;
import javax.swing.*;

public class GridFrame extends NiceFrame {
  public GridFrame() {
    super("Jimmy's Completely Bad Ass GUI Frame", 300, 200);
    setLayout(new GridLayout(5, 5));
    for (int i = 0; i < 25; i++) add(new JButton("b" + i));
  }

  public static void main(String[] args) {
    GridFrame f = new GridFrame();
    f.display();
  }
}
