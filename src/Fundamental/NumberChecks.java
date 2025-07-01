package src.Fundamental;

public class NumberChecks {

    // Method to check if a number is Prime
    // A prime number has exactly two distinct positive divisors: 1 and itself
    // Example: 2, 3, 5, 7, 11 are prime numbers
    public static boolean isPrime(int num) {
        if (num <= 1) return false;  // 0 and 1 are not prime
        for (int i = 2; i <= Math.sqrt(num); i++) { // only check up to √num
            if (num % i == 0) return false; // divisible by other number ⇒ not prime
        }
        return true;
    }

    // Method to check if a number is a Palindrome
    // A palindrome number reads the same backward as forward
    // Example: 121, 1331, 12321 are palindromes
    public static boolean isPalindrome(int num) {
        int original = num;     // store the original number
        int reversed = 0;

        while (num > 0) {
            int digit = num % 10;              // extract the last digit
            reversed = reversed * 10 + digit;  // build reversed number
            num /= 10;                         // remove last digit
        }

        return original == reversed; // check if original and reversed are equal
    }

    // Method to check if a number is an Armstrong number (3-digit version)
    // An Armstrong number of 3 digits is equal to the sum of the cubes of its digits
    // Example: 153 = 1³ + 5³ + 3³ = 1 + 125 + 27 = 153
    public static boolean isArmstrong(int num) {
        int original = num;
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;           // get last digit
            sum += digit * digit * digit;   // cube it and add to sum
            num /= 10;                      // remove last digit
        }

        return original == sum; // check if original equals sum of cubes
    }

    // Main method to test all checks
    public static void main(String[] args) {
        int number = 153;

        System.out.println("Number: " + number);
        System.out.println("Is Prime? " + isPrime(number));
        System.out.println("Is Palindrome? " + isPalindrome(number));
        System.out.println("Is Armstrong? " + isArmstrong(number));
    }
}
