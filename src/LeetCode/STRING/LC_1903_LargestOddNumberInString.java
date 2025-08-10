package src.LeetCode.STRING;

/*
LeetCode Problem #1903 - Largest Odd Number in String

Problem Statement:
You are given a string `num`, representing a large integer.
You need to find the largest-valued odd integer (as a substring) that is a non-empty prefix of `num`.
Return this substring, or an empty string if no such odd integer exists.

Example 1:
Input: num = "52"
Output: "5"
Explanation: "5" is the only non-empty odd prefix.

Example 2:
Input: num = "4206"
Output: ""
Explanation: There is no odd prefix in the given number.

Example 3:
Input: num = "35427"
Output: "35427"
Explanation: The whole number is odd, so we return it.

Approach:
1. We iterate from the rightmost digit towards the left.
2. We check each digit to see if it is odd.
3. The first odd digit from the right determines the end index of our answer.
4. Return the substring from start to that index (inclusive).
5. If no odd digit is found, return an empty string.

Time Complexity: O(n)  // single pass through the string
Space Complexity: O(1) // no extra space used apart from variables
*/

public class LC_1903_LargestOddNumberInString {

    public String largestOddNumber(String num) {
        int n = num.length();
        int end = -1;

        // Traverse from right to left to find the last odd digit
        for (int i = n - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0'; // convert char to int
            if (digit % 2 != 0) { // odd digit found
                end = i;
                break;
            }
        }

        // If found, return substring; else return ""
        if (end != -1)
            return num.substring(0, end + 1);
        else
            return "";
    }

    // Optional test
    public static void main(String[] args) {
        LC_1903_LargestOddNumberInString solution = new LC_1903_LargestOddNumberInString();
        System.out.println(solution.largestOddNumber("52"));      // Output: "5"
        System.out.println(solution.largestOddNumber("4206"));    // Output: ""
        System.out.println(solution.largestOddNumber("35427"));   // Output: "35427"
    }
}
