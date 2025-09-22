package src.Recursion.Basics;

/**
 * Problem: Print numbers from 1 to N using recursion
 * Example:
 * Input: N = 5
 * Output: 1 2 3 4 5
 *
 * Approach:
 * - Base case: if n == 0 → stop
 * - Recursive case: printNumbers(n-1), then print n
 */
public class Print1ToN {

    static void printNumbers(int n) {
        if (n == 0) return; // base case
        printNumbers(n - 1); // recursive call
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int n = 5;
        printNumbers(n);
    }
}

//  printNumbers(3)
//   -> printNumbers(2)
//         -> printNumbers(1)
//               -> printNumbers(0) [STOP]
//               -> print 1
//         -> print 2
//   -> print 3