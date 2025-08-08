package src.LeetCode.STRING;
/*
LeetCode 28: Find the Index of the First Occurrence in a String

Problem Statement:
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.

Example:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0

Input: haystack = "leetcode", needle = "leeto"
Output: -1

Goal:
Implement basic substring search (without using built-in methods like indexOf).
Use a sliding window to compare characters one by one.
*/

public class LC_28_FindIndexOfFirstOccurrence {

    public static int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();

        if (n2 == 0) return 0;  // Empty needle always found at index 0

        // Traverse the haystack until there's room for needle
        for (int i = 0; i <= n1 - n2; i++) {
            int j = 0;
            // Compare characters of needle with substring of haystack
            while (j < n2 && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            // If full needle matched, return starting index
            if (j == n2)
                return i;
        }

        return -1;  // No match found
    }

    // Optional main method to test
    public static void main(String[] args) {

        String haystack = "sadbutsad";
        String needle = "sad";

        System.out.println("First occurrence at index: " + strStr(haystack, needle));  // Output: 0
    }
}
