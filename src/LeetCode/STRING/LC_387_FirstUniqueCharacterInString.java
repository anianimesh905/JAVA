package src.LeetCode.STRING;

/*
LeetCode Problem #387 - First Unique Character in a String

Problem Statement:
Given a string `s`, find the first non-repeating character in it
and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0
Explanation: 'l' is the first character that does not repeat.

Example 2:
Input: s = "loveleetcode"
Output: 2
Explanation: 'v' is the first character that does not repeat.

Example 3:
Input: s = "aabb"
Output: -1
Explanation: No character is unique in this string.

Approach (Using HashMap):
1. Use a HashMap<Character, Integer> to store the frequency of each character.
2. First pass: store the count of each character in the map.
3. Second pass: check characters in original order and return the index
   of the first one with frequency 1.
4. If none are unique, return -1.

Time Complexity: O(n)   // two passes over the string
Space Complexity: O(1)  // constant for 26 lowercase letters, but O(k) for generic char set
*/

import java.util.HashMap;

public class LC_387_FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        // First pass: count frequency
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Second pass: find first unique character
        for (int i = 0; i < s.length(); i++) {
            if (freqMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    // Optional test
    public static void main(String[] args) {
        LC_387_FirstUniqueCharacterInString solution = new LC_387_FirstUniqueCharacterInString();
        System.out.println(solution.firstUniqChar("leetcode"));      // Output: 0
        System.out.println(solution.firstUniqChar("loveleetcode"));  // Output: 2
        System.out.println(solution.firstUniqChar("aabb"));          // Output: -1
    }
}