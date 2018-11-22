package reading;
/*
 * File: InputOutputPanel.java
 * Author: Jimmy Smutek
 * Date: November 12, 2018
 * Purpose:
 */

// InputOutputPanel.java
import java.awt.*;
import javax.swing.*;

class InputOutputPanel extends JPanel {
  private SimpleCalculatorPanel scPanel;
  // create input/output components
  private JLabel leftOprLbl = new JLabel("Left Operand", JLabel.CENTER);
  private JLabel rightOprLbl = new JLabel("Right Operand", JLabel.CENTER);
  private JLabel resultLbl = new JLabel("Result", JLabel.CENTER);
  private JTextField leftOprTxt = new JTextField("");
  private JTextField rightOprTxt = new JTextField("");
  private JTextField resultTxt = new JTextField("");

  public InputOutputPanel(SimpleCalculatorPanel scPanel) {
    this.scPanel = scPanel;
    setLayout(new GridLayout(2, 3));
    resultTxt.setBackground(Color.lightGray);
    resultTxt.setEditable(false);
    add(leftOprLbl);
    add(rightOprLbl);
    add(resultLbl);
    add(leftOprTxt);
    add(rightOprTxt);
    add(resultTxt);
  }
}
