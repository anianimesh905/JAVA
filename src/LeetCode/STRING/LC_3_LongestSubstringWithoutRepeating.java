package src.LeetCode.STRING;

import java.util.*;

/**
 * LeetCode 3. Longest Substring Without Repeating Characters
 *
 * Problem:
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 *
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 *
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 *
 * Approach (Sliding Window):
 * 1. Use two pointers (left, right) to represent the current window.
 * 2. Use HashSet to store unique characters.
 * 3. Expand right → if duplicate found, shrink left until no duplicates.
 * 4. Keep track of max window size.
 */
public class LC_3_LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            // If duplicate found, shrink window
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

    // Test the implementation
    public static void main(String[] args) {
        LC_3_LongestSubstringWithoutRepeating obj = new LC_3_LongestSubstringWithoutRepeating();

        System.out.println(obj.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(obj.lengthOfLongestSubstring(""));         // 0
    }
}
