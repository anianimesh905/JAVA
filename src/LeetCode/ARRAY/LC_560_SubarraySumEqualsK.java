package src.LeetCode.ARRAY;

import java.util.HashMap;

/**
 * LC 560. Subarray Sum Equals K
 *
 * Problem Statement:
 * Given an array of integers nums and an integer k,
 * return the total number of subarrays whose sum equals to k.
 *
 * Example:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 *
 * Goal / Approach:
 * - Brute Force: Try all subarrays → O(n^2).
 * - Optimized (HashMap + Prefix Sum): O(n).
 *   Use prefix sum and store frequency of sums in a map.
 *   If (currentSum - k) exists in map, it means we found a subarray.
 */
public class LC_560_SubarraySumEqualsK {

    // 🔹 Brute Force Approach (O(n^2))
    public int subarraySumBruteForce(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // 🔹 Optimized HashMap + Prefix Sum Approach (O(n))
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // prefixSum 0 occurs once (base case)

        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;

            // If (sum - k) exists, add its frequency to count
            if (prefixSumMap.containsKey(sum - k)) {
                count += prefixSumMap.get(sum - k);
            }

            // Store/update frequency of current sum
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // 🔹 Test the solution
    public static void main(String[] args) {
        LC_560_SubarraySumEqualsK solution = new LC_560_SubarraySumEqualsK();

        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println("Brute Force Result: " + solution.subarraySumBruteForce(nums, k)); // 2
        System.out.println("Optimized HashMap Result: " + solution.subarraySum(nums, k));     // 2
    }
}
