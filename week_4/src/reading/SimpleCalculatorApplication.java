package reading;
/*
 * File: SimpleCalculatorApplication.java
 * Author: Jimmy Smutek
 * Date: November 12, 2018
 * Purpose:
 */

// SimpleCalculatorApplication.java
import java.awt.*;

public class SimpleCalculatorApplication extends NiceFrame {
  public SimpleCalculatorApplication() {
    super("Simple Calculator Application", 320, 120);
    add(new SimpleCalculatorPanel());
  }

  public static void main(String[] args) {
    SimpleCalculatorApplication scApp = new SimpleCalculatorApplication();
    scApp.display();
  }
}
