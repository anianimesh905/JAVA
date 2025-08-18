package src.LeetCode.STRING;

/*
LeetCode Problem #557 - Reverse Words in a String III

Problem Statement:
Given a string s, reverse the characters of each word in the sentence while still
preserving whitespace and the initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "God Ding"
Output: "doG gniD"

Approach:
1. Split the sentence into words using spaces.
2. For each word:
   - Reverse the word using StringBuilder.
   - Append it to the final result with a space.
3. Remove the trailing space at the end using trim().
4. Return the final string.

Time Complexity: O(n)
   where n = length of the string (we traverse each character once).
Space Complexity: O(n)
   (a new string is created for the result).

Dry Run Example:
Input: "God Ding"
Split → ["God", "Ding"]

Word = "God" → reversed = "doG"
Word = "Ding" → reversed = "gniD"

Join → "doG gniD"
Final Answer = "doG gniD"
*/

public class LC_557_ReverseWordsInStringIII {

    public String reverseWords(String s) {
        // Split the input string into words
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        // Reverse each word and append to result
        for (String word : words) {
            result.append(new StringBuilder(word).reverse().toString()).append(" ");
        }

        // Remove the extra trailing space
        return result.toString().trim();
    }

    // Optional test
    public static void main(String[] args) {
        LC_557_ReverseWordsInStringIII solution = new LC_557_ReverseWordsInStringIII();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
        // Output: "s'teL ekat edoCteeL tsetnoc"

        System.out.println(solution.reverseWords("God Ding"));
        // Output: "doG gniD"
    }
}
