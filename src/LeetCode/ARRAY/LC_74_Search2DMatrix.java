package src.LeetCode.ARRAY;

import java.util.*;

/**
 * LeetCode 74. Search a 2D Matrix
 *
 * Problem Statement:
 * You are given an m x n integer matrix with the following properties:
 * 1. Each row is sorted in non-decreasing order.
 * 2. The first integer of each row is greater than the last integer of the previous row.
 *
 * Given an integer target, return true if target is in the matrix, or false otherwise.
 *
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 * Goal:
 * Efficiently determine whether the target exists in the sorted 2D matrix.
 *
 * Approach (Binary Search on Flattened Matrix):
 * ---------------------------------------------------------------
 * 1. Treat the 2D matrix as a flattened 1D sorted array.
 *    - Index mapping:
 *      row = mid / n, col = mid % n
 *      where n = number of columns.
 *
 * 2. Apply standard binary search on this virtual 1D array:
 *    - If matrix[row][col] == target → return true
 *    - If matrix[row][col] < target → move right
 *    - If matrix[row][col] > target → move left
 *
 * 3. If not found after binary search → return false.
 */

public class LC_74_Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;        // number of rows
        int n = matrix[0].length;     // number of columns

        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / n;  // row index in matrix
            int col = mid % n;  // col index in matrix
            int midVal = matrix[row][col];

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    // Test the implementation
    public static void main(String[] args) {
        LC_74_Search2DMatrix obj = new LC_74_Search2DMatrix();

        int[][] matrix1 = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };

        System.out.println(obj.searchMatrix(matrix1, 3));   // true
        System.out.println(obj.searchMatrix(matrix1, 13));  // false
        System.out.println(obj.searchMatrix(matrix1, 60));  // true
        System.out.println(obj.searchMatrix(matrix1, 1));   // true
        System.out.println(obj.searchMatrix(matrix1, 100)); // false
    }
}

/**
 * Time Complexity:
 * - O(log(m * n)) → Binary search over all elements.
 *
 * Space Complexity:
 * - O(1) → Only a few variables used.
 */
