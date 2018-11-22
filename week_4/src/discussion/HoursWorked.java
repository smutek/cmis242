package discussion;
/*
 * File: HoursWorked.java
 * Author: Jimmy Smutek
 * Date: November 16, 2018
 * Purpose: Calculate hours worked : Week 4 discussion
 *
 * Description:
 */
import java.text.NumberFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** Calculate hours worked as a percentage of 35 hours */
public class HoursWorked extends JFrame implements ActionListener {
  /*
   ************************************************************************
   * ************** Variables
   * **********************************************************************
   */
  private static final double GOAL = 40;
  // ************ Initialize Field Values
  private boolean isBillable;

  // ************ Strings values for each Label
  private final String goalString = "Goal: ";
  private final String hoursWorkedString = "Hours Worked: ";
  private final String entryTypeString = "Entry Type: ";
  private final String optionWorkingString = "Working";
  private final String optionMeetingString = "Meeting";
  private final String optionBreakString = "Break";
  private final String isBillableString = "Billable: ";
  private final String totalHoursString = "Total Hours: ";
  private final String totalWorkedString = "Time spent working: ";
  private final String totalBreaksString = "Well deserved breaks: ";
  private final String totalMeetingsString = "Time spent in meetings: ";
  private final String goalPercentageString = "Percentage of goal (" + GOAL + "hrs): ";
  private final String buttonSubmitString = "Submit";
  // ************ Labels - These identify the fields
  private JLabel goalLabel;
  private JLabel hoursWorkedLabel;
  private JLabel entryTypeLabel;
  private JLabel optionWorkingLabel;
  private JLabel optionMeetingLabel;
  private JLabel optionBreakLabel;
  private JLabel isBillableLabel;
  private JLabel totalHoursLabel;
  private JLabel totalWorkedLabel;
  private JLabel totalBreaksLabel;
  private JLabel totalMeetingsLabel;
  private JLabel goalPercentageLabel;
  private JLabel buttonSubmitLabel;
  // ************ Fields & Buttons
  private JFormattedTextField goalField;
  private JFormattedTextField hoursWorkedField;
  private JTextField entryTypeField;
  private ButtonGroup entryTypeButtonGroup;
  private JRadioButton optionWorking;
  private JRadioButton optionMeeting;
  private JRadioButton optionBreak;
  private JFormattedTextField isBillableField;
  private JFormattedTextField totalHoursField;
  private JFormattedTextField totalWorkedField;
  private JFormattedTextField totalBreaksField;
  private JFormattedTextField totalMeetingsField;
  private JFormattedTextField goalPercentageField;
  private JButton buttonSubmit;
  // ************ Number Formatters
  private NumberFormat hoursWorkedFormat;
  private NumberFormat totalHoursFormat;
  private NumberFormat totalWorkedFormat;
  private NumberFormat totalMeetingsFormat;
  private NumberFormat totalBreaksFormat;
  private NumberFormat goalPercentageFormat;

  public HoursWorked(String name) {
    super(name);
  }

  /** Create the components and add them to the Container */
  public void addComponentsToFrame(Container pane) {
    // Create the wrapping layout
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    setupFormats();
    double init = 00.00;

    // ************ Create Labels for Components
    goalLabel = new JLabel(goalString);
    hoursWorkedLabel = new JLabel(hoursWorkedString);
    entryTypeLabel = new JLabel(entryTypeString);
    optionWorkingLabel = new JLabel(optionWorkingString);
    optionMeetingLabel = new JLabel(optionMeetingString);
    optionBreakLabel = new JLabel(optionBreakString);
    isBillableLabel = new JLabel(isBillableString);
    totalHoursLabel = new JLabel(totalHoursString);
    totalWorkedLabel = new JLabel(totalWorkedString);
    totalBreaksLabel = new JLabel(totalBreaksString);
    totalMeetingsLabel = new JLabel(totalMeetingsString);
    goalPercentageLabel = new JLabel(goalPercentageString);
    buttonSubmitLabel = new JLabel(buttonSubmitString);

    // ************ Create and set up the Fields
    hoursWorkedField = new JFormattedTextField(hoursWorkedFormat);
    hoursWorkedField.setValue(init);
    hoursWorkedField.setColumns(4);

    entryTypeField = new JTextField();
    entryTypeField.setColumns(20);

    totalWorkedField = new JFormattedTextField(totalWorkedFormat);
    totalWorkedField.setValue(init);
    totalWorkedField.setColumns(4);
    totalWorkedField.setEditable(false);

    totalMeetingsField = new JFormattedTextField(totalMeetingsFormat);
    totalMeetingsField.setValue(init);
    totalMeetingsField.setColumns(4);
    totalMeetingsField.setEditable(false);

    totalBreaksField = new JFormattedTextField(totalBreaksFormat);
    totalBreaksField.setValue(init);
    totalBreaksField.setColumns(4);
    totalBreaksField.setEditable(false);

    totalHoursField = new JFormattedTextField(totalHoursFormat);
    totalHoursField.setValue(init);
    totalHoursField.setColumns(4);
    totalHoursField.setEditable(false);

    goalPercentageField = new JFormattedTextField(goalPercentageFormat);
    goalPercentageField.setValue(init);
    goalPercentageField.setColumns(4);
    goalPercentageField.setEditable(false);

    // ************ Create and set up the Radio Buttons
    optionWorking = new JRadioButton(optionWorkingString);
    optionWorking.setActionCommand(optionWorkingString);
    optionWorking.setSelected(true);
    optionMeeting = new JRadioButton(optionMeetingString);
    optionMeeting.setActionCommand(optionMeetingString);
    optionBreak = new JRadioButton(optionBreakString);
    optionBreak.setActionCommand(optionBreakString);
    // Create a ButtonGroup to hold the radio buttons (just for layout control)
    entryTypeButtonGroup = new ButtonGroup();
    entryTypeButtonGroup.add(optionWorking);
    entryTypeButtonGroup.add(optionMeeting);
    entryTypeButtonGroup.add(optionBreak);
    // Create the submit button
    buttonSubmit = new JButton(buttonSubmitString);
    buttonSubmit.addActionListener(this);

    // ************ Tell accessibility about labels and field pairings
    hoursWorkedLabel.setLabelFor(hoursWorkedField);

    // ************ Create Component containers & add components
    // Hours Worked
    final JPanel hoursWorkedComponent = new JPanel();
    hoursWorkedComponent.setLayout(new FlowLayout(FlowLayout.LEFT));
    hoursWorkedComponent.add(hoursWorkedLabel);
    hoursWorkedComponent.add(hoursWorkedField);
    // Button Group
    final JPanel buttonGroupComponent = new JPanel();
    buttonGroupComponent.setLayout(new FlowLayout(FlowLayout.LEFT));
    buttonGroupComponent.add(optionWorking);
    buttonGroupComponent.add(optionMeeting);
    buttonGroupComponent.add(optionBreak);
    // Entry Type
    final JPanel entryTypeComponent = new JPanel();
    entryTypeComponent.setLayout(new BoxLayout(entryTypeComponent, BoxLayout.Y_AXIS));
    entryTypeComponent.add(entryTypeLabel);
    entryTypeComponent.add(buttonGroupComponent);
    // Submit Button
    final JPanel buttonSubmitComponent = new JPanel();
    buttonSubmitComponent.setLayout(new BoxLayout(buttonSubmitComponent, BoxLayout.Y_AXIS));
    buttonSubmitComponent.add(buttonSubmit);
    // Total Hours Display
    final JPanel totalHoursComponent = new JPanel();
    totalHoursComponent.setLayout(new FlowLayout(FlowLayout.LEFT));
    totalHoursComponent.add(totalHoursLabel);
    totalHoursComponent.add(totalHoursField);
    // Total Breaks display
    final JPanel totalBreaksComponent = new JPanel();
    totalBreaksComponent.setLayout(new FlowLayout(FlowLayout.LEFT));
    totalBreaksComponent.add(totalBreaksLabel);
    totalBreaksComponent.add(totalBreaksField);
    // Total worked
    final JPanel totalWorkedComponent = new JPanel();
    totalWorkedComponent.setLayout(new FlowLayout(FlowLayout.LEFT));
    totalWorkedComponent.add(totalWorkedLabel);
    totalWorkedComponent.add(totalWorkedField);
    // Total meetings
    final JPanel totalMeetingsComponent = new JPanel();
    totalMeetingsComponent.setLayout(new FlowLayout(FlowLayout.LEFT));
    totalMeetingsComponent.add(totalMeetingsLabel);
    totalMeetingsComponent.add(totalMeetingsField);
    // Percentage of 37.5
    final JPanel percentageComponent = new JPanel();
    percentageComponent.setLayout(new FlowLayout(FlowLayout.LEFT));
    percentageComponent.add(goalPercentageLabel);
    percentageComponent.add(goalPercentageField);
    // ************ Set up Panels & add components
    // Left Panel
    final JPanel panelTop = new JPanel();
    panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.Y_AXIS));
    panelTop.add(entryTypeComponent);
    panelTop.add(hoursWorkedComponent);
    panelTop.add(buttonSubmitComponent);
    // Right Panel
    final JPanel panelBottom = new JPanel();
    panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.Y_AXIS));
    panelBottom.add(totalWorkedComponent);
    panelBottom.add(totalMeetingsComponent);
    panelBottom.add(totalBreaksComponent);
    panelBottom.add(totalHoursComponent);
    panelBottom.add(percentageComponent);
    // Outer Panel
    final JPanel panelOuter = new JPanel();
    panelOuter.setLayout(new BoxLayout(panelOuter, BoxLayout.X_AXIS));
    panelOuter.add(panelTop);
    panelOuter.add(panelBottom);
    // Add the main panel to the pane
    add(panelOuter);
  }

  // Event Listener
  public void actionPerformed(ActionEvent event) {

    // Get the input
    double hoursWorked = (((Number) (hoursWorkedField.getValue())).doubleValue());
    String entryType = entryTypeButtonGroup.getSelection().getActionCommand();

    // How many hours do we have now?
    double totalHours = (((Number) totalHoursField.getValue()).doubleValue());

    // Evaluate the entry type
    switch (entryType) {
      case optionWorkingString:
        double currentWorking = (((Number) totalWorkedField.getValue()).doubleValue());
        totalWorkedField.setValue(hoursWorked + currentWorking);
        isBillable = true;
        break;
      case optionMeetingString:
        double currentMeeting = (((Number) totalMeetingsField.getValue()).doubleValue());
        totalMeetingsField.setValue(hoursWorked + currentMeeting);
        isBillable = true;
        break;
      case optionBreakString:
        double currentBreaks = (((Number) totalBreaksField.getValue()).doubleValue());
        totalBreaksField.setValue(hoursWorked + currentBreaks);
        isBillable = false;
        break;
    }
    // Update the total hours
    totalHoursField.setValue(totalHours + hoursWorked);
    // Update percentage if type is billable
    if (isBillable) goalPercentageField.setValue(calculatePercentage((totalHours + hoursWorked)));
  }

  private double calculatePercentage(double allBillableHours) {
    return (allBillableHours * 100 / GOAL);
  }

  private void setupFormats() {
    // ************ Number Formatters
    hoursWorkedFormat = NumberFormat.getNumberInstance();
    totalHoursFormat = NumberFormat.getNumberInstance();
    totalWorkedFormat = NumberFormat.getNumberInstance();
    totalMeetingsFormat = NumberFormat.getNumberInstance();
    totalBreaksFormat = NumberFormat.getNumberInstance();
    goalPercentageFormat = NumberFormat.getNumberInstance();
  }

  /**
   * Create and show the Application GUI
   *
   * <p>Note: For thread safety, this method should be invoked from the event dispatch thread.
   *
   * <p>If you need to determine whether your code is running on the event dispatch thread, invoke
   * javax.swing.SwingUtilities.isEventDispatchThread.
   *
   * <p>Source: https://docs.oracle.com/javase/tutorial/uiswing/concurrency/dispatch.html
   */
  private static void createAndShowGUI() {
    // Create and set up the Frame - This is the top level GUI container
    HoursWorked frame = new HoursWorked("Hours Worked.");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // ** Add an instance of HoursWorked to the frame
    frame.addComponentsToFrame(frame.getContentPane());
    // ** Display the window
    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Main Method
   *
   * @param args String
   */
  public static void main(String[] args) {
    // Turn off metals bold fonts, as per Oracle examples.
    UIManager.put("swing.boldMetal", false);
    SwingUtilities.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            createAndShowGUI();
          }
        });
  }
}
