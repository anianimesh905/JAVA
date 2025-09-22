package src.Recursion.Basics;

/**
 * Problem: Print numbers from N to 1 using recursion
 * Example:
 * Input: N = 3
 * Output: 3 2 1
 *
 * Approach:
 * - Base case: if n == 0 → stop
 * - Recursive case: print n first, then call printNumbers(n-1)
 */
public class PrintNTo1 {

    static void printNumbers(int n) {
        if (n == 0) return; // base case
        System.out.print(n + " "); // print first
        printNumbers(n - 1); // recursive call
    }

    public static void main(String[] args) {
        int n = 3;
        printNumbers(n);
    }
}

/**
 * Recursion Tree for n = 3
 *
 * printNumbers(3)
 *   -> prints 3
 *   -> calls printNumbers(2)
 *          -> prints 2
 *          -> calls printNumbers(1)
 *                 -> prints 1
 *                 -> calls printNumbers(0) [STOP]
 */