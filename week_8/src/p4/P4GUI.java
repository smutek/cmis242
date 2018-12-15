package p4;
/*
 * File: P4GUI.java
 * Author: Jimmy Smutek
 * Date: December 14, 2018
 * Purpose: Defines the GUI and handles database interactions.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;

public class P4GUI extends JFrame implements ActionListener {

  // ************ Strings, for labels
  private static final String[] LABELS = {"ID:", "Name:", "Major:", "Choose Selection:"};
  private static final String[] OPTIONS = {"Insert", "Delete", "Find", "Update"};

  // ************ Fields
  private JTextField idField;
  private JTextField nameField;
  private JTextField majorField;
  private JTextField[] fields = {idField, nameField, majorField};

  // ************ Combo Box
  private JComboBox comboBox;

  private static final int FIELD_W = 12;

  /** Constructor */
  public P4GUI(String title) {
    super(title);
  }

  private void addComponentsToFrame(Container pane) {
    // ************ Setup outer container
    pane.setLayout(new GridBagLayout());
    pane.setPreferredSize(new Dimension(400, 200));

    // ************ Init GridBag Constraints (c)
    GridBagConstraints c = new GridBagConstraints();
    c.anchor = GridBagConstraints.LINE_START;
    c.fill = GridBagConstraints.HORIZONTAL;
    // x y origin
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 1;
    c.ipady = 5;
    c.ipadx = 10;

    // ************ Create and add labels
    for (int i = 0; i <= 3; i++) {
      JLabel label = new JLabel(LABELS[i]);
      add(label, c);
      // Increment grid Y position
      c.gridy++;
    }

    // ************ Create and add the submit button
    JButton submitButton = new JButton("Process Request");
    submitButton.addActionListener(this);
    add(submitButton, c);

    // Reset grid
    c.gridy = 0;
    c.gridx = 1;

    // ************ Create and add the text fields
    for (JTextField field : fields) {
      field = new JTextField();
      field.setColumns(FIELD_W);
      add(field, c);
      c.gridy ++;
    }

    // ************ Create and add the combo box
    JComboBox comboBox = new JComboBox(OPTIONS);
    add(comboBox);
    c.gridy++;

  }

  /** Create and show the application GUI */
  private static void createAndShowApplicationGUI() {
    // Create and set up the main frame
    P4GUI frame = new P4GUI("Project 4!");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.addComponentsToFrame(frame.getContentPane());
    // Display the frame
    frame.pack();
    frame.setVisible(true);
  }

  /** @param event ActionEvent */
  public void actionPerformed(ActionEvent event) {
    // Event listener
  }

  /**
   * Main Program Method
   *
   * @param args String
   */
  public static void main(String[] args) {
    // Turn off metals bold font
    UIManager.put("swing.blodMetal", false);
    // Schedule a job for the event dispatch thread
    SwingUtilities.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            // Create and show the application GUI
            createAndShowApplicationGUI();
          }
        });
  }
}
