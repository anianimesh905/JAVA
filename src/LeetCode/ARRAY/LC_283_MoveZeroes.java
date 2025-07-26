package src.LeetCode.ARRAY;

public class LC_283_MoveZeroes {

    /**
     * 📌 Leetcode 283: Move Zeroes
     *
     * 🧠 Goal: Move all zeros to the end of the array while maintaining the order of non-zero elements.
     * ✅ Do it in-place (modify original array) and use O(n) time.
     *
     * 🔹 Example:
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     */
    static void moveZeroes(int[] arr) {
        int insertPos = 0;  // Keeps track of where to insert the next non-zero element

        // Pass 1: Move all non-zero elements to the front
        for (int num : arr) {
            if (num != 0) {
                arr[insertPos] = num; // Place non-zero element at insertPos
                insertPos++;          // Move insertPos ahead
            }
        }

        // Pass 2: Fill the remaining positions with 0s
        while (insertPos < arr.length) {
            arr[insertPos] = 0;
            insertPos++;
        }

        // Print final array (optional)
        System.out.print("After moving zeroes: ");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums); // Output: 1 3 12 0 0
    }
}
