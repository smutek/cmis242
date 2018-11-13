package reading;
/*
 * File: HelloWorldApplication.java
 * Author: Jimmy Smutek
 * Date: November 12, 2018
 * Purpose: GUI demo
 */

import java.awt.Graphics;

public class HelloWorldApplication extends NiceFrame {

  HelloWorldApplication() {
    super("Hello, World!", 270, 180);
  }
  public void paint(Graphics g) {
    g.drawString("Hello, World!", 100, 100);

  }

  public static void main(String[] args) {
    HelloWorldApplication hwApp = new HelloWorldApplication();
    hwApp.display();
  }

}
