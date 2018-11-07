package discussion;
/*
 * File: Message.java
 * Author: Jimmy Smutek
 * Date: November 04, 2018
 * Purpose: Create a default message class
 */
public class Message {
  // Message Counter
  private static int mssgCount = 0;
  // Fields: A message has a title, a body, and an ID.
  private int id;
  private String title;
  private String body;
  /** Default Message Constructor */
  Message() {
    title = "Default message title";
    body = "Default message body";
    // Set ID by incrementing message count
    id = mssgCount++;
  }
  /**
   * Message Constructor
   *
   * @param title String
   * @param body String
   */
  Message(String title, String body) {
    this.id = mssgCount++;
    this.title = title;
    this.body = body;
  }
  // getters for the id and message count
  /**
   * Get message count
   *
   * @return int Message count
   */
  public static int getMssgCount() {
    return mssgCount;
  }
  /**
   * Get ID
   *
   * @return int ID
   */
  int getId() {
    return id;
  }
  // getters and setters for title and body
  /**
   * Get title
   *
   * @return String title
   */
  String getTitle() {
    return title;
  }
  /**
   * Set the title
   *
   * @param title String
   */
  void setTitle(String title) {
    this.title = title;
  }
  /**
   * Get the body
   *
   * @return String body
   */
  String getBody() {
    return body;
  }
  /**
   * Set the body
   *
   * @param body String
   */
  void setBody(String body) {
    this.body = body;
  }
  /**
   * To String method
   *
   * @return String Message object as string
   */
  @Override
  public String toString() {
    return "Message{" + "id=" + id + ", title='" + title + '\'' + ", body='" + body + '\'' + '}';
  }
  /** Displaye method */
  void display() {
    System.out.println(this.toString());
  }
}
