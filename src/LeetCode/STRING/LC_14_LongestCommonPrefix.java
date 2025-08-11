package src.LeetCode.STRING;

/*
LeetCode Problem #14 - Longest Common Prefix

Problem Statement:
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Approach:
1. Assume the first string is the prefix.
2. Compare it with each subsequent string:
   - While the current string does not start with the prefix,
     remove the last character from the prefix using substring().
   - Stop early if the prefix becomes empty.
3. Return the final prefix.

Time Complexity: O(n * m)
   where n = number of strings, m = length of the first string.
Space Complexity: O(1)
   (only uses a few variables)

Dry Run Example:
strs = ["flower", "flow", "flight"]

Initial prefix = "flower"

Compare with "flow":
- "flow".indexOf("flower") != 0 → shorten to "flowe"
- "flow".indexOf("flowe") != 0 → shorten to "flow"
- match found → keep "flow"

Compare with "flight":
- "flight".indexOf("flow") != 0 → shorten to "flo"
- "flight".indexOf("flo") != 0 → shorten to "fl"
- match found → keep "fl"

Final prefix = "fl"
*/

public class LC_14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Start with the first string as the assumed prefix
        String prefix = strs[0];

        // Compare with each string
        for (int i = 1; i < strs.length; i++) {
            // Shorten the prefix until it matches the start of the current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    // Optional test
    public static void main(String[] args) {
        LC_14_LongestCommonPrefix solution = new LC_14_LongestCommonPrefix();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // Output: "fl"
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));    // Output: ""
    }
}
