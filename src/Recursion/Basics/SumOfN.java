package src.Recursion.Basics;

/**
 * Problem: Find sum of first N numbers using recursion
 * Example:
 * Input: 5
 * Output: 15 (1+2+3+4+5)
 */
public class SumOfN {

    static int sum(int n) {
        if (n == 0) return 0; // base case
        return n + sum(n - 1); // recursive call
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(sum(n)); // Output: 15
    }
}

//sum(3) = 3 + sum(2)
//             = 2 + sum(1)
//                   = 1 + sum(0)
//                          = 0