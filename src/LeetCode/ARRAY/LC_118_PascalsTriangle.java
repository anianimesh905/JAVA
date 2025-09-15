package src.LeetCode.ARRAY;

import java.util.*;

/**
 * LeetCode 118. Pascal's Triangle
 *
 * Problem Statement:
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle:
 * - Each number is the sum of the two numbers directly above it.
 * - The triangle starts with a single 1 at the top.
 *
 * Example 1:
 * Input: numRows = 5
 * Output: [
 *   [1],
 *   [1,1],
 *   [1,2,1],
 *   [1,3,3,1],
 *   [1,4,6,4,1]
 * ]
 *
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 *
 * Goal:
 * Generate the first numRows rows of Pascal’s Triangle.
 *
 * Approach:
 * ---------------------------------------------------------------
 * 1. Initialize an empty list of lists `triangle`.
 * 2. For each row i (0 to numRows-1):
 *    - Start with an empty row.
 *    - First and last elements are always 1.
 *    - Middle elements are calculated as the sum of two elements from the row above:
 *      row[j] = triangle[i-1][j-1] + triangle[i-1][j].
 * 3. Add the row into the triangle.
 * 4. Return the triangle.
 */

public class LC_118_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // First and last elements are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Middle elements = sum of two above
                    int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(val);
                }
            }
            triangle.add(row);
        }

        return triangle;
    }

    // Test the implementation
    public static void main(String[] args) {
        LC_118_PascalsTriangle obj = new LC_118_PascalsTriangle();

        System.out.println(obj.generate(5)); // [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
        System.out.println(obj.generate(1)); // [[1]]
    }
}

/**
 * Time Complexity:
 * - O(numRows^2): We generate each element of the triangle once.
 *
 * Space Complexity:
 * - O(numRows^2): The output triangle stores all rows.
 */
