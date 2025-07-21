package src.Array.Easy;

/*
🎯 QUESTION:
Given an array of integers `a[]` and a value `k`,
find the length of the **longest subarray** whose **sum is equal to `k`**.

👉 Example:
Input: a[] = {1, 2, 3, 1, 1, 1, 1}, k = 3
Output: 3
Explanation: The subarray {1, 1, 1} has a sum of 3 and length 3.
*/

public class LongestSubarraySumK {

    // -----------------------------
    // 🧠 Approach 1: Brute Force O(N^2)
    // -----------------------------
    public static int getLongestSubarray(int[] a, long k) {
        int n = a.length; // size of the array
        int len = 0;      // store maximum length

        // Try every subarray starting from index i
        for (int i = 0; i < n; i++) {
            long s = 0; // to store the sum of current subarray
            for (int j = i; j < n; j++) {
                s += a[j]; // add current element to sum
                if (s == k) {
                    len = Math.max(len, j - i + 1); // update max length
                }
            }
        }

        return len; // return the maximum length found
    }

    // -----------------------------
    // 🚀 Approach 2: Sliding Window (O(N)) - Only for non-negative numbers
    // -----------------------------
    public static int getLongestSubarraySlidingWindow(int[] a, long k) {
        int n = a.length;

        int left = 0, right = 0;  // two pointers to maintain window
        long sum = a[0];          // current sum of the window
        int maxLen = 0;           // store max length
        int startIdx = -1, endIdx = -1; // to store indices of the longest subarray

        while (right < n) {
            // Shrink window from the left if the sum is greater than k
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // If current window's sum is exactly k
            if (sum == k) {
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    startIdx = left;
                    endIdx = right;
                }
            }

            // Expand the window to the right
            right++;
            if (right < n) sum += a[right];
        }

        // Print the longest subarray found
        if (maxLen > 0) {
            System.out.print("Longest subarray with sum " + k + " is: ");
            for (int i = startIdx; i <= endIdx; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("No subarray with sum " + k + " found.");
        }

        return maxLen; // return the maximum length found
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 1, 1, 1}; // input array
        long k = 3; // target sum
        int[] array2 = {-1, 1, 1}; // input array
        long k2 = 1; // target sum

        // 💥 Approach 1: Brute Force
        int longestLength1 = getLongestSubarray(array, k);
        System.out.println("Approach 1 - Length of the longest subarray with sum " + k + ": " + longestLength1);

        // ⚡ Approach 2: Sliding Window
        int longestLength2 = getLongestSubarraySlidingWindow(array, k);
        System.out.println("Approach 2 - Length of the longest subarray with sum " + k + ": " + longestLength2);

        int longestLength3 = getLongestSubarraySlidingWindow(array2, k2);
        System.out.println("Approach... - Length of the longest subarray with sum " + k2 + ": " + longestLength3);


    }
}
