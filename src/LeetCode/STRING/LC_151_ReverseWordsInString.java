package src.LeetCode.STRING;

/**
 * LeetCode 151 - Reverse Words in a String
 *
 * Problem Statement:
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between words.
 * The returned string should only have a single space separating words. Do not include extra spaces.
 *
 * Example:
 * Input: s = "  the sky  is blue  "
 * Output: "blue is sky the"
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 *
 * Goal:
 * - Trim leading/trailing spaces.
 * - Split words by spaces.
 * - Reverse the order of words.
 * - Join with single space.
 */

public class LC_151_ReverseWordsInString {
    public String reverseWords(String s) {
        // Step 1: Trim leading and trailing spaces
        s = s.trim();

        // Step 2: Split words by one or more spaces (regex)
        String[] words = s.split("\\s+");

        // Step 3: Reverse words using StringBuilder
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" ");
        }

        return sb.toString();
    }

    // Optional test
    public static void main(String[] args) {
        LC_151_ReverseWordsInString sol = new LC_151_ReverseWordsInString();
        System.out.println(sol.reverseWords("  the sky  is blue  ")); // "blue is sky the"
        System.out.println(sol.reverseWords("  hello world  ")); // "world hello"
        System.out.println(sol.reverseWords("a good   example")); // "example good a"
    }
}
