/*
LeetCode 2965 - Find Missing and Repeated Values

You are given an `n x n` matrix `grid` where the numbers are from `1` to `n^2`.
However, one number is missing and another number is repeated exactly once.

Return an array of two integers:
- The **first** is the number that is **repeated**,
- The **second** is the number that is **missing**.
*/


package src.LeetCode.HASHING;

import java.util.HashMap;

public class LC_2965_FindMissingAndRepeatedValues {

    // Method to find the repeated and missing values
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Flatten the 2D grid into a frequency map
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
        }

        // Step 2: Find the number repeated twice and the number missing
        int[] result = new int[2]; // result[0] = repeated, result[1] = missing
        for (int i = 1; i <= n * n; i++) {
            int freq = freqMap.getOrDefault(i, 0);
            if (freq == 2) {
                result[0] = i; // repeated value
            } else if (freq == 0) {
                result[1] = i; // missing value
            }
        }

        return result;
    }

    // Sample test
    public static void main(String[] args) {
        LC_2965_FindMissingAndRepeatedValues solution = new LC_2965_FindMissingAndRepeatedValues();

        int[][] grid = {
                {1, 2},
                {2, 4}
        };

        int[] result = solution.findMissingAndRepeatedValues(grid);
        System.out.println("Repeated: " + result[0] + ", Missing: " + result[1]); // Output: Repeated: 2, Missing: 3
    }
}
