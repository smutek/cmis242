import java.awt.Color;

public interface Lamp {

  boolean isLampPoweredOn();

  void setLampPoweredOn(boolean lampPoweredOn);

  boolean isLampPluggedIn();

  void setLampPluggedIn(boolean lampPluggedIn);

  boolean getLampHasFunctionalBulb();

  void setLampHasFunctionalBulb(boolean lampHasFunctionalBulb);

  Color getLampColor();

  void setLampColor(Color lampColor);

  @Override
  String toString();
}
