package src.LeetCode.ARRAY;

/**
 * 📌 Leetcode 53: Maximum Subarray
 *
 * 🧠 Problem:
 * Given an integer array `nums`, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * ✨ Bonus: Also print the subarray itself.
 *
 * 🔹 Input: [-2,1,-3,4,-1,2,1,-5,4]
 * 🔹 Output: 6 (Subarray: [4, -1, 2, 1])
 */

public class LC_53_MaximumSubarray {

    // ✅ Kadane’s Algorithm with subarray index tracking
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];         // Stores the overall maximum subarray sum
        int currentSum = nums[0];     // Running sum of current subarray

        int start = 0;                // Start index of max subarray
        int end = 0;                  // End index of max subarray
        int tempStart = 0;           // Temp start index for current subarray

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];     // Start a new subarray at index i
                tempStart = i;
            } else {
                currentSum += nums[i];    // Extend current subarray
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;      // Update maxSum
                start = tempStart;        // Update start of best subarray
                end = i;                  // Update end of best subarray
            }
        }

        // ✅ Optional: Print the subarray with max sum
        System.out.print("Max Subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        return maxSum;
    }

    // 🚀 Main method for testing
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(nums); // Expected Output: 6

        System.out.println("Maximum Subarray Sum: " + result);
    }
}
