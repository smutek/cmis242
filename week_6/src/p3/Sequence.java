package p3;

import java.util.ArrayList;
import java.util.List;

/*
 * File: Sequence.java
 * Author: Jimmy Smutek
 * Date: November 28, 2018
 * Purpose: Defines static utility and computational methods
 */
public class Sequence {

  private static int count;
  private static List<Integer> seq;

  /**
   * Iterative method
   *
   * <p>Accept a value of n and return the corresponding element in the sequence using iteration.
   *
   * @param n int Sequence marker
   * @return int r Result (Term value at that marker) & e (efficiency)
   */
  public static int computeIterative(int n) {
    for (int i = 0; i <= n; i++) {
      // c = 2 x a + b
      seq.add(2 * seq.get(i) + seq.get(i + 1));
      count++;
    }
    return seq.get(n);
  }

  /**
   * Recursive method
   *
   * <p>Accept a value of n and return the corresponding element in the sequence using recursion.
   * This method will initialize the efficiency counter before calling the private recursive method.
   *
   * @param n int
   * @return int
   */
  public static int computeRecursive(int n) {
    if (count == n) {
      return seq.get(n);
    }
    seq.add(2 * seq.get(count) + seq.get(count + 1));
    count++;
    return computeRecursive(n);
  }

  /**
   * Return the efficiency counter from the previous call to either of the above two methods.
   *
   * @return int Efficiency Counter
   */
  public static int getEfficiency() {
    return count;
  }

  /** Reset the efficiency counter to 0 */
  public static void resetEfficiency() {
    count = 0;
    seq = new ArrayList<>(20);
    seq.add(0);
    seq.add(1);
  }
}
