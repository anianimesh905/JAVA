package src.LeetCode.ARRAY;

/*
 🔶 LeetCode 48 - Rotate Image

 🔹 Problem Statement:
 You are given an `n x n` 2D matrix representing an image. Rotate the image by 90 degrees (clockwise) in place.

 🔸 Example:
 Input:
 matrix = [
   [1,2,3],
   [4,5,6],
   [7,8,9]
 ]
 Output:
 [
   [7,4,1],
   [8,5,2],
   [9,6,3]
 ]

 ✅ Goal:
 Rotate the matrix 90° clockwise in place without using extra space.

 🔹 Approach:
 1. **Transpose the matrix** (swap across the diagonal).
 2. **Reverse each row** to complete the rotation.

 ✅ Time Complexity: O(n^2)
 ✅ Space Complexity: O(1) (in-place rotation)
*/

import java.util.Arrays;

public class LC_48_RotateImage {

    // ✅ Rotate the matrix 90 degrees clockwise
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // 🧪 Test the code
    public static void main(String[] args) {
        LC_48_RotateImage solution = new LC_48_RotateImage();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        solution.rotate(matrix);

        System.out.println("\nRotated Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
