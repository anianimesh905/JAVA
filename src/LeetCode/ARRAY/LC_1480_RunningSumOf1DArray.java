package src.LeetCode.ARRAY;

/**
 * 📌 1480. Running Sum of 1d Array (Leetcode Easy)
 *
 * 🧠 Problem Statement:
 * Given an array `nums`. We define a running sum of an array as:
 * runningSum[i] = sum(nums[0]...nums[i])
 *
 * Return the running sum of `nums`.
 *
 * 🔹 Example:
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 *
 * Explanation:
 * runningSum[0] = 1
 * runningSum[1] = 1 + 2 = 3
 * runningSum[2] = 1 + 2 + 3 = 6
 * runningSum[3] = 1 + 2 + 3 + 4 = 10
 */

public class LC_1480_RunningSumOf1DArray {

    // ✅ Function to compute the running sum
    public int[] runningSum(int[] nums) {
        int sum = 0; // Holds the cumulative sum
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];    // Add current number to sum
            nums[i] = sum;     // Update current element with running sum
        }
        return nums; // Return the modified array
    }

    // Optional: Add a main method to test it
    public static void main(String[] args) {
        LC_1480_RunningSumOf1DArray obj = new LC_1480_RunningSumOf1DArray();
        int[] nums = {1, 2, 3, 4};
        int[] result = obj.runningSum(nums);

        System.out.print("Running Sum: ");
        for (int val : result) {
            System.out.print(val + " "); // Output: 1 3 6 10
        }
    }
}
