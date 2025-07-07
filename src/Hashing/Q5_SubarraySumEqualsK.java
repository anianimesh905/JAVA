/*
 * Subarray Sum Equals K
 *
 * Given an integer array and a target value K,
 * return the total number of continuous subarrays whose sum equals to K.
 *
 * Example:
 * Input:  arr = {1, 2, 3}, K = 3
 * Output: 2
 * Explanation:
 *   Subarrays with sum = 3 are:
 *     [1, 2]
 *     [3]
 *
 * Constraints:
 * - Subarrays must be contiguous.
 * - Elements can be positive, negative, or zero.
 */


package src.Hashing;

import java.util.*;

public class Q5_SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10}; // Input array
        int k = -10;                     // Target subarray sum
        HashMap<Integer, Integer> map = new HashMap<>(); // {prefixSum -> frequency}

        map.put(0, 1); // To handle the case when subarray from start has sum = k

        int ans = 0;   // To count subarrays with sum = k
        int sum = 0;   // Prefix sum

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j]; // Update prefix sum

            // If (sum - k) exists in map, there is a subarray ending at index j with sum = k
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            // Add/update current prefix sum in map
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }

            /*
             * Dry run:
             * j = 0: arr[j] = 10 → sum = 10 → sum-k = 20 → not in map → map = {0:1, 10:1}
             * j = 1: arr[j] = 2  → sum = 12 → sum-k = 22 → not in map → map = {0:1, 10:1, 12:1}
             * j = 2: arr[j] = -2 → sum = 10 → sum-k = 20 → not in map → map = {0:1, 10:2, 12:1}
             * j = 3: arr[j] = -20→ sum = -10 → sum-k = 0 → found! map[0]=1 → ans += 1
             *                                   → map = {0:1, 10:2, 12:1, -10:1}
             * j = 4: arr[j] = 10 → sum = 0 → sum-k = 10 → found! map[10]=2 → ans += 2
             *                                   → map = {0:2, 10:2, 12:1, -10:1}
             * Final ans = 3
             */
        }

        System.out.println(ans); // Output: 3
    }
}
