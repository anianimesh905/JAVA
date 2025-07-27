// LC_1920_BuildArrayFromPermutation.java
// ✅ LeetCode 1920 - Build Array from Permutation
// 🔸 Problem:
// Given a zero-based permutation `nums` (i.e., it contains every number from 0 to nums.length - 1),
// build an array `ans` such that `ans[i] = nums[nums[i]]`, and return it.

// 🔹 Example:
// Input:  nums = [0,2,1,5,3,4]
// Output: [0,1,2,4,5,3]

package src.LeetCode.ARRAY;

import java.util.Arrays;

public class LC_1920_BuildArrayFromPermutation {

    // Method to build the array based on the permutation rule
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n]; // Create new array of same length

        for (int i = 0; i < n; i++) {
            result[i] = nums[nums[i]]; // Follow the rule: result[i] = nums[nums[i]]
        }

        return result; // Return the new array
    }

    // Main method to test the function
    public static void main(String[] args) {
        LC_1920_BuildArrayFromPermutation solution = new LC_1920_BuildArrayFromPermutation();

        int[] nums = {0, 2, 1, 5, 3, 4};  // Input array
        int[] result = solution.buildArray(nums); // Call the method

        System.out.println("Input:  " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(result)); // Should print: [0, 1, 2, 4, 5, 3]
    }
}
