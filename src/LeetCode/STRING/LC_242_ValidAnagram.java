package src.LeetCode.STRING;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LeetCode 242. Valid Anagram
 *
 * Problem:
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word formed by rearranging the letters of another word.
 *
 * Example:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Goal:
 * - Compare character frequencies of both strings.
 */
public class LC_242_ValidAnagram {

    // Approach 1: Using frequency count (O(n)), works for lowercase letters
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // only lowercase letters

        for (char c : s.toCharArray()) count[c - 'a']++;
        for (char c : t.toCharArray()) count[c - 'a']--;

        for (int freq : count) {
            if (freq != 0) return false;
        }
        return true;
    }

    // Approach 2: Sorting (O(n log n))
    public boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    // Approach 3: Using HashMap (O(n)), works for any character set
    public boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of chars in s
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Decrease frequency using chars from t
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false; // char not found
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);   // clean up
        }

        return map.isEmpty();
    }

    // Test the implementation
    public static void main(String[] args) {
        LC_242_ValidAnagram obj = new LC_242_ValidAnagram();

        System.out.println(obj.isAnagram("anagram", "nagaram"));   // ✅ true
        System.out.println(obj.isAnagram("rat", "car"));           // ❌ false

        // Using sorting
        System.out.println(obj.isAnagramSort("listen", "silent")); // ✅ true

        // Using HashMap
        System.out.println(obj.isAnagramHashMap("aabbcc", "baccab")); // ✅ true
        System.out.println(obj.isAnagramHashMap("hello", "world"));   // ❌ false
    }
}
