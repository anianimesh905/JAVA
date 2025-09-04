package src.LeetCode.STRING;

/**
 * LeetCode 796. Rotate String
 *
 * Problem:
 * Given two strings s and goal, return true if and only if s can become goal
 * after some number of shifts (rotations).
 *
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 *
 * Example:
 * Input: s = "abcde", goal = "cdeab"
 * Output: true
 *
 * Input: s = "abcde", goal = "abced"
 * Output: false
 *
 * Goal:
 * - Check if goal is a substring of s+s (concatenated string).
 */
public class LC_796_RotateString {

    public boolean rotateString(String s, String goal) {
        // If lengths differ, it’s impossible
        if (s.length() != goal.length()) return false;

        // s+s contains all possible rotations of s
        return (s + s).contains(goal);
    }

    // Test the implementation
    public static void main(String[] args) {
        LC_796_RotateString obj = new LC_796_RotateString();

        System.out.println(obj.rotateString("abcde", "cdeab")); // ✅ true
        System.out.println(obj.rotateString("abcde", "abced")); // ❌ false
        System.out.println(obj.rotateString("aab", "aba"));     // ✅ true
    }
}
