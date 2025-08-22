package src.LeetCode.STRING;

/*
 🔶 LeetCode 392 - Is Subsequence

 🔹 Problem Statement:
 Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 A subsequence of a string is a new string that is formed from the original string
 by deleting some (can be none) of the characters without disturbing the relative positions
 of the remaining characters.

 🔸 Examples:
 Input: s = "abc", t = "ahbgdc"
 Output: true

 Input: s = "axc", t = "ahbgdc"
 Output: false

 ✅ Goal:
 Check if all characters of string `s` appear in string `t` in the same order.
*/

public class LC_392_IsSubsequence {

    // ✅ Two-pointer solution
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0; // Pointers for s and t

        // Traverse both strings
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // Move pointer in s if characters match
            }
            j++; // Always move pointer in t
        }

        // If we matched all characters of s, return true
        return i == s.length();
    }

    // 🧪 Test the code
    public static void main(String[] args) {
        LC_392_IsSubsequence solution = new LC_392_IsSubsequence();

        System.out.println(solution.isSubsequence("abc", "ahbgdc")); // true
        System.out.println(solution.isSubsequence("axc", "ahbgdc")); // false
        System.out.println(solution.isSubsequence("", "ahbgdc"));    // true
        System.out.println(solution.isSubsequence("abc", ""));       // false
    }
}
