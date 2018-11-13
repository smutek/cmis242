package reading;
/*
 * File: ButtonsPanel.java
 * Author: Jimmy Smutek
 * Date: November 12, 2018
 * Purpose:
 */

import java.awt.*;
import javax.swing.*;

class ButtonsPanel extends JPanel {
  private SimpleCalculatorPanel scPanel;
  private JButton addBtn = new JButton("Add");
  private JButton subtractBtn = new JButton("Subtract");

  public ButtonsPanel(SimpleCalculatorPanel scPanel) {
    this.scPanel = scPanel;
    setLayout(new FlowLayout(FlowLayout.CENTER));
    addBtn.setToolTipText("Add the two operands.");
    subtractBtn.setToolTipText("Subtract the two operands.");
    add(addBtn);
    add(subtractBtn);
  }
}
