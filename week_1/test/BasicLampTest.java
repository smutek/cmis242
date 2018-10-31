import java.awt.Color;
import org.junit.Assert;
import org.junit.Test;

public class BasicLampTest {

  Lamp testLamp = new BasicLamp();
  Lamp testCustomLamp = new BasicLamp(true, true, false, Color.orange);

  @Test
  public void testIsLampPoweredOn() throws Exception {
    Assert.assertFalse(testLamp.isLampPoweredOn());
  }

  @Test
  public void testSetLampPoweredOn() {
    testLamp.setLampPoweredOn(true);
    Assert.assertTrue(testLamp.isLampPoweredOn());
  }

  @Test
  public void testIsLampPluggedIn() {
    Assert.assertFalse(testLamp.isLampPluggedIn());
  }

  @Test
  public void testSetLampPluggedIn() {
    testLamp.setLampPluggedIn(true);
    Assert.assertTrue(testLamp.isLampPluggedIn());
  }

  @Test
  public void testIfLampHasFunctionalBulb() {
    Assert.assertTrue(testLamp.getLampHasFunctionalBulb());
  }

  @Test
  public void setIfLampHasFunctionalBulb() {
    testLamp.setLampHasFunctionalBulb(false);
    Assert.assertFalse(testLamp.getLampHasFunctionalBulb());
  }

  @Test
  public void testGetLampColor() {
    Assert.assertEquals(testLamp.getLampColor(), Color.black);
  }

  @Test
  public void testSetLampColor() {
    testLamp.setLampColor(Color.green);
    Assert.assertEquals(testLamp.getLampColor(), Color.green);
  }

  @Test
  public void testIsCustomLampPoweredOn() {
    Assert.assertTrue(testCustomLamp.isLampPoweredOn());
  }

  @Test
  public void testSetCustomLampPoweredOn() {
    testCustomLamp.setLampPoweredOn(false);
    Assert.assertFalse(testCustomLamp.isLampPoweredOn());
  }

  @Test
  public void testIsCustomLampPluggedIn() {
    Assert.assertTrue(testCustomLamp.isLampPluggedIn());
  }

  @Test
  public void testSetCustomLampPluggedIn() {
    testCustomLamp.setLampPluggedIn(false);
    Assert.assertFalse(testCustomLamp.isLampPluggedIn());
  }

  @Test
  public void testIsCustomLampBulbFunctional() {
    Assert.assertFalse(testCustomLamp.getLampHasFunctionalBulb());
  }

  @Test
  public void testSetLampHasFunctionalBulb() {
    testCustomLamp.setLampHasFunctionalBulb(true);
    Assert.assertTrue(testCustomLamp.getLampHasFunctionalBulb());
  }
}
