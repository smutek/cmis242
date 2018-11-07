package discussion;
/*
 * File: TestMessage.java
 * Author: Jimmy Smutek
 * Date: November 04, 2018
 * Purpose: Test driver for the message superclass and alert subclass
 */
public class TestMessage {
  // Spacer for console output
  private static void sectionSpacer() {
    System.out.println("\n**********");
  }

  public static void main(String[] args) {
    System.out.println("Message superclass & Alert subclass test driver ******");
    sectionSpacer();
    /*
     ********* Default Message
     */
    System.out.println("Default message:");
    Message testMsg = new Message();
    testMsg.display();
    sectionSpacer();
    /*
     ********* Test creating a custom message, getters and setters
     */
    System.out.println("Custom message:");
    Message testCustomMsg = new Message("Custom Message", "Custom Body");
    testCustomMsg.display();
    sectionSpacer();
    System.out.println("Custom message getters:");
    System.out.println("Get title: " + testCustomMsg.getTitle());
    System.out.println("Get body: " + testCustomMsg.getBody());
    System.out.println("get id: " + testCustomMsg.getId());
    sectionSpacer();
    System.out.println("Custom message setters:");
    testCustomMsg.setTitle("Set a new custom title");
    testCustomMsg.setBody("Set a new custom body");
    testCustomMsg.display();
    sectionSpacer();
    /*
     ********* Default Alert
     */
    System.out.println("Default alert:");
    Alert testAlert = new Alert();
    testAlert.display();
    System.out.println("** Note: Flagged should be false if severity >= 7 **");
    System.out.println(testAlert.isFlagged());
    sectionSpacer();
    /*
     ********* Test creating a custom alert, getters and setters
     */
    System.out.println("Custom Alert:");
    String title = "Custom Alert Title";
    String body = "Custom Alert body";
    byte severity = 7;
    Alert testCustomAlert = new Alert(title, body, severity);
    testCustomAlert.display();
    sectionSpacer();
    // Getters
    System.out.println("Custom alert getters:");
    System.out.println("Get title: " + testCustomAlert.getTitle());
    System.out.println("Get body: " + testCustomAlert.getBody());
    System.out.println("Get id: " + testCustomAlert.getId());
    System.out.println("** Note: Flagged should be false if severity >= 7 **");
    System.out.println("Get Severity: " + testCustomAlert.getSeverity());
    System.out.println("Is flagged: " + testCustomAlert.isFlagged());
    sectionSpacer();
    // Setters
    System.out.println("Testing Setters:");
    testCustomAlert.setTitle("Set custom alert title");
    testCustomAlert.setBody("Set custom alert body");
    byte newSeverity = 6;
    testCustomAlert.display();
    // When severity is set, it should change the flag
    testCustomAlert.setSeverity(newSeverity);
    System.out.println("** Note: Flagged should be false if severity >= 7 **");
    System.out.println("Get Severity: " + testCustomAlert.getSeverity());
    System.out.println("Is flagged: " + testCustomAlert.isFlagged());
    testCustomAlert.display();
  }
}
