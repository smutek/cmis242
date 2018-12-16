package p4;
/*
 * File: P4GUI.java
 * Author: Jimmy Smutek
 * Date: December 14, 2018
 * Purpose: Defines the GUI and handles database interactions.
 */

import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;

/*
 * @todo: delete class instructions
 *
 * This programming project involves writing a program to manage a student database. The interface
 * to the program should be a Swing based GUI that looks similar to the following:
 *
 * ((
 * Id: [ text input field ]
 * Name: [ text input field ]
 * Major: [ text input field ]
 * Choose Selection: [ Combo box ]
 *
 * A combo box should allow the user to select one of the four database actions shown.
 *
 * The database should be implemented as a HashMap, with the Id field as the key and a Student
 * record as the value.
 *
 * The selected operation should be performed when the user clicks the Process Request button.
 *
 * If the user attempts to insert a key that is already in the database an error message should be
 * displayed using a JOptionPane message dialog box.
 *
 * If the user attempts to delete, find or update a record that is not in the database, a message
 * should also be displayed in a JOptionPane.
 *
 * After each successful operation is completed a JOptionPane window should be displayed confirming
 * the success.
 *
 * In the case of a successful Find request, a window should pop up containing the student's Id,
 * name, major and current GPA.
 *
 * When the user selects the Update request, the following JOptionPane windows should be displayed
 * to gather information about a course that has just been completed.
 *
 * Choose Grade:
 * [ combo box ]
 *
 * Choose credits:
 * [ Combo box ]
 *
 * As a result, the Student record in the database will be updated accordingly. User input values
 * should be checked and a warning message should be displayed in a JOptionPane for inappropriate
 * values.
 *
 * When the main application window is closed, the student records from the database will be
 * written into the text file outData.txt, each student data (including his/her GPA) on a separate
 * line. The last line of the file will contain the total number of student records in the database
 * and their average GPA value.
 */
public class P4GUI extends JFrame implements ActionListener {

  // ************ Strings
  private static final String[] OPTIONS = {"Insert", "Delete", "Find", "Update"};

  // ************ Labels
  private JLabel id, name, major, selection;
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
    id = new JLabel("ID: ");
    add(id, c);
    c.gridy++;
    name = new JLabel("Name: ");
    add(name, c);
    c.gridy++;
    major = new JLabel("Major: ");
    add(major, c);
    c.gridy++;
    selection = new JLabel("Selection: ");
    add(selection, c);
    c.gridy++;

    // ************ Create and add the submit button
    JButton submitButton = new JButton("Process Request");
    submitButton.addActionListener(this);
    add(submitButton, c);

    // Reset grid
    c.gridy = 0;
    c.gridx = 1;

    // ************ Create and add the text fields
    idField = new JTextField();
    idField.setColumns(FIELD_W);
    add(idField, c);
    c.gridy++;
    nameField = new JTextField();
    nameField.setColumns(FIELD_W);
    add(nameField, c);
    c.gridy++;
    majorField = new JTextField();
    majorField.setColumns(FIELD_W);
    add(majorField, c);
    c.gridy++;

    // ************ Create and add the combo box
    JComboBox comboBox = new JComboBox(OPTIONS);
    comboBox.setSelectedIndex(0);
    comboBox.addActionListener(this);
    add(comboBox, c);
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
    // Test click @todo Remove
    System.out.println("Click");
    // So, when someone clicks, get all the values
    // and kick them to the console @todo Remove
    System.out.println(idField.getText());
    System.out.println(nameField.getText());
    System.out.println(majorField.getText());

    if(comboBox.getSelectedItem() != null) {
      String cIn = (String)comboBox.getSelectedItem();
      System.out.println(cIn);

    } else {
      System.out.println("Still fucking null, bitches");
    }

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
