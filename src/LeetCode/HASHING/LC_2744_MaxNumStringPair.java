package src.LeetCode.HASHING;

import java.util.HashSet;

/**
 * LeetCode 2744 – Find Maximum Number of String Pairs
 *
 * You are given a 0-indexed array of strings words.
 * A pair of indices (i, j) is called a string pair if:
 *   - i < j
 *   - words[i] == reverse(words[j])
 *
 * Return the maximum number of string pairs that can be formed.
 *
 * Example:
 * Input: words = ["cd","ac","dc","ca","zz"]
 * Output: 2
 * Explanation: Two pairs can be formed: ("cd","dc") and ("ac","ca")
 */

public class LC_2744_MaxNumStringPair {

    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> hs = new HashSet<>();
        for (String s : words) {
            hs.add(s);
        }

        int count = 0;
        for (String s : words) {
            String str = new StringBuilder(s).reverse().toString();
            if (hs.contains(str))
                hs.remove(s);
            if (hs.contains(str))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        LC_2744_MaxNumStringPair solution = new LC_2744_MaxNumStringPair();
        String[] words = {"cd", "ac", "dc", "ca", "zz"};
        int result = solution.maximumNumberOfStringPairs(words);
        System.out.println("Maximum number of string pairs: " + result);
    }
}
