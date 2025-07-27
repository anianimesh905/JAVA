// LC_1295_FindEvenDigitNumbers.java
// ✅ LeetCode 1295 - Find Numbers with Even Number of Digits
// 🔸 Problem:
// Given an array nums of integers, return how many of them contain an even number of digits.

// 🔹 Example:
// Input:  nums = [12, 345, 2, 6, 7896]
// Output: 2  → (12 and 7896 have even number of digits)

package src.LeetCode.ARRAY;

import java.util.Arrays;

public class LC_1295_FindEvenDigitNumbers {

    // Method to count how many numbers have even number of digits
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            // Calculate number of digits using log10
            int digits = (int)Math.log10(Math.abs(num)) + 1;

            if (digits % 2 == 0) {
                count++; // Count if number of digits is even
            }
        }

        return count;
    }

    // Main method to test the function
    public static void main(String[] args) {
        LC_1295_FindEvenDigitNumbers solution = new LC_1295_FindEvenDigitNumbers();

        int[] nums = {12, 345, 2, 6, 7896};
        int result = solution.findNumbers(nums);

        System.out.println("Input:  " + Arrays.toString(nums));
        System.out.println("Output: " + result);  // Expected: 2
    }
}
