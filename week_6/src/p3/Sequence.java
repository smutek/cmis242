package p3;
/*
 * File: Sequence.java
 * Author: Jimmy Smutek
 * Date: November 28, 2018
 * Purpose: Defines static utility and computational methods
 */
public class Sequence {

  /** Constructor */
  public Sequence() {}

  /**
   * Computer iterative method
   *
   * @param iterate int
   * @return int
   */
  public static int computeIterative(int iterate) {
    System.out.println("Iterative method fired. Input was " + iterate);
    return iterate;
  }

  /**
   * Compute using recursive method
   *
   * @param recurse int
   * @return int
   */
  public static int computeRecursive(int recurse) {
    System.out.println("Recursive method fired. Input was " + recurse);
    return recurse;
  }

  public static int getEfficiency() {
    return 1;
  }
}
