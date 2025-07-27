// LC_344_ReverseString.java
// ✅ LeetCode 344 - Reverse String
// 🔸 Problem:
// Write a function that reverses a string. The input string is given as a character array `s`.
// You must reverse the characters in-place with O(1) extra memory.
// Example:
// Input: s = ['h','e','l','l','o']
// Output: ['o','l','l','e','h']

package src.LeetCode.STRING;

import java.util.Arrays;

public class LC_344_ReverseString {

    // Method to reverse the input char array in-place
    public void reverseString(char[] s) {
        int i = 0;                 // Start pointer
        int j = s.length - 1;     // End pointer

        // Swap characters at i and j, moving inward
        while (i < j) {
            char temp = s[i];     // Store left character
            s[i] = s[j];          // Assign right to left
            s[j] = temp;          // Assign stored left to right

            i++;                  // Move left pointer
            j--;                  // Move right pointer
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        LC_344_ReverseString solution = new LC_344_ReverseString();

        // Test input
        char[] s = {'H', 'e', 'l', 'l', 'o'};

        System.out.println("Before: " + Arrays.toString(s));
        solution.reverseString(s);  // Call the reverse method
        System.out.println("After:  " + Arrays.toString(s));
    }
}
