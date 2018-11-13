package reading;
/*
 * File: GraphicsApplication.java
 * Author: Jimmy Smutek
 * Date: November 12, 2018
 * Purpose:
 */

import java.awt.*;
public class GraphicsApplication extends NiceFrame {
  public GraphicsApplication() {
    super("Graphics Application", 220, 160);
    add(new DrawingPanel());
  }
  static public void main(String[] args)   {
    GraphicsApplication grApp = new GraphicsApplication();
    grApp.display();
  }
}