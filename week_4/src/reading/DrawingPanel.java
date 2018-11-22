package reading;
/*
 * File: DrawingPanel.java
 * Author: Jimmy Smutek
 * Date: November 12, 2018
 * Purpose:
 */

import java.awt.*;
import javax.swing.*;

class DrawingPanel extends JPanel {
  private static final int SIZE = 40;

  public DrawingPanel() {
    setBackground(Color.lightGray);
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.magenta);
    g.fillOval(30, 10, SIZE, SIZE);
    g.setColor(Color.orange);
    g.fillRect(10, 80, 2 * SIZE, SIZE);
    g.setColor(Color.blue);
    g.fillRoundRect(110, 10, 2 * SIZE, SIZE, 30, 30);
    g.setColor(Color.darkGray);
    g.fillOval(110, 80, 2 * SIZE, SIZE);
  }
}
