package reading;
/*
 * File: SketchPanel.java
 * Author: Jimmy Smutek
 * Date: November 12, 2018
 * Purpose:
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SketchPanel extends JPanel {
  private Point start, end;

  public SketchPanel() {
    start = new Point(0, 0);
    end = new Point(0, 0);
    addMouseListener(new SketchMouseAdapter());
    addMouseMotionListener(new SketchMouseMotionAdapter());
  }

  protected void paintComponent(Graphics g) {
    g.drawLine(start.x, start.y, end.x, end.y);
    start.setLocation(end);
  }

  class SketchMouseAdapter extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
      start = e.getPoint();
    }
  }

  class SketchMouseMotionAdapter extends MouseMotionAdapter {
    public void mouseDragged(MouseEvent e) {
      end = e.getPoint();
      repaint();
    }
  }
}
