package src.LeetCode.ARRAY;

import java.util.*;

/**
 * LeetCode 73. Set Matrix Zeroes
 *
 * Problem Statement:
 * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 *
 * Example:
 * Input:  [[1,1,1],
 *          [1,0,1],
 *          [1,1,1]]
 * Output: [[1,0,1],
 *          [0,0,0],
 *          [1,0,1]]
 */

public class LC_73_SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Flags to check if the *first row* or *first column* need to be zeroed later
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 1: Check if the first row has any zero
        // If yes, we mark "firstRowZero = true"
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 2: Check if the first column has any zero
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Step 3: Use first row & first column as "markers"
        // If matrix[i][j] == 0, mark matrix[i][0] = 0 (row marker) and matrix[0][j] = 0 (column marker)
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // mark the row
                    matrix[0][j] = 0;  // mark the column
                }
            }
        }

        // Step 4: Set elements to zero using the markers
        // If either row marker or column marker is 0 -> make that cell 0
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: Finally, handle the first row
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 6: Finally, handle the first column
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // Test the implementation
    public static void main(String[] args) {
        LC_73_SetMatrixZeroes obj = new LC_73_SetMatrixZeroes();

        int[][] matrix1 = {{1,1,1},{1,0,1},{1,1,1}};
        obj.setZeroes(matrix1);
        printMatrix(matrix1); // [[1,0,1],[0,0,0],[1,0,1]]

        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        obj.setZeroes(matrix2);
        printMatrix(matrix2); // [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
    }

    // Helper function to print matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}

/**
 * ✅ Time Complexity: O(m * n)
 *    (we scan the matrix twice at most)
 *
 * ✅ Space Complexity: O(1)
 *    (no extra space, just using flags & matrix itself)
 */
