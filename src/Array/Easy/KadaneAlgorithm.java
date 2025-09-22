package src.Array.Easy;

import java.util.*;

/**
 * LeetCode 53. Maximum Subarray
 *
 * Problem Statement:
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example 1:
 * Input:  nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4, -1, 2, 1] has the largest sum = 6
 *
 * Example 2:
 * Input:  nums = [1]
 * Output: 1
 *
 * Example 3:
 * Input:  nums = [5,4,-1,7,8]
 * Output: 23
 *
 * Goal:
 * Find the maximum subarray sum using Kadane's Algorithm.
 *
 * Approach (Kadane's Algorithm):
 * ---------------------------------------------------------------
 * 1. Iterate through the array while keeping two variables:
 *    - currSum: maximum subarray sum ending at current index
 *    - maxSum: maximum subarray sum found so far
 *
 * 2. At each step:
 *    - Either start a new subarray from current element
 *    - Or extend the previous subarray
 *
 * 3. Also track the start and end indices to retrieve the subarray itself.
 */

public class KadaneAlgorithm {

    // ✅ Method 1: Return both maximum sum and subarray
    public void findMaxSubarray(int[] nums) {
        int n = nums.length;

        int currSum = nums[0];
        int maxSum = nums[0];

        int start = 0, end = 0;     // final indices of max subarray
        int tempStart = 0;          // temp start for current subarray

        for (int i = 1; i < n; i++) {

            if (currSum + nums[i] < nums[i]) {
                currSum = nums[i];
                tempStart = i;      // start new subarray
            } else {
                currSum += nums[i]; // continue subarray
            }

            if (currSum > maxSum) {
                maxSum = currSum;
                start = tempStart;
                end = i;
            }
        }

        System.out.println("Maximum Subarray Sum = " + maxSum);
        printSubarray(nums, start, end);
    }

    // ✅ Method 2: Simpler Kadane's version — only returns the max sum
    public int maxSubarraySum(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    // Helper: Print subarray from start to end index
    private void printSubarray(int[] nums, int start, int end) {
        System.out.print("Subarray: [");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i]);
            if (i < end) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Test the implementation
    public static void main(String[] args) {
        KadaneAlgorithm obj = new KadaneAlgorithm();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        // Method 1: Print both sum and subarray
        obj.findMaxSubarray(nums);

        // Method 2: Only print max sum
        System.out.println("Maximum Subarray Sum (simple) = " + obj.maxSubarraySum(nums));
    }
}

/**
 * Time Complexity:
 * - O(n): Traverse the array once.
 *
 * Space Complexity:
 * - O(1): Constant extra space.
 */
