package src.LeetCode.STRING;

/*
🔶 LeetCode 1021 - Remove Outermost Parentheses

🔹 Problem:
A valid parentheses string is either empty "", "(" + A + ")", or A + B,
where A and B are valid parentheses strings.
A primitive parentheses string is a nonempty valid string that cannot be
split into smaller valid strings.

Given a valid parentheses string `s`, remove the outermost parentheses
of every primitive string in `s`.

🔸 Example:
Input: s = "(()())(())"
Output: "()()()"
Explanation: Primitive parts are "(()())" and "(())".
After removing outermost "()", we get "()()" and "()".

🎯 Goal:
Remove the outermost parentheses of each primitive group and return the result.
*/

public class LC_1021_RemoveOutermostParentheses {

    public String removeOuterParentheses(String s) {
        StringBuilder st = new StringBuilder(); // Stores final string without outer parentheses
        int start = 0; // Marks the start index of a primitive group
        int sum = 0;   // Tracks balance of parentheses

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                sum++; // Opening increases balance
            else
                sum--; // Closing decreases balance

            if (sum == 0) { // Primitive group completed
                st.append(s.substring(start + 1, i)); // Add without outer parentheses
                start = i + 1; // Move start to next group
            }
        }
        return st.toString();
    }

    // Test the method
    public static void main(String[] args) {
        LC_1021_RemoveOutermostParentheses sol = new LC_1021_RemoveOutermostParentheses();
        System.out.println(sol.removeOuterParentheses("(()())(())")); // Output: "()()()"
        System.out.println(sol.removeOuterParentheses("(()())(())(()(()))")); // Output: "()()()()(())"
    }
}