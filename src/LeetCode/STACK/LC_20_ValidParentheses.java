package src.LeetCode.STACK;

/*
LeetCode Problem #20 - Valid Parentheses

Problem Statement:
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Approach:
1. Use a stack to store opening brackets.
2. For each character:
   - If it is an opening bracket ('(', '{', '['), push it onto the stack.
   - If it is a closing bracket:
       - If stack is empty → invalid.
       - Otherwise, pop from stack and check if it matches.
3. At the end, if the stack is empty → valid string.
   Otherwise → invalid.

Time Complexity: O(n)
   (Each character is processed once.)
Space Complexity: O(n)
   (Stack can hold up to n characters in the worst case.)

Dry Run Example:
s = "([{}])"

- c = '(' → push → stack = ['(']
- c = '[' → push → stack = ['(', '[']
- c = '{' → push → stack = ['(', '[', '{']
- c = '}' → pop '{' → matches → stack = ['(', '[']
- c = ']' → pop '[' → matches → stack = ['(']
- c = ')' → pop '(' → matches → stack = []
End of string → stack empty → return true
*/

import java.util.Stack;

public class LC_20_ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;

                char top = st.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        return st.isEmpty();
    }

    // Optional test
    public static void main(String[] args) {
        LC_20_ValidParentheses solution = new LC_20_ValidParentheses();
        System.out.println(solution.isValid("()"));       // true
        System.out.println(solution.isValid("()[]{}"));   // true
        System.out.println(solution.isValid("(]"));       // false
        System.out.println(solution.isValid("([)]"));     // false
        System.out.println(solution.isValid("{[]}"));     // true
    }
}
