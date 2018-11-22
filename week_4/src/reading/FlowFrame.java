package reading;
/*
 * File: FlowFrame.java
 * Author: Jimmy Smutek
 * Date: November 12, 2018
 * Purpose:
 */

import java.awt.*;
import javax.swing.*;

public class FlowFrame extends NiceFrame {
  public FlowFrame() {
    super("Flow Frame", 300, 200);
    setLayout(new FlowLayout(FlowLayout.LEFT));
    for (int i = 0; i < 20; i++) add(new JButton("b" + i));
  }

  public static void main(String[] args) {
    FlowFrame f = new FlowFrame();
    f.display();
  }
}
