package src.Recursion.Basics;

/**
 * Problem: Find x^n using recursion
 * Example:
 * Input: x = 2, n = 5
 * Output: 32 (2^5)
 */
public class Power {

    static int power(int x, int n) {
        if (n == 0) return 1; // base case
        return x * power(x, n - 1); // recursive call
    }

    public static void main(String[] args) {
        int x = 2, n = 5;
        System.out.println(power(x, n)); // Output: 32
    }
}

//  power(2,3) = 2 * power(2,2)
//                   = 2 * power(2,1)
//                         = 2 * power(2,0)
//                               = 1