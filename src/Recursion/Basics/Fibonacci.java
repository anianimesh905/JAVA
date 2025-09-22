package src.Recursion.Basics;

/**
 * Problem: Find nth Fibonacci number using recursion
 * Example:
 * Input: n = 5
 * Output: 5
 * (Fibonacci sequence: 0 1 1 2 3 5 8 ...)
 */
public class Fibonacci {

    static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n)); // Output: 5
    }
}

//fib(4)
// = fib(3) + fib(2)
//   = (fib(2) + fib(1)) + (fib(1) + fib(0))
//   = ((fib(1)+fib(0)) + 1) + (1+0)
//   = ((1+0)+1) + 1
//   = 3