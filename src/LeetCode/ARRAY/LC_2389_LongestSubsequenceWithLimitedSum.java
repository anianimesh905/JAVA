package src.LeetCode.ARRAY;

import java.util.Arrays;

public class LC_2389_LongestSubsequenceWithLimitedSum {

    /*
     🧠 Problem: LeetCode 2389 - Longest Subsequence With Limited Sum

     ❓ Description:
     You are given an integer array `nums` and an array `queries`.
     For each `queries[i]`, determine the maximum number of elements from `nums`
     that you can include such that their sum is less than or equal to `queries[i]`.

     You can pick elements in any order, but once picked, all values must be counted in the sum.

     📌 Example:
     Input:
        nums = [4, 5, 2, 1]
        queries = [3, 10, 21]
     Output:
        [2, 3, 4]

     🔧 Approach:
     1. Sort the array `nums` to take smaller elements first.
     2. Build a prefix sum array.
     3. For each query, perform binary search on prefix sum to find
        how many elements we can take without exceeding the query value.
    */

    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);  // Step 1: Sort nums to prioritize smallest elements

        int n = nums.length;
        int[] prefix = new int[n];  // Step 2: Prefix sum array to store cumulative sums
        prefix[0] = nums[0];        // First element is same
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];  // Sum up values progressively
        }

        int[] res = new int[queries.length];  // To store result for each query

        // Step 3: Answer each query using binary search on prefix sums
        for (int i = 0; i < queries.length; i++) {
            int left = 0, right = n - 1, ans = 0;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (prefix[mid] <= queries[i]) {     // If current sum fits in query
                    ans = mid + 1;                   // mid+1 elements can be used
                    left = mid + 1;                  // Try to take more elements
                } else {
                    right = mid - 1;                 // Try smaller prefix
                }
            }
            res[i] = ans;  // Store result for current query
        }

        return res;  // Final result array
    }

    // Driver method to test the function
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 1};         // Input nums array
        int[] queries = {3, 10, 21};       // Query limits

        int[] result = answerQueries(nums, queries);  // Call the function

        // Output the results
        System.out.println("Result:");
        for (int r : result) {
            System.out.print(r + " ");
        }
        // Expected Output: 2 3 4
    }
}
