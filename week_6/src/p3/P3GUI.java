package p3;
/*
 * File: P3GUI.java
 * Author: Jimmy Smutek
 * Date: December 02, 2018
 * Purpose: Defines the Swing GUI
 */

import java.text.NumberFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;

public class P3GUI extends JFrame implements ActionListener {

  // ************ Radio button group
  private static final ButtonGroup OPTION_GROUP = new ButtonGroup();

  // ************ Fields
  private JFormattedTextField inputField;
  private JFormattedTextField resultField;
  private JFormattedTextField efficiencyField;

  // ************ Strings for the labels
  private static final String[] IO_STRINGS = {"Iterative", "Recursive"};
  private static final String[] LABEL_STRINGS = {"Enter n:", "Result:", "Efficiency:"};

  // ************ Color palette
  private static final Color PANE_BG = Color.lightGray;

  // ************ Global sizing units
  private static final int PAD_2 = 2;
  private static final int PAD_10 = 10;
  private static final int FIELD_WIDTH = 12;

  // ************ Number format
  private NumberFormat dataFormat;

  /**
   * Constructor
   *
   * @param title String Application Title
   * @throws HeadlessException Headless Exception
   */
  public P3GUI(String title) throws HeadlessException {
    super(title);
  }

  /**
   * Create and add interface components to the frame
   *
   * @param pane Main Application Container
   */
  private void addComponentsToFrame(Container pane) {

    // ************ Setup outer Container
    pane.setLayout(new GridBagLayout());
    pane.setPreferredSize(new Dimension(500, 250));
    pane.setBackground(PANE_BG);

    // ************ Setup Number formats
    setupFormats();

    // ************ Initialize GridBag constraints
    GridBagConstraints c = new GridBagConstraints();
    c.anchor = GridBagConstraints.LINE_START;
    c.fill = GridBagConstraints.HORIZONTAL;
    // Initialize X Y origin
    c.gridx = 0;
    c.gridy = 2;
    c.gridwidth = 1;
    c.ipady = PAD_2;
    c.ipadx = PAD_10;

    // ************ Create and add Labels
    for (int i = 0; i <= 2; i++) {
      // Increment twice, but only  after the first loop iteration, in order to account for
      // the submit button
      if (i == 1) c.gridy++;
      // Create the label
      JLabel label = new JLabel(LABEL_STRINGS[i]);
      // Add it to the container
      add(label, c);
      // Increment the Y axis position
      c.gridy++;
    }

    // Reset x/y index and start running down the second column
    c.gridy = 0;
    c.gridx = 1;

    // ************ Create and add radio Options
    JRadioButton[] radioButtons = new JRadioButton[2];
    for (int i = 0; i <= 1; i++) {
      add(radioButtons[i] = new JRadioButton(IO_STRINGS[i]), c);
      OPTION_GROUP.add(radioButtons[i]);
      c.gridy++;
    }
    OPTION_GROUP.getElements().nextElement().setSelected(true);

    // ************ Add input field & submit button
    inputField = new JFormattedTextField(dataFormat);
    inputField.setValue(0);
    inputField.setColumns(FIELD_WIDTH);
    add(inputField, c);
    c.gridy++;

    JButton submitButton = new JButton("Compute");
    submitButton.addActionListener(this);
    add(submitButton, c);
    c.gridy++;

    // ************ Add output fields
    // Results
    resultField = new JFormattedTextField(dataFormat);
    resultField.setValue(0);
    resultField.setColumns(FIELD_WIDTH);
    resultField.setEditable(false);
    add(resultField, c);
    c.gridy++;
    // Efficiency
    efficiencyField = new JFormattedTextField(dataFormat);
    efficiencyField.setValue(0);
    efficiencyField.setColumns(FIELD_WIDTH);
    efficiencyField.setEditable(false);
    add(efficiencyField, c);
    c.gridy++;

    // ************ Add Window listener
    addWindowListener(
        new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.out.println("Write the file");
            dispose();
          }
        });
  }

  /** Set up Number formats */
  private void setupFormats() {
    dataFormat = NumberFormat.getNumberInstance();
  }

  /** Create and show the application GUI */
  private static void createAndShowGUI() {
    // Create and set up the Frame
    P3GUI frame = new P3GUI("Project Three!");
    // Set up shut down operations
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Add an instance of the application to the Frame
    frame.addComponentsToFrame(frame.getContentPane());
    // Display the window
    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Action event listener
   *
   * @param event ActionEvent (button click)
   */
  public void actionPerformed(ActionEvent event) {
    Sequence.resetEfficiency();

    /*
    When the button is clicked:
    1. Get the value of the input field
    2. validate the input, should be whole positive int
    3. Get the state of the radio buttons
    4. Pass the input off to the corresponding method
    5. Get the method return
    6. Update the output fields
     */

    int inputValue = (((Number) (inputField.getValue())).intValue());
    int outputValue;

    if (OPTION_GROUP.getElements().nextElement().isSelected()) {
      outputValue = Sequence.computeIterative(inputValue);
    } else {
      outputValue = Sequence.computeRecursive(inputValue);
    }

    resultField.setValue(outputValue);
    efficiencyField.setValue(Sequence.getEfficiency());
  }

  /**
   * Main Method
   *
   * @param args String
   */
  public static void main(String[] args) {
    // Turn off metals bold
    UIManager.put("swing.boldMetal", false);
    // Schedule a job for the event dispatch thread
    SwingUtilities.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            // Create and show the application GUI
            createAndShowGUI();
          }
        });
  }
}
