package src.Recursion.Basics;

/**
 * Problem: Find factorial of N using recursion
 * Example:
 * Input: 5
 * Output: 120
 *
 * Approach:
 * - Base case: fact(0) = 1
 * - Recursive case: fact(n) = n * fact(n-1)
 */
public class Factorial {

    static int fact(int n) {
        if (n == 0) return 1; // base case
        return n * fact(n - 1); // recursive call
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fact(n)); // Output: 120
    }
}

//fact(3)
//= 3 * fact(2)
//       = 2 * fact(1)
//              = 1 * fact(0)
//                     = 1