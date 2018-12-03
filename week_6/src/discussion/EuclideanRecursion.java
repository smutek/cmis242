package discussion;
/*
 * File: EuclideanRecursion.java
 * Author: Jimmy Smutek
 * Date: November 26, 2018
 * Purpose: Week 6 discussion
 */

public class EuclideanRecursion {

  /*
    The Euclidean algorithm is a method for computing the greatest common divisor (GCD) of two
    numbers. The algorithm is based on "the greatest common divisor of two numbers does not change
    if the larger number is replaced by its difference with the smaller number"
    @see https://en.wikipedia.org/wiki/Euclidean_algorithm

    There are a number of different approaches to the algorithm, one of them being to:
  1. Divide the larger number (a) by the smaller number (b)
  2. If the remainder (a % b) = 0, then a is the GCD
  3. If not, replace the value of a with the value of b, & replace the value of b with the value
  of the remainder
  4. Repeat until the remainder r= 0, at which point the C=GCD is a
  */

  private static int iterativeGCD(int larger, int smaller) {
    // The iterative version uses a while loop to evaluate the value
    // of "smaller". It requires a temporary variable be used in order that
    // the larger variable may be swapped with the smaller,      and the smaller
    // variable with the remainder.
    while (smaller != 0) {
      int temp = smaller;
      smaller = larger % smaller;
      larger = temp;
    }
    // Once the smaller number reaches zero, return the larger
    return larger;
  }

  private static int recursiveGCD(int larger, int smaller) {

    // Here's the base case. The program will stop when the smaller number
    // reaches 0;
    if (smaller == 0) {
      // When this happens, return the larger number.
      return larger;
    } else {
      // Here is the recursive method. On each pass where the smaller number does not equal zero,
      // the method calls itself again.
      // The "smaller" value is now passed in to the method as the "larger" parameter and the
      // remainder of larger / smaller is passed in directly as the result of larger mod smaller
      //
      return recursiveGCD(smaller, (larger % smaller));
    }
  }

  public static void main(String[] args) {

    int[][] sets = {
      {25527, 53667},
      {53667, 25527},
      {192, 270},
      {270, 192},
      {21, 49},
      {49, 21}
    };

    for (int set[] : sets) {
      int a = set[0], b = set[1];
      System.out.println(a + " & " + b);
      System.out.println("Recursive: " + recursiveGCD(a, b));
      System.out.println("Iterative: " + iterativeGCD(a, b));
    }
  }
}
