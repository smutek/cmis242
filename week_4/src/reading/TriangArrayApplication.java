package reading;
/*
 * File: TriangArrayApplication.java
 * Author: Jimmy Smutek
 * Date: November 12, 2018
 * Purpose:
 */

// TriangArrayApplication.java
import java.awt.*;

public class TriangArrayApplication extends NiceFrame {
  public TriangArrayApplication() {
    super("Triangular Array", 200, 200);
    add(new TriangArrayPanel());
  }

  public static void main(String[] args) {
    TriangArrayApplication taApp = new TriangArrayApplication();
    taApp.display();
  }
}
