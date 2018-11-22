package reading;
/*
 * File: SketchApplication.java
 * Author: Jimmy Smutek
 * Date: November 12, 2018
 * Purpose:
 */

public class SketchApplication extends NiceFrame {
  private SketchPanel sketchPanel = new SketchPanel();

  public SketchApplication() {
    super("Sketcher");
    add(sketchPanel);
  }

  public static void main(String[] args) {
    SketchApplication skApp = new SketchApplication();
    skApp.display();
  }
}
