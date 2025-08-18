package src.LeetCode.STRING;

/*
LeetCode Problem #520 - Detect Capital Use

Problem Statement:
We define the usage of capitals in a word to be correct when one of the following cases holds:
1. All letters in this word are capitals. ("USA")
2. All letters in this word are not capitals. ("leetcode")
3. Only the first letter in this word is capital, and all other letters are not capital. ("Google")

Return true if the given word uses capitals correctly.

Example 1:
Input: word = "USA"
Output: true

Example 2:
Input: word = "leetcode"
Output: true

Example 3:
Input: word = "Google"
Output: true

Example 4:
Input: word = "FlaG"
Output: false

Approach:
1. Count how many uppercase characters exist in the word.
2. Valid cases:
   - Case 1: All characters are uppercase.
   - Case 2: No characters are uppercase (all lowercase).
   - Case 3: Only the first character is uppercase, rest are lowercase.
3. If none of the above cases match, return false.

Time Complexity: O(n)
   where n = length of the word (we scan characters once).
Space Complexity: O(1)
   (only a counter variable is used).

Dry Run Example:
word = "Google"
- Count uppercase letters → 1 ('G')
- Not all uppercase, not all lowercase
- Check if only first letter is uppercase → true
Final Answer = true
*/

public class LC_520_DetectCapitalUse {

    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int upperCount = 0;

        // Count uppercase characters
        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                upperCount++;
            }
        }

        // Case 1: All uppercase
        if (upperCount == n) return true;

        // Case 2: All lowercase
        if (upperCount == 0) return true;

        // Case 3: Only first uppercase, rest lowercase
        if (upperCount == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            return true;
        }

        return false;
    }

    // Optional test
    public static void main(String[] args) {
        LC_520_DetectCapitalUse solution = new LC_520_DetectCapitalUse();
        System.out.println(solution.detectCapitalUse("USA"));     // true
        System.out.println(solution.detectCapitalUse("leetcode"));// true
        System.out.println(solution.detectCapitalUse("Google"));  // true
        System.out.println(solution.detectCapitalUse("FlaG"));    // false
    }
}
