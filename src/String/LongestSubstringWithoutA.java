// 📘 Question:
// Write a program to find the longest continuous substring(s) in a given string
// that does NOT contain the letter 'a' (lowercase only).
//
// ✅ Example:
// Input: "hbcdeafhij"
// Output: Longest substring without 'a': hbcde
//
// If there are multiple substrings with the same longest length (without 'a'),
// you may list all of them as well (optional).

package src.String;

public class LongestSubstringWithoutA {

    // 🧠 Function to find and print the longest substring(s) without the letter 'a'
    static void longestSubstringWithoutA(String s) {
        String longest = "";  // Stores the longest substring found so far
        String current = "";  // Stores the current building substring (as we iterate)
        String same = "";     // Optional: Stores other substrings with same max length

        // 🌀 Loop through each character of the input string
        for (char c : s.toCharArray()) {

            // ✅ Case 1: If current character is NOT 'a'
            if (c != 'a') {
                current += c; // Add the character to current substring

                // 🎯 If the new current substring is longer than the previous longest
                if (current.length() > longest.length()) {
                    longest = current;  // Update the longest substring
                    same = current;     // Reset same (start with the new longest)
                }

                // 📌 If current is equal in length to the longest, and not already in `same`
                else if (current.length() == longest.length() && !same.contains(current)) {
                    same += ", " + current; // Add it to list of same-length substrings
                }
            }

            // ❌ Case 2: If character is 'a', reset current substring
            else {
                current = ""; // Start a new substring after 'a'
            }
        }

        // 📤 Output results
        System.out.println("Longest substring without 'a': " + longest);  // main longest substring
        System.out.println("Other substrings with same max length: " + same);  // optional
    }

    // 🚀 Main method to test the function
    public static void main(String[] args) {
        String input = "hbcdeafhiij"; // You can change this to test more cases
        longestSubstringWithoutA(input); // Call the function
    }
}
