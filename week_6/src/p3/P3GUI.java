package p3;
/*
 * File: P3GUI.java
 * Author: Jimmy Smutek
 * Date: December 02, 2018
 * Purpose: Defines the Swing GUI
 */

import java.net.SocketOption;
import java.text.NumberFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionListener;

public class P3GUI extends JFrame implements ActionListener {
  /*
  *** P3GUI [0/10]

  @todo- Allows the user to enter a value for n and click the Compute button, to display the nth term of the sequence in the Result field.

  @todo- User input value is checked and warning message is displayed if the entered value is not a positive integer.

  @todo- Allows the Efficiency field to contain the number of calls to the recursive method when the recursive option is chosen and the number of iterations of the loop when the iterative option is selected.

  @todo- When the window is closed, the efficiency values computes with values of n from 0 to 20 and writes them to a file.

  @todo- Each line of the output file contains the value of n, the efficiency of the iterative method for that value of n and the efficiency of the recursive method.

  @todo- The values of the output file are separated by commas so the file can be opened with Excel.

  @todo- Provides an event handler to handle the Compute button click and another handler will be needed to produce the file described above when the window is closed. The latter handler is an object of an inner class that extends the WindowAdapter class.

  @todo- Remove remaining todo's before turning in
   */

  // ************ Radio button group
  private static final ButtonGroup OPTION_GROUP = new ButtonGroup();

  // ************ Strings for the labels
  private static final String[] IO_STRINGS = {"Iterative", "Recursive"};
  private static final String[] LABEL_STRINGS = {"Enter n:", "Result:", "Efficiency:"};

  // ************ Color palette
  private static final Color PANE_BG = Color.lightGray;
  private static final Color BORDER_COLOR = Color.gray;
  private static final Color FIELD_BG = Color.white;
  private static final Color TEXT_COLOR = Color.darkGray;

  // ************ Global sizing units
  private static final int PAD_1 = 1;
  private static final int PAD_2 = 2;
  private static final int PAD_4 = 4;
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
      // Skip after the first loop iteration, in order to account for
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
    JFormattedTextField inputField = new JFormattedTextField(dataFormat);
    inputField.setValue(0);
    inputField.setColumns(FIELD_WIDTH);
    add(inputField, c);
    c.gridy++;

    JButton submitButton = new JButton("Compute");
    submitButton.addActionListener(this);
    add(submitButton, c);
    c.gridy++;

    // ************ Add output fields
    for (int i = 0; i <= 1; i++) {
      JFormattedTextField formattedTextField = new JFormattedTextField(dataFormat);
      formattedTextField.setValue(0);
      formattedTextField.setColumns(FIELD_WIDTH);
      formattedTextField.setEditable(false);
      add(formattedTextField, c);
      c.gridy++;
    }

    // ************ Add Window listener
    addWindowListener(new WindowAdapter(){
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
   * @param event ActionEvent (button click)
   */
  public void actionPerformed(ActionEvent event) {
    String type = event.getActionCommand();


    System.out.println(type);
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
