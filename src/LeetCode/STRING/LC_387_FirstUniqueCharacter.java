// LC_387_FirstUniqueCharacter.java
// ✅ LeetCode 387 - First Unique Character in a String

package src.LeetCode.STRING;

public class LC_387_FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int[] freq = new int[26]; // To store frequency of each character

        // Count frequency of each character
        // 🟡 Step 1: Count how many times each character appears
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            // 'a' - 'a' = 0   → freq[0]++
            // 'b' - 'a' = 1   → freq[1]++
            // 'z' - 'a' = 25  → freq[25]++
        }

        // 🟢 Step 2: Find the first character that appears only once
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;  // Return the index of the first unique character
            }
        }

        return -1; // No unique character found
    }

    // Test the code using main method
    public static void main(String[] args) {
        LC_387_FirstUniqueCharacter solution = new LC_387_FirstUniqueCharacter();

        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        System.out.println("First unique char index in '" + s1 + "' is: " + solution.firstUniqChar(s1)); // 0
        System.out.println("First unique char index in '" + s2 + "' is: " + solution.firstUniqChar(s2)); // 2
        System.out.println("First unique char index in '" + s3 + "' is: " + solution.firstUniqChar(s3)); // -1
    }
}
