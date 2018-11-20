package p2;
/*
 * File: P2GUI.java
 * Author: Jimmy Smutek
 * Date: November 18, 2018
 * Purpose: Defines the Swing GUI
 * Description: Contains the Main method and constructor to build the GUI.
 * Includes event handlers to handle button events and checks to ensure the
 * value in the text field is numeric and positive.
 *
 */

import java.math.RoundingMode;
import java.text.NumberFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P2GUI extends JFrame implements ActionListener {

  private static final ButtonGroup PANELGROUP = new ButtonGroup();
  private static final ButtonGroup RADIOGROUP = new ButtonGroup();
  private static final JRadioButton CHECKING = new JRadioButton("Checking");
  private static final JRadioButton SAVINGS = new JRadioButton("Checking");

  private static JFormattedTextField inputField = new JFormattedTextField();

  private NumberFormat dollarFormat;
  private NumberFormat inputFormat;
  private NumberFormat transferFormat;

  /**
   * Constructor
   *
   * @param name String Frame Name
   */
  private P2GUI(String name) {
    super(name);
  }

  /**
   * Add interface components to the frame
   *
   * @param pane Container GUI topmost container (frame)
   */
  private void addComponentsToFrame(Container pane) {

    // ************ Setup Pane layout
    pane.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    pane.setPreferredSize(new Dimension(420, 250));
    pane.setBackground(Color.lightGray);

    setupFormats();

    // ************ Set up String values
    String[] buttonText = {"Withdraw", "Deposit", "Transfer To", "Balance"};
    String[] radioText = {"Checking", "Savings"};
    JButton[] panelButtons = new JButton[4];

    // ************ Set up fields
    inputField = new JFormattedTextField(inputFormat);
    inputField.setValue(00.00);
    inputField.setColumns(20);
    inputField.addActionListener(this);

    // ************ Look and feel
    final Color colorBG = Color.lightGray;
    final Color colorBorder = Color.gray;
    final int padSm = 1;

    // ************ Create and add transaction button panel
    final JPanel buttonPanel = new JPanel();
    for (int i = 0; i <= 3; i++) {
      buttonPanel.add(panelButtons[i] = new JButton(buttonText[i]));
      panelButtons[i].addActionListener(this);
      PANELGROUP.add(panelButtons[i]);
    }
    buttonPanel.setLayout(new GridLayout(2, 2));
    buttonPanel.setBorder(BorderFactory.createLineBorder(colorBorder, padSm));
    buttonPanel.setBackground(colorBG);
    c.gridx = 0;
    c.gridy = 0;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(4, 4, 4, 4);
    // Add to pane
    add(buttonPanel, c);

    // ************ Create and add account radio button panel
    final JPanel radioPanel = new JPanel();
    CHECKING.setSelected(true);
    CHECKING.addActionListener(this);
    SAVINGS.addActionListener(this);
    radioPanel.add(CHECKING);
    radioPanel.add(SAVINGS);
    RADIOGROUP.add(CHECKING);
    RADIOGROUP.add(SAVINGS);
    radioPanel.setLayout(new GridLayout(1, 2));
    radioPanel.setBorder(BorderFactory.createLineBorder(colorBorder, padSm));
    radioPanel.setBackground(colorBG);
    c.gridy = 1;
    // Add to pane
    add(radioPanel, c);

    // ************ Create and add inputField panel
    final JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    inputPanel.add(inputField);
    inputPanel.setBorder(BorderFactory.createLineBorder(colorBorder, padSm));
    inputPanel.setBackground(colorBG);
    c.gridy = 2;
    // Add to pane
    add(inputPanel, c);
  }

  private void setupFormats() {
    inputFormat = NumberFormat.getNumberInstance();
    dollarFormat = NumberFormat.getCurrencyInstance();
    transferFormat = NumberFormat.getNumberInstance();
    transferFormat.setRoundingMode(RoundingMode.HALF_DOWN);
  }

  /** Create and show the application GUI */
  private static void createAndShowGUI() {
    // Create and setup the frame
    P2GUI frame = new P2GUI("ATM Machine");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Add an instance of the application to the Frame
    frame.addComponentsToFrame(frame.getContentPane());
    // Display the window
    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Action Performed
   *
   * @param event ActionEvent
   */
  public void actionPerformed(ActionEvent event) {
    // Get event type from button click
    String type = event.getActionCommand();
    int amount = (((Number) (inputField.getValue())).intValue());

    // Get event source
    switch (type) {
      case "Checking":
        System.out.println("Account type set to checking");
        break;
      case "Savings":
        System.out.println("Account type set to savings.");
        break;
      default:
        System.out.println("Transaction type: " + type);
    }
    // Get text box contents
    System.out.println(amount);
  }

  /**
   * Main Program Method
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
            // Show application GUI
            createAndShowGUI();
          }
        });
  }
}
